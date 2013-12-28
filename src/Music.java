
public class Music extends Media {
	
	String artist;
	private int id;

	public Music() {}
	
	public Music(String title, String artist, int publishYear, int rating, String genre) {
		super.increaseId();
		this.id = super.getId();
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
	
	public int getId() {
		return id;
	}
	
	public void print() {
        System.out.println("-------------");
        System.out.println("title: " + getTitle() + ", artist: " + getArtist() + ", PublishYear: " + getPublishYear() + ", Rating: " + getRating() + ", Genre: " + getGenre());
        System.out.println("-------------");
    }
	
	public String[] getRow() {
		String [] row = { Integer.toString(getId()), super.getTitle(), artist, Integer.toString(super.getPublishYear()), Integer.toString(super.getRating()), super.getGenre() };
		return row;
	}
}
