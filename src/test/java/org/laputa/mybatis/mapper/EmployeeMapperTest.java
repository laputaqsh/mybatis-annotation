package org.laputa.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.laputa.mybatis.entity.Department;
import org.laputa.mybatis.entity.Employee;
import org.laputa.mybatis.utils.SqlSessionUtil;

import java.io.IOException;
import java.util.List;

public class EmployeeMapperTest {

    @Test
    public void insertOneTest() {
        try {
            SqlSession session = SqlSessionUtil.getSqlSession();
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            Department dep = new Department(null, "采购部", "这里是采购部", null);
            Employee emp = new Employee(null, "白小白", "baixiaobai@qq.com", "女", dep);
            mapper.insertEmp(emp);

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectOneTest() {
        try {
            SqlSession session = SqlSessionUtil.getSqlSession();
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            Employee emp = mapper.selectEmpById(8);
            System.out.println(emp);

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectAllTest() {
        try {
            SqlSession session = SqlSessionUtil.getSqlSession();
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            List<Employee> emps = mapper.selectAll();
            emps.forEach(System.out::println);

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateEmpTest() {
        try {
            SqlSession session = SqlSessionUtil.getSqlSession();
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            Employee emp = mapper.selectEmpById(8);
            emp.setName("罗小黑");
            mapper.updateEmp(emp);

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteEmpTest() {
        try {
            SqlSession session = SqlSessionUtil.getSqlSession();
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            mapper.deleteEmp(8);

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getEmpWithDepTest() {
        try {
            SqlSession session = SqlSessionUtil.getSqlSession();
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

            Employee emp = mapper.getEmpWithDep(7);
            System.out.println(emp);

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}