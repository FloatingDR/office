package com.easy.office.model;

import lombok.Data;

/**
 * @author taylor
 */
@Data
public class UserInfo {
    private Integer userInfoId;

    private Integer userId;

    private String img;

    private String position;

    private String workPlace;

    private String workPhone;

    private String familyAddress;

    private String email;

    private String username;
}