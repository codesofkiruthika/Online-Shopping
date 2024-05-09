package com.Shopping;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class Shopping {
	public static void shopNow() {
			
		String priceQuantity="";
		Scanner shopNowObj = new Scanner(System.in);
		String quantityKey = "";
		boolean isCategoryValid = true;
		boolean isBrandValid = true;
		boolean isProductValid = true;
		for(String categoryKey : Products.categoryMap.keySet()) {
			System.out.println(categoryKey);
		}
		while(isCategoryValid) {
			System.out.println("Choose the category : ");
			String categoryNumber = shopNowObj.nextLine();
			for(String categoryKey : Products.categoryMap.keySet()) {
				if(categoryKey.substring(0,categoryKey.indexOf(".")).equals(categoryNumber)) {
					isCategoryValid=false;
					quantityKey+=categoryKey.substring(categoryKey.indexOf(".")+2);
					LinkedHashMap<String,LinkedHashMap<String,Integer>> brands = Products.categoryMap.get(categoryKey);
					for(String brandKey : brands.keySet()) {
						System.out.println(brandKey);
					}
					while(isBrandValid) {
						System.out.println("Choose the brand : ");
						String brandNumber = shopNowObj.nextLine();
						for(String brandKey : brands.keySet()) {
							if(brandKey.substring(0,brandKey.indexOf(".")).equals(brandNumber)) {
								isBrandValid=false;
								quantityKey+=">"+brandKey.substring(brandKey.indexOf(".")+2);
								LinkedHashMap<String,Integer> products = brands.get(brandKey);
								for(String productKey : products.keySet()) {
									System.out.println(productKey+"     Price :"+products.get(productKey)+"     Available quantity :"+Products.quantityMap.get(quantityKey+">"+productKey.substring(productKey.indexOf(".")+2)));
								}
								while(isProductValid) {
									System.out.println("Choose the product : ");
									String productNumber = shopNowObj.nextLine();
									for(String productKey : products.keySet()) {
										if(productKey.substring(0,productKey.indexOf(".")).equals(productNumber)) {
											isProductValid=false;
											quantityKey+=">"+productKey.substring(productKey.indexOf(".")+2);
											 priceQuantity = products.get(productKey)+ ">"+Products.quantityMap.get(quantityKey);
											 shoppingOptions(quantityKey, priceQuantity);							
										}
									}
									if(isProductValid) {
										System.out.println("Please choose valid product...");
									}
								}
							}
						}
						if(isBrandValid) {
							System.out.println("Please choose valid brand...");
						}
					}
				}	
		  }
			if(isCategoryValid) {
				System.out.println("Please choose valid category...");
			}
		}
	}
	public static void shoppingOptions(String quantityKey, String priceQuantity) {
		Scanner shoppingOptionObj = new Scanner(System.in);
		System.out.println();
		System.out.println("1. Add to wishlist \n2. Add to cart \n3. Back");
		System.out.println("Enter your option : ");
		int option = shoppingOptionObj.nextInt();
		switch(option) {
			case 1:
				addToWishlist(quantityKey, priceQuantity);
				break;
			case 2:
				addToCart(quantityKey, priceQuantity);
				break;
			case 3:
				Main.postSignInOptionsForUser();
				break;
			default:
				System.out.println("Please enter the valid option...");
				shopNow();
		}
	}
	public static void buyingOptions() {
		Scanner buyingOptionObj = new Scanner(System.in);
		System.out.println();
		System.out.println("1. Continue shopping \n2. Buy now \n3. Clear Cart \n4. Back");
		System.out.println("Enter your option : ");
		int nextOption = buyingOptionObj.nextInt();
		switch(nextOption) {
			case 1:
				shopNow();
				break;
			case 2:
				Payment.buyNow();
				break;
			case 3:
				Shopping.clearCart();
				break;
			case 4:
				Main.postSignInOptionsForUser();
				break;
			default:
				System.out.println("Please enter the valid option...");
				buyingOptions();
		}
	}
	
	
	public static void afterBuyingOptions() {
		Scanner afterBuyingOptionObj = new Scanner(System.in);
		System.out.println();
		System.out.println("1. Continue shopping \n2. Back");
		System.out.println("Enter your option : ");
		int nextOption = afterBuyingOptionObj.nextInt();
		switch(nextOption) {
			case 1:
				shopNow();
				break;
			case 2:
				Main.postSignInOptionsForUser();
				break;
			default:
				System.out.println("Please enter the valid option...");
				afterBuyingOptions();
		}
	}
	
	
	public static void viewWishlist(String userName){
		if(wishlistMap.containsKey(userName)) {
			LinkedHashMap<String,String> wishlistProductMap = wishlistMap.get(userName);
			System.out.println("Category "+"        Brand "+"        Product "+"        Price ");
			for(String product : wishlistProductMap.keySet()) {
				System.out.println(product.split(">")[0]+"            "+product.split(">")[1]+"         "+product.split(">")[2]+"          Rs. "+ wishlistProductMap.get(product).split(">")[0]);
			}
			boolean isValidOptionSelected = true;
			while(isValidOptionSelected) {
			Scanner  wishlistObj= new Scanner(System.in);
			System.out.println();
			System.out.println("1. Add to Cart \n2. Continue Shopping \n3. Back");
			int option = wishlistObj.nextInt();
			switch(option) {
				case 1:
					boolean isValidProductSelected = true;
					while(isValidProductSelected) {
					System.out.println("Select the product to add it in cart");
					Scanner productObj = new Scanner(System.in);
					int productNo = productObj.nextInt();
					boolean isProductInWishlist=false;
					for(String product:wishlistProductMap.keySet()) {
						if(productNo==Integer.valueOf(product.substring(0,product.indexOf(".")))) {
							addToCart(product.substring(product.indexOf(".")+2),wishlistProductMap.get(product));
							isProductInWishlist=true;
							isValidProductSelected=false;
						}
						
					}
					if(!isProductInWishlist) {
						System.out.println("Please select valid product...");
					}
					}
					
					isValidOptionSelected=false;
					break;
				case 2:
					shopNow();
					isValidOptionSelected=false;
					break;
				case 3:
					Main.postSignInOptionsForUser();
					isValidOptionSelected=false;
					break;
				default:
					System.out.println("please enter valid option..");
					
			}
			}
		}
		else {
			System.out.println("Your wishlist is empty...");
			//System.out.println("Please choose anything to add in wishlist...");
		}
		//shopNow();
		Main.postSignInOptionsForUser();
	}
	
	public static LinkedHashMap<String, LinkedHashMap<String,String>> wishlistMap = new LinkedHashMap<String, LinkedHashMap<String,String>>();
	
	public static void addToWishlist(String quantityKey,String priceQuantity) {
		if(wishlistMap.containsKey(User.getSignedInUser())) {
			LinkedHashMap<String,String> wishlistProductMap = wishlistMap.get(User.getSignedInUser());
			if(wishlistProductMap.containsKey(quantityKey)) {
					System.out.println("This product is already in your wishlist...");
					shopNow();					
				}
				else {
					int n = wishlistProductMap.size();
					wishlistProductMap.put((n+1)+". "+quantityKey, priceQuantity);
					wishlistMap.put(User.getSignedInUser(), wishlistProductMap);
					System.out.println("Product added to your wishlist...");
				}
			}
			else {
				wishlistMap.put(User.getSignedInUser(), new LinkedHashMap<String,String>());
				LinkedHashMap<String,String> wishlistProductMap = wishlistMap.get(User.getSignedInUser());
				int n = wishlistProductMap.size();
				wishlistProductMap.put((n+1)+". "+quantityKey, priceQuantity);
				wishlistMap.put(User.getSignedInUser(), wishlistProductMap);
				System.out.println("Product added to your wishlist...");
			}
		boolean isValidOptionSelected = true;
		while(isValidOptionSelected) {
		Scanner  wishlistObj= new Scanner(System.in);
		System.out.println();
		System.out.println("1. View Wishlist \n2. Continue Shopping \n3. Back");
		int option = wishlistObj.nextInt();
		switch(option) {
		case 1:
			viewWishlist(User.getSignedInUser());
			isValidOptionSelected=false;
			break;
		case 2:
			shopNow();
			isValidOptionSelected=false;
			break;
		case 3:
			Main.postSignInOptionsForUser();
			isValidOptionSelected=false;
			break;
		default:
			System.out.println("please enter valid option..");
			
		}
		}
	}
	
	
	public static LinkedHashMap<String, LinkedHashMap<String,String>> cartMap = new LinkedHashMap<String, LinkedHashMap<String,String>>();
	
	public static void addToCart(String quantityKey,String priceQuantity) {
		Scanner quantityObj = new Scanner(System.in);
		System.out.println("Enter the quantity");
		int  cartQuantity= quantityObj.nextInt();
		if(cartQuantity > Integer.valueOf(priceQuantity.split(">")[1])) {
			System.out.println("Insufficient product, please choose valid quantity");
			addToCart( quantityKey, priceQuantity); 
		}
		else {
			if(cartMap.containsKey(User.getSignedInUser())){
			LinkedHashMap<String, String> cartProductMap = cartMap.get(User.getSignedInUser());
				if(cartProductMap.containsKey(quantityKey)) {
				String oldQuantity = cartProductMap.get(quantityKey).split(">")[1];
				int newQuantity = Integer.valueOf(oldQuantity)+cartQuantity;
				cartProductMap.put(quantityKey,priceQuantity.split(">")[0]+">"+newQuantity );
				int presentQuantity = Integer.valueOf(priceQuantity.split(">")[1]);
				int finalQuantity = presentQuantity-cartQuantity;
				Products.quantityMap.put(quantityKey,finalQuantity);
		        cartMap.put(User.getSignedInUser(), cartProductMap);
				System.out.println("Product added to your cart...");
				buyingOptions();
		       
				}
				else {
					LinkedHashMap<String, String> newCartProductMap = cartMap.get(User.getSignedInUser());
					newCartProductMap.put(quantityKey, priceQuantity.split(">")[0]+">"+cartQuantity);
					int presentQuantity = Integer.valueOf(priceQuantity.split(">")[1]);
					int finalQuantity = presentQuantity-cartQuantity;
					Products.quantityMap.put(quantityKey,finalQuantity);
					System.out.println("Product added to your cart...");
					buyingOptions();
				}
			}
			else {
				cartMap.put(User.getSignedInUser(), new LinkedHashMap<String,String>());
				LinkedHashMap<String,String> newProductMap = cartMap.get(User.getSignedInUser());
				newProductMap.put(quantityKey, priceQuantity.split(">")[0]+">"+cartQuantity);
				int presentQuantity = Integer.valueOf(priceQuantity.split(">")[1]);
				int finalQuantity = presentQuantity-cartQuantity;
				Products.quantityMap.put(quantityKey,finalQuantity);
				System.out.println("Product added to your cart...");
				buyingOptions();
				
			}
		}
        }
	public static void viewCart() {
		if(cartMap.containsKey(User.getSignedInUser())) {
			LinkedHashMap<String, String> cartProductMap = cartMap.get(User.getSignedInUser());
			if(cartProductMap.size()==0) {
				System.out.println("Your cart is empty...");
				Main.postSignInOptionsForUser();
			}
			else {
				System.out.println("Category "+"        Brand "+"        Product "+"       Quantity"+"        Price ");
				for(String product:cartProductMap.keySet()) {
					System.out.println(product.split(">")[0]+"          "+product.split(">")[1]+"          "+product.split(">")[2]+"          "+cartProductMap.get(product).split(">")[1]+"          "+Integer.valueOf(cartProductMap.get(product).split(">")[0])*Integer.valueOf(cartProductMap.get(product).split(">")[1]));
				}
				buyingOptions();
			}
		}
		else {
			System.out.println("Your cart is empty...");
			Main.postSignInOptionsForUser();
//			System.out.println("Please choose anything to add in cart...");
//			shopNow();
		}
	}
	public static LinkedHashMap<String,LinkedHashMap<String,String>> myOrdersMap = new LinkedHashMap<String,LinkedHashMap<String,String>>();
	public static void myOrders() {
		if(myOrdersMap.containsKey(User.getSignedInUser())) {
		LinkedHashMap<String,String> myOrdersProductMap = myOrdersMap.get(User.getSignedInUser());
		System.out.println("Category "+"        Brand "+"        Product "+"        Quantity "+"        Price ");
		for(String product:myOrdersProductMap.keySet()) {
			System.out.println(product.split(">")[0]+"        "+product.split(">")[1]+"          "+product.split(">")[2]+"           "+myOrdersProductMap.get(product).split(">")[1]+"             "+Integer.valueOf(myOrdersProductMap.get(product).split(">")[0])*Integer.valueOf(myOrdersProductMap.get(product).split(">")[1]));
		}
		}
		else {
			System.out.println("You have not ordered anything...");
		}
		Main.postSignInOptionsForUser();
	}
	public static void clearCart() {
		if(cartMap.containsKey(User.getSignedInUser())) {
			LinkedHashMap<String,String> cartProductMap = cartMap.get(User.getSignedInUser());
			for(String product : cartProductMap.keySet()) {
				int cartQuantity = Integer.valueOf(cartProductMap.get(product).split(">")[1]);
				int originalQuantity = Integer.valueOf(Products.quantityMap.get(product));
				Products.quantityMap.put(product, cartQuantity+originalQuantity);
			}
			cartProductMap.clear();
			System.out.println("Your cart was cleared...");
		}
		else {
			System.out.println("You have nothing to clear in cart...");	
		}
		Main.postSignInOptionsForUser();
	}
	
	
	
	
	
	
}