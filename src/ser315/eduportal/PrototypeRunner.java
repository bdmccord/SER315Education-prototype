package ser315.eduportal;

import java.util.Scanner;

import ser315.eduportal.entities.User;


public class PrototypeRunner {

	boolean loggedIn = false;
	User currentUser = null;
	
	public PrototypeRunner(){
		displayMainInterface();
	}
	
	private void displayMainInterface(){
		if(!loggedIn){
			displayLoginInterface();
		}
	}
	
	private void displayLoginInterface(){
		
	}	

	
	private String promptUser(String message){
		System.out.print(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
}
