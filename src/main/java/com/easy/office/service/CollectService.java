package com.easy.office.service;

import com.easy.office.bean.ResponseBean;
import com.easy.office.model.UserFriendCollect;

/**
 * @author taylor
 * @ClassName: CollectService
 * @Description:
 * @date: 2019-05-13 13:10
 */
public interface CollectService {

    /**
     * get my collect by userId.
     * @param userId
     * @return ResponseBean
     */
    ResponseBean getMyCollectionByUserId(Integer userId);

    /**
     * get my collected friends  by userId.
     * @param userId
     * @return ResponseBean
     */
    ResponseBean getMyCollectedFriendIds(Integer userId);

    /**
     * add to my collect.
     * @param userFriendCollect
     * @return ResponseBean
     */
    ResponseBean addCollect(UserFriendCollect userFriendCollect);

    /**
     * delete from my collect.
     * @param userFriendCollect
     * @return ResponseBean
     */
    ResponseBean deleteCollect(UserFriendCollect userFriendCollect);
}
