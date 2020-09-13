package cn.wzh.util;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

public class Download {
    public static void xiaZai(String name, String path, HttpServletResponse response) {
        InputStream in = null;
        BufferedOutputStream out = null;
        String fileName = "";
        try {
            if (name == null || name.equals("")) {
                // 得到该路径中最后一次出现\\的位置，并从该位置向末尾截取字符串，从而得到文件名称。
                fileName = path.substring(path.lastIndexOf("\\"));
            } else {
                fileName = name;
            }
            // 给文件名转码，使其不会出现乱码的情况。
            fileName = URLEncoder.encode(fileName, "UTF-8");

            // 设置响应头的信息，用于给正在下载的文件赋名称。
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            // 设置内容类型，使其被判断为下载文件类型
            response.setContentType("multipart/form-data");

            // 根据路径找到该文件并读取至文件输入流中
            in = new BufferedInputStream(new FileInputStream(new File(path)));
            // 创建输出流
            out = new BufferedOutputStream(response.getOutputStream());

            // 循环将输入流中的内容输出。
            int len = 0;
            while ((len = in.read()) != -1) {
                out.write(len);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭文件输入流
                if (in != null) {
                    in.close();
                }
                // 关闭输出流
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
