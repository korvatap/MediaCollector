<html>
    <head>
        <title>MediaCollector</title>
    </head>
    <body>
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
    $mObject->add($tv);
    
    $mObject->info();*/
    
    //$fp = new FileParser();
    //$fp->readFile();
    
    echo "<br/><br/>";
    
    $db = new DatabaseCreator(new FileParser());
    $db->createDatabases();
    $db->info();
    
    ?>
    </body>
</html>