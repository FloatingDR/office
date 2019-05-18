package com.easy.office.service;

import com.easy.office.bean.ResponseBean;
import com.easy.office.model.Schedule;

/**
 * @author taylor
 * @ClassName: ScheduleService
 * @Description:
 * @date: 2019-05-02 12:37
 */
public interface ScheduleService {

    /**
     * 插入一条记录
     * @param schedule
     * @return
     */
    ResponseBean insert(Schedule schedule);

    /**
     * 根据用户id查找数据
     * @param userId
     * @return
     */
    ResponseBean findScheduleByUserId(Integer userId);
}
