package com.miaosha.service.impl;

import com.miaosha.mapper.UserInfoMapper;
import com.miaosha.mapper.UserPasswordMapper;
import com.miaosha.pojo.UserInfo;
import com.miaosha.pojo.UserPassword;
import com.miaosha.service.UserService;
import com.miaosha.service.mode.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserPasswordMapper userPasswordMapper;


    @Override
    public UserModel getUser(Integer id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);

        if (userInfo == null)
            return null;
        //通过用户ID获取对应的用户加密密码信息
        UserPassword userPassword =userPasswordMapper.selectByUserId(userInfo.getId());

        return converFromDateObject(userInfo,userPassword);
    }

    private UserModel converFromDateObject(UserInfo userInfo, UserPassword userPassword){
        if (userInfo == null)
            return null;
        UserModel userModel = new UserModel();
        //BeanUtils.copyProperties方法要求参数对象的字段名一致，字段类型一致
        BeanUtils.copyProperties(userInfo,userModel);
        if (userPassword != null) {
            userModel.setEncrptPassword(userPassword.getEncrptPassword());
        }
        return userModel;
    }
}
