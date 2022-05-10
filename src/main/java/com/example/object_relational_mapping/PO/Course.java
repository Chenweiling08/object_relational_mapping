package com.example.object_relational_mapping.PO;

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
@DomainDataObject("course")
public class Course {
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
    private  String name;

    /**
     * 课程名字
     */
    @Column
    private  String course_name;

    /**
     * 时间
     */
    @Column
    private Time time;


}
