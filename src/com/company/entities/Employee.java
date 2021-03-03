package com.company.entities;

public class Employee {
    private int Id;
    private String FirstName;
    private String SecondName;
    private String Email;
    private  String speciality;
    private String Salary;

    public Employee (int Id, String FirstName,String SecondName,String Email, String speciality, String Salary) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.SecondName = SecondName;
        this.Email = Email;
        this.speciality=speciality;
        this.Salary = Salary;

    }
    public Employee(int id, String FirstName, String SecondName, String Email, String speciality, String Salary, int illnesstype) {
        this.FirstName = FirstName;
        this.SecondName = SecondName;
        this.Email = Email;
        this.speciality=speciality;
        this.Salary = Salary;
    }

    public int getId(){return Id;}
    public String getFirstName(){return FirstName;}
    public String getSecondName(){return SecondName;}
    public String getEmail(){return Email;}
    public String getSpeciality() {return speciality;}
    public String getSalary(){return Salary;}


    @Override
    public String toString(){
        return getFirstName()+" "+getSecondName()+" "+getEmail()+" "+getSalary()+" "+getSpeciality();
    }


}
