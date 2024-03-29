package com.alina.spring.rest.service;

import com.alina.spring.rest.dao.EmployeeDAO;
import com.alina.spring.rest.entity.Employee;
import com.alina.spring.rest.exception.NoSuchEmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        Employee employee =  employeeDAO.getEmployee(id);
        if (employee == null){
            throw new NoSuchEmployeeException("There is no employee with ID = " +
                    id + " int Database");
        }
        return employee;
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        Employee employee = employeeDAO.getEmployee(id);
        if (employee == null) throw new NoSuchEmployeeException("There is no employee with ID = " +
                id + " int Database");
        employeeDAO.deleteEmployee(employee);

    }
}
