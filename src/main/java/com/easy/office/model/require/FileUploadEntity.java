package com.easy.office.model.require;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author taylor
 * @ClassName: FileUploadEntity
 * @Description:
 * @date: 2019-05-15 19:41
 */
@Data
@AllArgsConstructor
public class FileUploadEntity {
    String filename;
    long currentTime;
    String pathName;
}
