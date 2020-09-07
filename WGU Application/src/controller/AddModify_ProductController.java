package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Inventory;

public class AddModify_ProductController {

    Inventory inv;
    FxmlNavigationTools navTools = new FxmlNavigationTools();

    public void loadInventory(Inventory inv){
        System.out.println("AddModify_ProductController setInv called");
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
}
