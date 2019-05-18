package com.easy.office.model;

import lombok.Data;

import java.util.Date;

@Data
public class File {
    private Integer fileId;

    private String name;

    private Date date;

    private String path;

    private String type;
}