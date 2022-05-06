package com.example.object_relational_mapping;

import lombok.Data;
import org.springframework.stereotype.Service;

/**
 * @Author:陈炜灵
 * @Date:2022/4/30 12:08
 * @Version 1.0
 *默认mysql连接参数
 */
@Data
@Service
public class ConnectionParameters {
    private String Url="jdbc:mysql://127.0.0.1:3306/demo1?characterEncoding=utf-8&serverTimezone=UTC";
    private String User="root";
    private String Password="cwl123";
    private String Drive="com.mysql.cj.jdbc.Driver";
}
