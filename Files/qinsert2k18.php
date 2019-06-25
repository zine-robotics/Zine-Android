<?php

include 'host2k18.php';

 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);
 
 $college_id = $_POST['College_ID'];
 $name = $_POST['Name'];
 $number = $_POST['Mobile_Number'];
 $query = $_POST['Query'];
 
 
 $Sql_Query = "insert into query2k18 (College_ID,Name,Mobile_Number,Query) values ('$college_id','$name','$number','$query')";
 if(mysqli_query($con,$Sql_Query)){
    echo ' Successful';
 
 }
 else{
 
 echo ' Unsuccessful';
 
 }

 mysqli_close($con);
?>