package com.easy.office.service.impl;

import com.easy.office.bean.ResponseBean;
import com.easy.office.bean.ResultCode;
import com.easy.office.mapper.UserFriendMapper;
import com.easy.office.mapper.UserInfoMapper;
import com.easy.office.mapper.UserMapper;
import com.easy.office.model.UserFriend;
import com.easy.office.model.require.FriendInfo;
import com.easy.office.service.FriendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author taylor
 * @ClassName: FriendServiceImpl
 * @Description:
 * @date: 2019-05-01 20:25
 */
@Service
public class FriendServiceImpl implements FriendService {

    @Resource
    UserFriendMapper userFriendMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    UserInfoMapper userInfoMapper;

    @Override
    public ResponseBean getFriends(Integer userId) {
        List<UserFriend> friendsList=userFriendMapper.getFriends(userId);
        if(friendsList.isEmpty()){
            return new ResponseBean(ResultCode.NOTFOUND,"you are no friends",null);
        }
        List<FriendInfo> friendInfoList=new ArrayList<>();
        for(UserFriend index:friendsList){
            FriendInfo friendInfo=new FriendInfo();
            friendInfo.setName(userMapper.getInfoById(index.getFriednId()).getUsername());
            friendInfo.setFriendInfo(userInfoMapper.selectByUserId(index.getFriednId()));
            friendInfoList.add(friendInfo);
        }
        return new ResponseBean(ResultCode.SUCCESS,"success",friendInfoList);
    }
}
