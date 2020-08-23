package code.controller;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class TightendController implements Initializable {

    public Label resultsL;

    @Override public void initialize(URL location, ResourceBundle resources) {
        System.out.println(getClass().getName() + " in initialize!");

        // we do not do anything in initialize for this player
        // he will get a screen pass later in "the play"
    }
}

