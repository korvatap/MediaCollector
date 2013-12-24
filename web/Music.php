<?php

class Music extends Media {

    private $artist;

    public function __construct() {
        $arguments = func_get_args();
        $numOfArgs = func_num_args();
        if (method_exists ($this, $function = '__construct' .$numOfArgs) ) {
            call_user_func_array (array ($this, $function), $arguments);
        } 
    }
    
    public function __construct5($title, $artist, $publishYear, $rating, $genre) {
        parent::setTitle($title);
        $this->artist = $artist;
        parent::setPublishYear($publishYear);
        parent::setRating($rating);
        parent::setGenre($genre);
    }

    public function setArtist($artist) {
        $this->artist = $artist;
    }
    
    public function getArtist() {
        return $this->artist;
    }
    
    public function info() {
        echo "-------------<br/>";
        echo "Title: " .parent::getTitle() .", Artist: " .$this->getArtist() .", PublishYear: " .parent::getPublishYear() .", Rating: " .parent::getRating() .", Genre: " .parent::getGenre() ."<br/>";
        echo "-------------<br/>";
    }
}
?>