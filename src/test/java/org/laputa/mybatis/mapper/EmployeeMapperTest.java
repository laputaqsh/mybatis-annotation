package org.laputa.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.laputa.mybatis.entity.Department;
import org.laputa.mybatis.entity.Employee;
import org.laputa.mybatis.utils.SqlSessionUtil;

import java.io.IOException;

public class EmployeeMapperTest {

    @Test
    public void insertOneTest() {
        try {
            SqlSession session = SqlSessionUtil.getSqlSession();
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            Department dep = new Department(null, "采购部", "这里是采购部", null);
            Employee emp = new Employee(null, "白小白", "baixiaobai@qq.com", "女", dep);
            mapper.insertOne(emp);

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}