package com.github.yangguang19.juc.ThreadLocal;

public class ThreadLocalTest {
static void print(String str){
    System.out.println(str+":"+localVariable.get());
    localVariable.remove();
}
    static ThreadLocal<String> localVariable=new ThreadLocal<String>();

    public static void main(String[] args) throws Exception{
        Thread threadone=new Thread(() -> {
          localVariable.set("threadone local variable");
            print("threadone");
            System.out.println("threadone remove after"+":"+localVariable.get());
        });
        Thread threadtwo=new Thread(() -> {
            localVariable.set("threadtwo local variable");
            print("threadtwo");
            System.out.println("threadtwo remove after"+":"+localVariable.get());
        });
        threadone.start();
        threadtwo.start();
    }
}
