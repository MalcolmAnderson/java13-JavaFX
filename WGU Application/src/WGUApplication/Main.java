package WGUApplication;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import WGUApplication.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        BuildInventory();
        ObservableList<Product> products = Inventory.getAllProducts();
        int prodCount = products.size();
        System.out.println(prodCount);

        launch(args);

    }

    public static void BuildInventory(){
        //Inventory inventory = new Inventory();

        Outsourced osCase = new Outsourced(GetIdNumber.getNextIdNumber(),
                "Case", 2d, 2, 2,8, "Cases from Bob");

        InHouse ihSimpleCircuit = new InHouse(GetIdNumber.getNextIdNumber(),
                "Simple Circuit", 5d, 8, 2, 10, 200);

        InHouse ihLogicCircuit = new InHouse(GetIdNumber.getNextIdNumber(),
                "Logic Circuit", 5d, 8, 2, 10, 201);


        Outsourced osLEDMatrix = new Outsourced(GetIdNumber.getNextIdNumber(),
                "LED Matrix", 15d, 2, 2,8, "Almost NVidia Inc");

        Outsourced osSmRegisterBanks = new Outsourced(GetIdNumber.getNextIdNumber(),
                "Small Register Banks", 14d, 2, 2,8, "Anti-tel");

        Product prodPCMarkII = new Product(GetIdNumber.getNextIdNumber(),
                "PC Mark II", 800d, 8, 2, 10);

        prodPCMarkII.addAssociatedPart(osCase);
        prodPCMarkII.addAssociatedPart(ihSimpleCircuit);
        prodPCMarkII.addAssociatedPart(ihLogicCircuit);
        prodPCMarkII.addAssociatedPart(osLEDMatrix);
        prodPCMarkII.addAssociatedPart(osSmRegisterBanks);

        Inventory.getInstance().addPart(osCase);
        Inventory.getInstance().addProduct(prodPCMarkII);

        return;
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
