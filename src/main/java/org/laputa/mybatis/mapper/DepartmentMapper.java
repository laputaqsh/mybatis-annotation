package org.laputa.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.laputa.mybatis.entity.Department;

public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    Department selectDep(Integer id);

    /**
     * 根据部门编号查询部门级联查询该部门下所有员工
     *
     * @Results：代替的是<resultMap>标签，注解中可以使用单个@Result注解，也可以使用@Result集合
     * @Result：代替的是<id>标签和<result>标签
     * id：是否为主键，是为true，否为false
     * column：数据库的列名
     * property：实体类的属性名
     * @Many：一对多配置，代替的是<collection>标签，是多表查询的关键，在注解中用来指定子查询返回对象集合
     * select：指定用来多表查询的sqlmapper，它是对应接口方法的全限定方法名
     * fetchType：懒加载配置，会覆盖全局的配置参数 lazyLoadingEnabled，一对多一般是延迟加载
     * FetchType.LAZY：延迟加载
     * FetchType.EAGER：立即加载
     */
    @Select("select * from department where id=#{id}")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "name", property = "name"),
            @Result(column = "intro", property = "intro"),
            @Result(column = "id", property = "emps",
                    many = @Many(select = "org.laputa.mybatis.mapper.EmployeeMapper.selectEmpsByDepId",
                            fetchType = FetchType.LAZY))
    })
    public Department getDepWithEmps(Integer id);

}
