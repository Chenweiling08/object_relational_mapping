package com.example.object_relational_mapping.JpaSpecificationExecutor;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author:陈炜灵
 * @Date:2022/5/20 9:16
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "studentpo")
public class StudentPo {
    /**
     * Id
     */
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name="stu_id")
   private long stu_id;

    /**
     * 姓名
     */
    @Column(name="Name")
    private  String Name;

    /**
     * 年龄
     */
    @Column(name="stu_Age")
    private String Age;

    @ManyToOne
    @JoinColumn(name="sch_id")
    private SchedulePo schedulePo;

}
