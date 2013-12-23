<?php

class Music extends Media {

    private $artist

    public function __construct() {
    }
    
    public function __construct($title, $artist, $publishYear, $rating, $genre) {
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
    
    public function print() {
        echo "-------------";
        echo "Title: " .parent::getTitle() .", Artist: " .getArtist() .", PublishYear: " .parent::getPublishYear() .", Rating: " .parent::getRating() .", Genre: " .parent::getGenre();
        echo "-------------";
    }
}
?>