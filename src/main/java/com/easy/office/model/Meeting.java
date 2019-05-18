package com.easy.office.model;

import lombok.Data;

import java.util.Date;

@Data
public class Meeting {
    private Integer meetingId;

    private String name;

    private Date date;

    private String place;

    private String attend;

}