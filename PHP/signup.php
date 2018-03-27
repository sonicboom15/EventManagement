<?php
    
    require_once 'user.php';
    if(isset($_POST['name']))
        $name=$_POST['name'];
    if(isset($_POST['reg']))
        $reg=$_POST['reg'];
    if(isset($_POST['dob']))
        $dob=$_POST['dob'];
    if(isset($_POST['aoi']))
        $aoi=$_POST['aoi'];
    if(isset($_POST['address']))
        $address=$_POST['address'];
    if(isset($_POST['phno']))
        $phone_no = $_POST['phno'];
    if(isset($_POST['password']))
        $password=$_POST['password'];
    if(isset($_POST['email']))
        $email = $_POST['email'];
        
      $userObject = new User();
    
    
    if(!empty($name)&&!empty($reg)&&!empty($dob)&&!empty($aoi)&&!empty($address)&&!empty($phone_no)&&!empty($password)&&!empty($email))  { 
        $hashed_password = md5($password);
        
        $json_registration = $userObject->createNewRegisterUser($phone_no, $hashed_password, $email,$name,$reg,$dob,$aoi,$address);
        
        echo json_encode($json_registration);
        
    }
   
    ?>