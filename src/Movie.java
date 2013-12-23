import java.util.ArrayList;


public class Movie extends Media{

	/**
	 * @param args
	 */
	private String language;

	public Movie() {}
	
	public Movie(String title, String l, int publishYear, int rating, String genre) {
		super.setTitle(title);
		this.language = l;
		super.setPublishYear(publishYear);
		super.setRating(rating);
		super.setGenre(genre);
	}
	
	public void setLanguage(String l) {
		this.language = l;
	}
	
	public String getLanguage(int loc) {
		return language;
	}
	
	
}
