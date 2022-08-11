package com.example.object_relational_mapping.dao;

import com.example.object_relational_mapping.JpaSpecificationExecutor.StudentPo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author:陈炜灵
 * @Date:2022/5/20 10:14
 * @Version 1.0
 */

public interface StudentPoDao extends JpaRepository<StudentPo,String>, JpaSpecificationExecutor<StudentPo> {
}
