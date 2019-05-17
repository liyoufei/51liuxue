package com.sss.service;

import com.google.common.collect.Lists;
import com.sss.util.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
/**
 * FileService class
 *
 * @author Sss
 * @date 2019/3/26
 */

@Service
public class FileService {

    @Value("${file.path}")
    private String filePath;

    /**
     * 获得相对路径
     * @param files
     * @return
     */
    public  List<String> getImgPath(List<MultipartFile> files){
        List<String> paths = Lists.newArrayList();
        files.forEach((file) -> {
            File localFile = null;
            if(!file.isEmpty()){
                try {
                    localFile = FileUtil.saveToLocal(file,filePath);
                    String localPath = localFile.getAbsolutePath();
                    paths.add(StringUtils.substringAfterLast(localPath,filePath));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return paths;
    }
}
