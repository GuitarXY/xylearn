package com.example.easyExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import sun.nio.ch.FileChannelImpl;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoy
 * @date 2022/1/19
 */
@Slf4j
public class ExcelTest {
    public static void main(String[] args) throws Exception {
        List<Integer> l = new ArrayList<>();
        List<Integer> integers = Arrays.asList(1, 2, 3);
        l.addAll(integers);
        integers.forEach(i ->{

        });
        dow();
//        List<Map<Integer, String>> excelListMapIncludEmpRoe =
//                getExcelListMapIncludEmpRoe("http://xinbianli.oss-cn-hangzhou.aliyuncs.com/fdd/template/11acad6ca1f641d9817652c8755d94a8.xls",
//                        1, 5);
//        System.out.println(JSON.toJSONString(excelListMapIncludEmpRoe));
    }
    public static List<Map<Integer, String>> getExcelListMapIncludEmpRoe(String fileUrl, int headEndNum, int sheetNum) {
        List<Map<Integer, String>> listMap = null;
        try {
            URL url = new URL(fileUrl);
            //FileInputStream files2 = new FileInputStream(fileUrl);
            InputStream files2= null;
            files2 = url.openStream();
            ExcelReaderBuilder readerBuilder = EasyExcel.read(files2);
            ExcelReaderSheetBuilder readerSheetBuilder = readerBuilder.sheet(sheetNum);
            listMap = readerSheetBuilder.headRowNumber(headEndNum).doReadSync();
        }catch (Exception e) {
            log.info(ExceptionUtils.getStackTrace(e));
        }
        return listMap;
    }
    public static void dow() throws Exception {
        URL url = new URL
                ("http://xinbianli.oss-cn-hangzhou.aliyuncs.com/fdd/template/11acad6ca1f641d9817652c8755d94a8.xls");
        InputStream f= url.openStream();
        byte[] b = new byte[1024];
        File te = new File("tt.xls");
        FileOutputStream o = new FileOutputStream(te);
        while (f.read() != -1){
            o.write(f.read(b));
        }
        f.close();
        o.close();
    }
    public static void dow1() throws Exception {
        URL url = new URL
                ("http://xinbianli.oss-cn-hangzhou.aliyuncs.com/fdd/template/11acad6ca1f641d9817652c8755d94a8.xls");
        InputStream f= url.openStream();
//        FileChannelImpl  fc = new FileChannelImpl()
        byte[] b = new byte[1024];
        File te = new File("tt1.xls");
        FileOutputStream o = new FileOutputStream(te);
        while (f.read() != -1){
            o.write(f.read(b));
        }
        f.close();
        o.close();
    }
}
