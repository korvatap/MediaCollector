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
    }
    

    function showMovie($masterDb) {
     //  $fp = new FileParser();
      // $masterDb = $fp->readDbFile();
	//$movieDb = $masterDb->getChild(0);
	//$movieDb->info();

        echo '<form action=' .htmlspecialchars($_SERVER["PHP_SELF"]) .' method="post" id="form">';
        echo 'Title: <br><input type="text" name="title" size=40> <br>';
        echo 'Language: <br><input type="text" name="language" size=40> <br>';
        echo 'Publish Year: <br><input type="text" name="publishYear" size=40> <br>';
        echo 'Rating: <br><input type="text" name="rating" size=40> <br>';
        echo 'Genre: <br><input type="text" name="genre" size=40> <br>';
        echo '<br><input type="submit" name="submitMovie" value="Add">';
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
        
        //$masterDb->add($movie1);
        //$masterDb->add($movie2);
        //$masterDb->add($movie3);
        //$masterDb->add($movie4);
        //$masterDb->add($movie5);
        //$masterDb->setTitle("Movie");
        echo "<table border='1' id='media'>";
        echo "<tr>";
        echo '<td>Title</td>';
        echo '<td>Language</td>';
        echo '<td>Publish Year</td>';
        echo '<td>Rating</td>';
        echo '<td>Genre</td>';
        echo '<td>Modify</td>';
        echo '<td>Delete</td>';
        echo '</tr>';
        $typeDb->info();
        //return $masterDb;
        echo "</table>";
        return $masterDb;

    }

    function showMusic($masterDb) {
        echo '<form action=' .htmlspecialchars($_SERVER["PHP_SELF"]) .' method="post" id="form">';
        echo 'Title: <br><input type="text" name="title" size=40> <br>';
        echo 'Artist: <br><input type="text" name="artist" size=40> <br>';
        echo 'Publish Year: <br><input type="text" name="publishYear" size=40> <br>';
        echo 'Rating: <br><input type="text" name="rating" size=40> <br>';
        echo 'Genre: <br><input type="text" name="genre" size=40> <br>';
        echo '<br><input type="submit" name="submitMusic" value="Add">';
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

        //$masterDb->add($music1);
        //$masterDb->add($music2);
        //$masterDb->add($music3);
        //$masterDb->add($music4);
        //$masterDb->add($music5);
        echo "<table border='1' id='media'>";
        echo "<tr>";
        echo '<td>Title</td>';
        echo '<td>Artist</td>';
        echo '<td>Publish Year</td>';
        echo '<td>Rating</td>';
        echo '<td>Genre</td>';
        echo '<td>Modify</td>';
        echo '<td>Delete</td>';
        echo '</tr>';
        $typeDb->info();
        //return $masterDb;
        echo "</table>";
        return $masterDb;

    }

    function showTVSeries($masterDb) {
        echo '<form action=' .htmlspecialchars($_SERVER["PHP_SELF"]) .' method="post" id="form">';
        echo 'Title: <br><input type="text" name="title" size=40> <br>';
        echo 'Season: <br><input type="text" name="season" size=40> <br>';
        echo 'Episode: <br><input type="text" name="episode" size=40> <br>';
        echo 'Publish Year: <br><input type="text" name="publishYear" size=40> <br>';
        echo 'Rating: <br><input type="text" name="rating" size=40> <br>';
        echo 'Genre: <br><input type="text" name="genre" size=40> <br>';
        echo '<br><input type="submit" name="submitTVSeries" value="Add">';
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
        
        //$masterDb->add($tv1);
        //$masterDb->add($tv2);
        //$masterDb->add($tv3);
        //$masterDb->add($tv4);
        //$masterDb->add($tv5);
        echo "<table border='1' id='media'>";
        echo "<tr>";
        echo '<td>Title</td>';
        echo '<td>Season</td>';
        echo '<td>Episode</td>';
        echo '<td>Publish Year</td>';
        echo '<td>Rating</td>';
        echo '<td>Genre</td>';
        echo '<td>Modify</td>';
        echo '<td>Delete</td>';
        echo '</tr>';
        $typeDb->info();
        //return $masterDb;
        echo "</table>";
        return $masterDb;
    }

    function showManual() {
        echo "<h2>Add media instructions</h2>"
            ."<p id='teksti'><br> - Media can be added by filling the text boxes and pressing add button in each of the categories.</p>";
            
        echo "<h2>How to delete media </h2><br>"
                ."<p id='teksti'>- You can delete media by clicking the delete link of the corresponding media you want to delete.<br>"
		  ."- The link is located in the last column of the table</p>";
                
        echo "<h2>How to modify media</h2><br>"
                ."<p id='teksti'>- To be able to modify media you first have to click the modify link beside the media you want to modify."
				."<br>- The modify link is located in the second last column of each row.<br>"
                ."- In the new view you have a text fields with the media information you selected.<br>"
                ."- Now you can modify the media information straight from these text fields and after that pressing save to save the media.</p>";
                
    }

    function modifyMedia($id,$type) {
        $fp = new FileParser();
        $masterDb = $fp->readDbFile();
        $item = $masterDb->getById($id);
       
        if($item != null) {
            $title = $item->getTitle();
            $publishYear = $item->getPublishYear();
            $rating = $item->getRating();
            $genre = $item->getGenre();
	    
            if($type == 'Movie') {
                $language = $item->getLanguage();
 
                echo '<form action=' .htmlspecialchars($_SERVER["PHP_SELF"]) .' method="post" id="form">';
                echo "<input type='hidden' name='id' value='$id'>";
                echo "Title: <br><input type='text' name='title' size=40 value='$title'> <br>";
                echo "Language: <br><input type='text' name='language' size=40 value='$language'> <br>";
                echo "Publish Year: <br><input type='text' name='publishYear' size=40 value='$publishYear'> <br>";
                echo "Rating: <br><input type='text' name='rating' size=40 value='$rating'> <br>";
                echo "Genre: <br><input type='text' name='genre' size=40 value='$genre'> <br>";
                echo '<br><input type="submit" name="movieSave" value="Save">';
                echo '</form>';
            }
 
            if($type == 'Music') {
                $artist = $item->getArtist();
                echo '<form action=' .htmlspecialchars($_SERVER["PHP_SELF"]) .' method="post" id="form">';
                echo "<input type='hidden' name='id' value='$id'>";
                echo "Title: <br><input type='text' name='title' size=40 value='$title'> <br>";
                echo "Artist: <br><input type='text' name='artist' size=40 value='$artist'> <br>";
                echo "Publish Year: <br><input type='text' name='publishYear' size=40 value='$publishYear'> <br>";
                echo "Rating: <br><input type='text' name='rating' size=40 value='$rating'> <br>";
                echo "Genre: <br><input type='text' name='genre' size=40 value='$genre'> <br>";
                echo '<br><input type="submit" name="musicSave" value="Save">';
                echo '</form>';
            }
 
            if($type == 'TVSeries') {
                $season = $item->getSeason();
                $episode = $item->getEpisode();
 
                echo '<form action=' .htmlspecialchars($_SERVER["PHP_SELF"]) .' method="post" id="form">';
                echo "<input type='hidden' name='id' value='$id'>";
                echo "Title: <br><input type='text' name='title' size=40 value='$title'> <br>";
                echo "Season: <br><input type='text' name='season' size=40 value='$season'> <br>";
                echo "Episode: <br><input type='text' name='episode' size=40 value='$episode'> <br>";
                echo "Publish Year: <br><input type='text' name='publishYear' size=40 value='$publishYear'> <br>";
                echo "Rating: <br><input type='text' name='rating' size=40 value='$rating'> <br>";
                echo "Genre: <br><input type='text' name='genre' size=40 value='$genre'> <br>";
                echo '<br><input type="submit" name="tvSave" value="Save">';
                echo '</form>';
            }
 
        }
    }

    function deleteMedia($id) {
        $fp = new FileParser();
        $masterDb = $fp->readDbFile();
        
        $item = $masterDb->getById($id);
        
        $type = "";
        if ($item != null) {
            $masterDb->remove($item);
            $fp->writeToFile($masterDb);
            $type = get_class($item);
        }
        header("Location: index.php?link=" .$type);
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
            showMovie($masterDb);
            break; 

        case 'Music' : 
            showMusic($masterDb); 
            break; 

        case 'TVSeries' :
            showTVSeries($masterDb);
            break;

        case 'Manual' :
            showManual();
            break;

        case 'Modify' :
            modifyMedia($_GET['id'], $_GET['type']);
            break;

        case 'Delete' :
            deleteMedia($_GET['id']);
            break;

        default : 
            //$masterDb = showMovie($masterDb);

    } 
    
    //$movie2 = new Movie("MacGyver: Lost Treasure of Atlantis", "English", 1994, 5, "Adventure");
    //$masterDb->add($movie2);
    
    //$fp->writeToFile($masterDb);
    //$masterDb = $fp->readDbFile();
    //$masterDb->info();
    
    //$masterDb->remove($movie2);
    
     //echo "<p id='teksti'>From .dat file with one movie removed: <br/></p>";
    //$fp->writeToFile($masterDb);
    //$masterDb = $fp->readDbFile();
    //$masterDb->info();
    
    if (isset($_POST["submitMovie"])) {
        echo "Painettu <br/>";
        $title = validateInput($_POST["title"]);
        $language = validateInput($_POST["language"]);
        $publishYear = validateInput($_POST["publishYear"]);
        $rating = validateInput($_POST["rating"]);
        $genre = validateInput($_POST["genre"]);
        
        $masterDb = $fp->readDbFile();
        $mv = new Movie($title, $language, $publishYear, $rating, $genre);
       
        $masterDb->add($mv);
        $fp->writeToFile($masterDb);
        
        header('Location: index.php');
        //$masterDb = $fp->readDbFile();
        //$masterDb->info();
    }
    
    if (isset($_POST["submitMusic"])) {
        echo "Painettu <br/>";
        $title = validateInput($_POST["title"]);
        $artist = validateInput($_POST["artist"]);
        $publishYear = validateInput($_POST["publishYear"]);
        $rating = validateInput($_POST["rating"]);
        $genre = validateInput($_POST["genre"]);
        
        $masterDb = $fp->readDbFile();
        $music = new Music($title, $artist, $publishYear, $rating, $genre);
       
        $masterDb->add($music);
        $fp->writeToFile($masterDb);
        
        header('Location: index.php?link=Music');
        //$masterDb = $fp->readDbFile();
        //$masterDb->info();
    }
    
    if (isset($_POST["submitTVSeries"])) {
        echo "Painettu <br/>";
        $title = validateInput($_POST["title"]);
        $season = validateInput($_POST["season"]);
        $episode = validateInput($_POST["episode"]);
        $publishYear = validateInput($_POST["publishYear"]);
        $rating = validateInput($_POST["rating"]);
        $genre = validateInput($_POST["genre"]);
        
        $masterDb = $fp->readDbFile();
        $tv = new TVSeries($title, $season, $episode, $publishYear, $rating, $genre);
       
        $masterDb->add($tv);
        $fp->writeToFile($masterDb);
        
        header('Location: index.php?link=TVSeries');
        //$masterDb = $fp->readDbFile();
        //$masterDb->info();
    }

    if (isset($_POST["musicSave"])) {
        $title = validateInput($_POST["title"]);
        $artist = validateInput($_POST["artist"]);
        $publishYear = validateInput($_POST["publishYear"]);
        $rating = validateInput($_POST["rating"]);
        $genre = validateInput($_POST["genre"]);
        $id = validateInput($_POST["id"]);
        $masterDb = $fp->readDbFile();
	
        $item = $masterDb->getById($id);
        $item->setTitle($title);
        $item->setArtist($artist);
        $item->setPublishYear($publishYear);
        $item->setRating($rating);
        $item->setGenre($genre);
        $fp->writeToFile($masterDb);
        
        echo "<p id='teksti'>New media saved</p>";
        header('Location: index.php?link=Music');
    }

    if (isset($_POST["movieSave"])) {
        $title = validateInput($_POST["title"]);
        $language = validateInput($_POST["language"]);
        $publishYear = validateInput($_POST["publishYear"]);
        $rating = validateInput($_POST["rating"]);
        $genre = validateInput($_POST["genre"]);
        $id = validateInput($_POST["id"]);

        $masterDb = $fp->readDbFile();
	
        $item = $masterDb->getById($id);
        $item->setTitle($title);
        $item->setLanguage($language);
        $item->setPublishYear($publishYear);
        $item->setRating($rating);
        $item->setGenre($genre);
        $fp->writeToFile($masterDb);
        
        echo "<p id='teksti'>New media saved</p>";
        header('Location: index.php');

    }

    if (isset($_POST["tvSave"])) {
        $title = validateInput($_POST["title"]);
        $season = validateInput($_POST["season"]);
        $episode = validateInput($_POST["episode"]);
        $publishYear = validateInput($_POST["publishYear"]);
        $rating = validateInput($_POST["rating"]);
        $genre = validateInput($_POST["genre"]);
        $id = validateInput($_POST["id"]);

        $masterDb = $fp->readDbFile();
	
        $item = $masterDb->getById($id);
        $item->setTitle($title);
        $item->setSeason($season);
        $item->setEpisode($episode);
        $item->setPublishYear($publishYear);
        $item->setRating($rating);
        $item->setGenre($genre);

        $fp->writeToFile($masterDb);
        
        echo "<p id='teksti'>New media saved</p>";
        header('Location: index.php?link=TVSeries');
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