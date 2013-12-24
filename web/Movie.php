<?php

class Movie extends Media {

    private $language;
    
    public function __construct() {
        $arguments = func_get_args();
        $numOfArgs = func_num_args();
        if (method_exists ($this, $function = '__construct' .$numOfArgs) ) {
            call_user_func_array (array ($this, $function), $arguments);
        } 
    }
    
    public function __construct5($title, $language, $publishYear, $rating, $genre) {
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
    
    public function info() {
        echo "-------------<br/>";
        echo "Title: " .parent::getTitle() .", Language: " .$this->getLanguage() .", PublishYear: " .parent::getPublishYear() .", Rating: " .parent::getRating() .", Genre: " .parent::getGenre() ."<br/>";
        echo "-------------<br/>";
    }
}
?>