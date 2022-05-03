package com.example.object_relational_mapping.PO;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Author:陈炜灵
 * @Date:2022/5/3 15:58
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "student")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@DomainDataObject("student")
public class Student {
    /**
     * Id
     */
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String Id;

    /**
     * 姓名
     */
    @Column
    private  String Name;

    /**
     * 姓名
     */
    @Column
    private  String Class;

    /**
     * 年龄
     */
    @Column
    private String Age;

}
