package com.easy.office.mapper;

import com.easy.office.model.Schedule;

import java.util.List;

public interface ScheduleMapper {

    /**
     * 根据 Schedule 对象插入数据
     * @param record
     * @return
     */
    int insert(Schedule record);

    /**
     * 根据用户id查找数据
     * @param id
     * @return
     */
    List<Schedule> findScheduleByUserId(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Schedule record);

    Schedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Schedule record);

    int updateByPrimaryKey(Schedule record);
}