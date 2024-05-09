package com.Shopping;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
	private String name;
	private String password;
	private String address;
	private long mobileNumber;

	private static String signedInUser;
	private static String signedInUserAddress;
	
	public static String getSignedInUser() {
		return signedInUser;
	}
	
	public static String getSignedInUserAddress() {
		return signedInUserAddress;
	}
	
	public static void setAddress(String address) {
		User userObj = userMap.get(getSignedInUser());
		userObj.address = address;
		userMap.put(getSignedInUser(), userObj);
	}

	
	private static Map<String,User> userMap = new HashMap<String, User>();
	
	private User(String userName, String userPassword, String userAddress, long userMobileNumber){
		this.name = userName;
		this.password = userPassword;
		this.address = userAddress;
		this.mobileNumber = userMobileNumber;
	}
	public static void signUp() {
		Scanner accObj = new Scanner(System.in);
		System.out.println("Enter your name : ");
		String userName = accObj.nextLine();
		System.out.println("Enter your password(Must be atleast 8 characters) : ");
		String userPassword = accObj.nextLine();
		System.out.println("Confirm your password : ");
		String reEnterPassword = accObj.nextLine();
		System.out.println("Enter your address : ");
		String userAddress = accObj.nextLine();
		System.out.println("Enter your mobile number : ");
		long userMobileNumber = accObj.nextLong();
		
		
		
		if(Long.toString(userMobileNumber).length()==10 && userPassword.equals(reEnterPassword) && userPassword.length()>=8) {
			User userObj = new User(userName, userPassword, userAddress, userMobileNumber);
			userMap.put(userName, userObj);
			System.out.println("Account created successfully!... ");
			Main.showOption();
		}
		else {
			System.out.println("Please enter valid details...");
			signUp();
		}
		

	}
	public static void signIn() {
		Scanner signInObj = new Scanner(System.in);
		System.out.println("Enter your Username : ");
		String signInName = signInObj.nextLine();
		System.out.println("Enter your password : ");
		String signInPassword = signInObj.nextLine();
		User usersignInObj = userMap.get(signInName);
		if("Admin".equals(signInName)){
			if("Keerthi27".equals(signInPassword)) {
				System.out.println("Signed in successfully!...");
				Main.postSignInOptionsForAdmin();
			}
			else {
				System.out.println("Please enter valid username or password...");
				Main.showOption();
			}
		}
		else if(usersignInObj==null) {
			System.out.println("Please enter valid username or password...");
			Main.showOption();
		} 
		else {
			if(signInPassword.equals(usersignInObj.password)){
				System.out.println("Signed in successfully!...");
				Main.postSignInOptionsForUser();
			}
			else {
				System.out.println("Please enter valid username or password...");
				Main.showOption();
			}
		}

	}

	

}
