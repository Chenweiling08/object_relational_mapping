package com.example.object_relational_mapping;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author:陈炜灵
 * @Date:2022/4/30 12:13
 * @Version 1.0
 * 默认mysql连接器
 */
@Data
@Service
public class Connector implements ConnectionDataStoreObject{
    Connection connection;
    @Override
    // 连接数据存储对象
    public boolean ConnectDataStoreObjects(ConnectionParameters connectionParameters)
            throws ClassNotFoundException, SQLException {
        //1.加载驱动程序
        Class.forName(connectionParameters.getDrive());
        //2. 获得数据库连接
        connection= DriverManager.getConnection
                (
                        connectionParameters.getUrl(),
                        connectionParameters.getUser(),
                        connectionParameters.getPassword()
                );
        return true;
    }
    @Override
    //创建对象
    public Statement statement() throws SQLException {
            Statement statement=connection.createStatement();
        return statement;
    }
}
