package com.easy.office.service;

import com.easy.office.bean.ResponseBean;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author taylor
 * @ClassName: FileService
 * @Description:
 * @date: 2019-05-14 19:50
 */
public interface FileService {

    /**
     * 根据userId得到文件信息
     * @param userId
     * @return
     */
    ResponseBean getFileByUserId(Integer userId);

    /**
     * 上传文件
     * @param userId
     * @param file
     * @param type
     * @return
     */
    ResponseBean uploadFile(Integer userId,MultipartFile file,String type);

    /**
     * 下载文件
     * @param fileId
     * @return ResponseEntity
     * @throws IOException
     */
    ResponseEntity<InputStreamResource> downloadFile(Integer fileId)throws IOException;
}
