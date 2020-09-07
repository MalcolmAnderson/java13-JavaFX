package controller;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Inventory;
import model.Part;
import model.Product;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    FxmlNavigationTools navTools = new FxmlNavigationTools();

    @FXML private TableView partsTableView;
    @FXML private TableColumn<Part, Integer> partIdColumn;
    @FXML private TableColumn<Part, String> partNameColumn;
    @FXML private TableColumn<Part, Integer> partInventoryLevelColumn;
    @FXML private TableColumn<Part, Double> partPricePerUnitColumn;


    @FXML private TableView productsTableView;
    @FXML private TableColumn<Part, Integer> productIdColumn;
    @FXML private TableColumn<Part, String> productNameColumn;
    @FXML private TableColumn<Part, Integer> productInventoryLevelColumn;
    @FXML private TableColumn<Part, Double> productPricePerUnitColumn;



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

        partsTableView.setItems(inv.getAllParts());
        partIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPricePerUnitColumn.setCellValueFactory(new PropertyValueFactory<>("price"));


        System.out.println("Inventory loaded into MainScreenController");
        System.out.println("End loadInventory");

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
    void OnEventPartAdd(ActionEvent event){
        System.out.println("PartAdd Clicked");
        navTools.openScreenWhilePassingInventory(event, "/view/AddModify_Part.fxml", inv, "Add");

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
        System.out.println("Begin initialize Table");
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

    public void OnEventPartModify(ActionEvent event){
        System.out.println("PartModify Clicked");
        navTools.openScreenWhilePassingInventory(event, "/view/AddModify_Part.fxml", inv, "Modify");
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
