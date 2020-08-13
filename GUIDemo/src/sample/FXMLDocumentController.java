package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {

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

    }
}
