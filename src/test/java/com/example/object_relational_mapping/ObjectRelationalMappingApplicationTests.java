package com.example.object_relational_mapping;

import com.example.object_relational_mapping.PO.Student;
import com.example.object_relational_mapping.PO.StudentDao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
class ObjectRelationalMappingApplicationTests {
    @Autowired
    Stu stu;

    @Autowired
    StudentDao studentDao;

    @Test
   public void contextLoads() throws ClassNotFoundException {

        Student student = new Student();
        student.setName("张三");
        student.setZlass("1");
        student.setAge("111");
        studentDao.save(student);

        Assert.assertTrue(stu.addTable(Student.class));

        List<Student> query = (List<Student>) stu.query(Student.class);
        Assert.assertEquals(1,query.size());

        Student student1 = query.get(0);
        Assert.assertEquals(student,student1);

    }

}
