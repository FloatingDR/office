package com.easy.office.mapper;

import com.easy.office.model.UserMeetingCollect;

import java.util.List;

/**
 * @author taylor
 * @date 2019.5.1
 */
public interface UserMeetingCollectMapper {

    /**
     * get collected meeting ids by user id
     * @param userId
     * @return
     */
    List<Integer> getCollectedMeetingIdsByUserId(Integer userId);

    int deleteByPrimaryKey(Integer id);

    int insert(UserMeetingCollect record);

    int insertSelective(UserMeetingCollect record);

    UserMeetingCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserMeetingCollect record);

    int updateByPrimaryKey(UserMeetingCollect record);
}