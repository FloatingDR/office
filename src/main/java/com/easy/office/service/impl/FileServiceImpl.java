package com.easy.office.service.impl;

import com.easy.office.bean.ResponseBean;
import com.easy.office.bean.ResultCode;
import com.easy.office.handler.DownloadFile;
import com.easy.office.handler.UploadFile;
import com.easy.office.mapper.FileMapper;
import com.easy.office.mapper.UserFileMapper;
import com.easy.office.model.File;
import com.easy.office.model.UserFile;
import com.easy.office.model.require.FileUploadEntity;
import com.easy.office.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * @author taylor
 * @ClassName: FileServiceImpl
 * @Description:
 * @date: 2019-05-14 19:51
 */
@Service
public class FileServiceImpl implements FileService {

    @Resource
    FileMapper fileMapper;
    @Resource
    UserFileMapper userFileMapper;
    @Autowired
    DownloadFile downloadFile;
    @Autowired
    UploadFile uploadFile;

    /**
     * 根据userId得到文件信息
     *
     * @param userId
     * @return
     */
    @Override
    public ResponseBean getFileByUserId(Integer userId) {
        List<Integer> fileIds = userFileMapper.getMyFileIds(userId);
        if (!fileIds.isEmpty()) {
            List<File> files = new ArrayList<>(16);
            for (Integer id : fileIds) {
                files.add(fileMapper.selectByPrimaryKey(id));
            }
            if (!files.isEmpty()) {
                return new ResponseBean(ResultCode.SUCCESS, "this is your file", files);
            }
        }
        return new ResponseBean(ResultCode.NOTFOUND, "you are not file", null);
    }

    /**
     * 文件上传
     * @param userId
     * @param file
     * @param type
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseBean uploadFile(Integer userId, MultipartFile file, String type) {
        FileUploadEntity fileUploadEntity = uploadFile.handleUploadFile(file, type);
        if (fileUploadEntity == null) {
            return new ResponseBean(ResultCode.FAIL, "fail", null);
        }

        File file1 = new File();
        file1.setName(fileUploadEntity.getFilename());
        file1.setDate(new Timestamp(fileUploadEntity.getCurrentTime()));
        file1.setPath(fileUploadEntity.getPathName());
        file1.setType(type);

        if (fileMapper.insert(file1) > 0) {
            int fileId = fileMapper.getIdByPath(fileUploadEntity.getPathName());
            if (fileId > 0) {
                UserFile userFile = new UserFile();
                userFile.setFileId(fileId);
                userFile.setUserId(userId);
                if (userFileMapper.insert(userFile) > 0) {
                    return new ResponseBean(ResultCode.SUCCESS, "success", null);
                }
            }
        }

        return new ResponseBean(ResultCode.FAIL, "fail", null);
    }

    /**
     * 下载文件
     * @param fileId
     * @throws IOException
     */
    @Override
    public ResponseEntity<InputStreamResource> downloadFile(Integer fileId)throws IOException {
        File file = fileMapper.selectByPrimaryKey(fileId);
        String fileName = file.getName();
        String filePath = file.getPath();
        return downloadFile.download(fileName, filePath);
    }

}
