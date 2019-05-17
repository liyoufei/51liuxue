package com.sss.util;

import com.google.common.io.Files;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import java.time.Instant;
/**
 * FileUtil class
 *
 * @author Sss
 * @date 2019/3/26
 */
public class FileUtil {

    public static File saveToLocal(MultipartFile file,String filePath) throws IOException {
        //创建目录一般以系统目录加时间戳文件夹分类
        File newFile = new File(filePath + "\\" + Instant.now().getEpochSecond() + "\\" + file.getOriginalFilename());
        if(! newFile.exists()){
            //如果不存在该文件，则创建上层所有目录
            newFile.getParentFile().mkdirs();
            newFile.createNewFile();
        }

        Files.write(file.getBytes(),newFile);
        return newFile;

    }
}
