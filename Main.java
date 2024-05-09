package com.Shopping;
import java.util.Scanner;

public class Main {
	
		public static void showOption() {
			Scanner homeObj = new Scanner(System.in);
			System.out.println();
			System.out.println("1. Sign up \n2. Sign in \n3. Exit");
			System.out.println("Enter your option : ");
			int option = homeObj.nextInt();
			switch(option) {
			case 1:
				User.signUp();
				break;
			case 2:
				User.signIn();
				break;
			case 3:
				System.out.println("Glad that you visited our App ! Keep shopping... Have a great day !...");
				break;
			default:
				System.out.println("Please enter the valid option...");
				showOption();
			}
		}
		public static void postSignInOptionsForAdmin() {
			Scanner postSignInAdminObj = new Scanner(System.in);
			System.out.println();
			System.out.println("1. Add new products \n2. Check available quantity \n3. Back");
			System.out.println("Enter your option : ");
			int option = postSignInAdminObj.nextInt();
			switch(option) {
			case 1:
				Products.addNewProducts();
				break;
			case 2:
				Products.checkQuantity();
				break;
			case 3:
				showOption();
				break;
			default:
				System.out.println("Please enter the valid option...");
				postSignInOptionsForAdmin();
			}
		
		}

		public static void postSignInOptionsForUser() {
			Scanner postSignInUserObj = new Scanner(System.in);
			System.out.println();
			System.out.println("1. Shop now \n2. View wishlist \n3. View cart \n4. My orders \n5. Back");
			System.out.println("Enter your option : ");
			int option = postSignInUserObj.nextInt();
			switch(option) {
			case 1:
				Shopping.shopNow();
				break;
			case 2:
				Shopping.viewWishlist(User.getSignedInUser());
				break;
			case 3:
				Shopping.viewCart();
				break;
			case 4:
				Shopping.myOrders();
				break;
			case 5:
				showOption();
				break;
			default:
				System.out.println("Please enter the valid option...");
				postSignInOptionsForUser();
			}
		}
		
		public static void main(String [] args) {
			Products.addDefaultProducts();
			System.out.println("Welcome to TKL Shop!...");
			showOption();
		}
}