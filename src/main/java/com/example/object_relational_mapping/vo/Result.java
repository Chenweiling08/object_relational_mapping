package com.example.object_relational_mapping.vo;

import com.example.object_relational_mapping.po.DomainDataObject;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;

/**
 * @Author:陈炜灵
 * @Date:2022/5/13 11:16
 * @Version 1.0
 */
@Data
@Entity
@DomainDataObject(
        value = "schedule t1,course t2",
        num =2,
        where = "t1.cou_number=t2.cou_number "
)
public class Result {
    @Id
    private String schId;
    private String couNumber;
    private Time schTime;
    private String Teacher;
    private String Classroom;
    private String couId;
    private  String stuClass;
    private  String couName;
    private Time couTime;
}
