
import WGUApplication.GetIdNumber;
import WGUApplication.Inventory;
import WGUApplication.Part_InHouse;
import WGUApplication.Part_Outsourced;
import WGUApplication.Part;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Assert;
import org.junit.Test;

public class InventoryTests {


    Part_Outsourced osCase = new Part_Outsourced(GetIdNumber.getNextIdNumber(),
            "Case", 2d, 2, 2,8, "Cases from Bob");

    Part_InHouse ihSimpleCircuit = new Part_InHouse(GetIdNumber.getNextIdNumber(),
            "Simple Circuit", 5d, 8, 2, 10, 200);

    Part_InHouse ihLogicCircuit = new Part_InHouse(GetIdNumber.getNextIdNumber(),
            "Logic Circuit", 5d, 8, 2, 10, 201);


    @Test
    public void RemovingAPartShouldReturnTrue(){
        Inventory.getAllParts().add(osCase);
        Inventory.getAllParts().add(ihSimpleCircuit);
        Inventory.getAllParts().add(ihLogicCircuit);
        Assert.assertEquals(3, Inventory.getAllParts().size());
        Assert.assertTrue( Inventory.deletePart(osCase));
        Assert.assertEquals(2, Inventory.getAllParts().size());
        ObservableList<Part> lookUpResults = FXCollections.observableArrayList();
        lookUpResults = Inventory.lookupPart("Case");
        Assert.assertEquals(0, lookUpResults.size());
    }

}
