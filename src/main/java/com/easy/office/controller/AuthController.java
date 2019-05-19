package com.easy.office.controller;

import com.easy.office.bean.ResponseBean;
import com.easy.office.model.User;
import com.easy.office.model.UserInfo;
import com.easy.office.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author taylor
 * @ClassName: AuthController
 * @Description: 用户授权、登陆、注册
 * @date: 2019-04-25 10:04
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "部署成功了哈!";
    }

    /**
     * 用户登陆
     * @param user
     * @return
     */
    @PostMapping("/login")
    public ResponseBean login(@RequestBody User user){
        return userService.login(user);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    public ResponseBean addUser(@RequestBody User user){
        return userService.insert(user);
    }

    /**
     * 更新用户信息
     * @param userInfo
     * @return
     */
    @PostMapping("/update")
    public ResponseBean updateUserInfo(@RequestBody UserInfo userInfo){ return userService.updateUserInfo(userInfo); }

    /**
     * 通过userId得到用户信息
     * @param userId
     * @return
     */
    @GetMapping("/get_userInfo_by_id/{userId}")
    public ResponseBean getUserInfoByUserId(@PathVariable Integer userId){
        return userService.getUserInfo(userId);
    }

}
