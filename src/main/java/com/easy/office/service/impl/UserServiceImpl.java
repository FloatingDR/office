package com.easy.office.service.impl;

import com.easy.office.bean.ResponseBean;
import com.easy.office.bean.ResultCode;
import com.easy.office.config.jwt.JWTUtil;
import com.easy.office.mapper.UserInfoMapper;
import com.easy.office.mapper.UserMapper;
import com.easy.office.model.User;
import com.easy.office.model.UserInfo;
import com.easy.office.service.UserService;
import com.easy.office.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author taylor
 * @ClassName: UserServiceImpl
 * @Description:
 * @date: 2019-04-25 10:07
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    UserInfoMapper userInfoMapper;

    /**
     * 用户登陆，返回登陆信息和用户存储的信息
     * @param user
     * @return token
     */
    @Override
    public ResponseBean login(User user) {
        if (userMapper.selectByUsername(user) < 0) {
            return new ResponseBean(ResultCode.NOTFOUND, "this account is notfound", null);
        }
        User currentUser=userMapper.getInfoByUsername(user.getUsername());
        String passwordEncoded = currentUser.getPassword();

        if(MD5Util.verify(user.getPassword(),passwordEncoded)){
            String token= JWTUtil.sign(user.getUsername(),passwordEncoded);
            return new ResponseBean(ResultCode.SUCCESS,token,userInfoMapper.selectByUserId(currentUser.getUserId()));
        }
        return new ResponseBean(ResultCode.FORBIDDEN,"password error",null);
    }

    /**
     * 添加用户，默认添加职工
     *
     * @param user
     * @return ResponseBean 403：用户名重复
     */
    @Override
    public ResponseBean insert(User user) {
        if (userMapper.selectByUsername(user) > 0) {
            return new ResponseBean(402, "this account is repeated", null);
        }
        if (user.getRoleId() == null) {
            user.setRoleId(3);
        }
        user.setPassword(MD5Util.md5(user.getPassword()));
        int msg = userMapper.insert(user);
        if (msg > 0) {
            return new ResponseBean(ResultCode.SUCCESS, "insert succeed", null);
        }
        return new ResponseBean(ResultCode.FAIL, "insert fail", null);
    }

    /**
     * 更新用户信息
     * @param userInfo
     * @return new token ; ResponseBean 200:success 500:fail
     */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public ResponseBean updateUserInfo(UserInfo userInfo) {

        /**
         * 如果修改的是家庭地址或电子邮箱
         */
        if(!StringUtils.isBlank(userInfo.getFamilyAddress()) ||
                !StringUtils.isBlank(userInfo.getEmail())){
            if(userInfoMapper.updateByPrimaryKeySelective(userInfo)<0){
                return new ResponseBean(ResultCode.FAIL,"update fail",null);
            }
        }

        /**
         * 如果用户名有修改，返回新token
         */
        if(!StringUtils.isBlank(userInfo.getUsername())){
            User user=userMapper.getInfoById(userInfo.getUserId());
            user.setUsername(userInfo.getUsername());
            if(userMapper.updateByPrimaryKeySelective(user)>0){
                String passwordEncoded=user.getPassword();
                String token= JWTUtil.sign(user.getUsername(),passwordEncoded);
                return new ResponseBean(ResultCode.SUCCESS,token,null);
            }
        }

        return new ResponseBean(ResultCode.SUCCESS,"update success",null);
    }

    /**
     * 根据userId得到用户数据
     * @param userId
     * @return
     */
    @Override
    public ResponseBean getUserInfo(Integer userId) {
        UserInfo userInfo=userInfoMapper.selectByUserId(userId);
        if(userInfo==null){
            return new ResponseBean(ResultCode.FAIL,"fail",null);
        }
        return new ResponseBean(ResultCode.SUCCESS,"success",userInfo);
    }
}
