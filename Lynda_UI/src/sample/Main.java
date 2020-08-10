package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Button btn = new Button();
        btn.setText("I'm a button");
        Label lbl = new Label("I'm a label");
        TextField tf = new TextField("Enter text here");
        Hyperlink hl = new Hyperlink("I'm a hyperlink");

        RadioButton rb = new RadioButton("Radio Button");
        rb.setStyle("-fx-base: #61a2b1");
        CheckBox cb = new CheckBox("Check box");
        ProgressBar pb = new ProgressBar();
        ScrollBar sb = new ScrollBar();

        GridPane grid = new GridPane();
//        Image imageHome
//        Button btn2 = new Button("Search", new )

//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
