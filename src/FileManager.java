import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * FileManager class store database to a file and to read it from the file.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
public class FileManager {
	private FileOutputStream saveFile;
	private FileInputStream readSaveFile;
	private ObjectInputStream readSave;
	private ObjectOutputStream save;
	private File dbFile;
	
	/**
	 * Constructor for class FileManager.
	 */
	FileManager() {
		try {
			dbFile = new File("SaveObj.sav");
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	/**
	 * Used to read the file and get a MediaObject from it.
	 * 
	 * @return MediaObject gotten from file or null if does not exist.
	 */
	public MediaObject readFile() {
		try {
			if(!dbFile.exists()) {
				return null;
			}
			readSaveFile = new FileInputStream(dbFile);
			readSave = new ObjectInputStream(readSaveFile);
			return (MediaObject) readSave.readObject();
			
		} catch (EOFException eof) {
			System.out.println("File is empty or not readable");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        finally {
            try {
                if (readSave != null) {
                    readSave.close();
                }
            }
            catch(Exception e) {
                e.printStackTrace();   
            }
        }  
		
		return null;
	}
	
	/**
	 * Used to write MediaObject to file which
	 * is usually a database of MediaItems.
	 * 
	 * @param db target MediaObject to be written.
	 */
	public void writeToFile(MediaObject db) {
		try {
			if(!dbFile.exists()) {
				dbFile.createNewFile();
			}
			
			saveFile = new FileOutputStream(dbFile);
			save = new ObjectOutputStream(saveFile);
			
			save.writeObject(db);
		} catch (Exception e) {
			e.printStackTrace();
		}
        finally {
            try {
                if (save != null) {
                    save.flush();
                    save.close();
                }
            }
            catch(Exception e) {
            	e.printStackTrace();   
            }
        }
	}
	
}
	
