<?php

class TVSeries extends Media {

    private $episode;
    private $season;

    public function __construct() {
        $arguments = func_get_args();
        $numOfArgs = func_num_args();
        if (method_exists ($this, $function = '__construct' .$numOfArgs) ) {
            call_user_func_array (array ($this, $function), $arguments);
        } 
    }
    public function __construct6($title, $season, $episode, $publishYear, $rating, $genre) {
        parent::setTitle($title);
        $this->season = $season;
        $this->episode = $episode;
        parent::setPublishYear($publishYear);
        parent::setRating($rating);
        parent::setGenre($genre);
    }

    public function setEpisode($episode) {
        $this->episode = $episode;
    }
    
    public function getEpisode() {
        return $this->episode;
    }
    
    public function setSeason($season) {
        $this->season = $season;
    }
    
    public function getSeason() {
        return $this->season;
    }
    
    public function info() {
        echo "-------------<br/>";
        echo "Title: " .parent::getTitle() .", Season: " .$this->getSeason() .", Episode: " .$this->getEpisode() .", PublishYear: " .parent::getPublishYear() .", Rating: " .parent::getRating() .", Genre: " .parent::getGenre() ."<br/>";
        echo "-------------<br/>";
    }
}
?>