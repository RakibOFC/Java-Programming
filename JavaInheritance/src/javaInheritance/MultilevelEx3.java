package javaInheritance;

class GrandParent{

    public void grandParent_property(){
        String property = "Land";
        System.out.println(property + " from GrandParent");
    }
}

class Parents extends GrandParent{

    public void parent_property(){
        String property = "House";
        System.out.println(property + " from Parents");
    }
}

class Child extends Parents{

    public void child_property(){
        String property = "Car";
        System.out.println(property + " from Child");
        System.out.println("Owner of all property is child.");
    }
}

public class MultilevelEx3 {

    public static void main(String[] args) {

        Child p = new Child();

        p.grandParent_property();
        p.parent_property();
        p.child_property();
    }
}
