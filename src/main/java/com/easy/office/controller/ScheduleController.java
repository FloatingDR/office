package com.easy.office.controller;

import com.easy.office.bean.ResponseBean;
import com.easy.office.model.Schedule;
import com.easy.office.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author taylor
 * @ClassName: ScheduleController
 * @Description:
 * @date: 2019-05-02 12:36
 */
@RestController
@CrossOrigin
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    /**
     * 插入一条记录
     * @param schedule
     * @return ResponseBean
     */
    @PostMapping("/insert")
    public ResponseBean insert(@RequestBody Schedule schedule){
        return scheduleService.insert(schedule);
    }

    /**
     * 根据用户id查找数据
     * @param userId
     * @return ResponseBean
     */
    @GetMapping("/find_friend_schedule/{userId}")
    public ResponseBean findScheduleByUserId(@PathVariable int userId){
        return scheduleService.findScheduleByUserId(userId);
    }
}
