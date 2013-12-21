import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileParser {
	String database = "Database/database.txt";
	Path path = Paths.get(database);
    Scanner scanner = new Scanner(path, ENCODING.name());
    final static Charset ENCODING = StandardCharsets.UTF_8;
    

    public FileParser() throws IOException {}
    
    public void readFile() {
        //read file line by line
        while(scanner.hasNext()){
            System.out.println("Lines: "+scanner.next());
        }
        
    }
    
    public String[] parseWordsFromLine(String line) {
    	String delims = "[,]";
    	String[] tokens = line.split(delims);
    
    	return tokens;
    }
     
}
