<?php
// abstract?

/**
 * Media class is a base class of Movie, Music and TVSeries.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
class Media implements MediaItem {

    private $title;
    private $publishYear;
    private $rating;
    private $genre;
    static private $id = 0;
    //private $mid;
    
    public function __construct() {
        $arguments = func_get_args();
        $numOfArgs = func_num_args();
        if (method_exists ($this, $function = '__construct' .$numOfArgs) ) {
            call_user_func_array (array ($this, $function), $arguments);
        } 
    }

	/**
	 * Constructor for class Media.
	 * Sets the title for the Media object.
	 * 
	 * @param title     title for the Media object.
	 */
    public function __construct1($title) {
            $this->title = $title;
            //$this->increaseId();
            //$this->mid = $this->getId();
    }

	/**
	 * Used to set the title of the Media.
	 * 
	 * @param title     title to be set.
	 */
    public function setTitle($title) {
        $this->title = $title;
    }
    
	/**
	 * Returns the title of the Media.
	 * 
	 * @return      title of the media.
	 */
    public function getTitle() {
        return $this->title;
    }
    
	/**
	 * Sets the publish year of the media.
     *
	 * @param publishYear   year to be set.
	 */
    public function setPublishYear($publishYear) {
        $this->publishYear = $publishYear;
    }
    
	/**
	 * Returns the publish year of the Media.
	 * 
	 * @return      publishYear of the media.
	 */
    public function getPublishYear() {
        return $this->publishYear;
    }
    
	/**
	 * Sets the rating of the Media.
     *
	 * @param rating    value to be set.
	 */
    public function setRating($rating) {
        $this->rating = $rating;
    }
    
	/**
	 * Returns the rating of the Media.
	 * 
	 * @return      rating of the media.
	 */
    public function getRating() {
        return $this->rating;
    }
    
	/**
	 * Sets the genre of the Media.
	 * 
	 * @param genre     value to be set as genre.
	 */
    public function setGenre($genre) {
        $this->genre = $genre;
    }
    
	/**
	 * Returns the genre of the Media.
	 * 
	 * @return      genre of the media.
	 */
    public function getGenre() {
        return $this->genre;
    }
    
	/**
	 * Inherited function not used in Media.
	 * @see MediaObject
	 */
    public function add($item) {
    }
    
	/**
	 * Inherited function not used in Media.
     * @see MediaObject
	 */
    public function info() {
    }
    
	/**
	 * Returns the id of the Media Object.
	 * 
	 * @return      id of the object.
	 */
    static public function getId() {
        return self::$id;
    }
    
	/**
	 * Increases id by one.
	 */
    static protected function increaseId() {
        self::$id++;
    }
}
?>