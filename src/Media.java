import java.util.ArrayList;


public class Media implements MediaItem {


	private String title;
	private int publishYear;
	private int rating;
	private String genre;
	private static int id;
	private int mid;
	public Media() {
		increaseId();
		mid = getId();
	}
	
	public Media(String title){
        this.title = title;
    }
	
	public int getId() {
		return id;
	}
	
	public void increaseId() {
		id++;
	}
	
	public void setTitle(String t) {
		this.title = t;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setPublishYear(int p) {
		this.publishYear = p;
	}
	
	public int getPublishYear() {
		return this.publishYear;
	}
	
	public void setRating(int r) {
		this.rating = r;
	}
	
	public int getRating() {
		return this.rating;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getGenre() {
		return genre;
	}
	

	@Override
	public void add(MediaItem item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	// NOT NEEDED SINCE SUPER CLASS CAN BE LEFT AS STUB
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getRow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteObjectById(int id) {
		// TODO Auto-generated method stub
		
	}
}
