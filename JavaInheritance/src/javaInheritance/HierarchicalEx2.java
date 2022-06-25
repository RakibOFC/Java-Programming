package javaInheritance;

class Animal {

    public void eat() {

        System.out.println("Animals can eat");
    }
}

class Cat extends Animal{

    @Override
    public void eat() {

        System.out.println("Cats can eat");
    }

    public void sound() {
        System.out.println("Cat sound: Meow Meow");
    }
}

class Dog extends Animal {

    @Override
    public void eat() {

        super.eat();
        System.out.println("Dogs can eat");
    }

    public void sound() {
        System.out.println("Dog sound: Bark Bark");
    }
}

class HierarchicalEx2 {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat  = new Cat();

        dog.eat();
        dog.sound();
        cat.eat();
        cat.sound();
    }
}