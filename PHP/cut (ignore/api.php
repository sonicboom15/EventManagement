<?php 

	require_once 'DbConnect.php';
	
	$response = array();
	
	/*if(isset($_GET['apicall'])){
		
		switch($_GET['apicall']){
			
			case 'signup':*/
				if(isTheseParametersAvailable(array('name','reg_no','dob','college_name','dept','year','AOI','phone_no','pswd','email_id'))){
					 $Name=$_POST['name'];
  					  $reg_no=$_POST['reg_no'];
  					  $DOB=$_POST['dob'];
   					 $CollegeName=$_POST['college_name'];
   					 $dept=$_POST['dept'];
   					 $Year=$_POST['year'];
   					 $AOI=$_POST['AOI'];
   					 $phone_no = $_POST['phone_no'];
   					 $password=$_POST['pswd'];
   					 $email = $_POST['email_id'];
   					 $userObject = new User();
    
    //Registration
    
    // if(!empty($phone_no) && !empty($password) && !empty($email) && !empty($Name) && !empty($reg_no) && !empty($CollegeName) && !empty($Year) &&!empty($AOI) && !empty($DOB)){
        
        $hashed_password = md5($password);
        
        $json_registration = $userObject->createNewRegisterUser($phone_no, $hashed_password, $email,$Name,$reg_no,$CollegeName,$Year,$AOI,$DOB,$dept);
        
        echo json_encode($json_registration);
        
					
					/*$stmt = $conn->prepare("SELECT id FROM users WHERE phone_no = ? OR email = ?");
					$stmt->bind_param("ss", $username, $email);
					$stmt->execute();
					$stmt->store_result();
					
					if($stmt->num_rows > 0){
						$response['error'] = true;
						$response['message'] = 'User already registered';
						$stmt->close();
					}else{
						$stmt = $conn->prepare("INSERT INTO users (username, email, password, gender) VALUES (?, ?, ?, ?)");
						$stmt->bind_param("ssss", $username, $email, $password, $gender);

						if($stmt->execute()){
							$stmt = $conn->prepare("SELECT id, id, username, email, gender FROM users WHERE username = ?"); 
							$stmt->bind_param("s",$username);
							$stmt->execute();
							$stmt->bind_result($userid, $id, $username, $email, $gender);
							$stmt->fetch();
							
							$user = array(
								'id'=>$id, 
								'username'=>$username, 
								'email'=>$email,
								'gender'=>$gender
							);
							
							$stmt->close();
							
							$response['error'] = false; 
							$response['message'] = 'User registered successfully'; 
							$response['user'] = $user; 
						}
					}
					
				}else{
					$response['error'] = true; 
					$response['message'] = 'required parameters are not available'; 
				}
				
			break; */
			
			case 'login':
				
				if(isTheseParametersAvailable(array('phone_no', 'pswd'))){
					
					$username = $_POST['username'];
					$password = md5($_POST['password']); 
					
					$stmt = $conn->prepare("SELECT id, username, email, gender FROM users WHERE username = ? AND password = ?");
					$stmt->bind_param("ss",$username, $password);
					
					$stmt->execute();
					
					$stmt->store_result();
					
					if($stmt->num_rows > 0){
						
						$stmt->bind_result($id, $username, $email, $gender);
						$stmt->fetch();
						
						$user = array(
							'id'=>$id, 
							'username'=>$username, 
							'email'=>$email,
							'gender'=>$gender
						);
						
						$response['error'] = false; 
						$response['message'] = 'Login successfull'; 
						$response['user'] = $user; 
					0


				}else{
						$response['error'] = false; 
						$response['message'] = 'Invalid username or password';
					}
				}
			break; 
			
			default: 
				$response['error'] = true; 
				$response['message'] = 'Invalid Operation Called';
		}
		
	}else{
		$response['error'] = true; 
		$response['message'] = 'Invalid API Call';
	}
	
	echo json_encode($response);
	
	function isTheseParametersAvailable($params){
		
		foreach($params as $param){
			if(!isset($_POST[$param])){
			      return false; 
			}
		}
		return true; 
	}