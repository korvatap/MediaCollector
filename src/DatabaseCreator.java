import java.io.IOException;


public class DatabaseCreator {
	
	FileParser fp;
	String line;
	MediaItem musicDb = new MediaObject();
	MediaItem movieDb = new MediaObject();
	MediaItem tvDb = new MediaObject();
	MediaObject masterDb = new MediaObject();
	
	public DatabaseCreator(FileParser fp){
		this.fp = fp;
	}

	public void createDatabases() {
		if(fp.hasNextLine()) {
			line = fp.getLine();
		} else {
			return;
		}
		
		if(line != null) {
			createDatabase(line);
			while(fp.hasNextLine()) {
				line = fp.getLine();
				createDatabase(line);
			}
		}
		
		masterDb.add(musicDb);
		masterDb.add(movieDb);
		masterDb.add(tvDb);
	}
	
	public void createDatabase(String line) {
		String[] media = fp.parseWordsFromLine(line);
		switch(media[0]) {
			case "Movie":
				movieDb.add(new Movie(media[1], media[2], Integer.parseInt(media[3]), Integer.parseInt(media[4]), media[5]));
				break;
				
			case "TVSeries":
				tvDb.add(new TVSeries(media[1], media[2], media[3], Integer.parseInt(media[4]), Integer.parseInt(media[5]), media[6]));
				break;
				
			case "Music":
				musicDb.add(new Music(media[1], media[2], Integer.parseInt(media[3]), Integer.parseInt(media[4]), media[5]));
				break;
		}

	}
	
	public void print() {
		masterDb.print();
	}
	
}