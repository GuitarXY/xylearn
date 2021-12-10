//package com.example.xylearn;
//
//import cn.hutool.core.date.DateTime;
//import cn.hutool.core.date.DateUtil;
//import com.alibaba.com.caucho.hessian.io.Hessian2Input;
//import com.alibaba.com.caucho.hessian.io.Hessian2Output;
//import org.apache.dubbo.common.serialize.fst.FstObjectInput;
//import org.apache.dubbo.common.serialize.fst.FstObjectOutput;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.Date;
//
///**
// * @author xiaoy
// * @date 2021/12/2
// */
//public class TestHessionLite1 {
//    public static void main(String[] args) throws IOException {
//        DateTime dateTime = DateUtil.endOfMonth(
//                new Date());
//        byte[] aa=TestHessionLite1.serialize(dateTime);
//        Object mm=TestHessionLite1.deserialize(aa);
//        System.out.println(mm.toString());
//
//    }
//
//    public static byte[] serialize(Object obj) throws IOException{
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        Hessian2Output ho = new Hessian2Output(os);
//        byte[] cc = null;
//        try {
//            if(obj==null) throw new NullPointerException();
//            ho.writeObject(obj);
//            ho.flushBuffer();
//            cc=os.toByteArray();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            ho.close();
//        }
//        return cc;
//
//    }
//
//    public static Object deserialize(byte[] by) throws IOException {
//        try {
//            if(by==null) throw new NullPointerException();
//            ByteArrayInputStream is = new ByteArrayInputStream(by);
//            Hessian2Input hi = new Hessian2Input(is);
//            return hi.readObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }
//    public static byte[] serialize1(Object obj) throws IOException{
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        FstObjectOutput ho = new FstObjectOutput(os);
//        byte[] cc = null;
//        try {
//            if(obj==null) throw new NullPointerException();
//            ho.writeObject(obj);
//            ho.flushBuffer();
//            cc=os.toByteArray();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            ho.flushBuffer();
//        }
//        return cc;
//
//    }
//
//    public static Object deserialize1(byte[] by) throws IOException {
//        try {
//            if(by==null) throw new NullPointerException();
//            ByteArrayInputStream is = new ByteArrayInputStream(by);
//            FstObjectInput hi = new FstObjectInput(is);
//            return hi.readObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }
//}
