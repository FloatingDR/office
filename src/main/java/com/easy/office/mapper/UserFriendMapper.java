package com.easy.office.mapper;

import com.easy.office.model.UserFriend;

import java.util.List;

/**
 * @author taylor
 * @date 2019.5.1
 */
public interface UserFriendMapper {
    /**
     * select friends by userId
     * @param userId
     * @return
     */
    List<UserFriend>getFriends(Integer userId);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFriend record);

    int insertSelective(UserFriend record);

    UserFriend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFriend record);

    int updateByPrimaryKey(UserFriend record);
}