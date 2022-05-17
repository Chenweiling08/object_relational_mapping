package com.example.object_relational_mapping.po;

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
@Table(name = "Student")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@DomainDataObject(value = "Student",num =1)
public class Student {
    /**
     * Id
     */
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String stuId;

    /**
     * 姓名
     */
    @Column
    private  String Name;

    /**
     * 年龄
     */
    @Column
    private String stuAge;

    /**
     * 班级
     */
    @Column
    private  String stuClass;

    /**
     * 课程号
     */
    @Column
    private String couNumber;
}
