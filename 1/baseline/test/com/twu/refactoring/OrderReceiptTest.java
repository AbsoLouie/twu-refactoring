package com.twu.refactoring;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderReceiptTest {

    public Order order;
    public OrderReceipt receipt;
    private StringBuilder stringBuilder;

    @Before
    public void setUp() throws Exception {
        order = mock(Order.class);
        stringBuilder = new StringBuilder(100);
        receipt = new OrderReceipt(order, stringBuilder);
    }

    @Test
    public void shouldPrintCustomerInformationOnOrderMock() {
        when(order.getCustomerName()).thenReturn("Mr X");
        when(order.getCustomerAddress()).thenReturn("Chicago, 60601");
        String output = receipt.printReceipt();

        assertTrue(output.contains("Mr X"));
        assertTrue(output.contains("Chicago, 60601"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        ArrayList<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
        }};

        order = new Order(null, null, lineItems);
        receipt = new OrderReceipt(order, stringBuilder);

        String output = receipt.printReceipt();

        assertTrue(output.contains("milk\t10.0\t2\t20.0\n"));
    }

}
