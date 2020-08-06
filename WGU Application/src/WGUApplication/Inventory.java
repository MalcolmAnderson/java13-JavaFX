package WGUApplication;

import WGUApplication.Product;
import javafx.collections.ObservableList;

public class Inventory {

    private static Inventory instance = new Inventory();
    public static Inventory getInstance(){
        return instance;
    }

    private static ObservableList<Part> allParts;
    private static ObservableList<Product> allProducts;

    public static void addPart(Part newPart){}
    public static void addProduct(Product newProduct){}

    public static Part lookupPart(Part newPart){ return new InHouse();}
    public static Product lookupProduct(Product newProduct){return new Product();}

    public static ObservableList<Part> lookupPart(String partName){
        return allParts;
    }
    public static ObservableList<Product> lookupProduct(String productName){
        return allProducts;
    }

    public static void updatePart(int index, Part selectedPart){ }
    public static void updateProduct(int index, Product selectedProduct){}

    public static boolean deletePart(Part selectedPart){ return true;}
    public static boolean deleteProduct(Product selectedProduct){return true;}

    public static ObservableList<Part> getAllParts(){
        return allParts;
    }
    public static ObservableList<Product> getAllProducts(){
        return allProducts;
    }




}
