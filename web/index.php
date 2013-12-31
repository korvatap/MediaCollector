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

    $fp = new FileParser();

    global $linkchoice;
    $masterDb = $fp->readDbFile();

    if($masterDb != null) {
    } 
    else {
       $masterDb = new MediaObject();
       $fp->writeToFile($masterDb);
    }
    

    function showMovie($masterDb) {

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
        echo "</table>";

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
        echo "</table>";

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
        echo "</table>";
    }

    function showManual() {
        echo "<h2>Add media instructions</h2>"
            ."<p id='teksti'><br> - Media can be added using the Add button in the main window."
            ."<br> - After this a window will open and there you have to fill the fields with information you want. <br>"
            ." - The next button in the add window will create new row to the table which enables you to add<br> multiple medias in a fast way in to the database."
            ."<br>- The Add button in the Add window finally then adds the new medias in to the database.<br> - This is supposed to be pressed when the information for the media has been inserted in to the table."
            ."<br>- The cancel button just cancels the new media adding feature and no information is saved to the database.</p>";
            
        echo "<h2>How to delete media </h2><br>"
                ."<p id='teksti'>- You can delete media by ticking the select column of the corresponding media you want to delete.<br>"
                ."- After this you just press delete button and the media will be deleted if you choose to confirm the removal of the media.</p>";
                
        echo "<h2>How to modify media</h2><br>"
                ."<p id='teksti'>- To be able to modify media you first have to select the media you want to modify."
				."<br>- This can be achieved by ticking the select column of the target media to be modified.<br>"
                ."- After this you just press the modify button and a new window will open.<br>"
                ."- In the new window you have a table with the media information you selected.<br>"
                ."- Now you can modify the media information straight from the table and after that pressing save to save the media.<br>"
                ."- Cancel button is to cancel the procedure and no modifications to the media will be saved.</p>";
                
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
            //showMovie($masterDb);

    } 
    
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
        
        header('Location: index.php?link=Movie');
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
        header('Location: index.php?link=Movie');

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