import java.util.Scanner;

class Area {
    protected double area;
    double PI = 3.1416;

    Area(double base, double height){

        area = 0.5 * base * height;
        System.out.println("Area of Triangle: " + area);
    }

    Area(int length, int width){

        area = ((double) length * (double) width);
        System.out.println("Area of Rectangle: " + area);
    }

    Area(double radius){

        area = PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}
public class Main {

    public static void main(String[] args) {

        double base, height, radius;
        int length, width;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter triangle base: ");
        base = in.nextDouble();
        System.out.print("Enter triangle height: ");
        height = in.nextDouble();
        new Area(base, height);

        System.out.print("Enter rectangle length: ");
        length = in.nextInt();
        System.out.print("Enter rectangle width: ");
        width = in.nextInt();
        new Area(length, width);

        System.out.print("Enter circle radius: ");
        radius = in.nextDouble();
        new Area(radius);
    }
}
