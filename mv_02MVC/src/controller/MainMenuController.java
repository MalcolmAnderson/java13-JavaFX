package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    FxmlNavigationTools navTools = new FxmlNavigationTools();

    @FXML
    void onActionCreateAnimal(ActionEvent event) {
        navTools.openViewFromButtonEvent(event, "/view/CreateAnimalMenu.fxml");
    }

    @FXML
    void onActionDisplayAnimals(ActionEvent event) {
        navTools.openViewFromButtonEvent(event, "/View/DisplayAnimalMenu.fxml");
    }

    @FXML
    void onActionExit(ActionEvent event) {
        System.out.println("onActionExit");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("In MainMenuController - initialize");
    }
}
