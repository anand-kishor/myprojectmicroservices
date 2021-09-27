package com.stream.producer.api.modal;



public class Order {
	private String orderId;
	private String name;
	private int quantity;
	private double price;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId)
	{
		this.orderId=orderId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
	public Order(String orderId, String name, int quantity, double price) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
