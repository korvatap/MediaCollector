<?php

class TVSeries extends Media {

    private $episode;
    private $season;

    public function __construct() {
    
    }
    public function __construct($title, $season, $episode, $publishYear, $rating, $genre) {
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
    
    public function print() {
        echo "-------------";
        echo "Title: " .parent::getTitle() .", Season: " .getSeason() .", Episode: " .getEpisode() .", PublishYear: " .parent::getPublishYear() .", Rating: " .parent::getRating() .", Genre: " .parent::getGenre();
        echo "-------------";
    }
}
?>