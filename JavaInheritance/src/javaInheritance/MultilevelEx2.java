package javaInheritance;

class Shape{

    double height = 2, width = 3, base = 4;

    public void property(){

        System.out.println("Height: " + height);
        System.out.println("Width: " + width);
        System.out.println("Base: " + base);
    }
}

class Triangle extends Shape{

    double area;

    public void areaOfTriangle(){

        area = 0.5 * height * base;
        System.out.println("Area of triangle: " + area);
    }
}

class Rectangle extends Triangle{

    double area;

    public void areaOfRectangle(){

        area = (height * width);
        System.out.println("Area of rectangle: " + area);
    }
}

public class MultilevelEx2 {

    public static void main(String[] args) {

        Rectangle obj = new Rectangle();

        obj.property();
        obj.areaOfTriangle();
        obj.areaOfRectangle();
    }
}
