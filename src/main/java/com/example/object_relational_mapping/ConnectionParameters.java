package com.example.object_relational_mapping;

import lombok.Data;

/**
 * @Author:陈炜灵
 * @Date:2022/4/30 12:08
 * @Version 1.0
 *默认mysql连接参数
 */
@Data
public class ConnectionParameters {
    private String Url;
    private String User;
    private String Password;
    private String Drive;
}
