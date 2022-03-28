package com.example.xylearn.alipay;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoy
 * @date 2021/12/30
 */
@Slf4j
public class MyExcelUtil {
    public static void main(String[] args) {
        String url = "http://xinbianli.oss-cn-hangzhou.aliyuncs.com/fdd/template/747074ad339540c4b8306664e660848d.xlsx";
        List<Map<Integer, String>> listMap = getExcelListMapIncludEmpRoe(url,1,0);
        log.info("data {}", JSON.toJSONString(listMap));
    }

    private static List<Map<Integer, String>> getExcelListMapIncludEmpRoe(String fileUrl, int headEndNum, int sheetNum) {
        List<Map<Integer, String>> listMap = null;
        try {
            URL url = new URL(fileUrl);

            InputStream files2= null;
            files2 = url.openStream();
            ExcelReaderBuilder readerBuilder = EasyExcel.read(files2);
            ExcelReaderSheetBuilder readerSheetBuilder = readerBuilder.ignoreEmptyRow(false).sheet(sheetNum);

            if(readerBuilder != null) {
                listMap = readerSheetBuilder.headRowNumber(headEndNum).doReadSync();
            }
        }catch (Exception e) {
            log.info(ExceptionUtils.getStackTrace(e));
        }
        return listMap;
    }
}
