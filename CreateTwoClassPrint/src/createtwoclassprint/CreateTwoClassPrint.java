package createtwoclassprint;

class Test{
    
    Test(){
        
        System.out.println("Hi, this is Constructor!");
    }
    void display(){
        System.out.println("Hi, this is Java Method!");
    }
}

public class CreateTwoClassPrint {

    public static void main(String[] args) {
        
        Test object = new Test();
        NewClassOne object2 = new NewClassOne();
        
        object.display();
        object2.newClassMethod();
        
        System.out.println("Hi, this is Main class!");
    }
    
}
