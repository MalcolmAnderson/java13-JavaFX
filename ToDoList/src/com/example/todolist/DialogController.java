package com.example.todolist;

import com.example.todolist.datamodel.ToDoData;
import com.example.todolist.datamodel.ToDoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadlinePicker;

    public void setToDoItem(ToDoItem selectedItem){
        shortDescriptionField.textProperty().setValue(selectedItem.getShortDescription());
    }

    public ToDoItem processResults(){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadLineValue = deadlinePicker.getValue();
        ToDoItem newItem = new ToDoItem(shortDescription, details, deadLineValue);
        ToDoData.getInstance().addToDoItem(newItem);
        return newItem;
    }

    public void modifyItemDetails(ToDoItem item){
        item.setShortDescription(shortDescriptionField.getText());
        item.setDetails(detailsArea.getText());
        item.setDeadline(deadlinePicker.getValue());
    }

    public void adoptItemDetails(ToDoItem edited){
        shortDescriptionField.setText(edited.getShortDescription());
        detailsArea.setText(edited.getDetails());
        deadlinePicker.setValue(edited.getDeadline());
    }


}
