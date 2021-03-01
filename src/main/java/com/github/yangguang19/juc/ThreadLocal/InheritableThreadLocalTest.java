package com.github.yangguang19.juc.ThreadLocal;

public class InheritableThreadLocalTest {
    public  static  InheritableThreadLocal<String> threadLocal=new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("hello world");
        Thread thread=new Thread(() -> {
            System.out.println("thread:"+threadLocal.get());
        });
        thread.start();


        System.out.println("main:"+threadLocal.get());
    }


}
