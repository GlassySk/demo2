package com.example.demo2.entity;

public class demo {
    public static void main(String[] args) {

        if (new demo().panduan()){
            System.out.println("错误");
        }else {
            System.out.println("正确");
        }
        System.out.println("nihao");
    }
    Boolean panduan(){
        String code="qwer";
        String codes="qwr";
        if (!codes.equalsIgnoreCase(code)){
            System.out.println("1");
        }
        return true;
    }
}
