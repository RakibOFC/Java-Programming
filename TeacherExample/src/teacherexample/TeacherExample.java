package teacherexample;

class Teacher {

    private String Name;
    private long ID;
    private double Salary;

    Teacher() { // Default Values
        Name = "Md Anisul Islam";
        ID = 1001;
        Salary = 75000;
    }

    Teacher(String name, long id, double salary) {    // Three different values 
        Name = name;
        ID = id;
        Salary = salary;
    }

    Teacher(Teacher n) {   // The values of another object of the same class
        Name = n.Name;
        ID = n.ID;
        Salary = n.Salary;

    }

    void display() {
        System.out.println("-----------------------------");
        System.out.println(" Teacher Name : " + Name);
        System.out.println(" Teacher ID   : " + ID);
        System.out.println(" Teacher Salary :" + Salary + " Taka");
        System.out.println("-----------------------------\n");
    }
}

public class TeacherExample {

    public static void main(String[] args) {

        Teacher obj1 = new Teacher();
        obj1.display();
        Teacher obj2 = new Teacher("Md Nazmul Huda", 1002, 70000);
        obj2.display();
        Teacher obj3 = new Teacher(obj1);
        obj3.display();
    }
}
