package com.easy.office.mapper;

import com.easy.office.model.UserFriendCollect;

import java.util.List;

/**
 * @author taylor
 * @date 2019.5.1
 */
public interface UserFriendCollectMapper {

    /**
     * get my collected friend ids by userId
     * @param userId
     * @return
     */
    List<Integer> getMyCollectedFriendIds(Integer userId);

    /**
     * 添加收藏
     * @param record
     * @return
     */
    int insert(UserFriendCollect record);

    /**
     * 删除收藏
     * @param record
     * @return
     */
    int deleteCollect(UserFriendCollect record);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserFriendCollect record);

    UserFriendCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFriendCollect record);

    int updateByPrimaryKey(UserFriendCollect record);
}