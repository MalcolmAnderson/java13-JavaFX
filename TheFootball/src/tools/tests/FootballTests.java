package tools.tests;

import code.model.Football;
import org.junit.*;

public class FootballTests {

    Football o;

    // ObjectUnderTest o
    @BeforeClass public static void setUpBeforeClass() throws Exception{
        //System.out.println("@BeforeClass runs once per test run");
    }
    @AfterClass public static void setUpAfterClass() throws Exception{
        //System.out.println("@AfterClass runs once per test run");
    }
    @Before public void setup() throws Exception{
        //System.out.println("@After before after EACH @Test during a test run");
        o = new Football("Pro", true, "Brown", 12.8f);
    }
    @After public void tearDown() throws Exception{
        //System.out.println("@After runs after EACH @Test during a test run");
    }

    @Test public void ShouldHaveHandoffMethod(){
        //o = new Football("Pro", true, "Brown", 12.8f);
        o.getHandoff();
    }

    @Test public void ShouldDisplayFootball(){
        //o = new Football("Pro", true, "Brown", 12.8f);
        String expected = "A Brown and laced Pro football is ready at 12.8 psi";
        Assert.assertEquals(expected, o.DisplayStatus());
    }


}
