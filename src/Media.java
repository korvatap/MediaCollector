import java.util.ArrayList;


public class Media implements MediaItem {

	/**
	 * @param args
	 */
	private String title;
	private int publishYear;
	private int rating;
	private ArrayList<String> genre = new ArrayList<String>();
	
	public Media() {
		
	}
	
	public Media(String title){
        this.title = title;
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
	
	public void addGenre(String genre) {
		this.genre.add(genre);
	}
	
	public void addGenres(ArrayList<String> g) {
		this.genre = g;
	}
	
	public ArrayList<String> getGenres() {
		return genre;
	}
	
	public String getGenre(int loc) {
	   return genre.get(loc);
	}
	
	public void print() {
        System.out.println("-------------");
        System.out.println("Name ="+getTitle());
        System.out.println("-------------");
    }

	@Override
	public void add(MediaItem item) {
		// TODO Auto-generated method stub
		
	}
}
