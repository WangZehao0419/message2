package cn.wzh.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Upload {
    private static final String PATH = "D:\\UploadTest\\";

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    public static String shangChuan(MultipartFile file) {

        String pathName = PATH + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + file.getOriginalFilename();
        try {
            // 创建文件
            file.transferTo(new File(pathName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathName;
    }


}
