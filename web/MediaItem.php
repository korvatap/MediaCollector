<?php

/**
 * MediaItem class is used as a component in composite pattern.
 * Contains skeleton functions for other classes that inherit MediaItem.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
interface MediaItem {

    public function info();
    public function add($item);
    public function id();
}
?>