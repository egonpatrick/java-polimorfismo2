package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			
			System.out.println("Product #"+i+" data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char resp = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			Product product;
			if (resp == 'i') {
				System.out.print("Customs fee: ");
				double customFee = sc.nextDouble();
				product = new ImportedProduct(name, price, customFee);
			}else if(resp =='u') {
				System.out.print("Manufacture date (DD/MM/YYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				product = new UsedProduct(name, price, manufactureDate);				
			}else {
				product = new Product(name, price);
			}
			products.add(product);
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product prod : products) {
			System.out.println(prod.priceTag());
		}
		sc.close();

	}

}
