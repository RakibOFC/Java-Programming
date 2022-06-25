package javaInheritance;

class Calculator{

    int number1 = 40, number2 = 60;

    public void numbers(){
        System.out.println("First Number: " + number1);
        System.out.println("Second Number: " + number2);
    }
}

class Sum extends Calculator{

    public void sum(){

        System.out.println("Sum of two numbers are: " + (number1 + number2));
    }
}

public class SimpleEx2 {
    public static void main(String[] args) {
        Sum obj = new Sum();
        obj.numbers();
        obj.sum();
    }
}
