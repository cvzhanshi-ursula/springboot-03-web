package cn.cvzhanshi.controller;

import cn.cvzhanshi.dao.DepartmentDao;
import cn.cvzhanshi.dao.EmployeeDao;
import cn.cvzhanshi.entity.Department;
import cn.cvzhanshi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * @author cVzhanshi
 * @create 2021-06-16 15:17
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;


    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //去员工的修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model){
        //查出原来的数据
        Employee employeeById = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employeeById);

        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    //员工信息修改
    @PostMapping("/updateEmp")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工信息
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.deleteById(id);
        return "redirect:/emps";
    }
    //注销
    @RequestMapping("/user/out")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:index.html";
    }

}
