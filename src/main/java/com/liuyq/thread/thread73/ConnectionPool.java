package com.liuyq.thread.thread73;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by Administrator on 2018/8/14 0014.
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool (int initialSize){
        if(initialSize > 0 ){
            for(int i =0 ;i<initialSize ;i++){
                pool.addLast(ConnectionDriver.createConnection);
            }
        }
    }

    public void releaseConnection(Connection connection){
        if(connection != null){
            synchronized (pool){
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }


}
