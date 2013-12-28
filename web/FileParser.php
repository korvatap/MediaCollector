<?php
//singleton pattern?
class FileParser {
    
    /*private $lineCount = 0;
    private $linesRead = 0;
    private $lines = array();*/
    
    //private $path = "Database/database.txt";
    private $dbPath = "Database/database.dat";
    
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
    
    public function readDbFile() {
        $db = null;
        if (file_exists($this->dbPath)) {
            $serializedDb = file_get_contents($this->dbPath);
            $db = unserialize($serializedDb);
        }
        
        return $db;
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