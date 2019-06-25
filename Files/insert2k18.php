<?php

include 'host2k18.php';

 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);

 $college_id = $_POST['College_ID'];
 $name = $_POST['Name'];
 $number = $_POST['Mobile_Number'];
 $email = $_POST['Email_ID'];
 $hosteller = $_POST['Hosteller'];
 $branch = $_POST['Branch'];

 
 $Sql_Query = "insert into vishal_kothari (cid,name,hos,email,mno,branch) values ('$college_id','$name','$hosteller','$email','$number','$branch')";
 
 if(mysqli_query($conn,$Sql_Query)){
    $id=mysqli_insert_id($con);
    echo "Registration Successful with ID : ".$id;
    /*echo "Registrations will start from August 15 ";*/
 
 }
 else{
 $query="SELECT id FROM vishal_kothari WHERE cid='$college_id'";
 if(mysqli_query($conn,$query))
 {
 $result=mysqli_query($con,$query);
 $result=mysqli_fetch_array($result);
 $display=$result[0];
 echo "User Already Registerd with ID : ".$display;
	/*echo "Registrations will start from August 15";*/
 }
 else
 {
 echo "Registrations Closed";
 }
 
 }

 mysqli_close($con);
?>