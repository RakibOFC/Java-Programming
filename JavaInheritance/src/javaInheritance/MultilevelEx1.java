package javaInheritance;
// Multilevel Inheritance 1
class Fruit {

    protected String title = "Fruit in Bangladesh";

    public void fruits() {

        System.out.println("Pineapple, Banana, Litchi and etc");
    }
}

class Mango extends Fruit{

    protected String mangoType = "Himsagar";

    public void mangoColor(){

        System.out.println("Himsagar Color: Yellow to Orange");
    }
}

class Jackfruit extends Mango{

    protected String property = "National Fruit";

    public void nationalFruit(){

        System.out.println(title);
        System.out.println("Famous Mango: " + mangoType);
        System.out.println(property + ": Jackfruit");
    }
}

public class MultilevelEx1 {

    public static void main(String[] args) {

        Jackfruit fruits = new Jackfruit();

        fruits.nationalFruit();
        fruits.mangoColor();
        fruits.fruits();
    }
}
