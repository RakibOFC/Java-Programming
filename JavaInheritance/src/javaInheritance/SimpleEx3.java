package javaInheritance;

class SuperClass{

    protected String str = "This is super class string.";
    public void sup_method(){
        System.out.println("This is super class method.");
    }
}

class SubClass extends SuperClass{

    public void sub_method(){
        System.out.println(str);
        System.out.println("This is sub class method.");
    }
}

public class SimpleEx3 {
    public static void main(String[] args) {
        SubClass sub_obj = new SubClass();

        sub_obj.sup_method();
        sub_obj.sub_method();
    }
}
