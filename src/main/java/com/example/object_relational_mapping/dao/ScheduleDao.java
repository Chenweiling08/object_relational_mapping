package com.example.object_relational_mapping.dao;

import com.example.object_relational_mapping.po.Course;
import com.example.object_relational_mapping.po.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:陈炜灵
 * @Date:2022/5/11 10:58
 * @Version 1.0
 */

public interface ScheduleDao extends JpaRepository<Schedule,String> {
}
