package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FxmlNavigationTools {

    Stage stage;
    Parent scene;

    public void openViewFromButtonEvent(ActionEvent event, String viewNameAndPath) {
        // Assumes that the event variable is a button object
        try {
            stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            scene = FXMLLoader.load(getClass().getResource(viewNameAndPath));
            stage.setScene(new Scene(scene));
            stage.show();
        } catch (IOException ioe) {
            // I don't care
            System.out.println("viewNameAndPath probably not found - viewNameAndPath: " + viewNameAndPath);
        }

    }
}
