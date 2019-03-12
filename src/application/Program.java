package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.StatusPedido;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String nome = sc.nextLine();
		System.out.print("E-mail: ");
		String mail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date bdate = sdf2.parse(sc.next());
		Client client = new Client(nome, mail, bdate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		sc.nextLine();
		String status = sc.nextLine();
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		Date now = new Date();
		Order order = new Order(now, StatusPedido.valueOf(status), client);
		
		for (int i=1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String pName = sc.nextLine();
			System.out.print("Product price: ");
			double pPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int pQuantity = sc.nextInt();
			Product produto = new Product(pName, pPrice);
			OrderItem orderItem = new OrderItem(pQuantity, pPrice, produto);
			order.addItem(orderItem);
		}
		System.out.println();		
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}

}
