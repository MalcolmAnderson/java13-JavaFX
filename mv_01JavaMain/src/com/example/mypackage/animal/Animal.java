package com.example.mypackage.animal;

public class Animal {
    private String breed;
    private int lifespan;
    private double price;

    public String getBreed() {return breed;}
    public void setBreed(String breed) {this.breed = breed;}

    public int getLifespan() {return lifespan;}
    public void setLifespan(int lifespan) {this.lifespan = lifespan;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public void display(){
        // Call getters
        System.out.println("Breed: " + this.getBreed());
        System.out.println("Lifespan: " + this.getLifespan());
        System.out.println("Price: " + this.getPrice());
    }

    // Constructor
    public Animal(String breed, int lifespan, double price){
        this.breed = breed;
        this.lifespan = lifespan;
        this.price = price;
    }


}
