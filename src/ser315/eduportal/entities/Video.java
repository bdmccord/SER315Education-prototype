package ser315.eduportal.entities;

import java.math.BigInteger;

import org.joda.time.DateTime;

public class Video {
	
	private BigInteger id;
	private String videoPath;
	private Teacher uploader;
	private DateTime uploadDate;
	
	public Video(BigInteger id, String videoPath, Teacher uploader, DateTime uploadDate) {
		this.id = id;
		this.videoPath = videoPath;
		this.uploader = uploader;
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
	 * @return the uploader
	 */
	public Teacher getUploader() {
		return uploader;
	}

	/**
	 * @param uploader the uploader to set
	 */
	public void setUploader(Teacher uploader) {
		this.uploader = uploader;
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
		return "ID " + id + " Video Path : " + videoPath + "\nUploader: " + uploader + "\nUpload Date: " + uploadDate; 
	}
}
