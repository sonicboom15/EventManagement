<?php
    include_once ('php/db-connect.php');
    class User{
        private $db;
        private $db_table = "user_table";
        public function __construct(){
            $this->db = new DbConnect();
        }
        // Login start
        public function isLoginExist($phone_no, $password){
            $query = "select * from ".$this->db_table." where phone_no = '$phone_no' AND password = '$password' Limit 1";
            $result = mysqli_query($this->db->getDb(), $query);
            if(mysqli_num_rows($result) > 0){                
                return true;                
            }            
            //mysqli_close($this->db->getDb());            
            return false;            
        }
        public function getSomeUserDetails($user_id)
        {
          $query="SELECT email,name,reg_no,college_name,dob,dept_id from ".$this->db_table." where user_id='$user_id'";
             $result = mysqli_query($this->db->getDb(), $query);
            $details=array();
             while($row =mysqli_fetch_assoc($result))
            {
                $details[] = $row;
            }
            return $details ;
        }
        public function updateProfile($user_id,$email,$name,$reg_no,$college_name,$dob,$dept_id)
        {
             $query =  "UPDATE ".$this->db_table." SET `email`='$email',`name`='$name',`reg_no`='$reg_no',`college_name`='$college_name',`dob`='$dob',`dept_id`='$dept_id',`updatedAt`=NOW() WHERE user_id='$user_id'";               
                   // echo $query;
                $inserted = mysqli_query($this->db->getDb(), $query);
                if($inserted == 1){
                    $json['success'] = 1;
                    $json['message'] = "Successfully updated the profile";
                }else{                    
                    $json['success'] = 0;
                    $json['message'] = "Error in updating the profile";                    
                }
                return $json;                
                mysqli_close($this->db->getDb());
        }
       /*public function changepassword($hashed_password)
        {
            $query="update from user_table set password=".$hashed_password "where user_id=".7;
            $result = mysqli_query($this->db->getDb(), $query);
        }*/
        //public function manageAccount($phone_no,$email,$name)
       // {
         //   $query="update from user_table set phone_no,email,name where user_id=".7;
     //         }
        public function getUserDetails($phone_no)
        {
            $query = "select prev_id,name,email_id,id from ".$this->db_table." where phone_no = '$phone_no' ";            
             $result = mysqli_query($this->db->getDb(), $query);
             $row=mysqli_fetch_array($result);
            return $row;            
            mysqli_close($this->db->getDb());        
     }
        public function loginUsers($phone_no, $password){            
            $json = array();            
            $canUserLogin = $this->isLoginExist($phone_no, $password);
            $row= $this->getUserDetails($phone_no);   
            $privilege_id=$row['prev_id'];
            $name=$row['name'];
            $email=$row['email_id'];
            $user_id=$row['id'];
            if($canUserLogin){                
                $json['success'] = 1;
                $json['message'] = "Successfully logged in";
                $json['username']= $phone_no;
                $json['privilege'] = $privilege_id;
                $json['name']=$name;
                $json['email']=$email;
                $json['user_id']=$user_id;                
            }else{
                $json['success'] = 0;
                $json['message'] = "Incorrect details";
            }
            return $json;
        }    
        // Login ends and signup starts
    public function isEmailUsernameExist($phone_no, $email){            
            $query = "select * from ".$this->db_table." where phone_no = '$phone_no' OR email = '$email'";            
            $result = mysqli_query($this->db->getDb(), $query);            
            if(mysqli_num_rows($result) >= 1){                
                mysqli_close($this->db->getDb());                
                return false;                
            }            
            //echo $query;
        return true;            
    }
       // public function manageAccount($phone_no,$email,$name)
       // {
       //     $user=json_decode($json,true);

       //     $manage="update user_table set phone_no,email,name where=".$user['user_id'];
       // }
        public function changePassword($hashed_password,$user_id)
        {
            $query="UPDATE ".$this->db_table." SET password='$hashed_password' where user_id='$user_id'";
             $inserted = mysqli_query($this->db->getDb(), $query);
                if($inserted == 1){
                    $json['success'] = 1;
                    $json['message'] = "Successfully password updated.";
                }else{
                    $json['success'] = 0;
                    $json['message'] = "Error in updating the password";
                }
                return $json;
                mysqli_close($this->db->getDb());
         }
        public function isValidEmail($email){
            return filter_var($email, FILTER_VALIDATE_EMAIL) !== false;
        }
        public function createNewRegisterUser($phone_no, $password, $email,$name,$reg_no,$dob,$aoi,$address){
            $isExisting = $this->isEmailUsernameExist($phone_no, $email);
            if(false){
                
                $json['success'] = 0;
                $json['message'] = "Error in registering. Probably the phone number already exists";
            } 
            
            else{
                
            $isValid = $this->isValidEmail($email);
                
                if($isValid)
                {
                $privilege_id=0;
                $query = "insert into ".$this->db_table." (`phone_no`, `email_id`, `name`, `reg_no`, `dob`, `prev_id`, `address`, `password`,`aoi`, `created_at`) VALUES ('$phone_no','$email','$name','$reg_no','$dob','$privilege_id','$address' ,'$password','$aoi', NOW())";
              
                // echo $query;
                $inserted = mysqli_query($this->db->getDb(), $query);
                
                if($inserted == 1){
                    $json['success'] = 1;
                    $json['message'] = "Successfully registered the user";
                    
                }else{
                    
                    $json['success'] = 0;
                    $json['message'] = "Error in registering.";
                    
                }
                
                mysqli_close($this->db->getDb());
                }
                else{
                    $json['success'] = 0;
                    $json['message'] = "Error in registering. Email Address is not valid";

                
                }
                
            }
            
            return $json;
            
        }
        // signup ends and eventpage starts

        public function getUserId($phone_no)
        {
            $sql="select user_id from user_table where phone_no=".$phone_no;
            $result = mysqli_query($this->db->getDb(), $sql);
            $row=mysqli_fetch_array($result);
            $userId=$row['user_id'];
            return $userId;
        }
        public function details($id){
            $sql = "select * from user_table where id=".$id;
            $result = mysqli_query($this->db->getDb(), $sql);
            $row=mysqli_fetch_array($result);
            $json['name']=$row['name'];
            $json['email']=$row['email'];
            $json['dob']=$row['dob'];
            $json['reg']=$row['reg'];
            $json['phno']=$row['phno'];
            $json['address'] = $row['phno'];
            return $json;
        }
    }
?>