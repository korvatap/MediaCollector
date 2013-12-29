import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileManager {
	FileOutputStream saveFile;
	FileInputStream readSaveFile;
	ObjectInputStream readSave;
	ObjectOutputStream save;
	
	FileManager() {
		try {
			readSaveFile = new FileInputStream("SaveObj.sav");
			readSave = new ObjectInputStream(readSaveFile);
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public MediaObject readFile() {
		File dbFile = new File("SaveObj.sav");
		try {
			if(!dbFile.exists()) {
				return null;
			}
			readSaveFile = new FileInputStream("SaveObj.sav");
			readSave = new ObjectInputStream(readSaveFile);
			return (MediaObject) readSave.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void writeToFile(MediaObject db) {
		File dbFile = new File("SaveObj.sav");
		try {
			if(!dbFile.exists()) {
				dbFile.createNewFile();
			}
			saveFile = new FileOutputStream("SaveObj.sav");
			save = new ObjectOutputStream(saveFile);
			
			save.writeObject(db);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
	
