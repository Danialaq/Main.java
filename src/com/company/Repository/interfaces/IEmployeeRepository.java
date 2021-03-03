package com.company.Repository.interfaces;

import com.company.entities.Employee;

import java.util.List;

public interface IEmployeeRepository {
    boolean createEmployee(Employee employee);
    Employee getEmployee(int id);
    Employee getEmployeeByName(String name);
    List<Employee> getAllEmployees();
    boolean deleteEmployee(Employee employee);
}