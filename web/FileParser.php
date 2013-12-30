<?php
//singleton pattern?

/**
 * FileParser class is used read files and write to files.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
class FileParser {
    
    /*private $lineCount = 0;
    private $linesRead = 0;
    private $lines = array();*/
    
    //private $path = "Database/database.txt";
    private $dbPath = "Database/database.dat";
    
    /**
     * Constructor for the FileParser.
     */
    public function __construct() {
        //$this->lines = $this->readFromFile();
    }
    /*public function readFromFile() {
        if (file_exists($this->path)) {
            $lines = file($this->path);
            
            $this->lineCount = count($lines);
            $this->linesRead = 0;
            
            //return $lines;
            $this->lines = $lines;
        }
    }*/
    
    /**
     * Serializes and writes MediaObject to file, which
     * is a database of MediaItems.
     * 
     * @param db        target MediaObject to be saved.
     */
    public function writeToFile($db) {
        $serializedDb = serialize($db);
        /*if (!file_exists($this->dbPath)) {
            touch($this->dbPath);
        }*/
        if (is_writable($this->dbPath)) {
            $file = fopen($this->dbPath, "w");
            fwrite($file, $serializedDb);
            fclose($file);
        }
    }

    /**
     * Unserializes and reads the file and gets the MediaObject from it.
     * 
     * @return      MediaObject read from file.
     */
    public function readDbFile() {
        $db = null;
        if (file_exists($this->dbPath)) {
            $serializedDb = file_get_contents($this->dbPath);
            $db = unserialize($serializedDb);
        }
        $this->highestId($db);
        return $db;
    }
    
    /**
     * Searches a database for the highest id and sets it to 
     * the static id in Media class.
     * 
     * @param db     database from which the highest id is searched.
     */
    public function highestId($db) {
        $highestId = 0;
        $items = $db->getItems();
        
        foreach ($items as $item) {
            if ($item->id() != null && ($item->id() > $highestId)) {
                $highestId = $item->id();
            }
        }
        
        Media::setId($highestId);
    }
    /*public function parseWordsFromLine($line) {
         $parts = explode(",", $line);
         return $parts;
    }
    
    public function getNextLine() {
        $nextLine = "";
        if ($this->hasNextLine()) {
            $nextLine = $this->lines[$this->linesRead];
            $this->linesRead++;
        }
        else {
            return null;
        }
        
        return $nextLine;
    }
    
    public function hasNextLine() {
        if ($this->linesRead < $this->lineCount) {
            return true;
        }
        else {
            return false;
        }
    }*/
}
?>