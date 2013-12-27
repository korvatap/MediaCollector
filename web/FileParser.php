<?php
//singleton pattern?
class FileParser {
    
    private $lineCount = 0;
    private $linesRead = 0;
    private $lines = array();
    
    public function __construct() {
        $this->lines = $this->readFile();
        $this->lineCount = count($this->lines);
    }
    private function readFile() {
        if (file_exists("Database/database.txt")) {
            $lines = file("Database/database.txt");
            //foreach ($lines as $line) {
                //echo $line . "<br/>";
            //}
            return $lines;
        }
    }
    
    public function parseWordsFromLine($line) {
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
    }
}
?>