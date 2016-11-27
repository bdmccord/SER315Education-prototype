package ser315.eduportal;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.joda.time.DateTime;

import ser315.eduportal.entities.Course;
import ser315.eduportal.entities.Student;
import ser315.eduportal.entities.Teacher;
import ser315.eduportal.entities.User;
import ser315.eduportal.entities.Video;


public class PrototypeRunner {

	private boolean loggedIn = false;
	private List<User> users = null;
	private List<Course> courses = null;
	private User currentUser = null;
	
	// these are merely used to simulate a database auto incrementing id's they are not really necessary
	private BigInteger nextCourseId = BigInteger.valueOf(0);
	private BigInteger nextUserId = BigInteger.valueOf(0);
	private BigInteger nextVideoId = BigInteger.valueOf(0);
	
	public PrototypeRunner(){
		initializeActors();
		displayMainInterface();
	}
	
	// set up prototype environment actors
	public void initializeActors(){
		users = new LinkedList<User>();
		User studentActor = new Student(getNextUserId(), "Joe", "Bob", "joebob@gmail.com");
		User teacherActor = new Teacher(getNextUserId(), "Marie", "Antoinette", "maryann@gmail.com");
		Course courseOne = new Course(getNextCourseId(), "C++ Basics");
		Teacher teacher = (Teacher)teacherActor;
		teacher.addCourse(courseOne);
		Video videoOne = new Video(getNextVideoId(),"videos/videoOne.mp4", DateTime.now());
		courseOne.addVideo(videoOne);
		users.add(studentActor);
		users.add(teacherActor);
	}
	
	// mainly routes users to other user interface methods
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
	
	// place holder to allow switching between the actors that were created upon initialization
	private void displayLoginInterface(){
		String response = promptUser("Login (There are only two users, use joebob@gmail.com for student user maryann@gmail.com for teacher): ");
		for(User user : users){
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
			System.out.println("Invalid Login (choose joebob@gmail.com or maryann@gmail.com)");
			displayLoginInterface();
		}
	}	
	
	private void logout(){
		loggedIn = false;
		currentUser = null;
		displayLoginInterface();
	}
	
	public void displayStudentInterface(){
		Student currentStudent = (Student) currentUser;
		System.out.println("------User Interface------");
	}
	
	public void displayTeacherInterface(){
		Teacher currentTeacher = (Teacher) currentUser;
		System.out.println("------Teacher Interface------");
		String response = promptUser("Choose an option:\n(1) View Courses List\n(2) Add a Video\n(logout) To Logout\nOption: ");
		if(checkForLogout(response)){
			logout();
		}
		else if(response.equalsIgnoreCase("1")){
			System.out.println("------Courses That You Teach------");
			for(Course course : currentTeacher.getCoursesTaught()){
				System.out.println(course);
				displayTeacherInterface();
			}
		}
		else if(response.equalsIgnoreCase("2")){
			displayAddVideoInterface();
		}
		else{
			displayTeacherInterface();
		}
	}
	
	private void displayAddVideoInterface(){
		Teacher currentTeacher = (Teacher) currentUser;
		Course courseToAddTo = null;
		String videoPath = "";
		while(courseToAddTo == null){
			StringBuilder sb = new StringBuilder("Choose a course:\n");
			int currentOption = 1;
			for(Course course : currentTeacher.getCoursesTaught()){
				sb.append("(" + currentOption + ") " + course.getCourseName() + "\n");
			}
			sb.append("Option: ");
			String response = promptUser(sb.toString());
			try{
				int index = Integer.parseInt(response) - 1;
				courseToAddTo = currentTeacher.getCourse(index);
				if(courseToAddTo == null){
					System.out.println("Not a valid option.");
				}
			}catch(NumberFormatException ex){
				System.out.println("Please enter a number.");
			}
		}
		videoPath = promptUser("Please enter the path to the video: ");
		Video videoToAdd = new Video(getNextVideoId(), videoPath, DateTime.now());
		courseToAddTo.addVideo(videoToAdd);
		System.out.println("Successfully added " + videoToAdd);
		displayTeacherInterface();
		
	}
	
	private String promptUser(String message){
		System.out.print(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	private boolean checkForLogout(String message){
		return message.equalsIgnoreCase("logout");
	}
	
	private BigInteger getNextCourseId(){
		BigInteger value = nextCourseId;
		nextCourseId = nextCourseId.add(BigInteger.valueOf(1));
		return value;
	}
	
	private BigInteger getNextUserId(){
		BigInteger value = nextUserId;
		nextUserId = nextUserId.add(BigInteger.valueOf(1));
		return value;
	}
	
	private BigInteger getNextVideoId(){
		BigInteger value = nextVideoId;
		nextVideoId = nextVideoId.add(BigInteger.valueOf(1));
		return value;
	}
}
