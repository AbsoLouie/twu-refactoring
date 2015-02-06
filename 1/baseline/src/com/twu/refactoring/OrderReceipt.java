package com.twu.refactoring;

public class OrderReceipt {

	private static final double TAX_RATE = .10;
	private Order order;
	private StringBuilder stringBuilder;
	private double totalSalesTax = 0d;
	private double total = 0d;

	public OrderReceipt(Order order, StringBuilder stringBuilder) {
        this.order = order;
		this.stringBuilder = stringBuilder;
	}

	public String printReceipt() {
		appendHeaders();
		processLineItems();
		appendSalesTax();
		appendTotalAmount();
		return stringBuilder.toString();
	}

	private void appendTotalAmount() {
		stringBuilder.append("Total Amount").append('\t').append(total);
	}

	private void appendSalesTax() {
		stringBuilder.append("Sales Tax").append('\t').append(totalSalesTax);
	}

	private void processLineItems() {
		for (LineItem lineItem : order.getLineItems()) {
			appendLineItemDetails(lineItem);
			calculateTotals(lineItem);
		}
	}

	private void calculateTotals(LineItem lineItem) {
		double salesTax = lineItem.totalAmount() * TAX_RATE;
		totalSalesTax += salesTax;
		total += lineItem.totalAmount() + salesTax;
	}

	private void appendLineItemDetails(LineItem lineItem) {
		stringBuilder.append(lineItem.getDescription());
		stringBuilder.append('\t');
		stringBuilder.append(lineItem.getPrice());
		stringBuilder.append('\t');
		stringBuilder.append(lineItem.getQuantity());
		stringBuilder.append('\t');
		stringBuilder.append(lineItem.totalAmount());
		stringBuilder.append('\n');
	}

	private void appendHeaders() {
		stringBuilder.append("======Printing Orders======\n");
		stringBuilder.append(order.getCustomerName());
		stringBuilder.append(order.getCustomerAddress());
	}
}