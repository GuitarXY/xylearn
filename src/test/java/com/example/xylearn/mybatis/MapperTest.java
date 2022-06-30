package com.example.xylearn.mybatis;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.example.xylearn.Mapper;
import com.example.xylearn.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
@SpringBootTest
public class MapperTest {
    @Autowired
    private Mapper mapper;
    @Autowired
    private UserDao userDao;
    @Test
    public void get() {
        mapper.get();

    }
    @Test
    public void getuser() {
        userDao.findAll();

    }


    public static void main(String[] args) {
        final List<Map<Integer, String>> excelListMapIncludEmpRoe = getExcelListMapIncludEmpRoe(
                "http://xinbianli.oss-cn-hangzhou.aliyuncs.com/fdd/template/fcc5d18d6fea44c888221910543d04dd.xls",
                1, 0);
    }

    static List<Map<Integer, String>>  getExcelListMapIncludEmpRoe(String fileUrl, int headEndNum, int sheetNum) {
        List<Map<Integer, String>> listMap = null;
        try {
            File f = new File("C:\\Users\\MC-701\\Downloads\\06301.xls");
            FileInputStream in = new FileInputStream(f);
            ExcelReaderBuilder readerBuilder = EasyExcel.read(in);
            ExcelReaderSheetBuilder readerSheetBuilder = readerBuilder.sheet(sheetNum);
            listMap = readerSheetBuilder.headRowNumber(headEndNum).doReadSync();
        }catch (Exception e) {
        }
        return listMap;
    }
}
