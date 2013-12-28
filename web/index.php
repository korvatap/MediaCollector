<html>
    <head>
        <title>MediaCollector</title>
    </head>
    <body>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="post">
    Title: <input type="text" name="title"> <br>
    Language: <input type="text" name="language"> <br>
    Publish Year: <input type="text" name="publishYear"> <br>
    Rating: <input type="text" name="rating"> <br>
    Genre: <input type="text" name="genre"> <br>
    <input type="submit" name="submit1" value="Add">
    </form>
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
    
    echo "<br/><br/>";
    
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
    $masterDb = $fp->readDbFile();
    
    echo "From .dat file: <br/>";
    $masterDb->info();
    
    echo "<br/><br/>";
    echo "From .dat file with added movie: <br/>";
    
    $movie2 = new Movie("MacGyver: Lost Treasure of Atlantis", "English", 1994, 5, "Adventure");
    $masterDb->add($movie2);
    
    $fp->writeToFile($masterDb);
    $masterDb = $fp->readDbFile();
    $masterDb->info();
    
    $masterDb->remove($movie2);
    
    echo "<br/><br/>";
    echo "From .dat file with one movie removed: <br/>";
    $fp->writeToFile($masterDb);
    $masterDb = $fp->readDbFile();
    $masterDb->info();
    
    /*if (isset($_POST["submit1"])) {
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
    }*/
    
    function validateInput($input) {
        $input = htmlspecialchars($input);
        return $input;
    }
    
    ?>
    </body>
</html>