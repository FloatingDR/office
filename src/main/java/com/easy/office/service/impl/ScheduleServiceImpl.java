package com.easy.office.service.impl;

import com.easy.office.bean.ResponseBean;
import com.easy.office.bean.ResultCode;
import com.easy.office.mapper.ScheduleMapper;
import com.easy.office.model.Schedule;
import com.easy.office.service.ScheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author taylor
 * @ClassName: ScheduleServiceImpl
 * @Description:
 * @date: 2019-05-02 12:38
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    ScheduleMapper scheduleMapper;

    /**
     * 插入一条记录
     * @param schedule
     * @return ResponseBean
     */
    @Override
    public ResponseBean insert(Schedule schedule) {
        if(scheduleMapper.insert(schedule)>0){
            return new ResponseBean(ResultCode.SUCCESS,"insert success",null);
        }
        return new ResponseBean(ResultCode.FAIL,"insert fail",null);
    }

    /**
     * 根据用户id查找数据
     * @param userId
     * @return ResponseBean
     */
    @Override
    public ResponseBean findScheduleByUserId(Integer userId) {
        List<Schedule> list=scheduleMapper.findScheduleByUserId(userId);
        if(list.isEmpty()){
            return new ResponseBean(ResultCode.NOTFOUND,"not found",null);
        }
        return new ResponseBean(ResultCode.SUCCESS,"found success",list);
    }


}
