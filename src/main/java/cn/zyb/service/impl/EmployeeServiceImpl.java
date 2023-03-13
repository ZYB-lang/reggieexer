package cn.zyb.service.impl;

import cn.zyb.entity.Employee;
import cn.zyb.mapper.EmployeeMapper;
import cn.zyb.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ClassName EmployeeServiceImpl
 * @Description TODO
 * @Author ZYB
 * @Date 2023/3/5 13:36
 * @Version 1.0
 **/
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {
}
