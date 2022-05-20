package com.example.object_relational_mapping.po;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;

/**
 * @Author:陈炜灵
 * @Date:2022/5/11 10:45
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "schedule")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@DomainDataObject(value = "Schedule",num = 1,where = "")
public class Schedule {
    /**
     * Id
     */
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String schId;
    /**
     * 课程号
     */
    @Column
    private String couNumber;

    /**
     * 上课时间
     */
    @Column
    private Time schTime;

    /**
     * 上课教师
     */
    @Column
    private String Teacher;

    /**
     * 上课教室
     */
    @Column
    private String Classroom;
}
