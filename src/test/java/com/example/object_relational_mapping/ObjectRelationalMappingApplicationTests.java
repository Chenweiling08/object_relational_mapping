package com.example.object_relational_mapping;

import com.example.object_relational_mapping.PO.Student;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

class ObjectRelationalMappingApplicationTests {
    @Autowired
    Stu stu;
    @Test
   public void contextLoads() throws ClassNotFoundException {
        stu.Query();

    }

}
