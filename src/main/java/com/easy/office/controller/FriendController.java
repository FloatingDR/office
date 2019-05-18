package com.easy.office.controller;

import com.easy.office.bean.ResponseBean;
import com.easy.office.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author taylor
 * @ClassName: FriendController
 * @Description:
 * @date: 2019-05-01 20:24
 */
@RestController
@RequestMapping("/api/friend")
@CrossOrigin
public class FriendController {

    @Autowired
    FriendService friendService;

    /**
     * 根据userId获得朋友信息
     * @param userId
     * @return
     */
    @GetMapping("/get_my_friend/{userId}")
    public ResponseBean getMyFriend(@PathVariable Integer userId){
        return friendService.getFriends(userId);
    }
}
