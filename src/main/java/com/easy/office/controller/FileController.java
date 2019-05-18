package com.easy.office.controller;

import com.easy.office.bean.ResponseBean;
import com.easy.office.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author taylor
 * @ClassName: FileController
 * @Description:
 * @date: 2019-05-14 19:50
 */
@RestController
@RequestMapping("/api/file")
@CrossOrigin
public class FileController {

    @Autowired
    FileService fileService;

    /**
     * 根据userId得到文件信息
     * @param userId
     * @return
     */
    @GetMapping("/get_my_file/{userId}")
    public ResponseBean getFileByUserId(@PathVariable Integer userId){
        return fileService.getFileByUserId(userId);
    }

    /**
     * @param userId
     * @param type 上传的文件类型
     * @param file 上传的文件
     * @return
     */
    @PostMapping("/upload/{userId}/{type}")
    public ResponseBean uploadFile(@PathVariable Integer userId,@PathVariable String type, MultipartFile file) {
        return fileService.uploadFile(userId,file,type);
    }

    /**
     * 文件下载
     * @param request
     * @param fileId
     * @return
     */
    @PostMapping("/download/{fileId}")
    public ResponseEntity<InputStreamResource> downloadFile(HttpServletRequest request,@PathVariable Integer fileId)throws IOException {
        return fileService.downloadFile(fileId);
    }
}
