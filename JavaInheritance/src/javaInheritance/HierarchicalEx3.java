package javaInheritance;

class Parent {

    public String name = "Parent name from Parent class";
    public void method1() {

        System.out.println("method1 in Parent class");
    }
}

class Child1 extends Parent {

    public void method2() {

        System.out.println("method2 in Child1 class");
        System.out.println(name + " in method2");
    }
}

class Child2 extends Parent {

    public void method3() {

        System.out.println("method3 in Child2 class");
        System.out.println(name + " in method3");
    }
}

class HierarchicalEx3 {
    public static void main(String[] args) {

        Child1 child1 = new Child1();
        Child2 child2 = new Child2();

        child1.method1();
        child1.method2();
        child2.method3();
    }
}