<%@ page language="java" isThreadSafe="true" pageEncoding="utf8" %>  
<%@ page contentType="text/html; charset=UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;" charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>奶茶妹妹</title>
<!-- Bootstrap -->
<link href="./bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link href="./css/main.css" type="text/css" rel="stylesheet" />
<link href="./bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="./datetimepicker/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" type="text/css" media="screen">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
	<table border="1">
		<thead><tr><td>排名</td><td>候选人</td><td>点赞数</td></tr></thead>
		<tbody>
		<s:iterator value='candidateList' status='stat' var='item'>
			<tr>
				<td><s:property value='#stat.index+1' /></td>
				<td><img width="50px" height="50px" src="<s:property value='showImageFilePath'/><s:property value='imageFileName' /> "/><s:property value='candidateName' /></td>
				<td><s:property value='poll' /></td>
			</tr>
		</s:iterator>
	 </tbody>
	</table>
</body>
</html>