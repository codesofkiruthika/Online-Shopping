package com.Shopping;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Scanner;


public class Products {
	public static LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String,Integer>>> categoryMap = new LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String,Integer>>>();
	public static LinkedHashMap<String, LinkedHashMap<String,Integer>> dressBrandMap = new LinkedHashMap<String, LinkedHashMap<String,Integer>>();
	public static LinkedHashMap<String, LinkedHashMap<String,Integer>> footWearBrandMap = new LinkedHashMap<String, LinkedHashMap<String,Integer>>();
	public static LinkedHashMap<String, LinkedHashMap<String,Integer>> bagsBrandMap = new LinkedHashMap<String, LinkedHashMap<String,Integer>>();
	public static LinkedHashMap<String,Integer> ottoProductMap = new LinkedHashMap<String,Integer>();
	public static LinkedHashMap<String,Integer> pumaProductMap = new LinkedHashMap<String,Integer>();
	public static LinkedHashMap<String,Integer> adidasProductMap = new LinkedHashMap<String,Integer>();
	public static LinkedHashMap<String,Integer> bataProductMap = new LinkedHashMap<String,Integer>();
	public static LinkedHashMap<String,Integer> nikeProductMap = new LinkedHashMap<String,Integer>();
	public static LinkedHashMap<String,Integer> crocsProductMap = new LinkedHashMap<String,Integer>();
	public static LinkedHashMap<String,Integer> zaraProductMap = new LinkedHashMap<String,Integer>();
	public static LinkedHashMap<String,Integer> zoukProductMap = new LinkedHashMap<String,Integer>();
	public static LinkedHashMap<String,Integer> lavieProductMap = new LinkedHashMap<String,Integer>();
	public static LinkedHashMap<String,Integer> quantityMap = new LinkedHashMap<String,Integer>();

