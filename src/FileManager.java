import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileManager {
	private FileOutputStream saveFile;
	private FileInputStream readSaveFile;
	private ObjectInputStream readSave;
	private ObjectOutputStream save;
	private File dbFile;
	
	FileManager() {
		try {
			dbFile = new File("SaveObj.sav");
			/*if (dbFile.isFile()) {
				readSaveFile = new FileInputStream(dbFile);
				readSave = new ObjectInputStream(readSaveFile);
			}
			else {
				dbFile.createNewFile();
				readSaveFile = new FileInputStream(dbFile);
				readSave = new ObjectInputStream(readSaveFile);
			}*/
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public MediaObject readFile() {
		//File dbFile = new File("SaveObj.sav");
		try {
			if(!dbFile.exists()) {
				return null;
			}
			//readSaveFile = new FileInputStream("SaveObj.sav");
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
	
	public void writeToFile(MediaObject db) {
		//File dbFile = new File("SaveObj.sav");
		try {
			if(!dbFile.exists()) {
				dbFile.createNewFile();
			}
			//saveFile = new FileOutputStream("SaveObj.sav");
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
	
