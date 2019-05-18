package com.easy.office.model.require;

import com.easy.office.model.UserInfo;
import lombok.Data;

/**
 * @author taylor
 * @ClassName: FriendInfo
 * @Description:
 * @date: 2019-05-01 21:16
 */
@Data
public class FriendInfo {
    private String name;
    private UserInfo friendInfo;
}
