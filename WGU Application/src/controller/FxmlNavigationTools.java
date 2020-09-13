package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;

import java.io.IOException;

public class FxmlNavigationTools {

    Stage stage;
    Parent scene;

    public void openMainScreenWhilePassingInventory(
            ActionEvent event,
            String viewNameAndPath,
            Inventory inv) {
        // Assumes that the event variable is a button object
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(viewNameAndPath));
            Parent mainScreenParent = loader.load();
            Scene mainScreenScene = new Scene(mainScreenParent);

            // get controller and load data
            MainScreenController mainScreenController = loader.getController();
            mainScreenController.loadInventory(inv);
            stage.setTitle("Inventory Management System");

            stage.setScene(mainScreenScene);
            stage.show();
        } catch (IOException ioe) {
            // I don't care
            System.out.println("viewNameAndPath probably not found - viewNameAndPath: " + viewNameAndPath);
        }
    }

    public void open_AddModify_PartController_WhilePassingInventory(
            ActionEvent event,
            String viewNameAndPath,
            Inventory inv,
            String transactionType,
            Part selectedItem) {
        // Assumes that the event variable is a button object
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(viewNameAndPath));
            Parent mainScreenParent = loader.load();
            Scene mainScreenScene = new Scene(mainScreenParent);

            // get controller and load data
            AddModify_PartController addModify_partController = loader.getController();
            addModify_partController.loadInventory(inv);
            addModify_partController.SetAddModifyLabel(transactionType);
            if(transactionType == "Modify") {
                addModify_partController.SetItemToModify(selectedItem);
            } else {
                addModify_partController.InitializeNewItem();
            }


            stage.setTitle("Inventory Management System - " + transactionType + " Part Screen");

            stage.setScene(mainScreenScene);
            stage.show();
        } catch (IOException ioe) {
            // I don't care
            System.out.println("viewNameAndPath probably not found - viewNameAndPath: " + viewNameAndPath);
        }
    }

    public void open_AddModify_ProductController_WhilePassingInventory(
            ActionEvent event,
            String viewNameAndPath,
            Inventory inv,
            String transactionType) {
        // Assumes that the event variable is a button object
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(viewNameAndPath));
            Parent mainScreenParent = loader.load();
            Scene mainScreenScene = new Scene(mainScreenParent);

            // get controller and load data
            AddModify_ProductController addModify_productController = loader.getController();
            addModify_productController.loadInventory(inv);

            stage.setTitle(transactionType + " Product Screen");

            stage.setScene(mainScreenScene);
            stage.show();
        } catch (IOException ioe) {
            // I don't care
            System.out.println("viewNameAndPath probably not found - viewNameAndPath: " + viewNameAndPath);
        }
    }

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
