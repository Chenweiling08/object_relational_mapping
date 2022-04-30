package com.example.object_relational_mapping;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author:陈炜灵
 * @Date:2022/4/30 12:43
 * @Version 1.0
 * mysql数据存储对象
 */
@Data
public class DataStoreObjectClass implements DataStoreObject{
    //连接器
    Connector connector;
    //连接参数
    ConnectionParameters connectionParameters;
    //业务需求的sql语句
    Statement sq;
    //对象关系映射
    DefaultObjectRelationalMapping objectRelationalMapping;
    @Override
    //连接数据存储系统
    public void ConnectDataStorageSystem() throws SQLException, ClassNotFoundException {
        connector.ConnectDataStoreObjects(connectionParameters);
        //查询结果
        ResultSet rs = connector.statement().executeQuery(sq.sql);
        //输出
        while (rs.next()) {
            System.out.println(rs.getString("TABLE_NAME"));
        }
    }

}
