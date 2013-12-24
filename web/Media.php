<?php
// abstract?
class Media implements MediaItem {

    private $title;
    private $publishYear;
    private $rating;
    private $genre;
    
    public function __construct() {
        $a = func_get_args();
        $i = func_num_args();
        if (method_exists($this,$f='__construct'.$i)) {
            call_user_func_array(array($this,$f),$a);
        } 
    }
    
    public function __construct1($title) {
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
    
    public function info() {
        //NOT NEEDED IN THIS BASE CLASS
    }
}
?>