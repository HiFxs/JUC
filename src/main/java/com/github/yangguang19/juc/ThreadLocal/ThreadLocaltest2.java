package com.github.yangguang19.juc.ThreadLocal;

public class ThreadLocaltest2 {
public  static  ThreadLocal<String> threadLocal=new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("hello world");
        Thread thread=new Thread(() -> {
            System.out.println("thread:"+threadLocal.get());
        });
        thread.start();


        System.out.println("main:"+threadLocal.get());
    }



}
