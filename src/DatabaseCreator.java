import java.io.IOException;


public class DatabaseCreator {
	
	FileParser fp;
	String line;
	MediaObject musicDb = new MediaObject();
	MediaObject movieDb = new MediaObject();
	MediaObject tvDb = new MediaObject();
	
	
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
		
		System.out.println(musicDb.isEmpty());
		if(!musicDb.isEmpty()) {
			musicDb.setTitle("Music");
			masterDb.add(musicDb);
		}
		if(!movieDb.isEmpty()) {
			movieDb.setTitle("Movie");
			masterDb.add(movieDb);
		}
		if(!tvDb.isEmpty()) {
			tvDb.setTitle("TVSeries");
			masterDb.add(tvDb);
		}
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
	
	public MediaObject getDatabases() {
		return masterDb;
	}
}