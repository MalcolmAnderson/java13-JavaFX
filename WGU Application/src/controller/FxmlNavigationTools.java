package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

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
            MainScreen_Controller mainScreenController = loader.getController();
            mainScreenController.loadInventory(inv);
            stage.setTitle("Inventory Management System");

            stage.setScene(mainScreenScene);
            stage.show();
        } catch (IOException ioe) {
            // I don't care
            System.out.println("viewNameAndPath probably not found - viewNameAndPath: " + viewNameAndPath);
        }
    }

    private void ConfigureAndShowStage(
            Stage stage, Scene mainScreenScene,
            String transactionType, String partProduct){
        stage.setTitle("Inventory Management System - " + transactionType + " " + partProduct + " Screen");
        stage.setScene(mainScreenScene);
        stage.show();
    }
    private void ConfigurePartController(
            FXMLLoader loader, Inventory inv,
            String transactionType, Part selectedItem){
        // get controller and load data
        AddModify_PartController addModify_partController = loader.getController();
        addModify_partController.loadInventory(inv);
        addModify_partController.SetAddModifyLabel(transactionType);
        if(transactionType == "Modify") {
            addModify_partController.SetItemToModify(selectedItem);
        } else {
            addModify_partController.InitializeNewItem();
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

            ConfigurePartController(loader, inv, transactionType, selectedItem);
            ConfigureAndShowStage(stage, mainScreenScene, transactionType, "Part");
        } catch (IOException ioe) {
            System.out.println("viewNameAndPath probably not found - viewNameAndPath: " + viewNameAndPath);
        }
    }

    private void ConfigureProductController(
            FXMLLoader loader, Inventory inv,
            String transactionType, Product selectedItem){
        // get controller and load data
        AddModify_ProductController addModify_ProductController = loader.getController();
        addModify_ProductController.loadInventory(inv);
        addModify_ProductController.SetAddModifyLabel(transactionType);
        addModify_ProductController.SetItemToModify(selectedItem);
    }
    public void open_AddModify_ProductController_WhilePassingInventory(
            ActionEvent event,
            String viewNameAndPath,
            Inventory inv,
            String transactionType,
            Product selectedItem) {
        // Assumes that the event variable is a button object
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(viewNameAndPath));
            Parent mainScreenParent = loader.load();
            Scene mainScreenScene = new Scene(mainScreenParent);

            ConfigureProductController( loader,  inv,  transactionType, selectedItem);

            ConfigureAndShowStage(stage, mainScreenScene, transactionType, "Product");
        } catch (IOException ioe) {
            // I don't care
            System.out.println("viewNameAndPath probably not found - viewNameAndPath: " + viewNameAndPath);
        }
    }
}
