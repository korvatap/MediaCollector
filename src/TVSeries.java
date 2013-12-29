import java.util.ArrayList;


public class TVSeries extends Media{

	static final long serialVersionUID = 53L;
	String episode;
	String series;
	private int id;

	public TVSeries() {}
	
	public TVSeries(String title, String series, String episode, int publishYear, int rating, String genre) {
		super.increaseId();
		this.id = super.getId();
		super.setTitle(title);
		this.series = series;
		this.episode = episode;
		super.setPublishYear(publishYear);
		super.setRating(rating);
		super.setGenre(genre);
	}
	
	public int getId() {
		return id;
	}
	
	public void setEpisode(String e) {
		this.episode = e;
	}
	
	public String getEpisode() {
		return this.episode;
	}
	
	public void setSeries(String s) {
		this.series = s;
	}
	
	public String getSeries() {
		return series;
	}
	
	public void print() {
        System.out.println("-------------");
        System.out.println("title: " + getTitle() + ", Series: " + getSeries() + ", Episode: " + getEpisode() +  ", PublishYear: " + getPublishYear() + ", Rating: " + getRating() + ", Genre: " + getGenre());
        System.out.println("-------------");
    }
	
	public String[] getRow() {
		String [] row = { Integer.toString(getId()), super.getTitle(), series, episode, Integer.toString(super.getPublishYear()), Integer.toString(super.getRating()), super.getGenre() };
		return row;
	}
}
