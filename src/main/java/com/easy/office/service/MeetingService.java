package com.easy.office.service;

import com.easy.office.bean.ResponseBean;
import com.easy.office.model.Meeting;

/**
 * @author taylor
 * @ClassName: MeetingService
 * @Description:
 * @date: 2019-05-01 09:56
 */
public interface MeetingService {

    /**
     * 根据userId得到该用户的会议信息
     * @param userId
     * @return
     */
    ResponseBean getMeetingById(Integer userId);

    /**
     * 新建会议
     * @param meeting
     * @return
     */
    ResponseBean createMeeting(Meeting meeting);
}
