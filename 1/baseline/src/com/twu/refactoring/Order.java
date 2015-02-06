package com.twu.refactoring;

import java.util.List;

public class Order {
    String name;
    String address;
    List<LineItem> lineItem;

    public Order(String name, String address, List<LineItem> lineItem) {
        this.name = name;
        this.address = address;
        this.lineItem = lineItem;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItem;
    }
}
