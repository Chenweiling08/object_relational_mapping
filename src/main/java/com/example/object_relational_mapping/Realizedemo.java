package com.example.object_relational_mapping;

import com.example.object_relational_mapping.po.Demo;
import com.example.object_relational_mapping.po.DomainDataObject;
import lombok.SneakyThrows;
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
public class Realizedemo implements Demo {
    @PersistenceContext
    private EntityManager em;
    List<String> TableName = new ArrayList<>();

    @SneakyThrows
    @Override
    public Boolean addTable(Class s) {
        DomainDataObject a=(DomainDataObject)s.getAnnotation(DomainDataObject.class);
        String value = a.value();
        TableName.add(value);
        return true;
    }
    @Override
    public Object query(Class s) {
        List<Object> result = null;
        String judge = s.getSimpleName();
        // sql
        for (int i = 0; i < TableName.size(); i++) {
//            String sql = "select * from " + TableName.get(i) + "";
            StringBuilder sql = new StringBuilder(" select *  ");
            sql.append(" from " + TableName.get(i) + "");
            if (judge.equals(TableName.get(i))) {
                // 执行查询 并把结果专为实体类
                Query query = em.createNativeQuery(sql.toString(), s);
                // 获取查询结果
                result = query.getResultList();


            }
        }
        return result;
    }
}

