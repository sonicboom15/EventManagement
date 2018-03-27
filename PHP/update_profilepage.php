<?php
    //This page is used to do the processing after clicking on update button and updates the tabel through update query for user table'
    require_once 'user.php';
    $name=$_POST['name'];
    $reg_no=$_POST['reg_no'];
    $dob=$_POST['dob'];
    $college_name=$_POST['college_name'];
    $dept_id=$_POST['dept_id'];
    $user_id=$_POST['user_id'];
   // $AOI=$_POST['AOI'];
    //$phone_no = $_POST['phone_no'];
    //$password=$_POST['password'];
    $email = $_POST['email'];
   
 
   // $username = $_POST['username'];
        
      $userObject = new User();
    
    //Registration
    
    // if(!empty($phone_no) && !empty($password) && !empty($email) && !empty($name) && !empty($reg_no) && !empty($college_name) && !empty($Year) &&!empty($AOI) && !empty($dob)){
        
        
        $json_registration = $userObject->updateProfile($user_id,$email,$name,$reg_no,$college_name,$dob,$dept_id);
        
        echo json_encode($json_registration);
        
    //}
    
   
    ?>