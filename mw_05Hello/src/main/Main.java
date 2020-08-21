package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override public void init(){
        System.out.println("Starting App");
        System.out.println("Spinup resources, configure connections and validate");
    }

    @Override public void stop(){
        System.out.println("Stopping App");
        System.out.println("Issue shutdown commands to dependencies, disconnect connections and validate");
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/mainView.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
