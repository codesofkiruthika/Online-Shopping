package com.Shopping;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import com.Shopping.User;

public class Payment {
	public static void buyNow() {
		boolean isCorrectUPIIDEntered = true;
		long totalAmount = 0l;
		LinkedHashMap <String, String> buyMap = Shopping.cartMap.get(User.getSignedInUser());
		System.out.println("List of Products in your cart:");
		if(Shopping.myOrdersMap.containsKey(User.getSignedInUser())) {
			LinkedHashMap<String,String> myOrdersProductMap = Shopping.myOrdersMap.get(User.getSignedInUser());
			for(String product:buyMap.keySet()) {
			String[] productDetail = product.split(">");
			String[] pricenQuantity = buyMap.get(product).split(">");
			long currentProductPrice = Integer.valueOf(pricenQuantity[0])*Integer.valueOf(pricenQuantity[1]);
			System.out.println("Brand: "+productDetail[1]+"      Product: "+productDetail[2]+"      Quantity: "+pricenQuantity[1]+"      Price: Rs. "+currentProductPrice);
			totalAmount+=currentProductPrice;
			int n=myOrdersProductMap.size();
			myOrdersProductMap.put((n+1)+". "+product,buyMap.get(product));
			}
		}
		else {
			Shopping.myOrdersMap.put(User.getSignedInUser(), new LinkedHashMap<String,String>());
			LinkedHashMap<String,String> myOrdersProductMap = Shopping.myOrdersMap.get(User.getSignedInUser());
			for(String product:buyMap.keySet()) {
				String[] productDetail = product.split(">");
				String[] pricenQuantity = buyMap.get(product).split(">");
				long currentProductPrice = Integer.valueOf(pricenQuantity[0])*Integer.valueOf(pricenQuantity[1]);
				System.out.println("Brand: "+productDetail[1]+"      Product: "+productDetail[2]+"      Quantity: "+pricenQuantity[1]+"      Price: Rs. "+currentProductPrice);
				totalAmount+=currentProductPrice;
				myOrdersProductMap.put("1. "+product,buyMap.get(product));

			}
		}
		System.out.println("Total Bill Amount : "+totalAmount);
		Scanner buyingObj = new Scanner(System.in);
		System.out.println("Your current address is: ");
		System.out.println(User.getSignedInUserAddress());
		System.out.println("Do you want to change the delivery location?");
		System.out.println("1. Yes  \n2. No");
		int addressOption = buyingObj.nextInt();
		switch(addressOption) {
		case 1:
			System.out.println("Please enter the new delivery location:");
			String changedAddress = buyingObj.nextLine();
			buyingObj.nextLine();
			User.setAddress(changedAddress);
			System.out.println("Your new address changed successfully...");
			break;
		case 2:
			break;
		default:
			System.out.println("Please enter the valid option...");
			buyNow();
		}
		System.out.println("Please select the mode of payment");
		System.out.println("1. Cash on Delivery  \n2. UPI");
		System.out.println("Enter your option :");
		int modeOfPayment = buyingObj.nextInt();
		switch(modeOfPayment) {
		case 1:
			System.out.println("Your order has been placed and product will be delivered within two days...");
			buyMap.clear();
			Shopping.afterBuyingOptions();
			break;
		case 2:
			while(isCorrectUPIIDEntered) {
				Scanner upiObj = new Scanner(System.in);
				System.out.println("Please enter your UPI ID");
				String UPIId = upiObj.nextLine();
				buyingObj.nextLine();
				if((UPIId.length()>3)&&(UPIId.contains("@"))&&(!UPIId.endsWith("@"))&&(!UPIId.startsWith("@"))){
					System.out.println("Your UPI ID has been verified");
					System.out.println("Enter your pin to pay");
					int payOption = upiObj.nextInt();
					if(Integer.toString(payOption).length()==6) {
						System.out.println("Payment Successfull!!!...");
						System.out.println("Your order has been placed and product will be delivered within two days...");
						buyMap.clear();
						isCorrectUPIIDEntered=false;
						Shopping.afterBuyingOptions();
					}
					else {
						System.out.println("Please enter valid pin...");
					}
				}
				else {
					System.out.println("Please enter valid UPI ID");
				}
			}
		}
		
	}
}