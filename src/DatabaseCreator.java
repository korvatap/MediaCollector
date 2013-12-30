import java.util.Iterator;

/**
 * DatabaseCreator class creates databases that have been gotten from the filemanager or from the fileparser.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
public class DatabaseCreator {
	
	FileParser fp;
	String line;
	MediaObject musicDb = new MediaObject();
	MediaObject movieDb = new MediaObject();
	MediaObject tvDb = new MediaObject();
	
	
	MediaObject masterDb = new MediaObject();
	
	/**
	 * Constructor for the DatabaseCreator.
	 * @param fp
	 */
	public DatabaseCreator(FileParser fp){
		this.fp = fp;
	}

	/**
	 * Used to create the databases from file.
	 */
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
	
	/**
	 * Creates new database from MediaObject.
	 * 
	 * @param dbFromFile database MediaObject to used.
	 */
	public void createDatabasesNew (MediaObject dbFromFile) {
		if (dbFromFile != null && !dbFromFile.isEmpty()) {
			musicDb = (MediaObject)dbFromFile.getChild(0);
			movieDb = (MediaObject)dbFromFile.getChild(1);
			tvDb = (MediaObject)dbFromFile.getChild(2);

			masterDb.add(musicDb);
			masterDb.add(movieDb);
			masterDb.add(tvDb);
			System.out.println(movieDb.isEmpty());
		}
		else {
			
			musicDb.setTitle("Music");
			masterDb.add(musicDb);
		
			movieDb.setTitle("Movie");
			masterDb.add(movieDb);
			
			tvDb.setTitle("TVSeries");
			masterDb.add(tvDb);
		}
		
	}
	
	/**
	 * Adds a new media to the database.
	 * 
	 * @param line values for creating a new media.
	 */
	public void createDatabase(String line) {
		String[] media = fp.parseWordsFromLine(line);
		switch(media[0]) {
			case "Movie":
				System.out.println("Adding movie named: " + media[1]);
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
	
	/**
	 * calls for the databases print() function.
	 * @see MediaObject
	 */
	public void print() {
		masterDb.print();
	}
	
	/**
	 * Returns the main database.
	 * 
	 * @return main database
	 */
	public MediaObject getDatabases() {
		return masterDb;
	}
	
	// probably not needed anymore, was used for testing
	/**
	 * Used to set database to another database.
	 * 
	 * @param database target database to be set.
	 */
	public void setDatabases(MediaObject database) {
		this.masterDb = database;
	}
	
	/**
	 * Used to find the highest id of media items in the database.
	 * 
	 * @return highest id of media items.
	 */
	public int getHighestId() {
		int highId = 0;
		Iterator<MediaItem> itemIterator = musicDb.getItems().iterator();
		
			while(itemIterator.hasNext()){
				MediaItem tmp = itemIterator.next();
				if (tmp.getId() > highId) {
					highId = tmp.getId();
				}
		    }
			
			itemIterator = movieDb.getItems().iterator();
			
			while(itemIterator.hasNext()){
				MediaItem tmp = itemIterator.next();
				if (tmp.getId() > highId) {
					highId = tmp.getId();
				}
			}
			
			itemIterator = tvDb.getItems().iterator();
			
			while(itemIterator.hasNext()){
				MediaItem tmp = itemIterator.next();
				if (tmp.getId() > highId) {
					highId = tmp.getId();
				}
			}
			
			return highId;
	}
}