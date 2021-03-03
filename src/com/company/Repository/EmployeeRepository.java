package com.company.Repository;

import com.company.Repository.interfaces.IEmployeeRepository;
import com.company.data.IPostgresDB;
import com.company.entities.Employee;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final IPostgresDB database;

    public EmployeeRepository(IPostgresDB database){this.database = database;}

    @Override
    public boolean createEmployee(Employee employee) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "INSERT INTO employees(employee_id, FirstName, SecondName, Email, Speciality, Salary ) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, employee.getId());
            st.setString(2, employee.getFirstName());
            st.setString(3, employee.getSecondName());
            st.setString(4, employee.getEmail());
            st.setString(5, employee.getSpeciality());
            st.setString(6, employee.getSalary());
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Employee getEmployee(int id){
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "Select employee_id, FirstName, SecondName, Email, Speciality, Salary FROM employees WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("FirstName"),
                        rs.getString("SecondName"),
                        rs.getString("Email"),
                        rs.getString("Speciality"),
                        rs.getString("Salary"));
                return employee;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Employee getEmployeeByName(String FirstName) {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "SELECT  * FROM employees;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("FirstName"),
                        rs.getString("SecondName"),
                        rs.getString("Email"),
                        rs.getString("Speciality"),
                        rs.getString("Salary"));
                if(employee.getFirstName().equals(FirstName)){
                    return employee;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "SELECT * FROM employees;";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new LinkedList<>();
            while(rs.next()){
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("Firstname"),
                        rs.getString("SecondName"),
                        rs.getString("Email"),
                        rs.getString("Speciality"),
                        rs.getString("Salary"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(Employee employee){
        Connection con = null;
        try {
            con = database.getConnection();
            String sql = "DELETE from employees WHERE id=" + employee.getId() + ";";
            PreparedStatement st = con.prepareStatement(sql);
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

}