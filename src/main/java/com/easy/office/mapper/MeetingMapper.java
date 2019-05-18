package com.easy.office.mapper;

import com.easy.office.model.Meeting;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author taylor
 * @date 2019.5.1
 */
public interface MeetingMapper {

    List<Meeting>all();

    /**
     * select one by meetingId.
     * @param meetingId
     * @return
     */
    Meeting selectByPrimaryKey(Integer meetingId);

    /**
     * select * by meetingList.
     * @param list
     * @return  <p> List<Meeting> </p>
     */
    List<Meeting> selectByMeetingIdList(List<Integer> list);

    /**
     * 插入一条记录
     * @param record
     * @return
     */
    int insertSelective(Meeting record);

    /**
     * get meetingId by meetingName or date.
     * @param name
     * @param date
     * @return
     */
    int getIdByNameOrDate(@Param("name") String name,@Param("date") String date);

    int deleteByPrimaryKey(Integer meetingId);

    int insert(Meeting record);

    int updateByPrimaryKeySelective(Meeting record);

    int updateByPrimaryKey(Meeting record);
}