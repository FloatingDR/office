package com.easy.office.mapper;

import com.easy.office.model.UserSchedule;

/**
 * @author taylor
 * @date 2019.5.1
 */
public interface UserScheduleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserSchedule record);

    int insertSelective(UserSchedule record);

    UserSchedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserSchedule record);

    int updateByPrimaryKey(UserSchedule record);
}