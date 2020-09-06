package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Animal;
import model.DataProvider;


import java.net.URL;
import java.util.ResourceBundle;

public class DisplayAnimalController implements Initializable {
    FxmlNavigationTools navTools = new FxmlNavigationTools();

    @FXML
    private TableView<Animal> animalTableView;

    @FXML
    private TableColumn<Animal, Integer> animalIdCol;

    @FXML
    private TableColumn<Animal, String> breedCol;

    @FXML
    private TableColumn<Animal, Integer> lifespanCol;

    @FXML
    private TableColumn<Animal, Double> priceCol;

    @FXML
    void onActionDisplayAnimalDetails(ActionEvent event) {
        navTools.openViewFromButtonEvent(event, "/view/AnimalDetailsMenu.fxml");
    }

    @FXML
    void onActionDisplayMainMenu(ActionEvent event) {
        navTools.openViewFromButtonEvent(event, "/view/MainMenu.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        animalTableView.setItems(DataProvider.getAllAnimals());

        animalIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        breedCol.setCellValueFactory(new PropertyValueFactory<>("breed"));
        lifespanCol.setCellValueFactory(new PropertyValueFactory<>("lifespan"));
        //animalBehaviorCol.setCellValueFactory(new PropertyValueFactory<>("behavior"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        //animalVaccinatedIdCol.setCellValueFactory(new PropertyValueFactory<>("vaccinated"));
    }
}
