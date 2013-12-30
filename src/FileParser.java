import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * FileParser class is used read files and write to files and also
 * it is used to parse lines from which are taken from the files.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
public class FileParser {
	String workingDir = System.getProperty("user.dir");
	String database = workingDir + "/src/Database/database.txt";
	Path path = Paths.get(database);
    Scanner scanner = new Scanner(path, ENCODING.name());
    final static Charset ENCODING = StandardCharsets.UTF_8;

    /**
     * Constructor for the class FileParser
     * @throws IOException	if the file cannot be opened or written.
     */
    public FileParser() throws IOException {}
    
    /**
     * Prints out all the lines from the file.
     */
    public void readFile() {
        //read file line by line
    	//testing
        while(scanner.hasNextLine()){
            System.out.println("Lines: "+scanner.nextLine());
        }
    }
    
    /**
     * Write a line to the file.
     * 
     * @param line text to be added.
     */
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
    
    /**
     * Parses a word from line using delimiter ",".
     * 
     * @param 	line target line to parse.
     * @return	parsed words from the line.
     */
    public String[] parseWordsFromLine(String line) {
    	String delims = "[,]";
    	String[] tokens = line.split(delims);
    
    	return tokens;
    }
    
    /**
     * Prints words that have been parsed from the line.
     */
    public void printWords() {
    	String[] tmp = parseWordsFromLine(scanner.nextLine());
    	for(int i=0; i<tmp.length; i++) {
    		System.out.println(tmp[i]);
    	}
    }
    
    /**
     * Returns a next line from the scanner if any.
     * @return next line if not null, else null.
     */
    public String getLine() {
    	if(scanner.hasNextLine()) {
    		return scanner.nextLine();
    	} else {
    		return null;
    	}
    }
    
    /**
     * Returns if the scanner has next line.
     * 
     * @return true if has, else false.
     */
    public boolean hasNextLine() {
    	if(scanner.hasNextLine()) {
    		return true;
    	} else {
    		return false;
    	}
    }
     
}
