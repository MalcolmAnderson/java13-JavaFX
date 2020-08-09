
import Model.GetIdNumber;
import Model.Inventory;
import Model.Part_InHouse;
import Model.Part_Outsourced;
import Model.Part;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InventoryTests {


    @Test
    public void RemovingAPartShouldReturnTrue(){


    Part_Outsourced osCase = new Part_Outsourced(GetIdNumber.getNextIdNumber(),
            "Case", 2d, 2, 2,8, "Cases from Bob");

    Part_InHouse ihSimpleCircuit = new Part_InHouse(GetIdNumber.getNextIdNumber(),
            "Simple Circuit", 5d, 8, 2, 10, 200);

    Part_InHouse ihLogicCircuit = new Part_InHouse(GetIdNumber.getNextIdNumber(),
            "Logic Circuit", 5d, 8, 2, 10, 201);

        Inventory inv = new Inventory();
        inv.getAllParts().add(osCase);
        inv.getAllParts().add(ihSimpleCircuit);
        inv.getAllParts().add(ihLogicCircuit);
        Assert.assertEquals(3, inv.getAllParts().size());
        Assert.assertTrue( inv.deletePart(osCase));
        Assert.assertEquals(2, inv.getAllParts().size());
        ObservableList<Part> lookUpResults = FXCollections.observableArrayList();
        lookUpResults = inv.lookupPart("Case");
        Assert.assertEquals(0, lookUpResults.size());
    }

}
