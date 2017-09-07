package com.candidate;

public class Item extends Parse{
    private String rawInput;

    public Item(String input) {
        rawInput = input;
    }

    public final String getName() {
        return Parse.itemName(rawInput);
    }
    public final boolean getImported() {
        return Boolean.valueOf(Parse.itemImported(rawInput));
    }
    public final int getCount() { return Integer.parseInt(Parse.itemCount(rawInput)); }
    public final double getBaseCost() {
        return Double.parseDouble(Parse.itemBaseCost(rawInput));
    }
    public final double getTax() {
        return Calculator.getTax(this);
    }
    public final double getTotal() { return Calculator.getTotal(this); }

}

