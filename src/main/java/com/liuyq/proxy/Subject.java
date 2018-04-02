package com.liuyq.proxy;

/**
 * Created by Administrator on 2018/3/27 0027.
 */
public interface Subject {

        /**
         * 你好
         *
         * @param name
         * @return
         */
        public String SayHello(String name);

        /**
         * 再见
         *
         * @return
         */
    public String SayGoodBye();

}
