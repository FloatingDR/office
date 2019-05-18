package com.easy.office.service.impl;

import com.easy.office.bean.ResponseBean;
import com.easy.office.bean.ResultCode;
import com.easy.office.mapper.*;
import com.easy.office.model.File;
import com.easy.office.model.Meeting;
import com.easy.office.model.UserFriendCollect;
import com.easy.office.model.require.MyCollection;
import com.easy.office.service.CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author taylor
 * @ClassName: CollectServiceImpl
 * @Description:
 * @date: 2019-05-13 13:10
 */
@Service
public class CollectServiceImpl implements CollectService {

    @Resource
    FileMapper fileMapper;
    @Resource
    UserFileCollectMapper userFileCollectMapper;
    @Resource
    MeetingMapper meetingMapper;
    @Resource
    UserMeetingCollectMapper userMeetingCollectMapper;
    @Resource
    UserFriendCollectMapper userFriendCollectMapper;

    /**
     * get my collect by userId
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseBean getMyCollectionByUserId(Integer userId) {
        /**
         * get collected file info
         */
        List<Integer> collectedFileIds = userFileCollectMapper.getFileIdsByUserId(userId);
        List<File> collectedFiles = new ArrayList<>(16);
        if (!collectedFileIds.isEmpty()) {
            for (Integer fileId : collectedFileIds) {
                collectedFiles.add(fileMapper.selectByPrimaryKey(fileId));
            }
        }

        /**
         * get collected meeting info
         */
        List<Integer> collectedMeetingIds = userMeetingCollectMapper.getCollectedMeetingIdsByUserId(userId);
        List<Meeting> collectedMeetings=new ArrayList<>(16);
        if (!collectedMeetingIds.isEmpty()) {
            for(Integer meetingId:collectedMeetingIds){
                collectedMeetings.add(meetingMapper.selectByPrimaryKey(meetingId));
            }

        }

        MyCollection myCollection = new MyCollection();
        if(!collectedFiles.isEmpty()){
            myCollection.setFiles(collectedFiles);
        }
        if(!collectedMeetings.isEmpty()){
            myCollection.setMeetings(collectedMeetings);
        }

        return new ResponseBean(ResultCode.SUCCESS, "success", myCollection);
    }

    /**
     * get my collected friend ids by userId
     * @param userId
     * @return ResponseBean
     */
    @Override
    public ResponseBean getMyCollectedFriendIds(Integer userId) {
        List<Integer> collectedIds=userFriendCollectMapper.getMyCollectedFriendIds(userId);
        if(!collectedIds.isEmpty()){
            Integer[]collectedIdArray=new Integer[collectedIds.size()];
            for(int i=0;i<collectedIds.size();i++){
                collectedIdArray[i]=collectedIds.get(i);
            }
            return new ResponseBean(ResultCode.SUCCESS, "success", collectedIdArray);
        }
        return new ResponseBean(ResultCode.NOTFOUND, "not found", null);
    }

    /**
     * add to my collect
     * @param record
     * @return
     */
    @Override
    public ResponseBean addCollect(UserFriendCollect record) {
        if(userFriendCollectMapper.insert(record)>0){
            return new ResponseBean(ResultCode.SUCCESS, "add collect success", null);
        }
        return new ResponseBean(ResultCode.FAIL, "add collect fail", null);
    }

    /**
     * delete from my collect
     * @param record
     * @return
     */
    @Override
    public ResponseBean deleteCollect(UserFriendCollect record) {
        if(userFriendCollectMapper.deleteCollect(record)>0){
            return new ResponseBean(ResultCode.SUCCESS, "delete collect success", null);
        }
        return new ResponseBean(ResultCode.FAIL, "delete collect fail", null);
    }
}
