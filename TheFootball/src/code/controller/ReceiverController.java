package code.controller;

import code.model.Football;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ReceiverController implements Initializable {
    private static Football thePass = null;
    public Label resultsL;

    public static void passFootball(Football pass){
        thePass = pass;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(getClass().getName()+ " in initialize!");

        // here the receiver should have gotten "the pass" - a static data attribute

        // need to run the play
//        String result = Playmaker.passingPlay(thePass);

        // post the results
//        resultsL.setText(result);
    }
}
