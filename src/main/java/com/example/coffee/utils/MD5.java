package com.example.coffee.utils;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MD5 {

    public static String getMD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }
    static boolean foo(char c){
        System.out.println(c);
        return true;
    }
    // 测试主函数
    public static void main(String args[]) {
//        String s = new String("121212");
//        System.out.println("原始：" + s);
////        System.out.println("MD5后：" + string2MD5(s));
//        System.out.println("加密的：" + convertMD5(s));
//        System.out.println("解密的：" + convertMD5(convertMD5(s)));
//        int i = 0;
//        for(foo('a'); foo('b') && (i<2); foo('c')){
//            i++;
//            foo('d');
//        }
        String a = "140511199801110912";
        int i = countAge(a);
        System.out.println(i);
    }

    //根据身份证号输出年龄
    public static int countAge(String idNumber) {
        if(idNumber.length() != 18 && idNumber.length() != 15){
            throw new IllegalArgumentException("身份证号长度错误");
        }
        String year;
        String yue;
        String day;
        if(idNumber.length() == 18){
            year = idNumber.substring(6).substring(0, 4);// 得到年份
            yue = idNumber.substring(10).substring(0, 2);// 得到月份
            day = idNumber.substring(12).substring(0,2);//得到日
        }else{
            year = "19" + idNumber.substring(6, 8);// 年份
            yue = idNumber.substring(8, 10);// 月份
            day = idNumber.substring(10, 12);//日
        }
        Date date = new Date();// 得到当前的系统时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String fyear = format.format(date).substring(0, 4);// 当前年份
        String fyue = format.format(date).substring(5, 7);// 月份
        String fday=format.format(date).substring(8,10);//
        int age = 0;
        if(Integer.parseInt(yue) == Integer.parseInt(fyue)){//如果月份相同
            if(Integer.parseInt(day) < Integer.parseInt(fday)){//说明已经过了生日或者今天是生日
                age = Integer.parseInt(fyear) - Integer.parseInt(year);
            }else{
                age = Integer.parseInt(fyear) - Integer.parseInt(year) - 1;
            }
        }else{
            if(Integer.parseInt(yue) < Integer.parseInt(fyue)){
                //如果当前月份大于出生月份
                age = Integer.parseInt(fyear) - Integer.parseInt(year);
            }else{
                //如果当前月份小于出生月份,说明生日还没过
                age = Integer.parseInt(fyear) - Integer.parseInt(year) - 1;
            }
        }
        System.out.println("age = " + age);
        return age;
    }
}
