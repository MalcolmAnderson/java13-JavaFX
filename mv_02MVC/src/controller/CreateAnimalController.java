package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.DataProvider;
import model.Dog;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateAnimalController implements Initializable {

        FxmlNavigationTools navTools = new FxmlNavigationTools();


        @FXML private TextField animalIdTxt;
        @FXML private TextField breedTxt;
        @FXML private TextField lifespanTxt;
        @FXML private TextField behaviorTxt;
        @FXML private TextField priceTxt;
        @FXML private RadioButton vaccYesRBtn;
        @FXML private RadioButton vaccNoRBtn;


        @FXML
        void onActionDisplayMainMenu(ActionEvent event) {
                System.out.println("Throw away any changes before going back");
                navTools.openViewFromButtonEvent(event, "/view/MainMenu.fxml");
        }

        @FXML
        void onActionSaveAnimal(ActionEvent event) {
                System.out.println("Save any changes before going forward");

                int id = Integer.parseInt(animalIdTxt.getText().trim());
                String breed = breedTxt.getText();
                int lifespan = Integer.parseInt(lifespanTxt.getText());
                String behavior = behaviorTxt.getText();
                double price = Double.parseDouble(priceTxt.getText());
                boolean isVaccinated;
                String special = null;

                if(vaccYesRBtn.isSelected()){
                        isVaccinated = true;
                } else {
                        isVaccinated = false;
                }
                DataProvider.addAnimal(new Dog(id, breed, lifespan, behavior, price, isVaccinated, special));

                navTools.openViewFromButtonEvent(event, "/view/MainMenu.fxml");
        }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
