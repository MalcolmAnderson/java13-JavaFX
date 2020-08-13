package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {





    // These items are for the ChoiceBox example
    @FXML private ChoiceBox choiceBox;
    @FXML private Label choiceBoxLabel;

    public void choiceBoxButtonPushed(){
        if (choiceBox.getValue() != null) {
            choiceBoxLabel.setText("My favourite fruit is " + choiceBox.getValue().toString());
        } else {
            choiceBoxLabel.setText("Favourite Fruit must be selected before pressing button");
        }
    }




    // These items are for the CheckBox example
    @FXML private Label pizzaOrderLabel;
    @FXML private CheckBox pepperoniCheckBox;
    @FXML private CheckBox pineappleCheckBox;
    @FXML private CheckBox baconCheckBox;

    public void pizzaOrderButtonPushed(){
        String order = "Toppings are:";
        if (pineappleCheckBox.isSelected()){
            order += "\npineapple";
        }
        if (pepperoniCheckBox.isSelected()){
            order += "\npepperoni";
        }
        if (baconCheckBox.isSelected()){
            order += "\nbacon";
        }
        this.pizzaOrderLabel.setText(order);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize() routine started");
        pizzaOrderLabel.setText("");

        // items for configuring ChoiceBox
        choiceBoxLabel.setText("");
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Bananas");
        choiceBox.getItems().add("Pineapple");
        choiceBox.getItems().add("Pears");
        choiceBox.getItems().addAll("Oranges", "Pears", "Raspberries");
        choiceBox.setValue("Apples");


    }
}
