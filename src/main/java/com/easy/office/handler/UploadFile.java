package com.easy.office.handler;

import com.easy.office.model.require.FileUploadEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

/**
 * @author taylor
 * @ClassName: UploadFile
 * @Description:
 * @date: 2019-05-15 19:30
 */
@Service
public class UploadFile {

    public FileUploadEntity handleUploadFile(MultipartFile file, String filePath) {
        try {
            String filename = file.getOriginalFilename();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long currentTime = System.currentTimeMillis();
            String currentDate = simpleDateFormat.format(currentTime);
            //     存在项目的某个目录下
            String pathName = System.getProperty("user.dir") + "/uploadFile/" +filePath+"/"+ "(" + currentDate + ")" + filename;
            //     存在指定目录下  String pathName="/Users/taylor/EasyOfficeUploadFile/"+filename;
            Path path = Paths.get(pathName);
            //     判断路径是否存在如果不存在则创建对应文件夹
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/uploadFile/"+filePath));
            }

            //将文件存入本地
            Files.write(path, file.getBytes());

            return new FileUploadEntity(filename,currentTime,pathName);

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
