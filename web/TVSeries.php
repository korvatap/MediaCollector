<?php

class TVSeries {
    private $episode;
	private $season;

    public function __construct($episode, $season) {
        //parent::__construct(something);
        $this->episode = $episode;
		$this->season = $season;
    }

    //public function something() {
    //}
}
?>