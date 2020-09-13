import model.IdNumber;
import org.junit.Assert;
import org.junit.Test;

import model.Part_InHouse;

public class PartTests {
    @Test
    public void ShouldInstantiate_Part_InHouse(){
        Part_InHouse ihSimpleCircuit = new Part_InHouse(IdNumber.getNextIdNumberAndCommit(),
                "Simple Circuit", 5d, 8, 2, 10, 200);

        Assert.assertEquals("Simple Circuit", ihSimpleCircuit.getName());
    }

}


