package test;

import com.candidate.Parse;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParseTest {
    @Test
    public void testRuns() {
        assertTrue("true - should equal true", true);
    }
    @Test
    public void findName() {
        String targetOne = "tea";
        assertEquals("Should return single word name",
                Parse.itemName("1 " + targetOne + " at 14.99"), targetOne);

        String targetTwo = "bottle of perfume";
        assertEquals("Should return multi word name, when imported presence",
                Parse.itemName("1 imported " + targetTwo + " at 27.99"), targetTwo);

        String targetThree = "chocolate bar";
        assertEquals("Should return multi word name",
                Parse.itemName("1 " + targetThree + " at 0.85"), targetThree);
    }
    @Test
    public void findImportStatus() {
        assertEquals("Should return true when imported",
                Parse.itemImported("1 imported bottle of perfume at 27.99"), "true");

        assertEquals("Should return false when not imported",
                Parse.itemImported("1 packet of headache pills at 9.75"), "false");
    }
    @Test
    public void findCount() {
        String target = "1";
        assertEquals("Should return true when imported",
                Parse.itemCount(target + " packet of headache pills at 9.75"), target);
    }
    @Test
    public void findBaseCost() {
        String targetOne = "14.99";
        assertEquals("Should return the correct cost",
                Parse.itemBaseCost("1 music CD at " + targetOne), targetOne);

        String targetTwo = "18.99";
        assertEquals("Should return the correct cost",
                Parse.itemBaseCost("1 bottle of perfume at " + targetTwo), targetTwo);

        String targetThree = "11.25";
        assertEquals("Should return the correct cost",
                Parse.itemBaseCost("1 box of imported chocolates at " + targetThree), targetThree);
    }
    @Test
    public void runRegex() {
        String patternOne = "chocolate";
        assertEquals("Should use pattern to find a regex match",
                Parse.findPattern(patternOne, "There are chocolate boxes over the hill."), "chocolate");
    }

}
