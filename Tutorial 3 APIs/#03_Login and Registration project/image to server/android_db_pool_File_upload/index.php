<?php
session_start();
$conn=mysqli_connect("localhost","root","");
mysqli_select_db($conn,"android_db");

  if(isset($_GET['add']))
   {
	   $name=$_POST['t1'];
	   $design=$_POST['t2'];	   
	   
	   if($_FILES['upload'])
	    {
			$on=$_FILES['upload']['name']; //img name
			$sn=$_FILES['upload']['tmp_name'];	//path		
			$dn="images/".$on; //destination
			move_uploaded_file($sn,$dn);
			
			$qry="INSERT INTO `tbl_staff` (`id`, `name`, `desig`, `image`)
			      VALUES (NULL, '$name', '$design', '$on')";
			$res=mysqli_query($conn,$qry);
			
			if($res==true)
			 $_SESSION['msg']="File Uploaded Successfully";
			else
			 $_SESSION['msg']="Could not upload File";
			 
			 header("location:".$_SERVER['PHP_SELF']);
			 exit();
			 
		}
   }

?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>File Upload</title>
</head>
<body>
<center>
<table border="1">
<form name="frm" action="<?php echo $_SERVER['PHP_SELF'];?>?add=333" method="post" enctype="multipart/form-data">
   <tr>
   <td>Enter Your Name</td>
   <td><input type="text" name="t1"></td>
   </tr>

   <tr>
   <td>Enter Your Name</td>
   <td><input type="text" name="t2"></td>
   </tr>

   <tr>
   <td>Enter Your Name</td>
   <td><input type="file" name="upload" /></td>
   </tr>

   <tr>
     <td colspan="2" align="center">
      <input type="submit" value="Upload" />
     </td>
   </tr>
</form>   
</table>
<?php
if(isset($_SESSION['msg']))
 {
	 echo $_SESSION['msg'];
	 unset($_SESSION['msg']);
 }
?>
</center>
</body>
</html>