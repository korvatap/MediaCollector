/**
 * Media class is a super class of Movie, Music, TVSeries.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
public class Media implements MediaItem {

	static final long serialVersionUID = 53L;
	private String title;
	private int publishYear;
	private int rating;
	private String genre;
	private static int id;
	
	/**
	 * Constuctor for class media.
	 */
	public Media() {
		increaseId();
	}
	
	/**
	 * Another constructor for class media.
	 * Can set a title for the object.
	 * 
	 * @param title		title for Media object.
	 */
	public Media(String title){
        this.title = title;
    }
	
	/**
	 * Returns the id of the Media Object.
	 * 
	 * @return id of the object.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Used to increase id by one.
	 */
	public void increaseId() {
		id++;
	}
	
	/**
	 * Used to get the current maximum id.
	 * 
	 * @return current max id.
	 */
	public int getCurrentMaxId() {
		return getId();
	}
	
	/**
	 * Used to set the title of the Media.
	 * 
	 * @param title title to be set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Returns the title of the Media.
	 * 
	 * @return title of the media.
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Used to se the publish year of the media.
	 * 
	 * @param publishYear year to be set.
	 */
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	
	/**
	 * Returns the publish year of the Media.
	 * 
	 * @return publishYear of the media.
	 */
	public int getPublishYear() {
		return this.publishYear;
	}
	
	/**
	 * Used to set the rating of the Media.
	 * 
	 * @param rating value to be set.
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	/**
	 * Returns the rating of the Media.
	 * 
	 * @return rating of the media.
	 */
	public int getRating() {
		return this.rating;
	}
	
	/**
	 * Used to set the genre of the Media.
	 * 
	 * @param genre value to be set.
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	/**
	 * Returns the genre of the Media.
	 * 
	 * @return genre of the media.
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Inherited function not used in Media.
	 * @see MediaObject
	 */
	@Override
	public void add(MediaItem item) {
	}

	/**
	 * Inherited function not used in Media.
	 * @see MediaObject
	 */
	@Override
	public void print() {
	}

	/**
	 * Inherited function not used in Media.
	 * @see Movie
	 * @see Music
	 * @see TVSeries
	 */
	@Override
	public String[] getRow() {
		return null;
	}

	/**
	 * Inherited function not used in Media.
	 * @see MediaObject
	 */
	@Override
	public void deleteObjectById(int id) {
	}
	
	/**
	 * Used to set the id of Media.
	 * 
	 * @param id	id to be set.
	 */
	public static void setId(int id) {
		Media.id = id;
	}

}
