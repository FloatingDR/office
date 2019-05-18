package com.easy.office.model;

import lombok.Data;

/**
 * @author taylor
 */
@Data
public class User {
    private Integer userId;

    private String username;

    private String password;

    private Integer roleId;

}