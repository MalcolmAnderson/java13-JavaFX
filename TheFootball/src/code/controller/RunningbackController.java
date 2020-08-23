package code.controller;

import code.model.Football;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RunningbackController implements Initializable {

    public Label resultsL;
    private Football football = null;

    @Override public void initialize(URL location, ResourceBundle resources) {
        System.out.println(getClass().getName() + " in initialize!");

        // grab the football from the quarterback here - this is a static method call
        football = QuarterbackController.getHandOff();

        // Do the Play
        // String results = Playmaker.runningPlay(football);

        // post Results
        resultsL.setText("13");
    }
}
