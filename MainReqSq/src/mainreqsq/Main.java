package mainreqsq;

class Shape{
    
    double length, breadth, area, perimeter;
    
    public Shape(double length){
        
        this.length = length;
    }
    
    public Shape(double length, double breadth){
        
        this.length = length;
        this.breadth = breadth;
        
    }
    
    double Calculate_area(double length){
        //square
        area = length*length;
        return area;
    }
    
    double Calculate_area(double length, double breadth){
        //rectangle
        area = length*length;
        return area;
    }
    
    double Calculate_perimeter(double length){
        //square
        perimeter = 4*length;
        return perimeter;
    }
    
    double Calculate_perimeter(double length, double breadth){
        //rectangle
        perimeter = 2*(length+breadth);
        return perimeter;
    }
}

public class Main {

    public static void main(String[] args) {

        double length = (211002046 % 20) + 5;
        double breadth = (211002046 % 10) + 3;
        
        Shape square = new Shape(length);
        Shape rectangle = new Shape(length, breadth);
        
        System.out.println("Area of square: " + square.Calculate_area(length));
        System.out.println("Area of rectangle: " + rectangle.Calculate_area(length, breadth));
        
        System.out.println("Perimeter of square: " + square.Calculate_perimeter(length));
        System.out.println("Perimeter of rectangle: " + rectangle.Calculate_perimeter(length, breadth));
    }
    
}
