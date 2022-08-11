package com.example.object_relational_mapping.JpaSpecificationExecutor;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:陈炜灵
 * @Date:2022/5/20 9:24
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "coursepo")
public class CoursePo {
    /**
     * Id
     */
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "cous_id",length = 32)
    private long id;

    /**
     * 课程名
     */
    @Column(name = "cou_name")
    private  String Cname;

    /**
     * 学分
     */
    @Column(name = "cou_credit")
    private String credit;


}
