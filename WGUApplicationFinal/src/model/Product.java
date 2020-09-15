package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Product {
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    public Product(int id, String name, double price, int stock, int min, int max){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    public static Product Clone(Product p){
        Product clone = new Product(p.getId(), p.getName(), p.getPrice(), p.getStock(), p.getMin(), p.getMax());
        for(Part part : p.getAssociatedParts()){
            clone.addAssociatedPart(part);
        }
        return clone;
    }

    public static Product NewEmptyProduct(){
        Product newEmptyProduct = new Product(0,"Empty",5d,0,0,0);
        return newEmptyProduct;
    }


    @Override
    public String toString() {
        return name ;
    }

    public Product(){} // should throw not implemented exception


    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public void setMin(int min){
        this.min = min;
    }
    public void setMax(int max){
        this.max = max;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getStock(){
        return stock;
    }
    public int getMin(){
        return min;
    }
    public int getMax(){
        return max;
    }

    public void addAssociatedPart(Part part){
        associatedParts.add(part);
    }

    public boolean deleteAssociatedPart(Part selectedAssociatedPart){
        return false;
    }
    public ObservableList<Part> getAssociatedParts(){
        return associatedParts;
    }

    public double getPriceAssociatedParts(){
        double total = 0d;
        for(Part part : associatedParts){
            total += part.getPrice();
        }
        return total;
    }


}
