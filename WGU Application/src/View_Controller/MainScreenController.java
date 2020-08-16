package View_Controller;

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {


    private Inventory inv;
    ObservableList<Part> allParts;
    ObservableList<Product> allProducts;
    public void loadInventory(Inventory inv){
        this.inv = inv;
        System.out.println(inv.getAllParts().size());
        //List<Part> tempParts = this.inv.getAllParts();
        allParts = inv.getAllParts();
        allProducts = inv.getAllProducts();
        System.out.println("Inventory loaded into MainScreenController");
    }

    @FXML
    private ListView<Part> lv_Parts;

    @FXML
    private ListView<Product> lv_Products;


    @FXML
    private GridPane addModify_Part;

    @FXML
    private Button buttonExit;

    @FXML
    private GridPane idMainScreen;

    public void OnButtonClicked_Exit(){
        Platform.exit();
    }

    public void DoSomeTesting(){
        System.out.println("Doing some testing");
        System.out.println(allParts.size());
        System.out.println(allProducts.size());
    }


    @FXML
    public void OnMouseClicked_PartAdd_Only(ActionEvent event) throws IOException {
        System.out.println("Hello from PartAdd_Only");
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/AddModify_Part.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        // this line gets the stage info
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    public void OnMouseClicked_PartAdd(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(idMainScreen.getScene().getWindow());
        try{
            Parent root = FXMLLoader.load(getClass().getResource("AddModify_Part.fxml"));
            dialog.getDialogPane().setContent(root);


        } catch (Exception e){
            System.out.println("Couldn't load the add part dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            System.out.println("OK pressed");
        } else {
            System.out.println("Cancel pressed");
        }
    }


    // Handlers for Product Logic
    @FXML
    public void OnButtonClicked_ProductAdd(){
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lv_Products.setItems(allProducts);
        lv_Parts.setItems(allParts);
    }



    // Stubs
    public void OnButtonClicked_PartSearch(){}
    public void OnButtonClicked_PartModify(){}
    public void OnButtonClicked_PartDelete(){}
    public void handleAction_PartSearch(){}

    public void OnButtonClicked_ProductSearch(){}
    public void OnButtonClicked_ProductModify(){}
    public void OnButtonClicked_ProductDelete(){}
    public void handleAction_ProductSearch(){}


}
