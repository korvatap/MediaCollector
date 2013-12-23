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
    
    public function print() {
        foreach ($this->items as $item) {
            $item->print();
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
    
    public function isEmpty() {
        return empty($this->items);
    }
}
?>