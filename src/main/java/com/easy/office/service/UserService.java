package com.easy.office.service;

import com.easy.office.bean.ResponseBean;
import com.easy.office.model.User;
import com.easy.office.model.UserInfo;

/**
 * @author taylor
 * @ClassName: UserService
 * @Description:
 * @date: 2019-04-25 10:07
 */
public interface UserService {

    /**
     * 增加用户
     * @param record
     * @return
     */
    ResponseBean insert(User record);

    /**
     * 登陆
     * @param record
     * @return
     */
    ResponseBean login(User record);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    ResponseBean updateUserInfo(UserInfo userInfo);

    /**
     * 根据userId得到用户数据
     * @param userId
     * @return
     */
    ResponseBean getUserInfo(Integer userId);

}
