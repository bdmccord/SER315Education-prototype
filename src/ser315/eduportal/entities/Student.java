package ser315.eduportal.entities;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class Student extends User {

private List<Course> enrolledCourses;
	
	public Student(BigInteger id, String firstName, String lastName, String emailAddress) {
		super(id, firstName, lastName, emailAddress);
		this.enrolledCourses = new LinkedList<Course>();
	}
	
	public Student(BigInteger id, String firstName, String lastName, String emailAddress, List<Course> enrolledCourses) {
		super(id, firstName, lastName, emailAddress);
		this.enrolledCourses = enrolledCourses;
	}
	
	
	/**
	 * @return the enrolledCourses
	 */
	public List<Course> getEnrolledCourses() {
		return enrolledCourses;
	}
	/**
	 * @param enrolledCourses the enrolledCourses to set
	 */
	public void setEnrolledCourses(List<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	
	public void addCourse(Course course){
		enrolledCourses.add(course);
	}
	
	public Course getCourse(int index){
		if(index > enrolledCourses.size() || index < 0){
			return null;
		}
		return enrolledCourses.get(index);
	}
	
	public String toString(){
		return super.toString() + ", Enrolled Courses: " + enrolledCourses; 
	}

}
