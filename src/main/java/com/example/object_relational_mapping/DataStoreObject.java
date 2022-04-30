package com.example.object_relational_mapping;

import java.sql.SQLException;

/**
 * @program: object_relational_mapping
 * @description数据存储对象
 * @author: 苏敏
 * @create: 2022-04-29 14:47
 **/
public interface DataStoreObject{
     //连接数据存储系统
     public  void ConnectDataStorageSystem() throws SQLException, ClassNotFoundException;


}
