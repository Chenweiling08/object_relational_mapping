package com.example.object_relational_mapping.PO;

import org.hibernate.jpa.HibernateEntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

/**
 * @Author:陈炜灵
 * @Date:2022/5/4 15:34
 * @Version 1.0
 */
@Service
public class Stu {
    @PersistenceContext
    private EntityManager em;
    @PersistenceUnit
    private EntityManagerFactory factory;

    @Bean
    public void Query() {
        // sql
        String sql = "select * from student";
        // 执行查询 并把结果专为实体类
        Query query = em.createNativeQuery(sql,Student.class);
        // 获取查询结果
        List<Student> students = query.getResultList();
        query.getFirstResult();
        for(Student b:students){
            System.out.println(b);
        }

    }
    public  void add()  {
         em = factory.createEntityManager();
        em.getTransaction().begin();
        String sql="create table IF NOT EXISTS table_1" +
                "(id INTEGER not NULL, firstName VARCHAR(50),  lastName VARCHAR(50), age INTEGER, PRIMARY KEY ( id ))";
        HibernateEntityManager hibernateEntityManager=(HibernateEntityManager) em.getDelegate();
        hibernateEntityManager.createNativeQuery(sql).executeUpdate();
        hibernateEntityManager.close();
        em.getTransaction().commit();
        em.close();


    }

}

