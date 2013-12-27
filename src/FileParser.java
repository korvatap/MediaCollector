import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileParser {
	String workingDir = System.getProperty("user.dir");
	String database = workingDir + "/src/Database/database.txt";
	Path path = Paths.get(database);
    Scanner scanner = new Scanner(path, ENCODING.name());
    final static Charset ENCODING = StandardCharsets.UTF_8;

    public FileParser() throws IOException {}
    
    public void readFile() {
        //read file line by line
    	//testing
        while(scanner.hasNextLine()){
            System.out.println("Lines: "+scanner.nextLine());
        }
    }
    
    public void writeToFile(String line) {
    	PrintWriter writer = null;
    	try {
			writer = new PrintWriter(database, "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	writer.println(line);
    }
    
    public String[] parseWordsFromLine(String line) {
    	String delims = "[,]";
    	String[] tokens = line.split(delims);
    
    	return tokens;
    }
    
    public void printWords() {
    	String[] tmp = parseWordsFromLine(scanner.nextLine());
    	for(int i=0; i<tmp.length; i++) {
    		System.out.println(tmp[i]);
    	}
    
    
    }
    
    public String getLine() {
    	if(scanner.hasNextLine()) {
    		return scanner.nextLine();
    	} else {
    		return null;
    	}
    }
    
    public boolean hasNextLine() {
    	if(scanner.hasNextLine()) {
    		return true;
    	} else {
    		return false;
    	}
    }
     
}
