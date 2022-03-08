package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaoy
 * @date 2022/1/12
 */
public class CopyFile {
    public static Integer c;
    public void t1(){
       List<String> a = new ArrayList<>();
       a.stream().filter(e -> e.equals("11")).collect(Collectors.toList());
       System.out.println("1111111111");
       a.forEach(i -> i.length());
    }
    public int t(){
        int a = 1;
        int b = 1;
        int c = 1;
        return a+b;
    }
    public static void main(String[] args) throws Exception {
//        String infile = "test.txt";
//        String outfile = "test1.txt";
//        // 获取源文件和目标文件的输入输出流
//        FileInputStream fin = new FileInputStream(infile);
//        FileOutputStream fout = new FileOutputStream(outfile);
//        // 获取输入输出通道
//        FileChannel fcin = fin.getChannel();
//        FileChannel fcout = fout.getChannel();
//        // 创建缓冲区
//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        while (true) {
//            // clear方法重设缓冲区，使它可以接受读入的数据
//            buffer.clear();
//            // 从输入通道中将数据读到缓冲区
//            int r = fcin.read(buffer);
//            // read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
//            if (r == -1) {
//                break;
//            }
//            // flip方法让缓冲区可以将新读入的数据写入另一个通道
//            buffer.flip();
//            // 从输出通道中将数据写入缓冲区
//            fcout.write(buffer);
//        }
    }
}
