package com.miaosha;

import com.miaosha.mapper.UserInfoMapper;
import com.miaosha.pojo.UserInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!     (git上的目录为https://github.com/gitleilei/miaosha.git)
 * SpringBootApplication注解和EnableAutoConfiguration注解异曲同工，
 * 可以把App这个类被spring托管并且置顶App这个类是主启动类，
 * MapperScan注解标记dao（mapper接口）存放的目录
 * */
@SpringBootApplication(scanBasePackages = {"com.miaosha"})
@RestController
@MapperScan("com.miaosha.mapper")
public class App 
{
    @Autowired
    private UserInfoMapper userInfoMapper;


    @RequestMapping("/")
    public String home(){
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1);
        if (userInfo ==null){
            return "用户对象不存在";
        }else {
            return userInfo.getName();
        }
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
