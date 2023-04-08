package com.example.xylearn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alipay.service.schema.util.StringUtil;
import com.example.xylearn.common.ListNode;
import com.example.xylearn.controller.A;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
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
    public static void main(String[] args) throws Exception {
        String stt = "{p1:\"13755610449\",p2:1478692546573825,p3:[{f1:\"\",f2:\"1\"},{f1:null,f2:\"\"}]}";

        final Map map1 = JSON.parseObject(stt, Map.class);
//        String tiu = JSON.toJSONString(map1, SerializerFeature.w);


//        Long.parseLong("10117310162518020010");
        for (int i = 0; i < 5; i++) {
            if(i<5){
                if (i==3){
                    continue;
                }
                if (i==3){
                    throw new Exception("");
                }
            }

        }
//        File flie = new File("C:\\Users\\MC-701\\Desktop\\my\\fq\\chang.txt");
        String path = "C:\\Users\\MC-701\\Desktop\\my\\fq\\cc.txt";

        File file = new File(path);
        StringBuilder content = new StringBuilder();
        String encoding = "utf-8";
        try (InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
             BufferedReader bufferedReader = new BufferedReader(read)) {
            //判断文件是否存在
            if (file.isFile() && file.exists()) {
                String lineTxt;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    content.append(lineTxt);
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
        }
//        System.out.println(content);
        Map map = JSON.parseObject(content.toString(), Map.class);
//        final String s = JSON.toJSONString(null);
//        final A a = JSONObject.parseObject(s, A.class);
//        XylearnApplicationTests.parseDate("3301-11-23");
//        XylearnApplicationTests.parseDate("2021年11月23日");
//        XylearnApplicationTests.parseDate("2021-1-23");
//        XylearnApplicationTests.parseDate("2021/11/23");
//        XylearnApplicationTests.parseDate("2021/1/23");
//        XylearnApplicationTests.parseDate("1/23");
        final XylearnApplicationTests xylearnApplicationTests = new XylearnApplicationTests();
        ListNode l = ListNode.of("1,2,3,4,5,6,7,8");

        List<List<String>> guanlian = new ArrayList<>();
        guanlian.add(Arrays.asList("A","B,C"));
        guanlian.add(Arrays.asList("B","C"));
        guanlian.add(Arrays.asList("C","E"));
        guanlian.add(Arrays.asList("E","B"));
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        final List<String> strings = xylearnApplicationTests.get(list, guanlian, "E");
        System.out.println(strings);
    }
    List<String> get(List<String> list,List<List<String>> guanlian,String s){
        List<String> g = new ArrayList<>();
        getAll(s,guanlian,g);
        list.removeAll(g);
        return list;
    }

    private void getAll(String s, List<List<String>> guanlian,List<String> re) {
        re.add(s);
        for (List<String> strings : guanlian) {
            if (strings.get(1).contains(s)){
                getAll(strings.get(0),guanlian,re);
            }
        }
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
    private void qiuckS11(int[] list, int low, int hight) {
        if (low>=hight){
            return;
        }
        int stander = list[low];
        int i = low+1;
        int j = hight;
        while(i<j){
            while(i<j&&list[i]<=stander){
                i++;
            }
            while(i<j&&list[j]>stander){
                j--;
            }
        }
        //分开
        qiuckS11(list,low,low+hight/2);
        qiuckS11(list,low+hight/2+1, hight);
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




    public void MergesS(int[] list1,int start,int end){
        int mid = start + (start+end)/2;
        if (start<end){
            mergeS(list1,start,mid);
            mergeS(list1,mid+1,end);
            mS(list1,start,mid,end);
        }

    }
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void appendTail(int value) {
        s2.push(value);
    }

    public int deleteHead() {
        if (s1.isEmpty()){
            //s2,倒入s1
            if (s2.isEmpty()){
                return -1;
            }
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }

    private void mS(int[] list1, int start, int mid, int end) {
        if (start>=end){
            return;
        }
        int[] temp = new int[end-start+1];
        int t = 0;
        int i = start;
        int j = mid+1;
        while(i<=mid && j<=end){
            if ( list1[i]<=list1[j]){
                temp[t++] = list1[i];
                i++;
            }else {
                temp[t++] = list1[j];
                j++;
            }
        }
        while (i<=mid) {
            temp[t++] = list1[i];
            i++;
        }
        while (j<=mid){
            temp[t++] = list1[j];
            j++;
        }
        System.arraycopy(temp,0,list1,start,temp.length);
    }




    public String removeKdigits(String num, int k) {
        final char[] chars = num.toCharArray();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (st.isEmpty()){
                st.push(i);
                continue;
            }
            if (k==0){
                st.push(i);
                continue;
            }
            if (chars[st.peek()] <= chars[i]){
                st.push(i);
            }else {
                while (!st.isEmpty() && k != 0 && chars[st.peek()] > chars[i]){
                    st.pop();
                    k--;
                }
                st.push(i);
            }
        }

        String re = "";
        for (Integer integer : st) {
            re =  re + chars[integer];
        }
        if (k!= 0){
            if (re.length() > k){
                re = re.substring(0,re.length()-k);
            }else {
                re = "0";
            }
        }
        while (re.length()>1 && re.startsWith("0")){
            re = re.substring(1);
        }
        return re;

    }

    @Test
    public void merge() {

        int[] list = {4,6,7,2,1,4};
        MergesS(list,0,list.length-1);
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


    public void merge(int[] list,int start,int end) {
        int mid = (start + end )/2;
        merge(list,start, mid);
        merge(list,mid+1, end);
        mergeS1(list,start,mid,end);
    }

    private void mergeS1(int[] list, int start, int mid, int end) {
        int i = start;
        int j =mid;
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
        if (temp.length >= 0) System.arraycopy(temp, 0, list, start + 0, temp.length);

    }

}
