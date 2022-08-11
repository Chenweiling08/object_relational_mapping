package com.example.object_relational_mapping;

import com.example.object_relational_mapping.JpaSpecificationExecutor.CoursePo;
import com.example.object_relational_mapping.JpaSpecificationExecutor.SchedulePo;
import com.example.object_relational_mapping.JpaSpecificationExecutor.StudentPo;
import com.example.object_relational_mapping.dao.StudentPoDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

/**
 * @program: object_relational_mapping
 * @description
 * @author: 陈炜灵
 * @create: 2022-05-20 09:00
 **/
//@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(true)
public class TestJpaSpecificationExecutor {
    @Autowired
    public StudentPoDao studentPoDao;

    //学生PO，姓名，性别，年龄
    //课程PO，课程名，学分，
    //选课表PO，学生id，课程id，成绩
    @Test
    public void Query() {
        //查询1张表
        Specification<StudentPo> stu = new Specification<StudentPo>() {
            //重新写方法
            //构造查询条件
            /**
             *   root    ：Root接口，代表查询的根对象，可以通过root获取实体中的属性
             *   query   ：代表一个顶层查询对象，用来自定义查询
             *   cb      ：用来构建查询，此对象里有很多条件方法
             **/
            @Override
            public Predicate toPredicate(Root<StudentPo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //获取属性
                Path<Object> stuid = root.get("stu_id");
                //构建查询条件
                Predicate predicate = cb.equal(stuid, 1);
                return predicate;
            }
        };
       Optional<StudentPo> studentPo = studentPoDao.findOne(stu);
        System.out.println(studentPo);
    }

        //两张表查询
        @Test
        public void Query2(){
            Specification<StudentPo> stu=new Specification<StudentPo>() {
                @Override
                public Predicate toPredicate(Root<StudentPo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cd) {

                    Join<StudentPo, SchedulePo> join=root.join("schedulePo",JoinType.INNER);
                    return cd.like(join.get("stu_id").as(String.class),"1");
                }
            };
            List<StudentPo> list=studentPoDao.findAll(stu);
            for (StudentPo studentPo : list) {
                System.out.println(studentPo);
            }
        }
        //多张表
        @Test
    public void query3(){
            Specification<StudentPo> stu= new Specification<StudentPo>() {
                @Override
                public Predicate toPredicate(Root<StudentPo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                    Join<StudentPo, SchedulePo> test=root.join("schedulePo",JoinType.INNER);
                    Join<Object,CoursePo> re=test.join("coursePo",JoinType.INNER);
                    return cb.like(re.get("id").as(String.class),"1");
                }
            };
            List<StudentPo> list=studentPoDao.findAll(stu);
            for (StudentPo studentPo : list) {
                System.out.println(studentPo);
            }
        }

        //where语句和选择特定的字段
        @Test
        public void Query4() {
            //查询1张表
            Specification<StudentPo> stu = new Specification<StudentPo>() {
                //重新写方法
                //构造查询条件
                /**
                 *   root    ：Root接口，代表查询的根对象，可以通过root获取实体中的属性
                 *   query   ：代表一个顶层查询对象，用来自定义查询
                 *   cb      ：用来构建查询，此对象里有很多条件方法
                 **/
                @Override
                public Predicate toPredicate(Root<StudentPo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                    //获取属性
                    Path<Object> stu_id= root.get("stu_id");
                    Path<Object> Name= root.get("Name");
                    //构建查询条件
                    Predicate p1 = cb.equal(stu_id, "1");
                    Predicate p2 = cb.equal(Name, "asdas");
                    //条件合并
                    Predicate predicate = cb.and(p1,p2);
                    return predicate;
                }
            };
            Optional<StudentPo> studentPo = studentPoDao.findOne(stu);
            System.out.println(studentPo);
        }


}
