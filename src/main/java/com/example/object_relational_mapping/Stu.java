package com.example.object_relational_mapping;

import ch.qos.logback.classic.db.names.TableName;
import com.example.object_relational_mapping.PO.Course;
import com.example.object_relational_mapping.PO.Demo;
import com.example.object_relational_mapping.PO.DomainDataObject;
import com.example.object_relational_mapping.PO.Student;
import lombok.SneakyThrows;
import org.hibernate.jpa.HibernateEntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/5/4 15:34
 * @Version 1.0
 */
@Service
public class Stu implements Demo {
    @PersistenceContext
    private EntityManager em;
    @PersistenceUnit
    private EntityManagerFactory factory;
    List<String> TableName = new ArrayList<>();

    @SneakyThrows
    @Override
    public void addTable(Student student) {
      Class ss=Class.forName("com.example.object_relational_mapping.PO.Student");
       Class zz=Class.forName("com.example.object_relational_mapping.PO.Course");
        DomainDataObject a=(DomainDataObject)ss.getAnnotation(DomainDataObject.class);
//        DomainDataObject b=(DomainDataObject)zz.getAnnotation(DomainDataObject.class);
        String value = a.value();
//        String values=b.values();
        TableName.add(value);
//        TableName.add(values);
        for(String Table:TableName){
            System.out.println(Table);
        }
    }
    @Override
    public void query() {
        // sql
        for (int i = 0; i < TableName.size(); i++) {
            String sql = "select * from " + TableName.get(i) + "";
            if (TableName.get(i).toString()== "Student") {
                // 执行查询 并把结果专为实体类
                Query query = em.createNativeQuery(sql, Student.class);
                // 获取查询结果
                List<Student> students = query.getResultList();
                for (Student a : students) {
                    System.out.println(a);
                }
            }
                if (TableName.get(i) == "Course") {
                    Query query1 = em.createNativeQuery(sql,Course.class);
                    // 获取查询结果
                    List<Course> Course = query1.getResultList();
                    for (Course b : Course) {
                        System.out.println(b);
                    }
                }
        }
    }

}

