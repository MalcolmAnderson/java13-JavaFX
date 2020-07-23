package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Controller {
    private int threadCount = 0;

    @FXML
    private TextField nameField;

    @FXML
    private Button helloButton;

    @FXML
    private Button byeButton;

    @FXML
    private CheckBox clearNameAfterInteraction;

    @FXML
    private Label labelAdditionalThreadCount;

    @FXML
    private Label ourLabel;

    @FXML
    public void initialize(){
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void handleCheckBoxState(){
        System.out.println("The checkbox is " + (clearNameAfterInteraction.isSelected() ? "checked" : "unchecked"));
    }

    @FXML
    public void onButtonClicked(ActionEvent e){
        if(e.getSource().equals(helloButton)){
            System.out.println("Hello " + nameField.getText());
        } else if(e.getSource().equals((byeButton))){
            System.out.println("Bye " + nameField.getText());
            //System.exit(0);
        }
        updateLabelAdditionalThreadCount(++threadCount);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("I'm going to sleep on the: " + s);
                    Thread.sleep(10000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            ourLabel.setText("We did something! " + threadCount);
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println("I'm updating the label on the: " + s);
                            updateLabelAdditionalThreadCount(--threadCount);
                        }
                    });
                } catch (InterruptedException event){
                    // we dont care
                }

            }
        };
        new Thread(task).start();

        if(clearNameAfterInteraction.isSelected()){
            nameField.clear();
            updateButtonState();
        }
    }

    @FXML
    public void handleKeyReleased(){
        updateButtonState();
    }



    private void updateButtonState(){
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }
    private void updateLabelAdditionalThreadCount(int threadCount){
        labelAdditionalThreadCount.setText("Additional running threads: " + threadCount);
    }
}
