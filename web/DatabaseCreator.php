<?php

/**
 * DatabaseCreator class help in creating databases that have been gotten from the FileParser class.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
class DatabaseCreator {

    private $fp;
    private $musicDb;
    private $movieDb;
    private $tvDb;
    private $masterDB;
    
	/**
	 * Constructor for the DatabaseCreator.
     * Creates MediaObjects that form the master database.
     *
	 * @param fp        FileParser object needed in creating the database.
	 */
    public function __construct($fp) {
        $this->fp = $fp;
        $this->musicDb = new MediaObject();
        $this->movieDb = new MediaObject();
        $this->tvDb = new MediaObject();
        $this->masterDb = new MediaObject();
    }
    
	/**
	 * Creates the databases using the FileParser object.
	 */
    public function createDatabases() {
        $line = "";
        while ($this->fp->hasNextLine()) {
            $line = $this->fp->getNextLine();
            $this->createDatabase($line);
        }
        
        if (!$this->musicDb->isEmpty()) {
            $this->musicDb->setTitle("Music");
            $this->masterDb->add($this->musicDb);
        }
        
        if (!$this->movieDb->isEmpty()) {
            $this->movieDb->setTitle("Movie");
            $this->masterDb->add($this->movieDb);
        }

        if (!$this->tvDb->isEmpty()) {
            $this->tvDb->setTitle("TVSeries");
            $this->masterDb->add($this->tvDb);
        }
        
    }
    
	/**
	 * Adds a new Media object to the database.
	 * 
	 * @param line      values for creating a new media.
	 */
    private function createDatabase($line) {
        $media = $this->fp->parseWordsFromLine($line);
        switch ($media[0]) {
            case "Movie":
                $this->movieDb->add(new Movie($media[1], $media[2], $media[3], $media[4], $media[5]));
                break;
            case "TVSeries":
                $this->tvDb->add(new TVSeries($media[1], $media[2], $media[3], $media[4], $media[5], $media[6]));
                break;
            case "Music":
                $this->musicDb->add(new Music($media[1], $media[2], $media[3], $media[4], $media[5]));
                break;
        }
    }
   
	/**
	 * Calls for the databases info() function.
	 * @see MediaObject
	 */
    public function info() {
        $this->masterDb->info();
    }
    
	/**
	 * Returns the main database.
	 * 
	 * @return      main database.
	 */
    public function getDatabases() {
        return $this->masterDb;
    }
}
?>