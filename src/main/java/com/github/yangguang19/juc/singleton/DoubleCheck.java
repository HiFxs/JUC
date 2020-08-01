package com.github.yangguang19.juc.singleton;

import java.util.Objects;

/**
 * @Description : 单例模式 - 双端检索机制
 * @Author :    yangguang
 * @Date :      2019/11/23
 */
public class DoubleCheck {

    private static volatile DoubleCheck doubleCheck = null;

    public static DoubleCheck getInstance()
    {
        if(Objects.isNull(doubleCheck))
        {
            synchronized (DoubleCheck.class)
            {
                if(doubleCheck == null)
                {
                    doubleCheck = new DoubleCheck();
                }
            }
        }
        return doubleCheck;
    }

    public static void main(String[] args) {
        System.out.println(getInstance() == getInstance());
        System.out.println(getInstance() == getInstance());


        for (int i = 0; i < 20; ++i)
        {
            new Thread(()->{
                System.out.println(getInstance());
            }).start();
        }
    }

}
