package org.laputa.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.laputa.mybatis.entity.Employee;

public interface EmployeeMapper {

    @Insert("insert into employee(id,name,email,gender,dep_id) values(null,#{name},#{email},#{gender},#{dep.id})")
    void insertOne(Employee emp);

}
