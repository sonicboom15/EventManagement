<?php
    //This page is used to return the values of event requested to be updated.. based on this json the front end form will be prefilled so that the update process can be done
    require_once 'event.php';
    if(isset($_POST['submit'])){
   // $event_id=$_POST['event_id'];
    $event_id=$_POST['event_id'];
    
      $eventObject = new Event();

        
        
        $event_details=$eventObject->getSomeEventDetails($event_id);
       
        
        echo json_encode($event_details,JSON_UNESCAPED_SLASHES);
   
    }
    
    
    ?>