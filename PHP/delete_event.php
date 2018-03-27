<?php
    //This page is used to delete the event based on event id .. It makes the status_id=5 which has a status of deleted
    require_once 'event.php';
    // if(isset($_POST['submit'])){
   // $event_id=$_POST['event_id'];
    $event_id=$_GET['event_id'];
    
      $eventObject = new Event();

        
        
        $details=$eventObject->deleteEvent($event_id);
       
        
        echo json_encode($details);
   
    //}
    
    
    ?>