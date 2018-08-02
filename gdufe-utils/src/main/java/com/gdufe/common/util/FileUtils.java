package com.gdufe.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: GuanQihua
 * @Description: 将输入流转换成二进制数组 ByteArrayOutputStream:字节数组缓冲区
 * @Date: 2018/8/2  16:19
 */
public class FileUtils {

    public static final byte[] toBytes(InputStream inStream){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int len = 0;
        try {
            while ((len = inStream.read(buff, 0, 100)) > 0) {
                baos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return baos.toByteArray();
    }
}

