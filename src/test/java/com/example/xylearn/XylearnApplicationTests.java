package com.example.xylearn;

import com.alipay.service.schema.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class XylearnApplicationTests {

    /**
     * 解析大部分常见日期格式 <br/>
     * @author jingma@iflytek.com
     * @param dateStr 要解析的字符串
     * @return 时间对象，解析失败则为空
     */
    public static Date parseDate(String dateStr){
        if(StringUtil.isEmpty(dateStr)){
            return null;
        }
        String parse = dateStr;
        DateFormat format = null;
        parse = parse.replaceFirst("^(18|19|[2-9][0-9]){1}[0-9]{2}([^0-9]?)", "yyyy$2");
        parse = parse.replaceFirst("^[0-9]{2}([^0-9]?)", "yy$1");
        parse = parse.replaceFirst("([^0-9]?)(1{1}[0-2]{1}|0?[1-9]{1})([^0-9]?)", "$1MM$3");
        parse = parse.replaceFirst("([^0-9]?)(3{1}[0-1]{1}|[0-2]?[0-9]{1})([^0-9]?)", "$1dd$3");
        parse = parse.replaceFirst("([^0-9]?)(2[0-3]{1}|[0-1]?[0-9]{1})([^0-9]?)", "$1HH$3");
        parse = parse.replaceFirst("([^0-9]?)[0-5]?[0-9]{1}([^0-9]?)", "$1mm$2");
        parse = parse.replaceFirst("([^0-9]?)[0-5]?[0-9]{1}([^0-9]?)", "$1ss$2");
        try {
            format = new SimpleDateFormat(parse);
            //设置为严格验证时间格式，默认是非严格的，1月32不会报错，会解析为2月1号。
            format.setLenient(false);
            Date date = format.parse(dateStr);
            log.debug("原始字符串：{},判断格式：{},解析结果：date{}", dateStr,parse, DateFormatUtils.format(date,"yyyy-MM-dd hh:mm:ss"));
            return date;
        } catch (Exception e) {
            log.error("日期解析出错：{}-->{}",parse,dateStr);
            log.debug(null, e);
        }
        return null;
    }
//    YYYY-M-D
//    YYYY-MM
//            YYYY年M月D日
//    YYYY年M月
//    YYYY/M/D
//    MM/DD/YY
//    M/D
//    YYYY-MM-DD
//    YYYY-MM
//            YYYYMM
//    MM/DD
//    YYYY.MM.DD
//    YYYY.M.D
//    YYYY.MM
//    YYYY.M
//    YYYY/MM/DD
//    YYYY-MM-DD HH:MM
//    YYYY-MM-DD HH:MM AM
    public static void main(String[] args) {
        XylearnApplicationTests.parseDate("3301-11-23");
        XylearnApplicationTests.parseDate("2021年11月23日");
        XylearnApplicationTests.parseDate("2021-1-23");
        XylearnApplicationTests.parseDate("2021/11/23");
        XylearnApplicationTests.parseDate("2021/1/23");
        XylearnApplicationTests.parseDate("1/23");
    }

    @Test
    public void collection() {
        int[] lis = {1,2,6,7,9,3};
        int[] a = new int[]{};
        a[0] = 2;
        List<Integer> l = new ArrayList<>();
        Integer [] objects = (Integer[])l.toArray();
        Arrays.stream(lis).boxed().collect(Collectors.toList());
    }

    @Test
    public void quickSort() {
        int[] list = {4,6,7,2,1,4};
        qiuckS(list,0,list.length-1);
        for (int i : list) {
            System.out.print(i+",");
        }
    }
    private void qiuckS(int[] a, int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] > index)
                j--;

            while (i < j && a[i] <= index)
                i++;
            if (i < j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }// 用比基准大的记录替换高位记录

        }
        a[low] =a[i];
        a[i] = index;// 将基准数值替换回 a[i]
        qiuckS(a, low, i - 1); // 对低子表进行递归排序
        qiuckS(a, i + 1, hight); // 对高子表进行递归排序
    }


    @Test
    public void merge() {
        int[] list = {4,6,7,2,1,4};
        mergeS(list,0,list.length-1);
        for (int i : list) {
            System.out.print(i+",");
        }
    }

    private void mergeS(int[] list, int start, int end) {
        int mid = (start+end)/2;
        if (start < end){

            mergeS(list,start,mid);
            mergeS(list,mid+1,end);
            mergeSort(list,start,mid,end);
        }

    }

    private void mergeSort(int[] list, int start, int mid, int end) {
        if (start >= end) {
            return;
        }
        int[] temp = new int[end - start + 1];
        int l1 = start;
        int i = 0;
        int l2 = mid+1;
        while (l1 <= mid && l2 <= end){
            if (list[l1] < list[l2]){
                temp[i++] = list[l1++];
            }else {
                temp[i++] = list[l2++];
            }
        }
        while (l1<=mid){
            temp[i++] = list[l1++];
        }
        while (l2<=end){
            temp[i++] = list[l2++];
        }
        for (int k = 0;k<temp.length;k++){
            list[start+k] = temp[k];
        }

    }

}
