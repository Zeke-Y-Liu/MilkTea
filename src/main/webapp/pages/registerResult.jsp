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
    <link href="./css/main.css" type="text/css" rel="stylesheet"/>
    <link href="./bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="./datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" media="screen" > 
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
	<body>
	<div class="ziwei-padding container">
    <form action="#" method="post" enctype="multipart/form-data" class="form-horizontal" role="form">
    	<div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">参选人数</label>
            <div class="col-xs-9"><s:property value='totalCandidateCount'/></div>
        </div>
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">姓名</label>
            <div class="col-xs-9"><s:property value='candidateName'/></div>
        </div>
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">联系方式</label>
            <div class="col-xs-9"><s:property value='phoneNumber'/></div>
        </div>
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">工作</label>
            <div class="col-xs-9"><s:property value='job'/></div>
        </div>
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">年龄</label>
            <div class="col-xs-9"><s:property value='age'/></div>
        </div>
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">性别</label>
            <div class="col-xs-9"><s:property value='genderDesc'/></div>
        </div>
        <div class="best-padding ziwei-form form-group">
          <label class="label-padding col-xs-3">身高 CM</label>
          <div class="col-xs-9"><s:property value='height'/></div>
      	</div>
      	<div class="best-padding ziwei-form form-group">
          <label class="label-padding col-xs-3">参赛宣言</label>
          <div class="col-xs-9"><s:property value='selfRemark'/></div>
      	</div>
        <div class="best-padding ziwei-form form-group">
			<label class="label-padding col-xs-3">图片秀</label>
			<div class="col-xs-9"><img src="<s:property value='showImageFile'/>"/></div>
		</div>
		<input type="hidden" name="id" value="<s:property value='id'/>" />
    </form>
</div>
</body>
</html>