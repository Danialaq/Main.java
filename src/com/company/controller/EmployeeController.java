package com.company.controller;

import com.company.Repository.interfaces.IEmployeeRepository;
import com.company.entities.Employee;

import java.util.List;

public class EmployeeController {
    private final IEmployeeRepository repo;

    public EmployeeController(IEmployeeRepository repo) {
        this.repo = repo;
    }

    public String deleteEmployee(int id){
        Employee employee = repo.getEmployee(id);
        boolean created = repo.deleteEmployee(employee);
        return (created ? "Employee was deleted!" : "Employee deletion was failed! ");
    }

    public String createEmployee(int id, String FirstName, String SecondName, String Email, String Salary, String Speciality){
        Employee employee = new Employee(id, FirstName, SecondName, Email, Salary, Speciality);
        boolean created = repo.createEmployee(employee);
        return (created ? "Employee was created!" : "Employee creation was failed! ");
    }
    public  String getEmployee(int id){
        Employee employee = repo.getEmployee(id);

        return (employee == null ? "Employee was not found!" : employee.toString());
    }

    public  String getEmployeeByName(String FirstName){
        Employee employee = repo.getEmployeeByName(FirstName);

        return (employee == null ? "Employee was not found!" : employee.toString());
    }

    public String getAllEmployees(){
        List <Employee> Employees = repo.getAllEmployees();

        return Employees.toString();
    }
}
