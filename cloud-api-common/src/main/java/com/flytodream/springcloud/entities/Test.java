package com.flytodream.springcloud.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * @Date 2021/6/1 11:03
 * @Author by tongxm
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("1");
        objects.add("2");
        objects.add("3");
        objects.add("4");
        objects.add("5");
        te te = new te(objects);
        delete(objects,"3");
        System.out.println(te.list);
    }


    public static void delete(List<String> des,String s){
        Iterator<String> iterator = des.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            if(iterator.next().equals(s)){
                iterator.remove();
            }
        }
    }


    static class te{
        List<String> list = new ArrayList<>();
        public  te(List<String> list){
            this.list = list;
        }
    }
}
