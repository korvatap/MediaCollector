<?php

/**
 * Music is a subclass of Media. The objects of Music contain information about a song.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
class Music extends Media {

    private $artist;
    private $id;

    public function __construct() {
        $arguments = func_get_args();
        $numOfArgs = func_num_args();
        if (method_exists ($this, $function = '__construct' .$numOfArgs) ) {
            call_user_func_array (array ($this, $function), $arguments);
        } 
    }
 
    /**
     * Constructor for class Music which can store the information about a song.
     *
     * @param title	        title for the song.
     * @param artist        name of the artist.
     * @param publishYear   the year the song was produced.
     * @param rating        the rating of the song, 1-10.
     * @param genre         the genre for the album e.g. Rock.
     */
    public function __construct5($title, $artist, $publishYear, $rating, $genre) {
        parent::setTitle($title);
        $this->artist = $artist;
        parent::setPublishYear($publishYear);
        parent::setRating($rating);
        parent::setGenre($genre);
        parent::increaseId();
        $this->id = parent::getId();
    }

    /**
     * Sets the name of the artist.
     * 
     * @param artist    name to be set.
     */
    public function setArtist($artist) {
        $this->artist = $artist;
    }
    
    /**
     * Returns the artist name.
     * 
     * @return      name of the artist.
     */
    public function getArtist() {
        return $this->artist;
    }
    
    /**
     * Returns the id of the music object.
     * 
     * @return      id of the music object.
     */
    public function id() {
        return $this->id;
    }
    
    /**
     * Prints the info of the Music object.
     */
    public function info() {
        echo "<p id='teksti'>-------------<br/></p>";
        echo "<p id='teksti'>ID: " .$this->id() .", Title: " .parent::getTitle() .", Artist: " .$this->getArtist() .", PublishYear: " .parent::getPublishYear() .", Rating: " .parent::getRating() .", Genre: " .parent::getGenre() ." <a href='?link=Modify&id=$this->id()&type=Music'>Modify</a> ". "<a href=?link=Delete&id=$this->id()&type=Music>Delete</a>"."<br/></p>";
        echo "<p id='teksti'>-------------<br/></p>";
    }
}
?>