package test;

import com.candidate.Item;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ItemTest {
    @Test
    public void testRuns() {
        assertTrue("true - should equal true", true);
    }
    @Test
    public void getName() {
        String input = "1 box of imported chocolates at 11.25";
        String target = "box of chocolates";
        Item newItem = new Item(input);
        String response = newItem.getName();

        assertEquals("should return 'box of chocolates' for name", target, response);
    }
    @Test
    public void getImportedTrue() {
        String input = "1 box of imported chocolates at 11.25";
        Item newItem = new Item(input);
        boolean response = newItem.getImported();

        assertTrue("should return true if imported", response);
    }
    @Test
    public void getImportedFalse() {
        String input = "1 box of chocolates at 11.25";
        Item newItem = new Item(input);
        boolean response = newItem.getImported();

        assertFalse("should return false if imported", response);
    }
    @Test
    public void getCount() {
        String input = "1 box of imported chocolates at 11.25";
        Item newItem = new Item(input);
        int response = newItem.getCount();

        assertEquals("should return count - 1", 1, response);
    }
    @Test
    public void getBaseCost() {
        String input = "1 box of imported chocolates at 11.25";
        Item newItem = new Item(input);

        assertEquals("should return base cost - 11.25", 11.25, newItem.getBaseCost());
    }
    @Test
    public void getTax() {
        assertEquals("should return 10% * baseCost rounded to nearest .05",
                1.50,
                new Item("1 music CD at 14.99").getTax());

        assertEquals("should return 0 if item is a food",
                0.00,
                new Item("1 chocolate bar at 0.85").getTax());

        assertEquals("should return 0 if item is a medical supply",
                0.00,
                new Item("1 packet of headache pills at 9.75").getTax());

        assertEquals("should return 0 item is a book",
                0.00,
                new Item("1 book at 12.49").getTax());

        assertEquals("should return 5% * baseCost rounded to nearest .05 if imported",
                0.50,
                new Item("1 imported box of chocolates at 10.00").getTax());

        assertEquals("should return (5% * base) + (10% * base) - rounded to nearest .05 if imported and taxable",
                7.15,
                new Item("1 imported bottle of perfume at 47.50").getTax());
    }
    @Test
    public void getTotal() {
        String input = "1 imported bottle of perfume at 27.99";
        Item newItem = new Item(input);

        assertEquals("should return baseCost + importedTax + salesTax", 32.19, newItem.getTotal());
    }
}
