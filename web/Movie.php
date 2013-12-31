<?php

/**
 * Movie is a subclass of Media. The objects of Movie contain information about a movie.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
class Movie extends Media {

    private $language;
    private $id;

    public function __construct() {
        $arguments = func_get_args();
        $numOfArgs = func_num_args();
        if (method_exists ($this, $function = '__construct' .$numOfArgs) ) {
            call_user_func_array (array ($this, $function), $arguments);
        } 
    }

    /**
     * Constructor for class Movie which can store the information about a movie.
     *
     * @param title         title for the movie.
     * @param language      language of the movie.
     * @param publishYear   the year the movie was produced.
     * @param rating        the rating of the movie, 1-10.
     * @param genre         the genre for the movie e.g. Action.
     */
    public function __construct5($title, $language, $publishYear, $rating, $genre) {
        parent::setTitle($title);
        $this->language = $language;
        parent::setPublishYear($publishYear);
        parent::setRating($rating);
        parent::setGenre($genre);
        parent::increaseId();
        $this->id = parent::getId();
    }

    /**
     * Sets the language of the movie.
     * 
     * @param language      language to be set.
     */
    public function setLanguage($language) {
        $this->language = $language;
    }

    /**
     * Returns the language of the movie.
     * 
     * @return      language of the movie.
     */
    public function getLanguage() {
        return $this->language;
    }
   
    /**
     * Returns the id of the movie.
     * 
     * @return      id of the movie.
     */
    public function id() {
        return $this->id;
    }
    
    /**
     * Prints the info of the Movie object.
     */
    public function info() {
        echo "<p id='teksti'>-------------<br/></p>";
        echo "<p id='teksti'>ID: " .$this->id() .", Title: " .parent::getTitle() .", Language: " .$this->getLanguage() .", PublishYear: " .parent::getPublishYear() .", Rating: " .parent::getRating() .", Genre: " .parent::getGenre() ." <a href='?link=Modify&id=" .$this->id() ."&type=Movie'>Modify</a> ". "<a href=?link=Delete&id=" .$this->id() ."&type=Movie>Delete</a>"."<br/></p>";
        echo "<p id='teksti'>-------------<br/></p>";
    }
}
?>