<?php

class Media implements MediaItem {

    private $title;
    private $publishYear;
    private $rating;
    private $genre;
    
    public function __construct() {
    }
    
    public function __construct($title) {
            $this->title = $title;
    }

    public function setTitle($title) {
        $this->title = $title;
    }
    
    public function getTitle() {
        return $this->title;
    }
    
    public function setPublishYear($publishYear) {
        $this->publishYear = $publishYear;
    }
    
    public function getPublishYear() {
        return $this->publishYear;
    }
    
    public function setRating($rating) {
        $this->rating = $rating;
    }
    
    public function getRating() {
        return $this->rating;
    }
    
    public function setGenre($genre) {
        $this->genre = $genre;
    }
    
    public function getGenre() {
        return $this->genre;
    }
    
    public function add($item) {
        //stub
    }
    
    public function print() {
        //NOT NEEDED IN THIS BASE CLASS
    }
}
?>