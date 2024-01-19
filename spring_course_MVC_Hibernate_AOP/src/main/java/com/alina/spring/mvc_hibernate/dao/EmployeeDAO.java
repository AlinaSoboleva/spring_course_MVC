package com.alina.spring.mvc_hibernate.dao;

import com.alina.spring.mvc_hibernate.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();
}
