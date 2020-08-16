package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class ExampleOfTableViewController implements Initializable {

    @FXML private TextArea selectedPeople;


    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameColumn;
    @FXML private TableColumn<Person, String> lastNameColumn;
    @FXML private TableColumn<Person, LocalDate> birthdayColumn;

    // instance variable used to create a new person
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private DatePicker birthdayDatePicker;

    public void changeFirstNameCellEvent(TableColumn.CellEditEvent editedCell){
        System.out.println("double click in firstName column");
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setFirstName(editedCell.getNewValue().toString());
    }

    public void changeLastNameCellEvent(TableColumn.CellEditEvent editedCell){
        System.out.println("double click in lastName column");
        Person personSelected = tableView.getSelectionModel().getSelectedItem();
        personSelected.setLastName(editedCell.getNewValue().toString());
    }

    public void changeBirthdayCellEvent(TableColumn.CellEditEvent editedCell){
        System.out.println("double click in birthday column");
//        Person personSelected = tableView.getSelectionModel().getSelectedItem();
//        personSelected.setBirthday((LocalDate)editedCell.getNewValue());
    }



    // change scene
    public void changeScreenButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        // This line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }


    // change scene to view a person - pass the selected person object to the detailed view
    public void changeSceneToDetailedPersonView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PersonView.fxml"));
        Parent tableViewParent = loader.load();

        Scene tableViewScene = new Scene(tableViewParent);

        // access controller and call a method
        PersonViewController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());


        // This line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // setup columns in the table
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));

        // load dummy data
        tableView.setItems(getPeople());

        // update table to allow edits
        tableView.setEditable(true);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //birthdayColumn.setCellFactory();


        // allow table to select multiple rows
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }


    public void deletePersonPushed(){
        ObservableList<Person> selectedRows, allPeople;
        allPeople = tableView.getItems();
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for(Person person: selectedRows){
            allPeople.remove(person);
        }

        for(Person person: selectedRows){
            allPeople.remove(person);
        }
    }

    public void listSelectedPeople(){
        ObservableList<Person> selectedRows, allPeople;
        allPeople = tableView.getItems();
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        StringBuilder text = new StringBuilder("Selected People:");
        for(Person person: selectedRows){
            String line = "\n" + person.getFirstName().toString() + " " + person.getLastName().toString();
            text.append(line);
        }
        selectedPeople.setText(text.toString());

    }

    // method to create new person
    public void newPersonButtonPushed(){
        Person newPerson = new Person(
                firstNameTextField.getText(),
                lastNameTextField.getText(),
                birthdayDatePicker.getValue());
        // Get all the items from the table as a list,
        // then add the new person to the list
        tableView.getItems().add(newPerson);
    }

    // create dummy data
    private ObservableList<Person> getPeople(){
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("Frank", "Sinatra", LocalDate.of(1915, Month.DECEMBER, 12)));
        people.add(new Person("Rebecca", "Fergusson", LocalDate.of(1986, Month.JULY, 21)));
        people.add(new Person("Mr.", "T", LocalDate.of(1952, Month.MAY, 21)));

        return people;
    }
}
