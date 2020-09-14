import model.IdNumber;
import model.Part;
import model.Part_InHouse;
import model.Product;
import org.junit.Assert;
import org.junit.Test;


public class ProductTests {
    @Test public void ShouldInstantiate_new_Product(){
        Product o = new Product(IdNumber.getNextIdNumberAndCommit(),
                "Simple Product", 5d, 8, 2, 10);
        Assert.assertEquals(0, o.getAssociatedParts().size());
    }
//
//    @Test public void CloneShouldWork_forZeroParts(){
//        Product prod1 = new Product(IdNumber.getNextIdNumberAndCommit(),
//                "Simple Product", 5d, 8, 2, 10);
//        Product o = Product.Clone(prod1);
//        Assert.assertEquals(0, prod1.getAssociatedParts().size());
//        Assert.assertEquals(0, o.getAssociatedParts().size());
//    }
//
//    @Test public void CloneShouldWork(){
//        Product prod1 = new Product(IdNumber.getNextIdNumberAndCommit(),
//                "Simple Product", 5d, 8, 2, 10);
//        Part part1 = new Part_InHouse(IdNumber.getNextIdNumberAndCommit(), "p1", 1d, 3, 2, 5, 200);
//        Part part2 = new Part_InHouse(IdNumber.getNextIdNumberAndCommit(), "p2", 2d, 6, 4, 10, 200);
//        prod1.addAssociatedPart(part1);
//        prod1.addAssociatedPart(part2);
//        Product o = Product.Clone(prod1);
//        Assert.assertEquals(2, prod1.getAssociatedParts().size());
//        Assert.assertEquals(2, o.getAssociatedParts().size());
//    }


}
