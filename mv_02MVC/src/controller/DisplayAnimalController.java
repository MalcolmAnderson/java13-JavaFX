package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import java.net.URL;
import java.util.ResourceBundle;

public class DisplayAnimalController implements Initializable {




        @FXML
        private TableView<?> animalTableView;

        @FXML
        private TableColumn<?, ?> animalIdCol;

        @FXML
        private TableColumn<?, ?> breedCol;

        @FXML
        private TableColumn<?, ?> lifespanCol;

        @FXML
        private TableColumn<?, ?> priceCol;

    @FXML
    void onActionDisplayAnimalDetails(ActionEvent event) {

    }

    @FXML
    void onActionDisplayMainMenu(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
