import java.util.ArrayList;


public class Movie extends Media{

	/**
	 * @param args
	 */
	private String language;

	public Movie() {}
	
	public Movie(String title, String language, int publishYear, int rating, String genre) {
		super.setTitle(title);
		this.language = language;
		super.setPublishYear(publishYear);
		super.setRating(rating);
		super.setGenre(genre);
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void print() {
        System.out.println("-------------");
        System.out.println("title: "+getTitle() + ", language: " + getLanguage() + ", PublishYear: " + getPublishYear() + ", Rating: " + getRating() + ", Genre: " + getGenre());
        System.out.println("-------------");
    }
	
	
}
