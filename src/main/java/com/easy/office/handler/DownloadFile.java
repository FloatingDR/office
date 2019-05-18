package com.easy.office.handler;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author taylor
 * @ClassName: DownloadFile
 * @Description:
 * @date: 2019-05-15 20:51
 */
@Service
public class DownloadFile {

    public ResponseEntity<InputStreamResource> download(String filename, String filePath) throws IOException {
        //从项目目录下获取要下载的文件
        FileSystemResource file = new FileSystemResource(filePath);
        //设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment;filename=\"%s\"", URLEncoder.encode(filename, "utf-8")));
        headers.add("Prama", "no-cache");
        headers.add("Expries", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }
}
