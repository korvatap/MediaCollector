<?php

class Movie extends Media {

    private $language;
    
    public function __construct() {
    }
    
    public function __construct($title, $language, $publishYear, $rating, $genre) {
        parent::setTitle($title);
        $this->language = $language;
        parent::setPublishYear($publishYear);
        parent::setRating($rating);
        parent::setGenre($genre);
    }
    
    public function setLanguage($language) {
        $this->language = $language;
    }
    
    public function getLanguage() {
        return $this->language;
    }
    
    public function print() {
        echo "-------------";
        echo "Title: " .parent::getTitle() .", Language: " .getLanguage() .", PublishYear: " .parent::getPublishYear() .", Rating: " .parent::getRating() .", Genre: " .parent::getGenre();
        echo "-------------";
    }
}
?>