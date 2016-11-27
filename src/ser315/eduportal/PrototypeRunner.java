package ser315.eduportal;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import ser315.eduportal.entities.Student;
import ser315.eduportal.entities.Teacher;
import ser315.eduportal.entities.User;


public class PrototypeRunner {

	boolean loggedIn = false;
	List<User> users = null;
	User currentUser = null;
	
	public PrototypeRunner(){
		initializeActors();
		displayMainInterface();
	}
	
	public void initializeActors(){
		users = new LinkedList<User>();
		User studentActor = new Student(BigInteger.valueOf(0), "Joe", "Bob", "joebob@gmail.com");
		User teacherActor = new Teacher(BigInteger.valueOf(1), "Marie", "Antoinette", "maryann@gmail.com");
		users.add(studentActor);
		users.add(teacherActor);
	}
	
	private void displayMainInterface(){
		if(!loggedIn){
			displayLoginInterface();
		}
		else{
			if(currentUser instanceof Student){
				displayStudentInterface();
			}
			else{
				displayTeacherInterface();
			}
		}
	}
	
	private void displayLoginInterface(){
		String response = promptUser("Login (There are only two users, use joebob@gmail.com for student user maryann@gmail.com for teacher): ");
		for(User user : users){
			System.out.println(user.getEmailAddress());
			if(response.equalsIgnoreCase(user.getEmailAddress())){
				currentUser = user;
				loggedIn = true;
				System.out.println("Logged in as " + user.getFullName());
				break;
			}
		}
		if(loggedIn){
			displayMainInterface();
		}
		else{
			displayLoginInterface();
		}
	}	

	public void displayStudentInterface(){
		Student currentStudent = (Student) currentUser;
		System.out.println(currentStudent);
	}
	
	public void displayTeacherInterface(){
		Teacher currentTeacher = (Teacher) currentUser;
		System.out.println(currentTeacher);
	}
	
	private String promptUser(String message){
		System.out.print(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
}
