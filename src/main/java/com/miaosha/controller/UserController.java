package com.miaosha.controller;


import com.miaosha.controller.controllerVO.UserVO;
import com.miaosha.error.BusinessException;
import com.miaosha.error.EmBusinessError;
import com.miaosha.response.CommonReturnType;
import com.miaosha.service.UserService;
import com.miaosha.service.mode.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller("user")
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    //用户获取otp短信接口




    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        //掉用serivce服务获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUser(id);

        //若获取的对应用户信息不存在
        if (userModel == null) {
           // userModel.setEncrptPassword("123");
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }


        //将核心领域模型用户对象转化为可供UI使用的viewObject
        UserVO userVO = convertFromModel(userModel);

        //调用通用返回类型方法
        return CommonReturnType.create(userVO);

    }

    //控制层返回的用户信息不需要密码等相关，所以建立了一层controllerVO返回模型，去除掉不需要向前端返回的用户信息
    private UserVO convertFromModel(UserModel userModel) {
        if (userModel == null) return null;

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }



}
