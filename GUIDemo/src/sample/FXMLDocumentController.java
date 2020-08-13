package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {

    @FXML private Label pizzaOrderLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize() routine started");
        pizzaOrderLabel.setText("");

    }
}