	public static void addDefaultProducts() {
		ottoProductMap.put("1. shirt", 800);
		ottoProductMap.put("2. tshirt", 450);
		ottoProductMap.put("3. pant", 980);
		dressBrandMap.put("1. otto", ottoProductMap);
		
		pumaProductMap.put("1. shirt", 800);
		pumaProductMap.put("2. tshirt", 700);
		pumaProductMap.put("3. pant", 600);
		dressBrandMap.put("2. puma", pumaProductMap);
		
		adidasProductMap.put("1. shirt", 500);
		adidasProductMap.put("2. tshirt", 350);
		adidasProductMap.put("3. pant", 400);
		dressBrandMap.put("3. adidas", adidasProductMap);
		
		categoryMap.put("1. Dress",dressBrandMap);
		
		quantityMap.put("Dress>otto>shirt", 10);
		quantityMap.put("Dress>otto>tshirt", 6);
		quantityMap.put("Dress>otto>pant", 7);

		quantityMap.put("Dress>puma>shirt", 4);
		quantityMap.put("Dress>puma>tshirt", 5);
		quantityMap.put("Dress>puma>pant", 6);

		quantityMap.put("Dress>adidas>shirt", 7);
		quantityMap.put("Dress>adidas>tshirt", 5);
		quantityMap.put("Dress>adidas>pant", 2);
//
		bataProductMap.put("1. flats", 500);
		bataProductMap.put("2. shoes", 850);
		bataProductMap.put("3. heels", 450);
		footWearBrandMap.put("1. bata", bataProductMap);
		
		nikeProductMap.put("1. flats", 400);
		nikeProductMap.put("2. shoes", 700);
		nikeProductMap.put("3. heels", 600);
		footWearBrandMap.put("2. nike", nikeProductMap);
		
		crocsProductMap.put("1. flats", 1400);
		crocsProductMap.put("2. shoes", 2350);
		crocsProductMap.put("3. heels", 2400); 
		footWearBrandMap.put("3. crocs", crocsProductMap);
		
		categoryMap.put("2. Footwear",footWearBrandMap);
		
		quantityMap.put("Footwear>bata>flats", 4);
		quantityMap.put("Footwear>bata>shoes", 6);
		quantityMap.put("Footwear>bata>heels", 8);

		quantityMap.put("Footwear>nike>flats", 4);
		quantityMap.put("Footwear>nike>shoes", 5);
		quantityMap.put("Footwear>nike>heels", 6);

		quantityMap.put("Footwear>crocs>flats", 5);
		quantityMap.put("Footwear>crocs>shoes", 3);
		quantityMap.put("Footwear>crocs>heels", 2);
//
		zaraProductMap.put("1. shoulder bag", 600);
		zaraProductMap.put("2. sling bag", 550);
		zaraProductMap.put("3. hand bag", 450);
		bagsBrandMap.put("1. zara", zaraProductMap);
		
		zoukProductMap.put("1. shoulder bag", 400);
		zoukProductMap.put("2. sling bag", 550);
		zoukProductMap.put("3. hand bag", 450);
		bagsBrandMap.put("2. zouk", zoukProductMap);
		
		lavieProductMap.put("1. shoulder bag", 450);
		lavieProductMap.put("2. sling bag", 350);
		lavieProductMap.put("3. hand bag", 400); 
		bagsBrandMap.put("3. lavie", lavieProductMap);
		
		categoryMap.put("3. Bags",bagsBrandMap);
		
		quantityMap.put("Bags>zara>shoulder bag", 4);
		quantityMap.put("Bags>zara>sling bag", 6);
		quantityMap.put("Bags>zara>hand bag", 8);

		quantityMap.put("Bags>zouk>shoulder bag", 6);
		quantityMap.put("Bags>zouk>sling bag", 8);
		quantityMap.put("Bags>zouk>hand bag", 8);

		quantityMap.put("Bags>lavie>shoulder bag", 5);
		quantityMap.put("Bags>lavie>sling bag", 3);
		quantityMap.put("Bags>lavie>hand bag", 2);

//
//		productMap.put("1. shoulder bag", 600);
//		bagsBrandMap.put("1. zara", productMap);
//		categoryMap.put("3. Bags",bagsBrandMap);
//		quantityMap.put("Bags>zara>shoulder bag", 4);
//		
//		LinkedHashMap <String, LinkedHashMap<String,Integer>> bags = categoryMap.get("3. Bags");
//		bags.put("2. zouk",new LinkedHashMap<String,Integer>());
//		bags.put("3. lavie",new LinkedHashMap<String,Integer>());
//
//		LinkedHashMap<String,Integer> zara = categoryMap.get("3. Bags").get("1. zara");
//		zara.put("2. sling bag", 550);
//		zara.put("3. hand bag", 450);
//		quantityMap.put("Bags>zara>sling bag", 6);
//		quantityMap.put("Bags>zara>hand bag", 8);
//
//		
//		LinkedHashMap<String,Integer> zouk = categoryMap.get("3. Bags").get("2. zouk");
//		zouk.put("1. shoulder bag", 400);
//		zouk.put("2. sling bag", 550);
//		zouk.put("3. hand bag", 450);
//		quantityMap.put("Bags>zouk>shoulder bag", 6);
//		quantityMap.put("Bags>zouk>sling bag", 8);
//		quantityMap.put("Bags>zouk>hand bag", 8);
//
//		LinkedHashMap<String,Integer> lavie = categoryMap.get("3. Bags").get("3. lavie");
//		lavie.put("1. shoulder bag", 450);
//		lavie.put("2. sling bag", 350);
//		lavie.put("3. hand bag", 400); 
//		quantityMap.put("Bags>lavie>shoulder bag", 5);
//		quantityMap.put("Bags>lavie>sling bag", 3);
//		quantityMap.put("Bags>lavie>hand bag", 2);
//		
//		
	}
	public static void addNewProducts(){
		Scanner addProductsObj = new Scanner(System.in);
		System.out.println("Enter the category name : ");
		String categoryName = addProductsObj.nextLine();
		System.out.println("Enter the brand name : ");
		String brandName = addProductsObj.nextLine();
		System.out.println("Enter the product name : ");
		String productName = addProductsObj.nextLine();
		System.out.println("Enter the price : ");
		int price = addProductsObj.nextInt();
		System.out.println("Enter the quantity : ");
		int quantity = addProductsObj.nextInt();
		loop1:
		for(String categoryKey : categoryMap.keySet()) {
			String categorySubStr = categoryKey.substring(categoryKey.indexOf('.')+2);
			if(categorySubStr.equals(categoryName)){
				LinkedHashMap<String,LinkedHashMap<String,Integer>> brandCheck = categoryMap.get(categoryKey);
				
				for(String brandKey : brandCheck.keySet()) {
					String brandSubStr = brandKey.substring(brandKey.indexOf('.')+2);
					if(brandSubStr.equals(brandName)){
						LinkedHashMap<String,Integer> productCheck = brandCheck.get(brandKey);
						
						for(String productKey : productCheck.keySet()) {
							String productSubStr = productKey.substring(productKey.indexOf('.')+2);
							if(productSubStr.equals(productName)){
								if(productCheck.get(productKey)!=price) {
									System.out.println("You entered the different price for the existing product. Do you want to update the price? \n1. Yes  \n2. No");
									int updatepriceOption = addProductsObj.nextInt();
									switch(updatepriceOption) {
									case 1:
										productCheck.put(productKey,price);
										break;
									}
								}
								quantityMap.put(categoryName+">"+brandName+">"+productName, quantityMap.get(categoryName+">"+brandName+">"+productName)+quantity);
								break loop1;
							
							}
							else {
								LinkedHashMap<String,Integer> newProductMap = categoryMap.get(categoryKey).get(brandKey);
								int n = newProductMap.size();
								newProductMap.put((n+1)+". "+productName, price);
								quantityMap.put(categoryName+">"+brandName+">"+productName, quantity);
								break loop1;
							}
							
						}
						break loop1;
					}
					
					else {
						LinkedHashMap<String,LinkedHashMap<String,Integer>> newBrandMap = categoryMap.get(categoryKey);
						int n = newBrandMap.size();
						newBrandMap.put((n+1)+". "+brandName, new LinkedHashMap<String,Integer>());
						LinkedHashMap<String,Integer> newProductMap = categoryMap.get(categoryKey).get((n+1)+". "+brandName);
						newProductMap.put("1. "+productName, price);
						quantityMap.put(categoryName+">"+brandName+">"+productName, quantity);
						break loop1;
					}
				}
				break loop1;

			}
			else {
				int n = categoryMap.size();
				categoryMap.put((n+1)+". "+categoryName,new LinkedHashMap<String,LinkedHashMap<String,Integer>>());
				LinkedHashMap<String,LinkedHashMap<String,Integer>> newBrandMap = categoryMap.get((n+1)+". "+categoryName);
				newBrandMap.put("1. "+brandName, new LinkedHashMap<String,Integer>());
				LinkedHashMap<String,Integer> newProductMap = categoryMap.get((n+1)+". "+categoryName).get("1. "+brandName);
				newProductMap.put("1. "+productName, price);
				quantityMap.put(categoryName+">"+brandName+">"+productName, quantity);
				break loop1;
			}
		}
		System.out.println("Products added successfully...");
		int number;
		do{
			System.out.println("Enter 1 for back");
			number = addProductsObj.nextInt();
		if(number==1) {
		Main.postSignInOptionsForAdmin();	
		}
		else {
			System.out.println("Please enter the valid number...");
		}
		}while(number!=1);

	}
	public static void checkQuantity(){
		Scanner checkQuantityObj = new Scanner(System.in);
		String quantityKey = "";
		for(String categoryKey : categoryMap.keySet()) {
			System.out.println(categoryKey);
		}
		System.out.println("Choose the category : ");
		String categoryNumber = checkQuantityObj.nextLine();
		for(String categoryKey : categoryMap.keySet()) {
			if(categoryKey.substring(0,categoryKey.indexOf(".")).equals(categoryNumber)) {
				quantityKey+=categoryKey.substring(categoryKey.indexOf(".")+2);
				LinkedHashMap<String,LinkedHashMap<String,Integer>> brands =categoryMap.get(categoryKey);
				for(String brandKey : brands.keySet()) {
					System.out.println(brandKey);
				}
				System.out.println("Choose the brand : ");
				String brandNumber = checkQuantityObj.nextLine();
				for(String brandKey : brands.keySet()) {
					if(brandKey.substring(0,brandKey.indexOf(".")).equals(brandNumber)) {
						quantityKey+=">"+brandKey.substring(brandKey.indexOf(".")+2);
						LinkedHashMap<String,Integer> products = brands.get(brandKey);
						for(String productKey : products.keySet()) {
							System.out.println(productKey);
						}
						System.out.println("Choose the product : ");
						String productNumber = checkQuantityObj.nextLine();
						for(String productKey : products.keySet()) {
							if(productKey.substring(0,productKey.indexOf(".")).equals(productNumber)) {
								quantityKey+=">"+productKey.substring(productKey.indexOf(".")+2);
								int quantity = quantityMap.get(quantityKey);
								System.out.println("Available Quantity is : "+quantity);
								break;
							}
							else {
//								System.out.println("Product not found...Please enter valid details...");
//								checkQuantity();
//								break;
							}
						}
						break;
					}
					else {
//						System.out.println("Brand not found...Please enter valid details...");
//						checkQuantity();
//						break;
					}
				}
				break;
			}
			else {
//				System.out.println("Category not found...Please enter valid details...");
//				checkQuantity();
			}
		}
		int number;
		do{
			System.out.println("Enter 1 for back");
			number = checkQuantityObj.nextInt();
		if(number==1) {
		Main.postSignInOptionsForAdmin();	
		}
		else {
			System.out.println("Please enter the valid number...");
		}
		}while(number!=1);
	}

}
