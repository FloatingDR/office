package com.easy.office.service;

import com.easy.office.bean.ResponseBean;

/**
 * @author taylor
 * @ClassName: FriendService
 * @Description:
 * @date: 2019-05-01 20:25
 */
public interface FriendService {
    /**
     * 查询userId的朋友
     * @param userId
     * @return
     */
    ResponseBean getFriends(Integer userId);
}
