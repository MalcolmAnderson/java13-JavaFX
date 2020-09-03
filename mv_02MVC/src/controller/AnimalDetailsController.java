package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AnimalDetailsController implements Initializable {



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



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
