package com.example.easyExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author xiaoy
 * @date 2022/1/19
 */
@Slf4j
public class ExcelTest {
    public static void main(String[] args) {
        List<Map<Integer, String>> excelListMapIncludEmpRoe =
                getExcelListMapIncludEmpRoe("./test/xlsx",
                        1, 0);
        System.out.println(JSON.toJSONString(excelListMapIncludEmpRoe));
    }
    public static List<Map<Integer, String>> getExcelListMapIncludEmpRoe(String fileUrl, int headEndNum, int sheetNum) {
        List<Map<Integer, String>> listMap = null;
        try {
            URL url = new URL(fileUrl);
            //FileInputStream files2 = new FileInputStream(fileUrl);
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
