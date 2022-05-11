package com.example.object_relational_mapping.dao;

import com.example.object_relational_mapping.po.Course;
import com.example.object_relational_mapping.po.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:陈炜灵
 * @Date:2022/5/11 10:33
 * @Version 1.0
 */

public interface CourseDao extends JpaRepository<Course,String> {
}
