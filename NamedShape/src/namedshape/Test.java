package namedshape;

import java.util.Scanner;

class NamedShape{
    
    
}

class Circle extends NamedShape{
    
    void draw (){
        System.out.println("Draw Circle");
    }
    
    void erase (){
        System.out.println("Erase Circle");
    }
}

class Triangle extends NamedShape{
    
    void draw (){
        System.out.println("Draw Triangle");
    }
    
    void erase (){
        System.out.println("Erase Triangle");
    }
}

class Square extends NamedShape{
    
    void draw (){
        System.out.println("Draw Square");
    }
    
    void erase (){
        System.out.println("Erase Square");
    }
}

public class Test {

    public static void main(String[] args) {

        int named_shape;
        
        Circle circle = new Circle();
        Triangle triangle = new Triangle();
        Square square = new Square();
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("1 for circle\n2 for triangle\n3 for square\n\nEnter your option: ");
        named_shape = in.nextInt();
        
        switch(named_shape) {
        case 1:
          circle.draw();
          circle.erase();
          break;
        case 2:
          triangle.draw();
          triangle.erase();
          break;
          
        case 3:
          square.draw();
          square.erase();
          break;
          
        default:
            System.out.println("Invalid Input!");
      }
    }
    
}
