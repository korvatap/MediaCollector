/**
 * Music is a subclass of Media. The objects of Music contain information about a Music record.
 * Title, artist, publish year, rating, genre can be stored in to the objects.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
public class Music extends Media {
	
	static final long serialVersionUID = 53L;
	String artist;
	private int id;

	/**
	 * Constructor for class Music which can store the information about TV series
	 * without using any setters.
	 * @param title			title for the album.
	 * @param artist		name of the artist.
	 * @param publishYear	the year the album was produced.
	 * @param rating		the rating of the album, 1-10.
	 * @param genre			the genre for the album e.x. Rock.
	 */
	public Music(String title, String artist, int publishYear, int rating, String genre) {
		super.increaseId();
		this.id = super.getId();
		super.setTitle(title);
		this.artist = artist;
		super.setPublishYear(publishYear);
		super.setRating(rating);
		super.setGenre(genre);
	}
	
	/**
	 * Sets the name of the artist.
	 * 
	 * @param artist	name to be set.
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	/**
	 * Returns the artist name.
	 * 
	 * @return		name of the artist.
	 */
	public String getArtist() {
		return this.artist;
	}
	
	/**
	 * Returns the id of the music object.
	 * 
	 * @return		id of the music object.
	 */
	public int getId() {
		return id;
	}
	
	public void print() {
        System.out.println("-------------");
        System.out.println("title: " + getTitle() + ", artist: " + getArtist() + ", PublishYear: " + getPublishYear() + ", Rating: " + getRating() + ", Genre: " + getGenre());
        System.out.println("-------------");
    }
	
	/**
	 * Returns all the values of the Music as string array.
	 * 
	 * @return		values of music.
	 */
	public String[] getRow() {
		String [] row = { Integer.toString(getId()), super.getTitle(), artist, Integer.toString(super.getPublishYear()), Integer.toString(super.getRating()), super.getGenre() };
		return row;
	}
}
