package org.laputa.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.laputa.mybatis.entity.Employee;

import java.util.List;

public interface EmployeeMapper {

    @Insert("insert into employee(id,name,email,gender,dep_id) values(null,#{name},#{email},#{gender},#{dep.id})")
    void insertEmp(Employee emp);

    @Select("select * from employee where id=#{id}")
    Employee selectEmpById(Integer id);

    @Select("select * from employee where dep_id=#{depId}")
    List<Employee> selectEmpsByDepId(Integer depId);

    @Select("select * from employee")
    List<Employee> selectAll();

    @Update("update employee set name=#{name},email=#{email},gender=#{gender},dep_id=#{dep.id} where id=#{id}")
    void updateEmp(Employee emp);

    @Delete("delete from employee where id=#{id}")
    void deleteEmp(Integer id);

    /**
     * 查找员工的信息级联查找部门信息
     *
     * @Results：代替的是<resultMap>标签，注解中可以使用单个@Result注解，也可以使用@Result集合
     * @Result：代替的是<id>标签和<result>标签
     * id：是否为主键，是为true，否为false
     * column：数据库的列名
     * property：实体类的属性名
     * @One：一对一配置，代替的是<assocation>标签，是多表查询的关键，在注解中用来指定子查询返回单一对象
     * select：指定用来多表查询的sqlmapper，它是对应接口方法的全限定方法名
     * fetchType：懒加载配置，会覆盖全局的配置参数 lazyLoadingEnabled，一对一一般是立即加载
     * FetchType.LAZY：延迟加载
     * FetchType.EAGER：立即加载
     */
    @Select("select * from employee where id=#{id}")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "name", property = "name"),
            @Result(column = "email", property = "email"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "dep_id", property = "dep",
                    one = @One(select = "org.laputa.mybatis.mapper.DepartmentMapper.selectDep",
                            fetchType = FetchType.EAGER))
    })
    Employee getEmpWithDep(Integer id);

}
