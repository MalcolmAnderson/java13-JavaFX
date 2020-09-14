package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AddModify_ProductController implements Initializable {

    Inventory inv;
    FxmlNavigationTools navTools = new FxmlNavigationTools();
    Product productBeingModified;
    Product productCopy = new Product(0,"Empty",5d,0,0,0);

    @FXML private Label lblScreenIdentifier;
    @FXML private Label id;
    @FXML private TextField name;
    @FXML private TextField level;
    @FXML private TextField price;
    @FXML private TextField min;
    @FXML private TextField max;

    @FXML private TextField textPartSearch;
    @FXML private TableView partsTableView;
    @FXML private TableColumn<Part, Integer> partIdColumn;
    @FXML private TableColumn<Part, String> partNameColumn;
    @FXML private TableColumn<Part, Integer> partInventoryLevelColumn;
    @FXML private TableColumn<Part, Double> partPricePerUnitColumn;

    @FXML private TableView prodPartsTableView;
    @FXML private TableColumn<Part, Integer> ppartIdColumn;
    @FXML private TableColumn<Part, String> ppartNameColumn;
    @FXML private TableColumn<Part, Integer> ppartInventoryLevelColumn;
    @FXML private TableColumn<Part, Double> ppartPricePerUnitColumn;

    @FXML
    void handleAction_PartSearch(ActionEvent event) {
        if(textPartSearch.getText() == ""){
            partsTableView.setItems(inv.getAllParts());
        } else {
            partsTableView.setItems(inv.partNameFilter(textPartSearch.getText()));
        }
        partsTableView.refresh();
    }


    public void loadInventory(Inventory inv){
        System.out.println("AddModify_ProductController setInv called");
        this.inv = inv;

        partsTableView.setItems(inv.getAllParts());
        partIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        partInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partPricePerUnitColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        prodPartsTableView.setItems(inv.getAllParts());
        ppartIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        ppartNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ppartInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        ppartPricePerUnitColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    public void SetAddModifyLabel(String transactionType){
        System.out.println("Trying to set value of lblScreenIdentifier");
        lblScreenIdentifier.setText(transactionType + " Product");
    }

    @FXML
    void onCancelAction(ActionEvent event) {
        System.out.println("Cancel Clicked");
        navTools.openMainScreenWhilePassingInventory(event, "/view/MainScreen.fxml", inv);
    }
    @FXML void onAddAction(ActionEvent event){}

    @FXML void onDeleteAction(ActionEvent event){}

    @FXML void onSaveAction(ActionEvent event) {
        System.out.println("Save Clicked");
        int iLevel = Integer.parseInt(level.getText());
        int iMin = Integer.parseInt(min.getText());
        int iMax = Integer.parseInt(max.getText());
        if(iMin <= iLevel && iLevel <= iMax) {
            Product newProduct;
            newProduct = new Product(
                        Integer.parseInt(id.getText()),
                        name.getText(),
                        Double.parseDouble(price.getText()),
                        iLevel,
                        iMin,
                        iMax);
            inv.getAllProducts().remove(productBeingModified);

            inv.addProduct(newProduct);
            IdNumber.commitIdNumber();

            navTools.openMainScreenWhilePassingInventory(event, "/view/MainScreen.fxml", inv);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Inventory level can not be greater than max or less than min", ButtonType.OK);
            alert.showAndWait();
        }
    }


    public void SetItemToModify(Product itemToModify){
        productBeingModified = itemToModify;
        productCopy = Product.Clone(itemToModify);

        System.out.println("In Set Item To Modify");
        id.setText(Integer.toString(IdNumber.getNextIdNumber()));
        name.setText(itemToModify.getName());
        level.setText(Integer.toString(itemToModify.getStock()));
        price.setText(Double.toString(itemToModify.getPrice()));
        min.setText(Integer.toString(itemToModify.getMin()));
        max.setText(Integer.toString(itemToModify.getMax()));

        System.out.println("Items in product copy -> associated parts: " + productCopy.getAssociatedParts().size());
        prodPartsTableView.setItems(productCopy.getAssociatedParts());
        prodPartsTableView.refresh();
    }

    public void InitializeNewItem() {
        id.setText(Integer.toString(IdNumber.getNextIdNumber()));
        name.setText("product name");
        level.setText("5");
        price.setText("1000.0");
        min.setText("3");
        max.setText("8");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("AddModify_ProductController initialize called");
        id.setText(Integer.toString(IdNumber.getNextIdNumber()));
    }


}
