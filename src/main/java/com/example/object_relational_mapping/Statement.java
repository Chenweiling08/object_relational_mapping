package com.example.object_relational_mapping;

import org.springframework.stereotype.Service;

/**
 * @Author:陈炜灵
 * @Date:2022/4/30 13:38
 * @Version 1.0
 * 存储sql语句
 */
@Service
public class Statement {
    public String sql="select * from information_schema.tables where table_schema = 'demo1'";
}
