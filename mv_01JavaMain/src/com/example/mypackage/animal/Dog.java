package com.example.mypackage.animal;

public class Dog {
    private String breed;
    private int lifespan;
    private String behavior;
    private double price;

    public String getBreed() {return breed;}
    public void setBreed(String breed) {this.breed = breed;}

    public int getLifespan() {return lifespan;}
    public void setLifespan(int lifespan) {this.lifespan = lifespan;}

    public String getBehavior() {return behavior;}
    public void setBehavior(String behavior) {this.behavior = behavior;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public void display(){
        // Call getters
        System.out.println("Breed: " + this.getBreed());
        System.out.println("Lifespan: " + this.getLifespan());
        System.out.println("Behavior: " + this.getBehavior());
        System.out.println("Price: " + this.getPrice());
    }

    // Constructor
    public Dog(String breed, int lifespan, String behavior, double price){
        this.breed = breed;
        this.lifespan = lifespan;
        this.behavior = behavior;
        this.price = price;
    }

}
