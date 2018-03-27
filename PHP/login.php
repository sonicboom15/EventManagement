<?php
//this page is used for login purpose by enering username[phone_no] and password.For both admin and user.Returns previliges for admin and user and user details (email,name user id, username<phone no>, privilege    
    require_once 'user.php';
    
    $phone_no = "";
    
    $password = "";
    
   
    
    if(isset($_POST['phone_no']) && isset($_POST['password'])){
        
        $phone_no = $_POST['phone_no'];
         $password = $_POST['password'];
        
    }
    
    $userObject = new User();
    
    if(!empty($phone_no) && !empty($password) ){
        
        $hashed_password = md5($password);
        
        $json_array = $userObject->loginUsers($phone_no, $hashed_password);
        echo json_encode($json_array);
    }
    ?>