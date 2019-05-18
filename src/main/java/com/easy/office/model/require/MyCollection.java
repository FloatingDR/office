package com.easy.office.model.require;

import com.easy.office.model.File;
import com.easy.office.model.Meeting;
import lombok.Data;

import java.util.List;

/**
 * @author taylor
 * @ClassName: MyCollection
 * @Description:
 * @date: 2019-05-13 13:01
 */
@Data
public class MyCollection {
    private List<File> files;
    private List<Meeting> meetings;
}
