import java.util.ArrayList;


public class Movie extends Media{

	/**
	 * @param args
	 */
	private String language;
	private int id;
	
	public Movie() {}
	
	public Movie(String title, String language, int publishYear, int rating, String genre) {
		super.increaseId();
		this.id = super.getId();
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
	
	public int getId() {
		return id;
	}
	
	public void print() {
        System.out.println("-------------");
        System.out.println("title: "+getTitle() + ", language: " + getLanguage() + ", PublishYear: " + getPublishYear() + ", Rating: " + getRating() + ", Genre: " + getGenre());
        System.out.println("-------------");
    }
	
	public String[] getRow() {
		String [] row = { Integer.toString(getId()), super.getTitle(), language, Integer.toString(super.getPublishYear()), Integer.toString(super.getRating()), super.getGenre() };
		return row;
	}
	
}
