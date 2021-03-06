package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AddModify_PartController implements Initializable {

    Inventory inv;
    FxmlNavigationTools navTools = new FxmlNavigationTools();
    Part partBeingModified;

    @FXML private RadioButton radioInHouse;
    @FXML private RadioButton radioOutsourced;
//    @FXML private ToggleGroup partSource;

//    @FXML private ResourceBundle resources;

    @FXML private Label id;
    @FXML private TextField name;
    @FXML private TextField level;
    @FXML private TextField price;
    @FXML private TextField min;
    @FXML private TextField max;
    @FXML private TextField source;

    @FXML private Label lblSourceDescription;
    @FXML private Label lblScreenIdentifier;


    public void loadInventory(Inventory inv){
        System.out.println("AddModify_PartController setInv called");
        this.inv = inv;
    }

    public void InitializeNewItem(){
        id.setText(Integer.toString(IdNumber.getNextIdNumber()));
        name.setText("part name");
        level.setText("0");
        price.setText("200.0");
        min.setText("0");
        max.setText("0");
        if(radioInHouse.isSelected()){
            source.setText("2001");
        } else {
            source.setText("Permberly Video and Parts");
        }
        onChangeSource(null);

    }

    public void SetItemToModify(Part itemToModify){
        partBeingModified = itemToModify;
        System.out.println("In Set Item To Modify");
        id.setText(Integer.toString(IdNumber.getNextIdNumber()));
        name.setText(itemToModify.getName());
        level.setText(Integer.toString(itemToModify.getStock()));
        price.setText(Double.toString(itemToModify.getPrice()));
        min.setText(Integer.toString(itemToModify.getMin()));
        max.setText(Integer.toString(itemToModify.getMax()));
        if(itemToModify instanceof Part_InHouse){
            source.setText(Integer.toString(((Part_InHouse) itemToModify).getMachineId()));
            radioInHouse.setSelected(true);
        } else {
            source.setText( ((Part_Outsourced) itemToModify).getCompanyName());
            radioOutsourced.setSelected(true);
        }
        onChangeSource(null);
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

    @FXML
    void onSaveAction(ActionEvent event) {
        System.out.println("Save Clicked");
        int iLevel = Integer.parseInt(level.getText());
        int iMin = Integer.parseInt(min.getText());
        int iMax = Integer.parseInt(max.getText());
        if(iMin <= iLevel && iLevel <= iMax) {
            Part newPart;
            if (radioInHouse.isSelected()) {
                newPart = new Part_InHouse(
                        Integer.parseInt(id.getText()),
                        name.getText(),
                        Double.parseDouble(price.getText()),
                        iLevel, iMin, iMax,
                        Integer.parseInt(source.getText()));
            } else {
                newPart = new Part_Outsourced(
                        Integer.parseInt(id.getText()),
                        name.getText(),
                        Double.parseDouble(price.getText()),
                        iLevel, iMin, iMax,
                        source.getText());
                inv.getAllParts().remove(partBeingModified);
            }
            inv.addPart(newPart);
            IdNumber.commitIdNumber();

            navTools.openMainScreenWhilePassingInventory(event, "/view/MainScreen.fxml", inv);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Inventory level can not be greater than max or less than min", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("AddModify_PartController initialize called");
        id.setText(Integer.toString(IdNumber.getNextIdNumber()));
        radioInHouse.setSelected(true);
        onChangeSource(null);
    }

    public void SetAddModifyLabel(String transactionType){
        System.out.println("Trying to set value of lblScreenIdentifier");
        lblScreenIdentifier.setText(transactionType + " Part");
    }

    @FXML void onChangeSource(ActionEvent event) {
        if(radioInHouse.isSelected()){
            lblSourceDescription.setText("Machine ID");
        } else {
            lblSourceDescription.setText("Company Name");
        }
    }
}
