package ser315.eduportal.entities;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class Teacher extends User{

	private List<Course> coursesTaught;
	
	public Teacher(BigInteger id, String firstName, String lastName, String emailAddress) {
		super(id, firstName, lastName, emailAddress);
		this.coursesTaught = new LinkedList<Course>();
	}
	
	public Teacher(BigInteger id, String firstName, String lastName, String emailAddress, List<Course> coursesTaught) {
		super(id, firstName, lastName, emailAddress);
		this.coursesTaught = new LinkedList<Course>();
	}
	
	/**
	 * @return the coursesTaught
	 */
	public List<Course> getCoursesTaught() {
		return coursesTaught;
	}
	/**
	 * @param coursesTaught the coursesTaught to set
	 */
	public void setCoursesTaught(List<Course> coursesTaught) {
		this.coursesTaught = coursesTaught;
	}
	
	public void addCourse(Course course){
		coursesTaught.add(course);
	}
	
	public Course getCourse(int index){
		return coursesTaught.get(index);
	}
	
	public String toString(){
		StringBuilder coursesListString = new StringBuilder();
		for(Course course : coursesTaught){
			coursesListString.append("\n" + course);
		}
		return super.toString() + "\nCourses Taught:" + coursesListString; 
	}
}
