package com.example.xylearn.netty.fileio;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author xiaoy
 * @date 2022/2/14
 */
public class NomalFile {
    public static void main(String[] args) throws IOException {

    }
    public static void normalIo() throws Exception {
        // file(内存)----输入流---->【程序】----输出流---->file(内存)
        File file = new File("t1.txt");
        file.createNewFile(); // 创建文件


        // 向文件写入内容(输出流)
        String str = "亲爱的小南瓜！";
        byte bt[] = str.getBytes();
        FileOutputStream in = new FileOutputStream(file);
        in.write(bt, 0, bt.length);
        in.close();


        // 读取文件内容 (输入流)
        FileInputStream out = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(out);
        int ch = 0;
        while ((ch = isr.read()) != -1) {
            System.out.print((char) ch);
        }

    }

    public static void NIo(String source,String target) throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        FileInputStream inputStream = new FileInputStream(source);
        FileChannel inChannel = inputStream.getChannel();

        FileOutputStream outputStream = new FileOutputStream(target);
        FileChannel outChannel = outputStream.getChannel();

        int length = inChannel.read(byteBuffer);
        while(length != -1){
            byteBuffer.flip();//读取模式转换写入模式
            outChannel.write(byteBuffer);
            byteBuffer.clear(); //清空缓存，等待下次写入
            // 再次读取文本内容
            length = inChannel.read(byteBuffer);
        }
        outputStream.close();
        outChannel.close();
        inputStream.close();
        inChannel.close();

    }
}
