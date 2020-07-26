package com.example.todolist;

import com.example.todolist.datamodel.ToDoData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
        primaryStage.setTitle("To Do List");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        try{
            ToDoData.getInstance().storeToDoItems();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void init() throws Exception {
        try{
            ToDoData.getInstance().loadToDoItems();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
/*
    product - LED Matrix
	4 plastic parts
	10 electronic parts
	1 Circuit Board

    product - LED Array
	4 electronic parts

    product - PC-Mark-I
	1 LED Matrix
	1 LED Array
	2 Sm Register Banks
	1 Logic Circuit
	1 Simple Circuit
	1 Metal Case

    product - PC-Mark-II
	2 LED Matrix
	2 Sm Register Banks
	1 Logic Circuit
	1 Simple Circuit
	1 Metal Case

 */
}
