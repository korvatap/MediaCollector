/**
 * TVSeries is a subclass of Media. The objects of TVSeries contain information about a TV Series.
 * Title, series, episode, publish year, rating, genre can be stored in to the objects.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */

public class TVSeries extends Media {

	static final long serialVersionUID = 53L;
	String episode;
	String season;
	private int id;
	
	/**
	 * Constructor for TVSeries class which can store the information about TV series
	 * without using any setters.
	 * 
	 * @param title		title for the tv series.
	 * @param season 	season name for the series or a number.
	 * @param episode 	name of the episode or a number.
	 * @param publishYear the year the current episode was produced.
	 * @param rating 	the rating of the episode, 1-10.
	 * @param genre 	the genre for the tv series e.x. Action.
	 */
	public TVSeries(String title, String season, String episode, int publishYear, int rating, String genre) {
		super.increaseId();
		this.id = super.getId();
		super.setTitle(title);
		this.season = season;
		this.episode = episode;
		super.setPublishYear(publishYear);
		super.setRating(rating);
		super.setGenre(genre);
	}
	
	/**
	 * Returns id of the created object.
	 * 
	 * @return id	id of the current object.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the episode name to the wanted value.
	 * 	
	 * @param e		value to set as episode name.
	 */
	public void setEpisode(String episode) {
		this.episode = episode;
	}
	
	/**
	 * Returns the name of the episode.
	 * 
	 * @return		name of the episode.
	 */
	public String getEpisode() {
		return this.episode;
	}
	
	/**
	 * Sets the name of the season.
	 * 
	 * @param s		value to be set as name of the season.
	 */
	public void setSeason(String season) {
		this.season = season;
	}
	
	/**
	 * Returns the name of the season.
	 * 
	 * @return		name of the season.
	 */
	public String getSeason() {
		return season;
	}
	
	public void print() {
        System.out.println("-------------");
        System.out.println("title: " + getTitle() + ", Series: " + getSeason() + ", Episode: " + getEpisode() +  ", PublishYear: " + getPublishYear() + ", Rating: " + getRating() + ", Genre: " + getGenre());
        System.out.println("-------------");
    }
	
	/**
	 * Returns all the values of the TV Series as string array.
	 * 
	 * @return		values of tv series.
	 */
	public String[] getRow() {
		String [] row = { Integer.toString(getId()), super.getTitle(), season, episode, Integer.toString(super.getPublishYear()), Integer.toString(super.getRating()), super.getGenre() };
		return row;
	}
}
