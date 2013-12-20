import java.util.ArrayList;


public class Movie extends Media{

	/**
	 * @param args
	 */
	private ArrayList<String> language;

	public Movie() {}
	
	public void addLanguage(String l) {
		this.language.add(l);
	}
	
	public void addLanguages(ArrayList<String> la) {
		this.language = la;
	}
	
	public String getLanguage(int loc) {
		return language.get(loc);
	}
	
	public ArrayList<String> getLanguages() {
		return language;
	}
	
}
