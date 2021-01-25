package org.laputa.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.laputa.mybatis.entity.Department;
import org.laputa.mybatis.utils.SqlSessionUtil;

import java.io.IOException;

public class DepartmentMapperTest {

    @Test
    public void getDepWithEmpsTest() {
        try {
            SqlSession session = SqlSessionUtil.getSqlSession();
            DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);

            Department dep = mapper.getDepWithEmps(1);
            System.out.println(dep);

            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}