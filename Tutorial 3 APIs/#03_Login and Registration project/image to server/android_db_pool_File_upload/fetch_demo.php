<?php
$conn=mysql_connect("localhost","root","");
mysql_select_db("android_db",$conn);

$qry="select * from tbl_user";
$raw=mysql_query($qry);
while($res=mysql_fetch_array($raw))
{
	$data[]=$res;
}
print(json_encode($data));
?>