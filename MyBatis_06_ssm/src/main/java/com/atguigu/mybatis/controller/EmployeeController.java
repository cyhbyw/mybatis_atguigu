package com.atguigu.mybatis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.service.EmployeeService;

/**
 * @author CYH
 * @date 2017/12/30 0030
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/getemps")
    public String getEmps(Map<String, Object> map) {
        List<Employee> emps = employeeService.getEmps();
        /////将数据放到map中，前端就可以得到，，，，底层到底是如何实现的？？？？？？//////
        map.put("allEmps", emps);
        return "list";
    }

}
