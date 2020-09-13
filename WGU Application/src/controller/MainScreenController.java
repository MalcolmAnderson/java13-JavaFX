package controller;
import javafx.collections.transformation.FilteredList;
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
    //FilteredList<Part> partFilteredList;

    @FXML private TableView partsTableView;
    @FXML private TableColumn<Part, Integer> partIdColumn;
    @FXML private TableColumn<Part, String> partNameColumn;
    @FXML private TableColumn<Part, Integer> partInventoryLevelColumn;
    @FXML private TableColumn<Part, Double> partPricePerUnitColumn;


    @FXML private TableView productsTableView;
    @FXML private TableColumn<Product, Integer> productIdColumn;
    @FXML private TableColumn<Product, String> productNameColumn;
    @FXML private TableColumn<Product, Integer> productInventoryLevelColumn;
    @FXML private TableColumn<Product, Double> productPricePerUnitColumn;



    @FXML private TextField textPartSearch;
    @FXML private TextField textProductSearch;


    @FXML private Button buttonPartSearch;
    @FXML private Button buttonProductSearch;

    public void OnButtonClicked_PartSearch(){
        System.out.println("PartSearch Clicked - Search on " + textPartSearch.getText());
        handleAction_PartSearch(null);
    }
    @FXML
    void handleAction_PartSearch(ActionEvent event) {
        if(textPartSearch.getText() == ""){
            partsTableView.setItems(inv.getAllParts());
        } else {
            partsTableView.setItems(inv.partNameFilter(textPartSearch.getText()));
        }
        partsTableView.refresh();
    }

    public void OnButtonClicked_ProductSearch(){
        System.out.println("ProductSearch Clicked - Search on " + textProductSearch.getText());
        handleAction_ProductSearch(null);
    }
    @FXML
    void handleAction_ProductSearch(ActionEvent event) {
        if(textProductSearch.getText() == ""){
            productsTableView.setItems(inv.getAllProducts());
        } else {
            productsTableView.setItems(inv.productNameFilter(textProductSearch.getText()));
        }
        productsTableView.refresh();
    }



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

        productsTableView.setItems(inv.getAllProducts());
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productPricePerUnitColumn.setCellValueFactory(new PropertyValueFactory<>("price"));



        System.out.println("Inventory loaded into MainScreenController");
        System.out.println("End loadInventory");

    }

    public void OnButtonClicked_Exit(){
        Platform.exit();
    }


    // Handle Part Buttons
    @FXML
    void OnEventPartAdd(ActionEvent event){
        System.out.println("PartAdd Clicked");
        navTools.open_AddModify_PartController_WhilePassingInventory(event, "/view/AddModify_Part.fxml", inv, "Add", null);
    }
    public void OnEventPartModify(ActionEvent event){
        System.out.println("PartModify Clicked");
        int selectedPartIndex = partsTableView.getSelectionModel().getSelectedIndex();
        if (selectedPartIndex != -1){
            navTools.open_AddModify_PartController_WhilePassingInventory(event, "/view/AddModify_Part.fxml", inv, "Modify", (Part)partsTableView.getSelectionModel().getSelectedItem() );
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select a part to modify", ButtonType.OK);
            alert.showAndWait();
        }
    }
    public void OnEventPartDelete(ActionEvent event){
        System.out.println("PartDelete Clicked");
        int selectedPartIndex = partsTableView.getSelectionModel().getSelectedIndex();
        Part selectedPart = (Part)partsTableView.getSelectionModel().getSelectedItem();
        System.out.println("Selected Part Index = " + selectedPartIndex);
        if (selectedPartIndex != -1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete this part?", ButtonType.YES, ButtonType.CANCEL);
            alert.showAndWait();
            if(alert.getResult() == ButtonType.YES){
                partsTableView.getItems().remove(selectedPartIndex);
                inv.deletePart(selectedPart);
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select a part to delete", ButtonType.OK);
            alert.showAndWait();
        }

    }


    // Handle Product Buttons
    @FXML
    public void OnEventProductAdd(ActionEvent event){
        System.out.println("ProductAdd Clicked");
        navTools.open_AddModify_ProductController_WhilePassingInventory(event, "/view/AddModify_Product.fxml", inv, "Add");
    }

    public void OnEventProductModify(ActionEvent event){
        System.out.println("ProductModify Clicked");
        navTools.open_AddModify_ProductController_WhilePassingInventory(event, "/view/AddModify_Product.fxml", inv, "Modify");
    }


    public void OnEventProductDelete(ActionEvent event){
        System.out.println("ProductDelete Clicked");
        int selectedProductIndex = productsTableView.getSelectionModel().getSelectedIndex();
        Product selectedProduct = (Product)productsTableView.getSelectionModel().getSelectedItem();
        System.out.println("Selected Part Index = " + selectedProductIndex);
        if (selectedProductIndex != -1){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete this product?", ButtonType.YES, ButtonType.CANCEL);
            alert.showAndWait();
            if(alert.getResult() == ButtonType.YES){
                productsTableView.getItems().remove(selectedProductIndex);
                inv.deleteProduct(selectedProduct);
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select a product to delete", ButtonType.OK);
            alert.showAndWait();
        }

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








}
