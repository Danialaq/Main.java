package com.company;

import com.company.Repository.EmployeeRepository;
import com.company.Repository.interfaces.IEmployeeRepository;
import com.company.controller.EmployeeController;
import com.company.data.IPostgresDB;
import com.company.data.PostgresDB;

public class Main {

    public static void main(String[] args) {
        IPostgresDB db = new PostgresDB();
        IEmployeeRepository repo = new EmployeeRepository(db);
        EmployeeController controller = new EmployeeController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}