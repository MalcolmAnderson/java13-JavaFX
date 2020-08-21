package controller;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Inventory;
import model.Part;
import model.Product;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML private TableView partsTableView;
    @FXML private TableColumn<Part, String> partIdColumn;
    @FXML private TableColumn<Part, String> partNameColumn;
    @FXML private TableColumn<Part, String> partInventoryLevelColumn;
    @FXML private TableColumn<Part, String> partPricePerUnitColumn;


    @FXML private TableView productsTableView;
    @FXML private TableColumn<Part, String> productIdColumn;
    @FXML private TableColumn<Part, String> productNameColumn;
    @FXML private TableColumn<Part, String> productInventoryLevelColumn;
    @FXML private TableColumn<Part, String> productPricePerUnitColumn;



    @FXML private TextField textPartSearch;
    @FXML private TextField textProductSearch;


    //    @FXML private ListView<Part> lv_Parts;
//    @FXML private ListView<Product> lv_Products;
    @FXML private GridPane addModify_Part;
    @FXML private Button buttonExit;
//    @FXML private GridPane idMainScreen;

    private Inventory inv;
    ObservableList<Part> allParts;
    ObservableList<Product> allProducts;
    public void loadInventory(Inventory inv){
        System.out.println("Begin loadInventory");
        this.inv = inv;
        System.out.println(inv.getAllParts().size());
        allParts = inv.getAllParts();
        allProducts = inv.getAllProducts();
        System.out.println("Inventory loaded into MainScreenController");
        System.out.println("End loadInventory");

        //partIdColumn.setCellValueFactory(PropertyValueFactory(String, id), "id");
    }

    public void OnButtonClicked_Exit(){
        Platform.exit();
    }

    public void DoSomeTesting(){
        System.out.println("Doing some testing");
        System.out.println(allParts.size());
        System.out.println(allProducts.size());
    }


    @FXML
    public void OnMouseClicked_PartAdd_Only(ActionEvent event) throws IOException {
        System.out.println("Hello from PartAdd_Only");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/AddModify_Part.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        // this line gets the stage info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    public void OnMouseClicked_PartAdd(){
        System.out.println("PartAdd Clicked");
//        Dialog<ButtonType> dialog = new Dialog<>();
//        dialog.initOwner(idMainScreen.getScene().getWindow());
//        try{
//            Parent root = FXMLLoader.load(getClass().getResource("AddModify_Part.fxml"));
//            dialog.getDialogPane().setContent(root);
//        } catch (Exception e){
//            System.out.println("Couldn't load the add part dialog");
//            e.printStackTrace();
//            return;
//        }
//        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
//        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
//        Optional<ButtonType> result = dialog.showAndWait();
//        if(result.isPresent() && result.get() == ButtonType.OK){
//            System.out.println("OK pressed");
//        } else {
//            System.out.println("Cancel pressed");
//        }
    }


    // Handlers for Product Logic
    @FXML
    public void OnButtonClicked_ProductAdd(){
        System.out.println("ProductAdd Clicked");
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Begin initialize");
//        lv_Products.setItems(allProducts);
//        lv_Parts.setItems(allParts);
        // setup parts table
        //partIdColumn.setCellFactory(new PropertyValueFactory("idS"));S
        //partNameColumn.setCellFactory(new PropertyValueFactory<Part, String>("getName()"));
        System.out.println("End initialize");
    }





    // Stubs
    public void OnButtonClicked_PartSearch(){
        System.out.println("PartSearch Clicked - Search on " + textPartSearch.getText());
    }

    public void OnButtonClicked_PartModify(){
        System.out.println("PartModify Clicked");
    }
    public void OnButtonClicked_PartDelete(){
        System.out.println("PartDelete Clicked");
    }
    public void handleAction_PartSearch(){
        System.out.println("handleAction_PartSearch Clicked");
    }

    public void OnButtonClicked_ProductSearch(){
        System.out.println("ProductSearch Clicked - Search on " + textProductSearch.getText());
    }


    public void OnButtonClicked_ProductModify(){
        System.out.println("ProductModify Clicked");
    }


    public void OnButtonClicked_ProductDelete(){
        System.out.println("ProductDelete Clicked");
    }


    public void handleAction_ProductSearch(){
        System.out.println("handleAction_ProductSearch Clicked");
    }




}
