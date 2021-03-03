package com.company;

import com.company.controller.EmployeeController;
import com.company.entities.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MyApplication {
    private final EmployeeController controller;
    private final Scanner scanner;

    public MyApplication(EmployeeController controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start(){
        while(true){
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option: (1-5)");
            System.out.println("Enter 1 if you want to show all employees");
            System.out.println("Enter 2 if you want to search employee by id");
            System.out.println("Enter 3 if you want to add new employee to database");
            System.out.println("Enter 4 if you want to search employee by name");
            System.out.println("Enter 5 if you want to delete employee by id");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.println("Enter the option: (1-5)");
                int option = scanner.nextInt();
                scanner.nextLine();
                if(option == 1){
                    getAllEmployeesMenu();
                }
                else if(option == 2){
                    getAllEmployeesMenu();
                }
                else if(option == 3){
                    createEmployeeMenu();
                }
                else if(option == 4){
                    getEmployeeByNameMenu();
                }
                else if(option == 5){
                    deleteEmployeeByIdMenu();
                }
                else{
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            System.out.println("----------------------------------------");
        }
    }



    public void getAllEmployeesMenu(){
        String response = controller.getAllEmployees();
        System.out.println(response);
    }

    public void getEmployeeByIdMenu(){
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.getEmployee(id);
        System.out.println(response);
        scanner.nextLine();
    }

    public void getEmployeeByNameMenu(){
        System.out.println("Please enter name");
        String name = scanner.nextLine();
        String response = controller.getEmployeeByName(name);
        System.out.println(response);
    }

    public void createEmployeeMenu(){
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter employee's first name");
        scanner.nextLine();
        String FirstName = scanner.nextLine();
        System.out.println("Please enter employee's second name");
        scanner.nextLine();
        String SecondName = scanner.nextLine();
        System.out.println("Please enter employee's email");
        scanner.nextLine();
        String Email = scanner.nextLine();
        System.out.println("Please enter employee's salary");
        scanner.nextLine();
        String Salary = scanner.nextLine();
        System.out.println("Please enter employee's speciality");
        scanner.nextLine();
        String Speciality = scanner.nextLine();
        String response = controller.createEmployee(id, FirstName, SecondName, Email, Speciality, Salary);
        System.out.println(response);
        scanner.nextLine();
    }

    public void deleteEmployeeByIdMenu(){
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        String response = controller.deleteEmployee(id);
        System.out.println(response);
    }


}
