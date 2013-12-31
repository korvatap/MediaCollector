<?php

/**
 * MediaObject class is used to hold MediaItems and is used as a composite class in composite pattern.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
 
class MediaObject implements MediaItem {
    
    private $title;
    private $items = array();

    /**
     * Adds new MediaItems to an array.
     * 
     * @param item      MediaItem to be added.
     */
    public function add($item) {
        $this->items[$item->id()] = $item;
    }

    /*public function remove($item) {
        foreach (array_keys($this->items, $item, true) as $key) {
            unset($this->items[$key]);
        }
    }*/
    
    /**
     * Removes MediaItems from the array.
     * 
     * @param item      MediaItem to be removed.
     */
    public function remove($item) {
        unset($this->items[$item->id()]);
    }
    
    /**
     * Goes through the Media objects and prints their info.
     */
    public function info() {
        foreach ($this->items as $item) {
            $item->info();
        }
    }
    
    /**
     * Gets child of mediaObject.
     * 
     * @param i	    index of the item to get.
     * @return      MediaItem which is part of the array of MediaItems.
     */
    public function getChild($i) {
        if (array_key_exists ($i, $this->items) ) {
            return $this->items[$i];
        }
    }
    
    /**
     * Returns the title of the mediaObject.
     * 
     * @return      title of the mediaObject.
     */
    public function getTitle() {
        return $this->title;
    }
    
    /**
     * Sets the title of the mediaObject.
     * 
     * @param title     name of the title to be set.
     */
    public function setTitle($title) {
        $this->title = $title;
    }
    
    /**
     * Checks if array of MediaItems is empty.
     * 
     * @return      true if empty, false if not.
     */
    public function isEmpty() {
        return empty($this->items);
    }
    
    /**
     * Not needed in this class.
     * @see Movie
     */
    public function id() {
    }
    
    /**
     * Returns the array of items this MediaObject holds.
     * 
     * @return      array of items.
     */
    public function getItems() {
        return $this->items;
    }
    
    /**
     * Returns an item hold by MediaObject, which
     * has the id given as parameter.
     * 
     * @return      item hold by MediaObject.
     */
    public function getById($id) {
        foreach ($this->items as $item) {
            if ($item->id() == $id) {
                return $item;
            }
        }
        
        return null;
    }
}
?>