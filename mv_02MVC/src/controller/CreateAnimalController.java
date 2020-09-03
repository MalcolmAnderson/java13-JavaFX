package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateAnimalController implements Initializable {

        @FXML
        private TextField animalIdTxt;

        @FXML
        private TextField breedTxt;

        @FXML
        private TextField lifespanTxt;

        @FXML
        private TextField behaviorTxt;

        @FXML
        private TextField priceTxt;

        @FXML
        private RadioButton vaccYesRBtn;

        @FXML
        private RadioButton vaccNoRBtn;




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
