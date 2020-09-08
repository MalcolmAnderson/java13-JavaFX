package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import model.Inventory;

import java.net.URL;
import java.util.ResourceBundle;

public class AddModify_PartController  implements Initializable {

    Inventory inv;
    FxmlNavigationTools navTools = new FxmlNavigationTools();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblScreenIdentifyer;

    @FXML
    private ToggleGroup partSource;

    @FXML
    private Label lblSourceTypeIdentifier;

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

    public void SetAddModifyLabel(String transactionType){
        System.out.println("Trying to set value of lblScreenIdentifyer");
        lblScreenIdentifyer.setText(transactionType);
    }

    @FXML
    void onChangeSource(ActionEvent event) {

        // do something on change of source
    }

}
