import java.io.IOException;


public class DatabaseCreator {
	
	FileParser fp = new FileParser();
	
	public DatabaseCreator() throws IOException {}
	
	public void createDatabases() {
		String line = fp.getLine();
		if(line != null) {
			createDatabase(line);
			while(fp.hasNextLine()) {
				createDatabase(line);
			}
		}
	}
	
	public void createDatabase(String line) {
		
	}
	
}