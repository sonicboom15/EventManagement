<?php
    // it will display all the active(status of value 3) events in the db to the app. need to be called in the MainActivity itself at the onCreate() method so that all the events are displayed
    require_once 'event.php';
     $eventObject = new Event();        
      $event_details=$eventObject->getEventDetails();
      echo json_encode($event_details, JSON_UNESCAPED_SLASHES);
    
    
    ?>