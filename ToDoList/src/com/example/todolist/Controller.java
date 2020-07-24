package com.example.todolist;

import com.example.todolist.datamodel.ToDoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<ToDoItem> toDoItems;

    @FXML
    private ListView<ToDoItem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;


    public void initialize(){
        ToDoItem item1 = new ToDoItem("Mail birthday card",
                "Buy a 30th birthday card for John", LocalDate.of(2020, Month.JULY, 25));

        ToDoItem item2 = new ToDoItem("Doctor's Appointment",
                "See Dr. Smith at 123 Main Street.  Bring Paperwork", LocalDate.of(2020, Month.JULY, 23));

        ToDoItem item3 = new ToDoItem("Finish design proposal for client",
                "I promised Mike I'd email website mockups by Friday 22nd April", LocalDate.of(2020, Month.JULY, 22));

        ToDoItem item4 = new ToDoItem("Pickup Doug at the train station",
                "Doug's arriving on June 23rd on the 5:00 train", LocalDate.of(2020, Month.SEPTEMBER, 23));

        ToDoItem item5 = new ToDoItem("Pick up dry cleaning",
                "The cloths should be ready by Wednesday", LocalDate.of(2020, Month.MAY, 2));

        toDoItems = new ArrayList<ToDoItem>();
        toDoItems.add(item1);
        toDoItems.add(item2);
        toDoItems.add(item3);
        toDoItems.add(item4);
        toDoItems.add(item5);

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

        todoListView.getItems().setAll(toDoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }


}
