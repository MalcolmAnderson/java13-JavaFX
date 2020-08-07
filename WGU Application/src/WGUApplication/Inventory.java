package WGUApplication;

import WGUApplication.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {

    private static Inventory instance = new Inventory();
    public static Inventory getInstance(){
        return instance;
    }

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    public static void addPart(Part newPart){
        allParts.add(newPart);
    }
    public static void addProduct(Product newProduct){
        allProducts.add(newProduct);
    }

    public static Part lookupPart(int partNumber){
        for(Part o: allParts ){
            if(o.getId() == partNumber){
                return o;
            }
        }
        return null;
    }

    public static Product lookupProduct(int productNumber){
        for(Product o: allProducts ){
            if(o.getId() == productNumber){
                return o;
            }
        }
        return null;
    }

    public static ObservableList<Part> lookupPart(String partName){
        ObservableList<Part> partList = FXCollections.observableArrayList();
        for(Part o: allParts ){
            if(o.getName().contains(partName)){
                partList.add(o);
            }
        }
        return partList;
    }
    public static ObservableList<Product> lookupProduct(String productName){
        ObservableList<Product> productList = FXCollections.observableArrayList();
        for(Product o: allProducts ){
            if(o.getName().contains(productName)){
                productList.add(o);
            }
        }
        return productList;
    }

    public static void updatePart(int index, Part selectedPart){
        for(Part o: allParts ){
            if(o.getId() == index){
                allParts.remove(o.getId());
                allParts.add(selectedPart);
            }
        }
        return;
    }
    public static void updateProduct(int index, Product selectedProduct){
        for(Product o: allProducts ){
            if(o.getId() == index){
                allProducts.remove(o.getId());
                allProducts.add(selectedProduct);
            }
        }
        return;
    }

    public static boolean deletePart(Part selectedPart)
    {
        for(Part o: allParts ){
//            if(o.getId() == index){
//                int index = 1;
//                allParts.remove ( o.getId());
//                allParts.add(selectedPart);
//            }
        }

        return true;
    }
    public static boolean deleteProduct(Product selectedProduct){return true;}

    public static ObservableList<Part> getAllParts(){
        return allParts;
    }
    public static ObservableList<Product> getAllProducts(){
        return allProducts;
    }

    public static void PrintAllParts(){
        for(Part o: allParts ){
            System.out.println(o.getId() + " " + o.getName());
        }
    }

    public static void PrintAllProducts(){
        for(Product o: allProducts ){
            System.out.println(o.getId() + " " + o.getName());
        }
    }


}
