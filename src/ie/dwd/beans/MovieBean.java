package ie.dwd.beans;

import java.io.Serializable;

public class MovieBean implements Serializable,  Comparable<MovieBean>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int movieid;
	private String title;
	private String certification;
	private int rating;
	
	
	public MovieBean() {}
	

	public int getMovieid() {
		return 	movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = 	movieid;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
		
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	public MovieBean (int movieid,  String title ,String certification, int rating){
		this.movieid = 	movieid;
		this.title = title;
		this.certification = certification;
		this.rating = rating;
		
		
		
	}
	
	public String toString() {
		return "MovieBean [Rating=" + rating + ", title=" + title + " Certification" + certification + "]";
	}


	@Override
	public int compareTo(MovieBean moviebean) {
		// TODO Auto-generated method stub
		 return getRating() - moviebean.getRating();
	}


}
