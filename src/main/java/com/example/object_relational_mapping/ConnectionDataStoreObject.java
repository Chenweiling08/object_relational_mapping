package com.example.object_relational_mapping;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author:陈炜灵
 * @Date:2022/4/29 16:38
 * @Version 1.0
 * 连接数据存储对象
 */
@Service
public interface ConnectionDataStoreObject {
    //连接数据库
    public boolean ConnectDataStoreObjects(ConnectionParameters connectionParameters)
            throws ClassNotFoundException, SQLException;
    //创建Statement的方法
    public Statement statement() throws SQLException;

}
