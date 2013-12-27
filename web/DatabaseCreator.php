<?php

class DatabaseCreator {

    private $fp;
    private $musicDb;
    private $movieDb;
    private $tvDb;
    private $masterDB;
    
    public function __construct($fp) {
        $this->fp = $fp;
        $this->musicDb = new MediaObject();
        $this->movieDb = new MediaObject();
        $this->tvDb = new MediaObject();
        $this->masterDb = new MediaObject();
    }
    
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
    
    public function info() {
        $this->masterDb->info();
    }
    
    public function getDatabases() {
        return $this->masterDb;
    }
}
?>