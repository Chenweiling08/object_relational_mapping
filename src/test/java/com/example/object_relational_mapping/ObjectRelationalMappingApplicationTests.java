package com.example.object_relational_mapping;

import com.example.object_relational_mapping.dao.CourseDao;
import com.example.object_relational_mapping.dao.ScheduleDao;
import com.example.object_relational_mapping.po.Course;
import com.example.object_relational_mapping.po.Schedule;
import com.example.object_relational_mapping.po.Student;
import com.example.object_relational_mapping.dao.StudentDao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.security.Timestamp;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
class ObjectRelationalMappingApplicationTests {
    @Autowired
    Realizedemo stu;
    @Autowired
    StudentDao studentDao;
    ScheduleDao scheduleDao;
    CourseDao courseDao;
    @Test
   public void contextLoads() throws ClassNotFoundException {
        Student student = new Student();
        student.setName("张三");
        student.setStuAge("111");
        student.setStuClass("1");
        student.setCouNumber("1");
            studentDao.save(student);

        Schedule schedule=new Schedule();
//        Date t = new Date();
//        Time time = new java.sql.Time(t.getTime());
        schedule.setName("张三");
        schedule.setCouName("数学");
        schedule.setTeacher("张三丰");
        schedule.setClassroom("25#603");
//        schedule.setSchTime(Time.valueOf("22.1.11 10:24"));
        scheduleDao.save(schedule);

        Course course=new Course();
        course.setName("张三");
//        course.setCouTime(Time.valueOf("22.1.12 10:24"));
        course.setStuClass("25#306");
        course.setCouName("数学");
        course.setCouNumber("1");
        courseDao.save(course);

        Assert.assertTrue(stu.addTable(Student.class));

        List<Student> query = (List<Student>) stu.query(Student.class);
        Assert.assertEquals(1,query.size());

        Student student1 = query.get(0);
        Assert.assertEquals(student,student1);


    }

}
