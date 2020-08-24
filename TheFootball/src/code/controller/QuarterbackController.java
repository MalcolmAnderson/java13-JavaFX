package code.controller;

import code.model.Football;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class QuarterbackController implements Initializable {
    // Private Data - The Football
    private Football theFootball = null;

    // Score Tracking
    private int homeScore = 0;
    private int visitorScore = 0;

    private static Football handOff = null;
    public static Football getHandOff(){
        return handOff;
    }

    private ButtonType btnBreakHuddle;
    private ButtonType btnHandOffTheBall;
    private ButtonType btnPassTheBall;
    private ButtonType btnScreenPlay;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        theFootball = new Football("Pro", true, "Brown", 12.8f);

    }

    public void onHandOffB(ActionEvent actionEvent){
        // mess with our own GUI
        // playAction(); // not sure what this does

        handOff = theFootball;

        // open the running back
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/view/runningback.fxml"));

            // set new stage
            Stage stage = new Stage();
            stage.setTitle("Running Back");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onPassB(ActionEvent actionEvent){
        // mess with our own GUI
        // playAction(); // not sure what this does

        // open the running back
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/view/receiver.fxml"));

            // set new stage
            Stage stage = new Stage();
            stage.setTitle("Receiver");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onScreenB(ActionEvent actionEvent){
        // mess with our own GUI
        // playAction(); // not sure what this does

        // open the running back
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/tightend.fxml"));
            Parent root = loader.load();

            // must get access to te controller to make the screen
            // so using the getController method ...
            TightendController te = loader.getController();
            //te.screenPlay(theFootball);

            // set new stage
            Stage stage = new Stage();
            stage.setTitle("Tight End");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onBreakHuddle(ActionEvent actionEvent){
        // Disable Break button
        //btnBreakHuddle.setDisable(true);
    }
}
