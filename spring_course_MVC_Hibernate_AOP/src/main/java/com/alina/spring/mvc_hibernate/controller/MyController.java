package com.alina.spring.mvc_hibernate.controller;

import com.alina.spring.mvc_hibernate.dao.EmployeeDAO;
import com.alina.spring.mvc_hibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> employees = employeeDAO.getAllEmployees();
        model.addAttribute("allEmps", employees);
        return "all-employees";
    }
}
