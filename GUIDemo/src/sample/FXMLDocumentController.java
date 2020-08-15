package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {

    // These items are for the ListView and TextArea examples
    @FXML private ListView listView;
    @FXML private TextArea golfTextArea;

    public void listViewButtonPushed(){
        String textAreaString = "";
        ObservableList listOfItems = listView.getSelectionModel().getSelectedItems();
        for(Object item: listOfItems){
            textAreaString += String.format("%s%n", (String) item);
        }
        golfTextArea.setText(textAreaString);
    }


    // These items are for the RadioButton examples
    private ToggleGroup favLangToggleGroup;
    @FXML private RadioButton phpRadioButton;
    @FXML private RadioButton javaRadioButton;
    @FXML private RadioButton cSharpRadioButton;
    @FXML private RadioButton cPlusPlusRadioButton;
    @FXML private Label radioButtonLabel;

    public void radioButtonChanged(){
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.cPlusPlusRadioButton)){
            radioButtonLabel.setText("The selected item is: C++");
        } else if(this.favLangToggleGroup.getSelectedToggle().equals(this.cSharpRadioButton)){
            radioButtonLabel.setText("The selected item is: C#");
        } else if(this.favLangToggleGroup.getSelectedToggle().equals(this.phpRadioButton)){
            radioButtonLabel.setText("The selected item is: php");
        } else if(this.favLangToggleGroup.getSelectedToggle().equals(this.javaRadioButton)){
            radioButtonLabel.setText("The selected item is: Java");
        }

    }

    // These items are for the ComboBox example
    @FXML private ComboBox comboBox;
    @FXML private Label comboBoxLabel;


    public void comboBoxWasUpdated(){
        String message = "Course selected: \n" + comboBox.getValue().toString();
        comboBoxLabel.setText(message);
    }



    // These items are for the ChoiceBox example
    @FXML private ChoiceBox choiceBox;
    @FXML private Label choiceBoxLabel;

    public void choiceBoxButtonPushed(){
        if (choiceBox.getValue() != null) {
            choiceBoxLabel.setText("My favourite fruit is " + choiceBox.getValue().toString());
        } else {
            choiceBoxLabel.setText("Favourite Fruit must be selected before pressing button");
        }
    }




    // These items are for the CheckBox example
    @FXML private Label pizzaOrderLabel;
    @FXML private CheckBox pepperoniCheckBox;
    @FXML private CheckBox pineappleCheckBox;
    @FXML private CheckBox baconCheckBox;

    public void pizzaOrderButtonPushed(){
        String order = "Toppings are:";
        if (pineappleCheckBox.isSelected()){
            order += "\npineapple";
        }
        if (pepperoniCheckBox.isSelected()){
            order += "\npepperoni";
        }
        if (baconCheckBox.isSelected()){
            order += "\nbacon";
        }
        this.pizzaOrderLabel.setText(order);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("initialize() routine started");
        pizzaOrderLabel.setText("");

        // items for configuring ChoiceBox
        choiceBoxLabel.setText("");
        choiceBox.getItems().add("Apples");
        choiceBox.getItems().add("Bananas");
        choiceBox.getItems().add("Pineapple");
        choiceBox.getItems().add("Pears");
        choiceBox.getItems().addAll("Oranges", "Pears", "Raspberries");
        choiceBox.setValue("Apples");

        // these items are for configuring the ComboBox
        comboBox.getItems().add("COMP1030");
        comboBox.getItems().addAll("COMP1008", "MGMT2003", "MGMT2010");
        comboBoxLabel.setText("");

        // these items are for configuring the RadioButtons
        radioButtonLabel.setText("");

        favLangToggleGroup = new ToggleGroup();
        this.cPlusPlusRadioButton.setToggleGroup(favLangToggleGroup);
        this.cSharpRadioButton.setToggleGroup(favLangToggleGroup);
        this.phpRadioButton.setToggleGroup(favLangToggleGroup);
        this.javaRadioButton.setToggleGroup(favLangToggleGroup);

        // these items are for configuring the ListView and TextArea
        listView.getItems().addAll("Golf Balls", "Wedges", "Irons", "Tees", "Driver", "Putter");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
}
