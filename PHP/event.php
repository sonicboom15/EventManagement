<?php
    // file 
    include_once ('php/db-connect.php');

    class Event{
        
        private $db;
        
        private $db_table = "event_table";
        
        public function __construct(){
            $this->db = new DbConnect();
        }
        public function getSomeEventDetails($event_id)
        {
          $query="SELECT event_name,event_startdate, event_enddate,event_time,date_of_displayingpost,event_pic,event_desc,venue_addr,category_id from ".$this->db_table." where event_id='$event_id'";
             $result = mysqli_query($this->db->getDb(), $query);
            $details=array();
             while($row =mysqli_fetch_assoc($result))
            {
                $details[] = $row;
            }
            return $details ;
        }
       
        // signup ends and eventpage starts

        public function getUserId($phone_no)
        {
            $sql="select user_id from user_table where phone_no=".$phone_no;
            //echo $sql;
            $result = mysqli_query($this->db->getDb(), $sql);
            $row=mysqli_fetch_array($result);
            $userId=$row['user_id'];
            return $userId;
        }
        public function getEventDetails()
        {
            $query="SELECT event_id, event_name,event_startdate, event_enddate,event_time,event_pic,event_desc,venue_addr,category_id from ".$this->db_table." where status_id=3";
           // echo $query;
             $result = mysqli_query($this->db->getDb(), $query);
            $details=array();
             while($row =mysqli_fetch_assoc($result))
            {
                $details[] = $row;
            }
            return $details ;
        }
     //  public function updateEvent($phone_no, $event_name, $event_startDate,$event_endDate,$event_desc,$date_of_displayingpost,$category_id,$venue_adr)
     //  {
     //   $update="update event_table set phone_no,event_name,event_startDate,event_endDate,event_desc,date_of_displayingpost,category_id,venue_adr where event_id=".
      // }

      // public function deleteEvent()
      // {
      //  $delete="delete  from event_table where event_id=".
      // }
        public function createNewEvent($event_name,$image_file,$event_startdate,$event_enddate,$event_time,$event_desc,$category_id,$date_of_displayingpost,$venue_addr,$user_id)
        {
                $query = "insert into ".$this->db_table." ( `user_id`, `event_name`, `event_startdate`, `event_enddate`,`event_time`, `event_pic`, `event_desc`, `date_of_displayingpost`, `status_id`, `venue_addr`, `category_id`) VALUES ('$user_id','$event_name','$event_startdate','$event_enddate','$event_time','$image_file','$event_desc','$date_of_displayingpost
                ','1' ,'$venue_addr', '$category_id')";
                    //echo $query;
                $inserted = mysqli_query($this->db->getDb(), $query);
                if($inserted == 1){
                    $json['success'] = 1;
                    $json['message'] = "Successfully registered the event.Wait for the admin's approval";
                   // $json['event_name']=$event_name;
                   // $json['event_startdate']=$event_startdate;
                   // $json['event_enddate']=$event_enddate;
                   // $json['image_file']=$image_file;
                   // $json['venue_addr']=$venue_addr;
                   // $json['event_desc']=$event_desc;
                }else{
                    
                    $json['success'] = 0;
                    $json['message'] = "Error in registering the event";
                    
                }

                return $json;
                
                mysqli_close($this->db->getDb());
        }
        public function updateEvent($event_name,$image_file,$event_startdate,$event_enddate,$event_time,$event_desc,$category_id,$date_of_displayingpost,$venue_addr,$event_id)
        {
                $query =  "UPDATE ".$this->db_table." SET `event_name`='$event_name',`event_startdate`='$event_startdate',`event_enddate`='$event_enddate',`event_time`='$event_time',`event_pic`='$image_file',`event_desc`='$event_desc',`date_of_displayingpost`='$date_of_displayingpost',`venue_addr`='$venue_addr',`category_id`='$category_id' WHERE event_id='$event_id'";
               
                    //echo $query;
                $inserted = mysqli_query($this->db->getDb(), $query);
                if($inserted == 1){
                    $json['success'] = 1;
                    $json['message'] = "Successfully updated the event";
                }else{
                    
                    $json['success'] = 0;
                    $json['message'] = "Error in updating the event";
                    
                }

                return $json;
                
                mysqli_close($this->db->getDb());
        }
        public function deleteEvent($event_id)
        {
          $query =  "UPDATE ".$this->db_table." SET `status_id`=5 WHERE event_id='$event_id'";
               
                    //echo $query;
                $inserted = mysqli_query($this->db->getDb(), $query);
                if($inserted == 1){
                    $json['success'] = 1;
                    $json['message'] = "Successfully deleted the event";
                }else{
                    
                    $json['success'] = 0;
                    $json['message'] = "Error in deleting the event";
                    
                }

                return $json;
                
                mysqli_close($this->db->getDb());
        }
        
    }
?>