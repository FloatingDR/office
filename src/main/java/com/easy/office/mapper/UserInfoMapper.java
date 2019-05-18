package com.easy.office.mapper;

import com.easy.office.model.UserInfo;

/**
 * @author taylor
 */
public interface UserInfoMapper {

    /**
     * 通过userId更新信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * select all by userId.
     * @param userId
     * @return
     */
    UserInfo selectByUserId(Integer userId);

    int deleteByPrimaryKey(Integer userInfoId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}