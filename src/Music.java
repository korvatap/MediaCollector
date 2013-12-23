
public class Music extends Media {
	
	String artist;


	public Music() {}
	
	public Music(String title, String artist, int publishYear, int rating, String genre) {
		super.setTitle(title);
		this.artist = artist;
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
	
	public void print() {
        System.out.println("-------------");
        System.out.println("title: " + getTitle() + ", artist: " + getArtist() + ", PublishYear: " + getPublishYear() + ", Rating: " + getRating() + ", Genre: " + getGenre());
        System.out.println("-------------");
    }
}
