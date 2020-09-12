package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextField;
import model.Inventory;
import model.Part;
import model.Part_InHouse;
import model.Part_Outsourced;

import java.net.URL;
import java.util.ResourceBundle;

public class AddModify_PartController  implements Initializable {

    Inventory inv;
    FxmlNavigationTools navTools = new FxmlNavigationTools();

    @FXML private RadioButton radioInHouse;
    @FXML private RadioButton radioOutsourced;
    @FXML private ToggleGroup partSource;

//    @FXML private ResourceBundle resources;


    @FXML private TextField id;
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

    public void SetItemToModify(Part itemToModify){
        System.out.println("In Set Item To Modify");
    }

    @FXML
    void onCancelAction(ActionEvent event) {
        System.out.println("Cancel Clicked");
        navTools.openMainScreenWhilePassingInventory(event, "/view/MainScreen.fxml", inv);
    }

    @FXML
    void onSaveAction(ActionEvent event) {
        System.out.println("Save Clicked");
        //if
        Part newPart;
        if(radioInHouse.isSelected()){
            newPart = new Part_InHouse(
                    Integer.parseInt(id.getText()),
                    name.getText(),
                    Integer.parseInt(level.getText()),
                    Integer.parseInt(price.getText()),
                    Integer.parseInt(min.getText()),
                    Integer.parseInt(max.getText()),
                    Integer.parseInt(source.getText()));
        } else {
            newPart = new Part_Outsourced(
                    Integer.parseInt(id.getText()),
                    name.getText(),
                    Integer.parseInt(level.getText()),
                    Integer.parseInt(price.getText()),
                    Integer.parseInt(min.getText()),
                    Integer.parseInt(max.getText()),
                    source.getText());
        }
        inv.addPart(newPart);

        navTools.openMainScreenWhilePassingInventory(event, "/view/MainScreen.fxml", inv);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("AddModify_PartController initialize called");
        radioInHouse.setSelected(true);
        onChangeSource(null);
    }

    public void SetAddModifyLabel(String transactionType){
        System.out.println("Trying to set value of lblScreenIdentifyer");
        lblScreenIdentifier.setText(transactionType + " Part");
    }

    @FXML
    void onChangeSource(ActionEvent event) {
        if(radioInHouse.isSelected()){
            lblSourceDescription.setText("Machine ID");
        } else {
            lblSourceDescription.setText("Company Name");
        }
    }

}
