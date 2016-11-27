package ser315.eduportal.entities;

import java.math.BigInteger;

import org.joda.time.DateTime;

public class Video {
	
	private BigInteger id;
	private String videoPath;
	private DateTime uploadDate;
	private String videoName;
	
	public Video(BigInteger id, String videoName, String videoPath, DateTime uploadDate) {
		this.id = id;
		this.videoName = videoName;
		this.videoPath = videoPath;
		this.uploadDate = uploadDate;
	}

	
	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}


	
	/**
	 * @return the videoName
	 */
	public String getVideoName() {
		return videoName;
	}


	/**
	 * @param videoName the videoName to set
	 */
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}


	/**
	 * @return the videoPath
	 */
	public String getVideoPath() {
		return videoPath;
	}

	/**
	 * @param videoPath the videoPath to set
	 */
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}


	/**
	 * @return the uploadDate
	 */
	public DateTime getUploadDate() {
		return uploadDate;
	}

	/**
	 * @param uploadDate the uploadDate to set
	 */
	public void setUploadDate(DateTime uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	public String toString(){
		return "ID " + id + ", Video Name: " + videoName + " Video Path : " + videoPath + ", Upload Date: " + uploadDate; 
	}
}
