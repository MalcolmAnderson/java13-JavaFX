package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {


    private ObservableList<Part> allParts = FXCollections.observableArrayList();
    private ObservableList<Product> allProducts = FXCollections.observableArrayList();


    public void addPart(Part newPart  ){
        allParts.add(newPart ); // this is a change I want to revert
    }
    public void addProduct(Product newProduct){
        allProducts.add(newProduct ); // this is a change I want to keep
    }

    public Part lookupPart(int partNumber){
        for(Part o: allParts ){
            if(o.getId() == partNumber){
                return o;
            }
        }
        return null;
    }

    public Product lookupProduct(int productNumber){
        for(Product o: allProducts ){
            if(o.getId() == productNumber){
                return o;
            }
        }
        return null;
    }

    public ObservableList<Part> lookupPart(String partName){
        ObservableList<Part> partList = FXCollections.observableArrayList();
        for(Part o: allParts ){
            if(o.getName().contains(partName)){
                partList.add(o);
            }
        }
        return partList;
    }
    public ObservableList<Product> lookupProduct(String productName){
        ObservableList<Product> productList = FXCollections.observableArrayList();
        for(Product o: allProducts ){
            if(o.getName().contains(productName)){
                productList.add(o);
            }
        }
        return productList;
    }

    public void updatePart(int index, Part selectedPart){
        for(Part o: allParts ){
            if(o.getId() == index){
                allParts.remove(o.getId());
                allParts.add(selectedPart);
            }
        }
        return;
    }
    public void updateProduct(int index, Product selectedProduct){

        for(Product o: allProducts ){
            if(o.getId() == index){
                allProducts.remove(o.getId());
                allProducts.add(selectedProduct);
            }
        }
        return;
    }

    public boolean deletePart(Part selectedPart)
    {
        int sizeOfAllParts = allParts.size();
        allParts.remove(selectedPart);
        return sizeOfAllParts == allParts.size() + 1;
    }

    public boolean deleteProduct(Product selectedProduct){
        int sizeOfAllParts = allProducts.size();
        allProducts.remove(selectedProduct);
        return sizeOfAllParts == allProducts.size() + 1;

    }

    public ObservableList<Part> getAllParts(){
        return allParts;
    }
    public ObservableList<Product> getAllProducts(){
        return allProducts;
    }

    public void PrintAllParts(){
        for(Part o: allParts ){
            System.out.println(o.getId() + " " + o.getName());
        }
    }

    public void PrintAllProducts(){
        for(Product o: allProducts ){
            System.out.println(o.getId() + " " + o.getName());
        }
    }


}
