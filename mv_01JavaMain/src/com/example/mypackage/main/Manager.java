package com.example.mypackage.main;

import com.example.mypackage.animal.Animal;
import com.example.mypackage.animal.Dog;

public class Manager {
    public void Juli(){
        System.out.println("Hello from Juli");
    }

    public Dog CreateNewDog(){
        //return new Dog("Doberman", 13, "Alert", 500.0d);
        return new Dog("Doberman", 13, 500.0d, "Hi");
        //return new Dog();
    }

//    public Animal CreateNewAnimal(){
//        return new Animal("Orange", 18, 50.0d);
//    }
}
