package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateAnimalController implements Initializable {

        FxmlNavigationTools navTools = new FxmlNavigationTools();


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

//        @FXML
//        private ToggleGroup vaccTG;

        @FXML
        void onActionDisplayMainMenu(ActionEvent event) {
                System.out.println("Throw away any changes before going back");
                navTools.openViewFromButtonEvent(event, "/view/MainMenu.fxml");
        }

        @FXML
        void onActionSaveAnimal(ActionEvent event) {
                System.out.println("Save any changes before going forward");
                navTools.openViewFromButtonEvent(event, "/view/MainMenu.fxml");
        }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
