package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AnimalDetailsController implements Initializable {

    FxmlNavigationTools navTools = new FxmlNavigationTools();


        @FXML
        private Label animalIdlbl;

        @FXML
        private Label breedLbl;

        @FXML
        private Label lifespanLbl;

        @FXML
        private Label behaviorLbl;

        @FXML
        private Label priceLbl;

        @FXML
        private Label vaccLbl;

        @FXML
        private Label specialLbl;

    @FXML
    void onActionDisplayMainMenu(ActionEvent event) {
        System.out.println("go to Display Animal Menu");
        navTools.openViewFromButtonEvent(event, "/View/DisplayAnimalMenu.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
