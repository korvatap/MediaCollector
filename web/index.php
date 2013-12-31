<html>
    <head>
        <title>MediaCollector</title>
	 <link href="style.css" rel="stylesheet" type="text/css" />  
    	 <link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow' rel='stylesheet' type='text/css'>
    </head>
    <body>

<div id="pageWrapper">
		<div id="header">

		<!-- <img src="./images/logo.png" alt="tux Logo" width="862px" height="71px" id="logo"/>-->

		</div> <!-- End of header-->

		<div id="links" class="menu">

		   <ul>  
        	      <li id="bar2">  
            	         <p class="mainlinktext"><a href="?link=Movie">Movie</a></p> 
        	      </li>
  
        	      <li id="bar">  
                         <p class="mainlinktext"><a href="?link=Music">Music</a></p>  
                      </li>
  
                      <li id="bar">  
                         <p class="mainlinktext"><a href="?link=TVSeries">TV Series</a></p>
                      </li>
  
                      <li id="bar">  
                         <p class="mainlinktext"><a href="?link=Manual">Manual</a></p>
                      </li id="bar">
  
                   </ul>  
		  


		</div> <!-- End of links-->
		
		<div id="contentWrapper">

		    <!--<div id="pageLogo"></div>-->
		   <div id="mainText">

		          <?php
    ini_set( 'error_reporting', E_ALL );
    ini_set( 'display_errors', true );
    include("MediaItem.php");
    include("Media.php");
    include("MediaObject.php");
    include("Movie.php");
    include("Music.php");
    include("TVSeries.php");
    include("FileParser.php");
    include("DatabaseCreator.php");
    
    /*$movie = new Movie("Die Hard", "English", 1988, 5, "Action");
    $music = new Music("The Trooper", "Iron Maiden", 1983, 5, "Metal");
    $tv = new TVSeries("MacGyver", 1, 5, 1985, 5, "Action");
    $mObject = new MediaObject();
    $mObject->add($movie);
    $mObject->add($music);
    $mObject->add($tv);*/
    
    //$mObject->info();
    
    //$fp = new FileParser();
    //$fp->readFile();
    
    //echo "<br/><br/>";
    
    //$db = new DatabaseCreator(new FileParser());
    //$db->createDatabases();
    //$db->info();
    
    //echo "From text file: <br/>";
    $fp = new FileParser();
    //$fp->readFromFile();
    
    //$db = new DatabaseCreator($fp);
    //$db->createDatabases();
    //$db->info();
    
    //echo "<br/><br/>";
    
    //$fp->writeToFile($db->getDatabases());
    //$masterDb = new MediaObject();
    //$fp->writeToFile($mObject);
    global $linkchoice;
    $masterDb = $fp->readDbFile();

    if($masterDb != null) {
        //$masterDb->info();
    } 
    else {
       $masterDb = new MediaObject();
       $fp->writeToFile($masterDb);
       echo "<p id='teksti'>lappa </p>";

    }
    

    function showMovie($masterDb) {
     //  $fp = new FileParser();
      // $masterDb = $fp->readDbFile();
	//$movieDb = $masterDb->getChild(0);
	//$movieDb->info();

        echo '<form action="htmlspecialchars($_SERVER["PHP_SELF"])" method="post" id="form">';
        echo 'Title: <br><input type="text" name="title" size=40> <br>';
        echo 'Language: <br><input type="text" name="language" size=40> <br>';
        echo 'Publish Year: <br><input type="text" name="publishYear" size=40> <br>';
        echo 'Rating: <br><input type="text" name="rating" size=40> <br>';
        echo 'Genre: <br><input type="text" name="genre" size=40> <br>';
        echo '<br><input type="submit" name="submit1" value="Add">';
        echo '</form>';

        $fp = new FileParser();
        $masterDb = $fp->readDbFile();
    
        $typeDb = getClasses($masterDb, "Movie");
        
        /*if($masterDb != null) {
            //$masterDb->info();
        } 
        else {
            $masterDb = new MediaObject();
        }*/
	
        $movie1 = new Movie("Die Hard", "English", 1988, 5, "Action");
        $movie2 = new Movie("Die Hard", "English", 1988, 5, "Action");
        $movie3 = new Movie("Die Hard", "English", 1988, 5, "Action");	
        $movie4 = new Movie("Die Hard", "English", 1988, 5, "Action");
        $movie5 = new Movie("Die Hard", "English", 1988, 5, "Action");

        /*$movieDb = new MediaObject();
        $movieDb->add($movie1);
        $movieDb->add($movie2);
        $movieDb->add($movie3);
        $movieDb->add($movie4);
        $movieDb->add($movie5);
        $movieDb->setTitle("Movie");
        $movieDb->info();*/
        
        $masterDb->add($movie1);
        //$masterDb->add($movie2);
        //$masterDb->add($movie3);
        //$masterDb->add($movie4);
        //$masterDb->add($movie5);
        //$masterDb->setTitle("Movie");
        $typeDb->info();
        return $masterDb;

    }

    function showMusic($masterDb) {
        echo '<form action="htmlspecialchars($_SERVER["PHP_SELF"])" method="post" id="form">';
        echo 'Title: <br><input type="text" name="title" size=40> <br>';
        echo 'Artist: <br><input type="text" name="artist" size=40> <br>';
        echo 'Publish Year: <br><input type="text" name="publishYear" size=40> <br>';
        echo 'Rating: <br><input type="text" name="rating" size=40> <br>';
        echo 'Genre: <br><input type="text" name="genre" size=40> <br>';
        echo '<br><input type="submit" name="submit1" value="Add">';
        echo '</form>';

        $fp = new FileParser();
        $masterDb = $fp->readDbFile();
        
        $typeDb = getClasses($masterDb, "Music");
        
        $music1 = new Music("The Trooper", "Iron Maiden", 1983, 5, "Metal");
        $music2 = new Music("The Trooper", "Iron Maiden", 1983, 5, "Metal");	
        $music3 = new Music("The Trooper", "Iron Maiden", 1983, 5, "Metal");
        $music4 = new Music("The Trooper", "Iron Maiden", 1983, 5, "Metal");
        $music5 = new Music("The Trooper", "Iron Maiden", 1983, 5, "Metal");
        
        /*$musicDb = new MediaObject();
        $musicDb->add($music1);
        $musicDb->add($music2);
        $musicDb->add($music3);	
        $musicDb->add($music4);
        $musicDb->add($music5);
        $musicDb->setTitle("Music");
        $musicDb->info();*/

        $masterDb->add($music1);
        //$masterDb->add($music2);
        //$masterDb->add($music3);
        //$masterDb->add($music4);
        //$masterDb->add($music5);
        $typeDb->info();
        return $masterDb;
    }

    function showTVSeries($masterDb) {
        echo '<form action="htmlspecialchars($_SERVER["PHP_SELF"])" method="post" id="form">';
        echo 'Title: <br><input type="text" name="title" size=40> <br>';
        echo 'Season: <br><input type="text" name="season" size=40> <br>';
        echo 'Episode: <br><input type="text" name="episode" size=40> <br>';
        echo 'Publish Year: <br><input type="text" name="publishYear" size=40> <br>';
        echo 'Rating: <br><input type="text" name="rating" size=40> <br>';
        echo 'Genre: <br><input type="text" name="genre" size=40> <br>';
        echo '<br><input type="submit" name="submit1" value="Add">';
        echo '</form>';   

        $fp = new FileParser();
        $masterDb = $fp->readDbFile();
        
        $typeDb = getClasses($masterDb, "TVSeries");
        
        $tv1= new TVSeries("MacGyver", 1, 5, 1985, 5, "Action");
        $tv2= new TVSeries("MacGyver", 1, 5, 1985, 5, "Action");
        $tv3= new TVSeries("MacGyver", 1, 5, 1985, 5, "Action");
        $tv4= new TVSeries("MacGyver", 1, 5, 1985, 5, "Action");
        $tv5= new TVSeries("MacGyver", 1, 5, 1985, 5, "Action");
        
        /*$tvDb = new MediaObject();
        $tvDb->add($tv1);
        $tvDb->add($tv2);
        $tvDb->add($tv3);
        $tvDb->add($tv4);
        $tvDb->add($tv5);
        $tvDb->setTitle("TVSeries");
        $tvDb->info();*/
        
        $masterDb->add($tv1);
        //$masterDb->add($tv2);
        //$masterDb->add($tv3);
        //$masterDb->add($tv4);
        //$masterDb->add($tv5);
        $typeDb->info();
        return $masterDb;
    }

    function showManual() {
        echo "LOL MANUAL<br>";
    }

    function modifyMedia($id) {
       //echo "LOL" . "$id";
    }

    function deleteMedia($id) {
        echo "DELETE" . "$id";
        
        $fp = new FileParser();
        $masterDb = $fp->readDbFile();
        
        $item = $masterDb->getById($id);
        
        if ($item != null) {
            $masterDb->remove($item);
            $fp->writeToFile($masterDb);
        }
    }
    
    function getClasses($db, $type) {
        $typeDb = new MediaObject();
        $tmp = $db->getItems();
        foreach ($tmp as $item) {
            if (get_class($item) === $type) {
                $typeDb->add($item);
            }
        }
        
        return $typeDb;
    }

    if (isset($_GET['link'])) {
        $linkchoice=$_GET['link']; 
    }
    else {
        $linkchoice=''; 
    }

    switch($linkchoice){ 
        
        case 'Movie' : 
            $masterDb = showMovie($masterDb);
            break; 

        case 'Music' : 
            $masterDb = showMusic($masterDb); 
            break; 

        case 'TVSeries' :
            $masterDb = showTVSeries($masterDb);
            break;

        case 'Manual' :
            showManual();
            break;

        case 'Modify' :
            modifyMedia($_GET['id']);
            break;

        case 'Delete' :
            deleteMedia($_GET['id']);

        default : 
            $masterDb = showMovie($masterDb);

    } 


    echo "<p id='teksti'>From .dat file: </p>";
    
 
    
    echo "<br/><br/>";
    echo "<p id='teksti'>From .dat file with added movie: <br/></p>";
    
    //$movie2 = new Movie("MacGyver: Lost Treasure of Atlantis", "English", 1994, 5, "Adventure");
    //$masterDb->add($movie2);
    
    $fp->writeToFile($masterDb);
    //$masterDb = $fp->readDbFile();
    //$masterDb->info();
    
    //$masterDb->remove($movie2);
    
    echo "<br/><br/>";
    //echo "<p id='teksti'>From .dat file with one movie removed: <br/></p>";
    //$fp->writeToFile($masterDb);
    //$masterDb = $fp->readDbFile();
    //$masterDb->info();
    
    if (isset($_POST["submit1"])) {
        echo "Painettu <br/>";
        $title = validateInput($_POST["title"]);
        $language = validateInput($_POST["language"]);
        $publishYear = validateInput($_POST["publishYear"]);
        $rating = validateInput($_POST["rating"]);
        $genre = validateInput($_POST["genre"]);
        
        $mv = new Movie($title, $language, $publishYear, $rating, $genre);
        $masterDb->add($mv);
        $fp->writeToFile($masterDb);
        $masterDb = $fp->readDbFile();
        $masterDb->info();
    }
    
    function validateInput($input) {
        $input = htmlspecialchars($input);
        return $input;
    }
    echo "</p>";
    ?>		      
			</p>

		   </div>
		 
		<div id="banner">
		<hr />
		<p>
		   <span style="font-size:50px">Media Collector | </span>
		   <span style="font-size:14px">Making it worthwhile everytime it really does count.</span>
		     
		</p>
		</div>
		</div>
	

	</div> <!-- End of pageWrapper -->


    </body>
</html>