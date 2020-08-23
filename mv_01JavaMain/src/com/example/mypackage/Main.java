package com.example.mypackage;

import com.example.mypackage.animal.Animal;
import com.example.mypackage.animal.Cat;
import com.example.mypackage.animal.Dog;
import com.example.mypackage.main.Manager;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello");

        Manager manager = new Manager();
        Dog dog1 = manager.CreateNewDog();
//        dog1.display();

//        Dog dog2 = new Dog("Foof", 15, "Slow", 50.0d);
//        dog2.display();

        Dog dog = new Dog("Foof", 15, 50.0d);
        dog.setBreed("Doberman");
        System.out.println(dog.getSound());
        System.out.println(dog.getBreed());
        dog.setSound("Foof");
        System.out.println(dog.getSound());

        Cat cat = new Cat("Orange", 18, 50.0d);
        System.out.println(cat.getSound());


//        Animal animal1 = manager.CreateNewAnimal();
//        animal1.display();

    }



}
