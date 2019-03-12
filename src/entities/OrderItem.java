package entities;

public class OrderItem {
	
	private Integer quantity;
	private Double price;
	private Product product;
	
	public OrderItem(Integer quantity, Double price, Product product) {
		
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double subTotal() {
		return price * quantity;
	}

	public Product getProduct() {
		return product;
	}
	@Override
	public String toString() {
		return product.getName() 
				+ ", $" 
				+ String.format("%.2f", price) 
				+ ", Quantity: " 
				+ quantity + 
				", Subtotal: $" 
				+ String.format("%.2f", subTotal());
	}
}
