import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * FileParser class is used read files and write to files and also
 * it is used to parse lines from which are taken from the files.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
public class FileParser {
    final static Charset ENCODING = StandardCharsets.UTF_8;

    /**
     * Constructor for the class FileParser
     * @throws IOException	if the file cannot be opened or written.
     */
    public FileParser() throws IOException {}
    
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
}
