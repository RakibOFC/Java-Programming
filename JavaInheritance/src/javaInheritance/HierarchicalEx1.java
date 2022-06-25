package javaInheritance;

class Employee{

    double salary = 40000;

    public void displaySalary(){

        System.out.println("The Employee salary is: " +salary);
    }
}

class PermanentEmployee extends Employee{

    double scale = 0.5;

    void incrementSalary()
    {
        System.out.println("The Permanent Employee incremented salary is: " + (salary + (salary * scale)));
    }
}

class TempEmployee extends Employee{

    double scale = 0.35;

    void incrementSalary()
    {
        System.out.println("The Temporary Employee incremented salary is: " + (salary + (salary * scale)));
    }
}

public class HierarchicalEx1 {

    public static void main(String[] args) {

        PermanentEmployee per_emp = new PermanentEmployee();
        TempEmployee temp_emp = new TempEmployee();

        per_emp.displaySalary();
        per_emp.incrementSalary();
        temp_emp.incrementSalary();
    }
}
