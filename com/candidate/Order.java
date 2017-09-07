package com.candidate;

import java.text.DecimalFormat;

public class Order {
    private Item[] orderItems;

    public Order(String rawOrder) {
        orderItems = createItems(rawOrder);
    }

    private final Item[] createItems(String rawOrder) {
        String inputRows[] = Parse.getItemRows(rawOrder);

        orderItems = new Item[inputRows.length];

        for (int i = 0; i < inputRows.length; i++) {
            orderItems[i] = new Item(inputRows[i]);
        }

        return orderItems;
    }

    public String getOrder() {
        String response = "";
        double orderTax = 0.00;
        double orderTotal = 0.00;

        for(int i = 0; i < orderItems.length; i++) {
            Item item = orderItems[i];

            response = response.concat(formatItem(item));

            orderTax += item.getTax();
            orderTotal += item.getTotal();
        }
        response = response.concat(formatOrderInfo(orderTotal, orderTax));

        return response;
    }
    private String formatOrderInfo(double orderTotal, double orderTax) {
        String formattedTotal = formatDecimal(orderTotal);
        String formattedSalesTax = formatDecimal(orderTax);

        return new String("Sales Taxes: " + formattedSalesTax + '\n' + "Total: " + formattedTotal);
    }
    private String formatItem(Item item) {
        int count = item.getCount();
        String name = item.getName();
        String total = formatDecimal(item.getTotal());
        String imported = item.getImported() ? " imported " : " ";

        return new String(count + imported + name + ": " + total + '\n');
    }
    private String formatDecimal(double amount) {
        return new DecimalFormat("#0.00" ).format(amount);
    }
}
