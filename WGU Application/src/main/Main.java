package main;

import model.*;
import controller.MainScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private Inventory inv;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Inventory inv = ManageTestData.BuildInventory();


//        inv.PrintAllParts();
//        inv.PrintAllProducts();
//        ListInventory(inv);


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/MainScreen.fxml"));
        Parent mainScreenParent = loader.load();
        Scene mainScreenScene = new Scene(mainScreenParent);

        // get controller and load data
        MainScreenController mainScreenController = loader.getController();
        mainScreenController.loadInventory(inv);

        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(mainScreenScene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);

    }

    public static void ListInventory(Inventory inv){
        System.out.println("Unique Products in Inventory: " + inv.getAllProducts().size());
        System.out.println("Unique Parts in Inventory:    " + inv.getAllParts().size());
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
