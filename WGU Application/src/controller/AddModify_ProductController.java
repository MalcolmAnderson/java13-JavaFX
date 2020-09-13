package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import model.*;

public class AddModify_ProductController {

    Inventory inv;
    FxmlNavigationTools navTools = new FxmlNavigationTools();

    @FXML private Label lblScreenIdentifier;
    @FXML private Label id;
    @FXML private TextField name;
    @FXML private TextField level;
    @FXML private TextField price;
    @FXML private TextField min;
    @FXML private TextField max;


    public void loadInventory(Inventory inv){
        System.out.println("AddModify_ProductController setInv called");
        this.inv = inv;
    }

    public void SetAddModifyLabel(String transactionType){
        System.out.println("Trying to set value of lblScreenIdentifier");
        lblScreenIdentifier.setText(transactionType + " Part");
    }

    @FXML
    void onCancelAction(ActionEvent event) {
        System.out.println("Cancel Clicked");
        navTools.openMainScreenWhilePassingInventory(event, "/view/MainScreen.fxml", inv);
    }

    @FXML
    void onSaveAction(ActionEvent event) {
        System.out.println("Save Clicked");
        navTools.openMainScreenWhilePassingInventory(event, "/view/MainScreen.fxml", inv);
    }


    public void SetItemToModify(Product itemToModify){
//        partBeingModified = itemToModify;
        System.out.println("In Set Item To Modify");
        id.setText(Integer.toString(IdNumber.getNextIdNumber()));
        name.setText(itemToModify.getName());
        level.setText(Integer.toString(itemToModify.getStock()));
        price.setText(Double.toString(itemToModify.getPrice()));
        min.setText(Integer.toString(itemToModify.getMin()));
        max.setText(Integer.toString(itemToModify.getMax()));
//        if(itemToModify instanceof Part_InHouse){
//            source.setText(Integer.toString(((Part_InHouse) itemToModify).getMachineId()));
//            radioInHouse.setSelected(true);
//        } else {
//            source.setText( ((Part_Outsourced) itemToModify).getCompanyName());
//            radioOutsourced.setSelected(true);
//        }
//        onChangeSource(null);
    }

    public void InitializeNewItem() {
        id.setText(Integer.toString(IdNumber.getNextIdNumber()));
        name.setText("part name");
        level.setText("5");
        price.setText("20.0");
        min.setText("3");
        max.setText("8");
    }


}
