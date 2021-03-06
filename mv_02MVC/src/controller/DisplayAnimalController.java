package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Animal;
import model.DataProvider;
import model.Dog;


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

    public boolean search(int id){
        for(Animal dog : DataProvider.getAllAnimals()){
            if(id == dog.getId()){
                return true;
            }
        }
        return false;
    }

    public boolean update(int id, Animal animal){
        int index = -1;
        for(Animal dog: DataProvider.getAllAnimals()){
            index++;
            if(dog.getId() == id){
                DataProvider.getAllAnimals().set(index, animal);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id){
        for(Animal dog: DataProvider.getAllAnimals()){
            if(dog.getId() == id){
                return DataProvider.getAllAnimals().remove(dog);
            }
        }
        return false;
    }

    public Animal selectAnimal(int id){
        for(Animal dog : DataProvider.getAllAnimals()){
            if(dog.getId() == id){
                return dog;
            }
        }
        return null;
    }

    public ObservableList<Animal> filter(String breed){
        if(!(DataProvider.getAllFilteredAnimals().isEmpty())){
            DataProvider.getAllFilteredAnimals().clear();
        }
        for(Animal dog: DataProvider.getAllAnimals()){
            if(dog.getBreed().toUpperCase().contains(breed.toUpperCase())){
                DataProvider.getAllFilteredAnimals().add(dog);
            }
        }
        if(DataProvider.getAllFilteredAnimals().isEmpty()){
            return DataProvider.getAllAnimals();
        } else {
            return DataProvider.getAllFilteredAnimals();
        }
    }


    @Override public void initialize(URL location, ResourceBundle resources) {
        //animalTableView.setItems(DataProvider.getAllAnimals());
        animalTableView.setItems(filter("q"));

        animalIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        breedCol.setCellValueFactory(new PropertyValueFactory<>("breed"));
        lifespanCol.setCellValueFactory(new PropertyValueFactory<>("lifespan"));
        //animalBehaviorCol.setCellValueFactory(new PropertyValueFactory<>("behavior"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        //animalVaccinatedIdCol.setCellValueFactory(new PropertyValueFactory<>("vaccinated"));


//        if(update(5, new Dog(5, "Toy", 13, "Sleepy", 999.99, true, "Sturdy"))){
//            System.out.println("Update Successful");
//        } else {
//            System.out.println("Update Failed");
//        }
//        if(delete(3)){
//            System.out.println("Deleted dog id 3");
//        } else {
//            System.out.println("No Match for delete");
//        }

        //animalTableView.getSelectionModel().select(selectAnimal(6));
    }
}
