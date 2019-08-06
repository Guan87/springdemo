package com.david.demo;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * Created by GW on 2019/6/20.
 */
public class TechnologyTest {
    Logger logger = LoggerFactory.getLogger(TechnologyTest.class);
    public static void main(String[] args) {

    }

    /*
    * 将图片转为BASE64字符串
    * */
    public  static String getImageStr(String filePath) throws IOException {
        //判断文件是否存在
        File file = new File(filePath);
        if (!file.exists()){
            throw new FileNotFoundException("文件不存在");
        }
        InputStream in =null;
        byte[] data = null;
        try {
                in = new FileInputStream(filePath);
                // int available()返回此输入流下一个方法调用可以不受阻塞地从此输入流读取（或跳过）的估计字节数。
                data = new byte[in.available()];
                //read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中。（这里将数据存入字节数组data中）
                in.read(data);
                in.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        BASE64Encoder encoder = new BASE64Encoder();

        return encoder.encode(data);
    }
}
