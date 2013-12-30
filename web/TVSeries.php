<?php

/**
 * TVSeries is a subclass of Media. The objects of TVSeries contain information about a TV Series.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
class TVSeries extends Media {

    private $episode;
    private $season;
    private $id;

    public function __construct() {
        $arguments = func_get_args();
        $numOfArgs = func_num_args();
        if (method_exists ($this, $function = '__construct' .$numOfArgs) ) {
            call_user_func_array (array ($this, $function), $arguments);
        } 
    }
    
    /**
     * Constructor for TVSeries class which can store the information about a TV series.
     * 
     * @param title         title for the tv series.
     * @param season        season name for the series or a number.
     * @param episode       name of the episode or a number.
     * @param publishYear   the year the episode in question was produced.
     * @param rating        the rating of the episode, 1-10.
     * @param genre         the genre for the tv series e.g. Action.
     */
    public function __construct6($title, $season, $episode, $publishYear, $rating, $genre) {
        parent::setTitle($title);
        $this->season = $season;
        $this->episode = $episode;
        parent::setPublishYear($publishYear);
        parent::setRating($rating);
        parent::setGenre($genre);
        parent::increaseId();
        $this->id = parent::getId();
    }

    /**
     * Sets the episode name to the wanted value.
     * 	
     * @param episode   value to set as episode name.
     */
    public function setEpisode($episode) {
        $this->episode = $episode;
    }
    
    /**
     * Returns the name of the episode.
     * 
     * @return      name of the episode.
     */
    public function getEpisode() {
        return $this->episode;
    }
    
    /**
     * Sets the name or number of the season.
     * 
     * @param season    value to be set as name or number of the season.
     */
    public function setSeason($season) {
        $this->season = $season;
    }
    
    /**
     * Returns the name or number of the season.
     * 
     * @return      name or number of the season.
     */
    public function getSeason() {
        return $this->season;
    }

    /**
     * Returns id of the TVSeries object.
     * 
     * @return id   id of the TVSeries object.
     */
    public function id() {
        return $this->id;
    }
    
    /**
     * Prints the info of the TVSeries object.
     */
    public function info() {
        echo "-------------<br/>";
        echo "ID: " .$this->id() .", Title: " .parent::getTitle() .", Season: " .$this->getSeason() .", Episode: " .$this->getEpisode() .", PublishYear: " .parent::getPublishYear() .", Rating: " .parent::getRating() .", Genre: " .parent::getGenre() ."<br/>";
        echo "-------------<br/>";
    }
}
?>