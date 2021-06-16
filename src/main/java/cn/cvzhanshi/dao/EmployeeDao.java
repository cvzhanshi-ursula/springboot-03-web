package cn.cvzhanshi.dao;

import cn.cvzhanshi.entity.Department;
import cn.cvzhanshi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cVzhanshi
 * @create 2021-06-15 19:46
 */
@Repository
public class EmployeeDao {
    //模拟数据库中的信息
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001,"AA","cvzhanhsi@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","cvzhanhsi2@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","cvzhanhsi3@qq.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","cvzhanhsi4@qq.com",1,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"EE","cvzhanhsi5@qq.com",0,new Department(105,"后勤部")));
        employees.put(1006,new Employee(1006,"FF","cvzhanhsi6@qq.com",1,new Department(106,"记者部")));
    }

    //主键自增
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除员工通过id
    public void deleteById(Integer id){
        employees.remove(id);
    }
}
