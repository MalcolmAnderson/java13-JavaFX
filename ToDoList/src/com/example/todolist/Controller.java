package com.example.todolist;

import com.example.todolist.datamodel.ToDoData;
import com.example.todolist.datamodel.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class Controller {
    private List<ToDoItem> toDoItems;

    @FXML
    private ListView<ToDoItem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;

    @FXML
    private BorderPane mainBorderPane;


    public void initialize(){
//        ToDoItem item1 = new ToDoItem("Mail birthday card",
//                "Buy a 30th birthday card for John", LocalDate.of(2020, Month.JULY, 25));
//
//        ToDoItem item2 = new ToDoItem("Doctor's Appointment",
//                "See Dr. Smith at 123 Main Street.  Bring Paperwork", LocalDate.of(2020, Month.JULY, 23));
//
//        ToDoItem item3 = new ToDoItem("Finish design proposal for client",
//                "I promised Mike I'd email website mockups by Friday 22nd April", LocalDate.of(2020, Month.JULY, 22));
//
//        ToDoItem item4 = new ToDoItem("Pickup Doug at the train station",
//                "Doug's arriving on June 23rd on the 5:00 train", LocalDate.of(2020, Month.SEPTEMBER, 23));
//
//        ToDoItem item5 = new ToDoItem("Pick up dry cleaning",
//                "The cloths should be ready by Wednesday", LocalDate.of(2020, Month.MAY, 2));
//
//        toDoItems = new ArrayList<ToDoItem>();
//        toDoItems.add(item1);
//        toDoItems.add(item2);
//        toDoItems.add(item3);
//        toDoItems.add(item4);
//        toDoItems.add(item5);
//
//        ToDoData.getInstance().setToDoItems(toDoItems);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoItem>() {
            @Override
            public void changed(ObservableValue<? extends ToDoItem> observable, ToDoItem oldValue, ToDoItem newValue) {
                if(newValue != null){
                    ToDoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("d MMMM, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        } );

        //todoListView.getItems().setAll(toDoItems);
        //todoListView.getItems().setAll(ToDoData.getInstance().getToDoItems());
        todoListView.setItems(ToDoData.getInstance().getToDoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void toDoExit(){
        System.exit(0);
    }

    @FXML
    public void showNewItemDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle(("Add New ToDo Item"));
        dialog.setHeaderText("Use this dialog to create a new ToDo item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            DialogController controller = fxmlLoader.getController();
            ToDoItem newItem = controller.processResults();
            //todoListView.getItems().setAll(ToDoData.getInstance().getToDoItems());
            todoListView.getSelectionModel().select(newItem);
        }

    }

}
