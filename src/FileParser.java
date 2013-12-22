import java.io.IOException;
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
     
}
