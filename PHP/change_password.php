<?php
    //This page takes the new password as the input and calls changePassword function to update the user_table through user_id.
    require_once 'user.php';
    
    $old_password = "";
    
    $new_password = "";
    $user_id="";   
    
    if(isset($_POST['old_password']) && isset($_POST['new_password'])){
        
        $old_password = $_POST['old_password'];
         $new_password = $_POST['new_password'];
         $user_id = $_POST['user_id'];


        
    }
    
    $userObject = new User();
    
    if(!empty($old_password) && !empty($new_password) ){
        
        $hashed_password = md5($new_password);
        
        $json_array = $userObject->changePassword($hashed_password,$user_id);
        echo json_encode($json_array);
    }
    ?>