package com.easy.office.service.impl;

import com.easy.office.bean.ResponseBean;
import com.easy.office.bean.ResultCode;
import com.easy.office.mapper.MeetingMapper;
import com.easy.office.mapper.UserMeetingMapper;
import com.easy.office.model.Meeting;
import com.easy.office.service.MeetingService;
import com.easy.office.utils.Converter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author taylor
 * @ClassName: MeetingServiceImpl
 * @Description:
 * @date: 2019-05-01 09:56
 */
@Service
public class MeetingServiceImpl implements MeetingService {

    @Resource
    MeetingMapper meetingMapper;
    @Resource
    UserMeetingMapper userMeetingMapper;


    /**
     * 根据userId得到该用户的会议信息
     *
     * @param userId
     * @return ResponseBean
     */
    @Override
    public ResponseBean getMeetingById(Integer userId) {

        List<Integer> meetingIds = userMeetingMapper.getMeetingIdsByUserId(userId);

        /**
         * 判断通过userId查到的meetingId集合是否为空
         */
        if (meetingIds.isEmpty()) {
            return new ResponseBean(ResultCode.NOTFOUND, "you are no meeting", null);
        } else {
            List<Meeting> meeting = meetingMapper.selectByMeetingIdList(meetingIds);
            return new ResponseBean(ResultCode.SUCCESS, "success", meeting);
        }
    }

    /**
     * 新建会议
     *
     * @param meeting
     * @return ResponseBean
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseBean createMeeting(Meeting meeting) {

        /**
         * 日期转string
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(meeting.getDate());

        /**
         * 如果数据库已有该会议,返回会议重复
         */
        if(meetingMapper.getIdByNameOrDate(meeting.getName(), date)>0){
            return new ResponseBean(ResultCode.FORBIDDEN, "meeting repeat", null);
        }

        int num1 = meetingMapper.insertSelective(meeting);

        /**
         * 得到刚插入的会议的id
         */
        int meetingId = meetingMapper.getIdByNameOrDate(meeting.getName(), date);

        /**
         * 将string转为Integer集合
         */
        List<Integer> userIds = Converter.ConverterToList(meeting.getAttend());

        /**
         * @param meetingId 会议id
         * @param userIds 参会人员id集合
         */
        int num2 = userMeetingMapper.insertUsersMeeting(meetingId, userIds);

        /**
         * 如果之前的操作无空值或正常
         */
        if (num1 > 0 && num2 > 0) {
            return new ResponseBean(ResultCode.SUCCESS, "insert success", null);
        }
        return new ResponseBean(ResultCode.FAIL, "insert fail", null);
    }
}
