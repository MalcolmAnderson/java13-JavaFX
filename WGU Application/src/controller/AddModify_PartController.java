package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.Inventory;

import java.net.URL;
import java.util.ResourceBundle;

public class AddModify_PartController  implements Initializable {

    Inventory inv;
    FxmlNavigationTools navTools = new FxmlNavigationTools();

    public void loadInventory(Inventory inv){
        System.out.println("AddModify_PartController setInv called");
        this.inv = inv;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("AddModify_PartController initialize called");
    }
}
