package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    Product copyOfOriginalProductForReplaceAction;
    Product productCopy = Product.NewEmptyProduct();
    ObservableList<Part> availableParts = FXCollections.observableArrayList();

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
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure you want to cancel this action?  Information will not be saved.", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if(alert.getResult() == ButtonType.YES){
            navTools.openMainScreenWhilePassingInventory(event, "/view/MainScreen.fxml", inv);
        }
    }
    @FXML void onAddAction(ActionEvent event){
        int selectedPartIndex = partsTableView.getSelectionModel().getSelectedIndex();
        Part selectedPart = (Part)partsTableView.getSelectionModel().getSelectedItem();
        System.out.println("Selected Part Index = " + selectedPartIndex);
        if (selectedPartIndex != -1){
            // remove part from parts list
            productCopy.getAssociatedParts().add(selectedPart);
            // add part to associated parts
            availableParts.remove(selectedPart);
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select a part to add to product", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML void onDeleteAction(ActionEvent event){
        int selectedPartIndex = prodPartsTableView.getSelectionModel().getSelectedIndex();
        Part selectedPart = (Part)prodPartsTableView.getSelectionModel().getSelectedItem();
        System.out.println("Selected Part Index = " + selectedPartIndex);
        if (selectedPartIndex != -1){
            // add part to parts list
            availableParts.add(selectedPart);
            // remove part to associated parts
            productCopy.getAssociatedParts().remove(selectedPart);
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please select a part to remove from product", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML void onSaveAction(ActionEvent event) {
        int selectedPartCount = productCopy.getAssociatedParts().size();
        if(selectedPartCount < 1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Products must have at least 1 associated part", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        if(Double.parseDouble(price.getText()) < productCopy.getPriceAssociatedParts()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Products price cannot be less than the cost of the associated parts", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        System.out.println("Save Clicked");
        int iLevel = Integer.parseInt(level.getText());
        int iMin = Integer.parseInt(min.getText());
        int iMax = Integer.parseInt(max.getText());
        if(iMin <= iLevel && iLevel <= iMax) {
            productCopy.setId(Integer.parseInt(id.getText()));
            productCopy.setName(name.getText());
            productCopy.setPrice(Double.parseDouble(price.getText()));
            productCopy.setStock(iLevel);
            productCopy.setMax(iMax);
            productCopy.setMin(iMin);
            inv.getAllProducts().remove(copyOfOriginalProductForReplaceAction);

            inv.addProduct(productCopy);
            IdNumber.commitIdNumber();

            navTools.openMainScreenWhilePassingInventory(event, "/view/MainScreen.fxml", inv);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Inventory level can not be greater than max or less than min", ButtonType.OK);
            alert.showAndWait();
        }
    }

    private void InitializeNonListProductValues(Product itemToModify){
        id.setText(Integer.toString(IdNumber.getNextIdNumber()));
        name.setText(itemToModify.getName());
        level.setText(Integer.toString(itemToModify.getStock()));
        price.setText(Double.toString(itemToModify.getPrice()));
        min.setText(Integer.toString(itemToModify.getMin()));
        max.setText(Integer.toString(itemToModify.getMax()));
    }
    private void InitializeListProductValues(Product itemToModify){
        if(itemToModify.getAssociatedParts().size() > 0) {
            for (Part part : itemToModify.getAssociatedParts()){
                availableParts.remove(part);
            }
        }
        partsTableView.setItems(availableParts);
        partsTableView.refresh();
        prodPartsTableView.setItems(itemToModify.getAssociatedParts());
        prodPartsTableView.refresh();
    }

    public void SetItemToModify(Product itemToModify){
        copyOfOriginalProductForReplaceAction = itemToModify;
        productCopy = Product.Clone(itemToModify);

        availableParts.setAll(inv.getAllParts()); // make a copy of parts
        InitializeNonListProductValues(productCopy);
        InitializeListProductValues(productCopy);

        prodPartsTableView.setItems(productCopy.getAssociatedParts());
        prodPartsTableView.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("AddModify_ProductController initialize called");
        id.setText(Integer.toString(IdNumber.getNextIdNumber()));
    }
}
