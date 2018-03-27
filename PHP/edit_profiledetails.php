<?php
    //This page is used to return the values of user profile requested to be updated.. based on this json the front end form will be prefilled so that the update process can be done
    require_once 'user.php';
    if(isset($_POST['submit'])){
   // $event_id=$_POST['event_id'];
    $user_id=$_POST['user_id'];
    
      $userObject = new User();

        
        
        $user_details=$userObject->getSomeUserDetails($user_id);
       
        
        echo json_encode($user_details,JSON_UNESCAPED_SLASHES);
   
    }
    
    ?>