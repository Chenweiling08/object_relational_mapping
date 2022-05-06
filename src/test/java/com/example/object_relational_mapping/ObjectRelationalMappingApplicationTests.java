package com.example.object_relational_mapping;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
@RunWith(SpringRunner.class)
@SpringBootTest
class ObjectRelationalMappingApplicationTests {
    @Autowired
   private DataStoreObjectClass dataStoreObjectClass;
    @Test
   public void contextLoads() throws SQLException, ClassNotFoundException {

        //连接数据库
       dataStoreObjectClass.connector.ConnectDataStoreObjects(dataStoreObjectClass.connectionParameters);
        //创建数据查询
        dataStoreObjectClass.connector.statement();
        //执行sql语句并查询结果
        ResultSet rs=dataStoreObjectClass.connector.statement().executeQuery(dataStoreObjectClass.sq.sql);
        //输出
        while (rs.next()) {
            System.out.println(rs.getString("TABLE_NAME"));
        }


    }

}
