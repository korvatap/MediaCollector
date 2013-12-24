<?php

class Movie extends Media {

    private $language;
    
    public function __construct() {
        $a = func_get_args();
        $i = func_num_args();
        if (method_exists($this,$f='__construct'.$i)) {
            call_user_func_array(array($this,$f),$a);
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