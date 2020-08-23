package com.example.mypackage.animal;

public class Cat extends Animal {
    private String sound = "Here Mousie";

    public Cat(String breed, int lifespan, double price, String sound) {
        super(breed, lifespan, price);
        this.sound = sound;
    }
    public Cat(String breed, int lifespan, double price) {
        super(breed, lifespan, price);
        //this.sound = sound;
    }



    public String getSound() {
        return sound;
        //return "Meow!";
    }
//
//    public void setSound(String sound) {
//        this.sound = sound;
//    }

}
