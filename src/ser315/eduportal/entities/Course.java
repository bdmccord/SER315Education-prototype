package ser315.eduportal.entities;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class Course {
	private BigInteger id;
	private List<Video> courseVideos;
	private String courseName;

	
	public Course(BigInteger id, String courseName) {
		this.id = id;
		this.courseName = courseName;
		this.courseVideos = new LinkedList<Video>();
	}
	
	/**
	 * @return the courseVideos
	 */
	public List<Video> getCourseVideos() {
		return courseVideos;
	}
	/**
	 * @param courseVideos the courseVideos to set
	 */
	public void setCourseVideos(List<Video> courseVideos) {
		this.courseVideos = courseVideos;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @param video the video to add to the course video list
	 */
	public void addVideo(Video video){
		courseVideos.add(video);
	}
	
	public Video getVideo(int index){
		if(index > courseVideos.size() || index < 0){
			return null;
		}
		return courseVideos.get(index);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ID " + id + ", Course name: " + courseName + ", Course Videos: " + courseVideos;
	}
	
	
}
