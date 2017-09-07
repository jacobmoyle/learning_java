package com.candidate;

public class Calculator {
    private static double importPercent() { return 0.05; }
    private static double salesPercent() { return 0.10; }
    private static String[] salesTaxExempt() { return new String[] {"book", "chocolate", "pills"}; }

    public static double getTax(Item item) {
        double tax = 0;
        boolean taxable = salesTaxable(item);
        boolean imported = item.getImported();
        double base = item.getBaseCost();

        tax += taxable ? base * salesPercent() : 0;
        tax += imported ? base * importPercent() : 0;

        double roundedTax = Math.ceil(tax * 20) / 20.0;

        return roundedTax;
    }
    public static double getTotal(Item item) {
        return item.getBaseCost() + item.getTax();
    }

    private static boolean salesTaxable(Item item) {
        boolean taxable = true;

        for (String exemptName: salesTaxExempt()) {
            if (Parse.findPattern(exemptName, item.getName()).length() > 0) { taxable = false; }
        }

        return taxable;
    }
}
