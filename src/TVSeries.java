import java.util.ArrayList;


public class TVSeries extends Media{

	String episode;
	String series;

	public TVSeries() {}
	
	public TVSeries(String title, String s, String e, int publishYear, int rating, String genre) {
		super.setTitle(title);
		this.series = s;
		this.episode = e;
		super.setPublishYear(publishYear);
		super.setRating(rating);
		super.setGenre(genre);
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
}
