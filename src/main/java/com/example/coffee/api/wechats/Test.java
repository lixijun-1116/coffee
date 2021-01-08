package com.example.coffee.api.wechats;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: Test
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/7/6 23:30
 */
public class Test {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        String []a=new String[5];
        for (int i = 0; i < 5; i++) {
            a[i]= s.next();;
        }
        Map<String,Integer>map=new HashMap<>();
        for (String s1 : a) {
            if (map.containsKey(s1)){
                map.put(s1,map.get(s1)+1);
            }else {
                map.put(s1,1);
            }
        }

        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string+"    "+map.get(string));
        }




    }

}
