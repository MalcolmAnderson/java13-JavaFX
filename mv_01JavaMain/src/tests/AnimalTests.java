package tests;

import com.example.mypackage.animal.Animal;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTests {
    @Test public void HelloAnimal(){
        Animal o = new Animal("MyBreed", 13, 50.0d);
        Assert.assertEquals(13, o.getLifespan());
    }

}
