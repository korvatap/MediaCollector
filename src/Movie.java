/**
 * Movie is a subclass of Media. The objects of Movie contain information about a movie.
 * Title, language, publish year, rating, genre can be stored in to the objects.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
public class Movie extends Media {

	static final long serialVersionUID = 53L;
	private String language;
	private int id;
	
	/**
	 * Constructor for class Movie which can store the information about movie
	 * without using any setters.
	 * @param title			title for the album.
	 * @param language		language of the movie
	 * @param publishYear	the year the album was produced.
	 * @param rating		the rating of the album, 1-10.
	 * @param genre			the genre for the album e.x. Rock.
	 */
	public Movie(String title, String language, int publishYear, int rating, String genre) {
		super.increaseId();
		this.id = super.getId();
		super.setTitle(title);
		this.language = language;
		super.setPublishYear(publishYear);
		super.setRating(rating);
		super.setGenre(genre);
	}
	
	/**
	 * Sets the language of the movie.
	 * 
	 * @param language		language to be set.
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	/**
	 * Returns the language movie.
	 * 
	 * @return		language of the movie.
	 */
	public String getLanguage() {
		return language;
	}
	
	/**
	 * Returns the id of the movie.
	 * 
	 * @return		id of the movie.
	 */
	public int getId() {
		return id;
	}
	
	public void print() {
        System.out.println("-------------");
        System.out.println("title: "+getTitle() + ", language: " + getLanguage() + ", PublishYear: " + getPublishYear() + ", Rating: " + getRating() + ", Genre: " + getGenre());
        System.out.println("-------------");
    }
	
	/**
	 * Returns all the values of the Movie as string array.
	 * 
	 * @return		values of movie.
	 */
	public String[] getRow() {
		String [] row = { Integer.toString(getId()), super.getTitle(), language, Integer.toString(super.getPublishYear()), Integer.toString(super.getRating()), super.getGenre() };
		return row;
	}
	
}
