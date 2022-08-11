package com.example.object_relational_mapping.JpaSpecificationExecutor;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author:陈炜灵
 * @Date:2022/5/20 9:25
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "schedulepo")
public class SchedulePo {
    /**
     * 学生Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sch_id")
    private long id;


    @Column(name = "stu_id")
    private String stu_id;

    /**
     * 课程Id
     */
    @Column(name = "cou_id")
    private String cou_id;

    /**
     * 成绩
     */
    @Column(name = "sch_Grade")
    private String Grade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cous_id")
    private CoursePo coursePo;
}
