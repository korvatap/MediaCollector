
public class Music extends Media {
	
	String artist;


	public Music() {}
	
	public Music(String title, String a, int publishYear, int rating, String genre) {
		super.setTitle(title);
		this.artist = a;
		super.setPublishYear(publishYear);
		super.setRating(rating);
		super.setGenre(genre);
	}
	
	public void setArtist(String a) {
		this.artist = a;
	}
	
	public String getArtist() {
		return this.artist;
	}
}
