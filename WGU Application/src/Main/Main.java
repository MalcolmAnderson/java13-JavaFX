package Main;

import Model.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View_Controller/MainScreen.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        ManageTestData.BuildInventory();
        ObservableList<Product> products = Inventory.getAllProducts();
        int prodCount = products.size();
        Inventory.getInstance().PrintAllParts();
        Inventory.getInstance().PrintAllProducts();
        ListInventory();

        launch(args);

    }

    public static void ListInventory(){
        System.out.println("Unique Products in Inventory: " + Inventory.getAllProducts().size());
        System.out.println("Unique Parts in Inventory:    " + Inventory.getAllParts().size());
    }

}

//            product - LED Matrix
//            4 plastic parts
//            10 electronic parts
//            1 Circuit Board
//
//            product - LED Array
//            4 electronic parts
//
//            product - PC-Mark-I
//            1 LED Matrix
//            1 LED Array
//            2 Sm Register Banks
//            1 Logic Circuit
//            1 Simple Circuit
//            1 Metal Case
//
//            product - PC-Mark-II
//            2 LED Matrix
//            2 Sm Register Banks
//            1 Logic Circuit
//            1 Simple Circuit
//            1 Metal Case
