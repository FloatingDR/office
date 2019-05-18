package com.easy.office.controller;

import com.easy.office.bean.ResponseBean;
import com.easy.office.model.Meeting;
import com.easy.office.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author taylor
 * @ClassName: MeetingController
 * @Description:
 * @date: 2019-05-01 09:50
 */
@RestController
@RequestMapping("/api/meeting")
@CrossOrigin
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    /**
     * get my meeting.
     * @param userId
     * @return
     */
    @GetMapping("/get_my_meeting/{userId}")
    public ResponseBean getUserMeeting(@PathVariable Integer userId){
        return meetingService.getMeetingById(userId);
    }

    /**
     * create new meeting.
     * @param meeting
     * @return
     */
    @PostMapping("/add_meeting")
    public ResponseBean createMeeting(@RequestBody Meeting meeting){
        return meetingService.createMeeting(meeting);
    }
}
