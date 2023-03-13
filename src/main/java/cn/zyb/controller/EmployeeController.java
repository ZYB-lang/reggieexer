package cn.zyb.controller;

import cn.zyb.common.R;
import cn.zyb.entity.Employee;
import cn.zyb.service.impl.EmployeeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * @ClassName EmployeeController
 * @Description TODO
 * @Author ZYB
 * @Date 2023/3/5 13:39
 * @Version 1.0
 **/
@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @PostMapping("/login")
    private R<Employee> login(HttpServletRequest request, @RequestBody Employee employee){
        //1、将页面提交的密码进行md5加密处理
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        //2、根据页面提交的用户名来查数据库
        LambdaQueryWrapper<Employee> employeeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        employeeLambdaQueryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(employeeLambdaQueryWrapper);
        // 3、如果没有查询到则返回失败结果
        if (emp==null){
            return R.error("登录失败");
        }
        //4、比对密码，如果不一致则返回失败结果
        if (!emp.getPassword().equals(password)){
            return R.error("密码错误");
        }
        //5、查看员工状态，如果已禁用状态，则返回员工已禁用结果
        if (emp.getStatus() == 0){
            return R.error("账号已禁用!");
        }
        //6、登录成功，将用户id存入Session并返回成功结果
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
    }
    @PostMapping("/logout")
    private R<String> logout(HttpServletRequest request){
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }
    @PostMapping
    private R<String> save(HttpServletRequest request,@RequestBody Employee employee){
        log.info("新增员工,员工信息:{}",employee.toString());
        employee.setPassword(DigestUtils.md5DigestAsHex("12345".getBytes(StandardCharsets.UTF_8)));
//        employee.setCreateTime(LocalDateTime.now());
//        employee.setUpdateTime(LocalDateTime.now());
//        employee.setCreateUser((Long) request.getSession().getAttribute("employee"));
//        employee.setUpdateUser((Long) request.getSession().getAttribute("employee"));
        employeeService.save(employee);
        return R.success("新增员工成功");
    }
    @GetMapping("/page")
    private R<Page> page(int page,int pageSize,String name){
     log.info("page = {},pageSize = {},name = {}",page,pageSize,name);
        Page<Employee> pageinfo = new Page<>(page,pageSize);
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotEmpty(name),Employee::getName,name);
        lambdaQueryWrapper.orderByDesc(Employee::getUpdateTime);
        employeeService.page(pageinfo,lambdaQueryWrapper);
        return R.success(pageinfo);
    }
    @PutMapping
    private R<String> update(HttpServletRequest request,@RequestBody Employee employee){
        log.info("员工信息:{}",employee.toString());
//        Long userid = (Long) request.getSession().getAttribute("employee");
//        employee.setUpdateUser(userid);
//        employee.setUpdateTime(LocalDateTime.now());
        employeeService.updateById(employee);
        return R.success("员工信息修改成功");
    }
    @GetMapping("/{id}")
    private R<Employee> getById(@PathVariable Long id){
        Employee employee= employeeService.getById(id);
        if (employee!=null){

            return R.success(employee);
        }
        return R.error("没有查询到对象信息");
    }
}
