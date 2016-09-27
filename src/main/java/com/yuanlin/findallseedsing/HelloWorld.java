package com.yuanlin.findallseedsing;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class HelloWorld {
    private HelloWorld(){
    }

    private static  HelloWorld instance = null;

    public synchronized  static HelloWorld getinstance(){
        if (instance==null){
            instance = new HelloWorld();
        }
        return  instance;
    }


}
