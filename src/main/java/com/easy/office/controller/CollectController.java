package com.easy.office.controller;

import com.easy.office.bean.ResponseBean;
import com.easy.office.model.UserFriendCollect;
import com.easy.office.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author taylor
 * @ClassName: CollectController
 * @Description:
 * @date: 2019-05-13 13:47
 */
@RestController
@RequestMapping("/api/collect")
@CrossOrigin
public class CollectController {

    @Autowired
    CollectService collectService;

    /**
     * get my collect list.
     * @param userId
     * @return ResponseBean
     */
    @GetMapping("/get_my_collect/{userId}")
    public ResponseBean getMyCollect(@PathVariable Integer userId){
        return collectService.getMyCollectionByUserId(userId);
    }

    /**
     * get my collected friend ids by userId
     * @param userId
     * @return ResponseBean
     */
    @GetMapping("/get_my_collected_friend/{userId}")
    public ResponseBean getMyCollectedFriendIds(@PathVariable Integer userId){
        return collectService.getMyCollectedFriendIds(userId);
    }

    /**
     * add to my collect.
     * @param userFriendCollect
     * @return ResponseBean
     */
    @PostMapping("/add_to_my_collect")
    public ResponseBean addToMyCollect(@RequestBody UserFriendCollect userFriendCollect){
        return collectService.addCollect(userFriendCollect);
    }

    /**
     * delete form my collect.
     * @param userFriendCollect
     * @return ResponseBean
     */
    @PostMapping("/delete_from_my_collect")
    public ResponseBean deleteFromMyCollect(@RequestBody UserFriendCollect userFriendCollect){
        return collectService.deleteCollect(userFriendCollect);
    }

}
