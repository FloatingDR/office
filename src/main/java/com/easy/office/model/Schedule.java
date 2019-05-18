package com.easy.office.model;

import lombok.Data;

import java.util.Date;

/**
 * @author taylor
 * @date 2019.5.12 21:21
 */
@Data
public class Schedule {
    private Integer id;

    private Integer userId;

    private String item;

    private Date beginDate;

    private Date endDate;

    private Date remindTime;

    private String remindPlace;

    private String privacy;

    private String describeText;
}