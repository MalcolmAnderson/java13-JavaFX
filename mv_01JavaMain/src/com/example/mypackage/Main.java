package com.example.mypackage;

import com.example.mypackage.animal.Dog;
import com.example.mypackage.main.Manager;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello");

        Manager manager = new Manager();
        Dog dog1 = manager.CreateNewDog();
        dog1.display();

        Dog dog2 = new Dog("Foof", 15, "Slow", 50.0d);
        dog2.display();

    }



}
