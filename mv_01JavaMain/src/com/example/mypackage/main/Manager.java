package com.example.mypackage.main;

import com.example.mypackage.animal.Dog;

public class Manager {
    public void Juli(){
        System.out.println("Hello from Juli");
    }

    public Dog CreateNewDog(){
        return new Dog("Doberman", 13, "Alert", 500.0d);
    }
}
