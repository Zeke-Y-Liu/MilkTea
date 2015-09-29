<%@ page import="com.youzan.easyranking.util.Constants" %>
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
    <form action="<%=Constants.WEB_CONTEXT_ROOT%>/register.action?function=register&action=save" method="post" enctype="multipart/form-data" class="form-horizontal" role="form">
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">姓名</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" name="candidateName" placeholder="姓名" maxlength="15" data-required data-errortext="请输入姓名"/>
            </div>
        </div>
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">联系方式</label>
            <div class="col-xs-9">
            	<input type="text" class="form-control" name="phoneNumber" placeholder="手机" data-pattern="^1[358]\d{9}$|^(\d{4}-?)?\d{7,8}$" data-errortext="请输入正确的手机或固话" maxlength="11" />
            </div>
        </div>
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">工作</label>
            <div class="col-xs-9"><input type="text" class="form-control" name="job" placeholder="工作"  maxlength="200">
            </div>
        </div>
        <div class="best-padding ziwei-form form-group">
          <label class="label-padding col-xs-3">年龄</label>
          <div class="col-xs-9">
              <input type="text" class="form-control" name="age" placeholder="请输入年龄" data-pattern="^\d{n,}$" data-required data-errortext="请输入正确的身高" maxlength="3" />
          </div>
      	</div>
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">性别</label>
            <div class="col-xs-9"><select name="gender"><option value="F">女</option><option value="M">男</option></select></div>
        </div>
        <div class="best-padding ziwei-form form-group">
          <label class="label-padding col-xs-3">身高 CM</label>
          <div class="col-xs-9">
              <input type="text" class="form-control" name="height" placeholder="请输入身高" data-pattern="^\d{n,}$" data-errortext="请输入正确的身高" maxlength="3" />
          </div>
      	</div>
      	<div class="best-padding ziwei-form form-group">
          <label class="label-padding col-xs-3">参赛宣言</label>
          <div class="col-xs-9">
              <textarea rows="3" cols="20" class="form-control" name="selfRemark" placeholder="请输入宣言" maxlength="200"></textarea>
          </div>
      	</div>
        <div class="best-padding ziwei-form form-group">
		<label class="label-padding col-xs-3">图片秀</label>
		<div class="col-xs-9"><input type="file" class="form-control" name="image" style="pending-top:10"/></div>
		</div>
        <br>
        <div class="ziwei-padding form-group">
            <button class="ziwei-btn btn btn-block" type="submit">提交</button>
        </div>
    </form>
</div>	
<script type="text/javascript" src="jquery/1.9.1/jquery.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="./bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>