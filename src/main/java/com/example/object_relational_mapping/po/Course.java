package com.example.object_relational_mapping.po;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;

/**
 * @Author:陈炜灵
 * @Date:2022/5/10 14:33
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "course")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@DomainDataObject(value = "Course",num =1,where = "")
public class Course {
    /**
     * Id
     */
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String couId;

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

    /**
     * 课程名字
     */
    @Column
    private  String couName;

    /**
     * 课程开始时间
     */
    @Column
    private Time couTime;


}
