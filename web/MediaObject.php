<?php

class MediaObject implements MediaItem {
    
    private $title;
    private $items = array();

    public function add($item) {
        $this->items[] = $item;
    }

    public function remove($item) {
        foreach (array_keys($this->items, $item, true) as $key) {
            unset($this->items[$key]);
        }
    }
    
    public function info() {
        foreach ($this->items as $item) {
            $item->info();
        }
    }
    
    public function getChild($i) {
        if (array_key_exists ($i, $this->items) ) {
            return $this->items[$i];
        }
    }
    
    public function getTitle() {
        return $this->title;
    }
    
    public function setTitle($title) {
        $this->title = $title;
    }
    
    public function isEmpty() {
        return empty($this->items);
    }
}
?>