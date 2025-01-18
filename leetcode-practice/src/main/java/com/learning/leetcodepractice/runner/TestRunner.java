package com.learning.leetcodepractice.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {

        String[] array = {"Apple", "Banana", "Cherry"};
        List<String> list = Arrays.asList(array);
        for (String l : list){
            System.out.println(l);
        }
        list.toArray();

        List<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list1.add(4);
        System.out.println(list1.get(1));

        Hashtable<String,String> map = new Hashtable<>();
        map.put("null","null");
        map.get("null");

     }
}
