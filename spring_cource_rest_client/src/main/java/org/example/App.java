package org.example;

import org.example.configuration.MyConfig;
import org.example.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean(Communication.class);
//        List<Employee> employees = communication.getAllEmployees();
//        System.out.println(employees);
//
//        System.out.println(communication.getEmployee(1));

//        Employee employee = new Employee("Katya", "Sidorcina", "NO IT", 9000);
//        employee.setId(13);
//
//        communication.saveEmployee(employee);
        communication.deleteEmployee(13);

        context.close();
    }
}
