package ser315.eduportal;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

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
