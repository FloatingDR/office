package com.easy.office.mapper;

import com.easy.office.model.UserMeeting;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author taylor
 * @date 2019.5.1
 */
public interface UserMeetingMapper {

    /**
     * 根据userId该用户的会议信息
     * @param id
     * @return
     */
    List<Integer>getMeetingIdsByUserId(Integer id);

    /**
     * 创建要参与的会议
     * @param meetingId  要参与的会议id
     * @param userIds 参与会议的用户id
     * @return
     */
    int insertUsersMeeting(@Param("meetingId") int meetingId,@Param("userIds") List<Integer>userIds);

    int deleteByPrimaryKey(Integer id);

    int insert(UserMeeting record);

    int insertSelective(UserMeeting record);

    UserMeeting selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserMeeting record);

    int updateByPrimaryKey(UserMeeting record);
}