package com.easy.office.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserSchedule {
    private Integer id;

    private Integer userId;

    private String title;

    private Date beginTime;

    private Date endTime;

    private String remindType;

    private Date remindTime;

    private String privacy;

    private String describeText;

}