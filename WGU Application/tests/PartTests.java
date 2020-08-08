import Model.GetIdNumber;
import org.junit.Assert;
import org.junit.Test;

import Model.Part_InHouse;

public class PartTests {
    @Test
    public void ShouldInstantiate_Part_InHouse(){
        Part_InHouse ihSimpleCircuit = new Part_InHouse(GetIdNumber.getNextIdNumber(),
                "Simple Circuit", 5d, 8, 2, 10, 200);

        Assert.assertEquals("Simple Circuit", ihSimpleCircuit.getName());
    }

}


