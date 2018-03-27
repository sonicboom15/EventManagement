
<?php
//This page is used to do the processing after clicking on update button and updates the tabel through update query forevent table'    
    require_once 'event.php';
    if(isset($_POST['submit'])){
    $event_time=$_POST['event_time'];
    $event_id=$_POST['event_id'];
    $event_name=$_POST['event_name'];
    $event_startDate=$_POST['event_startDate'];
    $event_endDate=$_POST['event_endDate'];
    $event_desc = $_POST['event_desc'];
    $date_of_displayingpost=$_POST['date_of_displayingpost'];
    $category_id=$_POST['category_id'];
    $venue_adr=$_POST['venue_adr'];
   
$image_dir="uploads/event_img/";
$image_file=$image_dir.date("d-m-Y")."-".time()."_".basename($_FILES["event_pic"]["name"]);
$imgOk=1;
$imageType=pathinfo($image_file,PATHINFO_EXTENSION);
//$image_size = $_FILES['event_pic']['size']; 

// Allow certain image formats
if($imageType!="jpeg" && $imageType!="JPEG" && $imageType!="JPG" && $imageType!="jpg" && $imageType!="png" && $imageType!="PNG"){
     echo 'Upload must be an image. Please upload *.jpg or *.png file';
    $imgOk=0; 
}    

// Check file size
if($_FILES['event_pic']['size'] > 3000000) {
    echo 'Image cannot be more than 3 MB.';
    $imgOk=0;
}

if($imgOk==1){
    
   
             if((move_uploaded_file($_FILES["event_pic"]["tmp_name"],$image_file))){
                 // $username = $_POST['username'];
           // echo "uploaded";
      $eventObject = new Event();
       
        $json_registration = $eventObject->updateEvent($event_name,$image_file,$event_startDate,$event_endDate,$event_time,$event_desc,$category_id,$date_of_displayingpost,$venue_adr,$event_id);
        
        echo json_encode($json_registration);
        
    
                  
                }
                else{
                               echo 'Unsuccessfull Upload.Try Again.';

        }
       
}

 
   
    
   }
   else
    die("Unable to connect");
    
    
    ?>