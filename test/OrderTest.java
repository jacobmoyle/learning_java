package test;

import com.candidate.Order;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderTest {
    @Test
    public void testRuns() {
        assertTrue("true - should equal true", true);
    }
    @Test
    public void inputOne() {
        String input = "1 book at 12.49\n1 music CD at 14.99\n1 chocolate bar at 0.85";
        String output = "1 book: 12.49\n1 music CD: 16.49\n1 chocolate bar: 0.85\nSales Taxes: 1.50\nTotal: 29.83";

        assertEquals("should format input correctly",
                output,
                new Order(input).getOrder());
    }
    @Test
    public void inputTwo() {
        String input = "1 imported box of chocolates at 10.00\n1 imported bottle of perfume at 47.50";
        String output = "1 imported box of chocolates: 10.50\n1 imported bottle of perfume: 54.65\nSales Taxes: 7.65\nTotal: 65.15";

        assertEquals("should format input correctly",
                output,
                new Order(input).getOrder());
    }
    @Test
    public void inputThree() {
        String input = "1 imported bottle of perfume at 27.99\n1 bottle of perfume at 18.99\n1 packet of headache pills at 9.75\n1 box of imported chocolates at 11.25\n";
        String output = "1 imported bottle of perfume: 32.19\n1 bottle of perfume: 20.89\n1 packet of headache pills: 9.75\n1 imported box of chocolates: 11.85\nSales Taxes: 6.70\nTotal: 74.68";

        assertEquals("should format input correctly",
                output,
                new Order(input).getOrder());
    }
}
