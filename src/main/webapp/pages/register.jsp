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
    <script type="text/javascript">
function validate() {
	alert("AAA");
	var errorMsg = "";
	if($('#candidateName').val() == "" || $('#candidateName').val() == undefined) {
		errorMsg ="请填写姓名"\n;
	}
	alert("BBBB");
	if($('#phoneNumber').val() == "" || $('#phoneNumber').val() == undefined) {
		errorMsg = errorMsg + "请填写电话号码\n";
		return false;
	} 
	var phoneRegx = new RegExp("^1[358]\d{9}$|^(\d{4}-?)?\d{7,8}$");
	if(!phoneRegx.test($('#phoneNumber').val())) {
		errorMsg = errorMsg + "请输入正确的手机或固话";
	}
	alert("DDDD");
	if($('#age').val() == "" || $('#age').val() == undefined) {
		errorMsg = errorMsg + "请填写年龄\n";
	}
	var ageRegx = new RegExp("(\d|\d\d)");
	if(!ageRegx.test($('#age').val())) {
		errorMsg = errorMsg + "请输入正确的年龄";
	}
	alert("EEEE");
	if($('#job').val() == "" || $('#job').val() == undefined) {
		errorMsg = errorMsg + "请填写工作\n";
	}
	if($('#height').val() == "" || $('#height').val() == undefined) {
		errorMsg = errorMsg + "请填写身高\n";
	}
	var heightRegx = new RegExp("(\d\d|\d\d\d)");
	if(!heightRegx.test($('#height').val())) {
		errorMsg = errorMsg + "请输入正确的身高";
	}
	alert("FFFFF");
	if($('#selfRemark').val() == "" || $('#selfRemark').val() == undefined) {
		errorMsg = errorMsg +"请填写参赛宣言\n";
	}	
	if($('#image').val() == "" || $('#image').val() == undefined) {
		errorMsg = errorMsg + "请选择照片\n";
	}
	alert("GGGG");
	if(errorMsg != "") {
		alert(errorMsg);
		return false;
	} else {
		return true;
	}
}
</script>
  </head>
	<body>
	<div class="ziwei-padding container">
	<s:actionerror/>
    <form action="<%=Constants.WEB_CONTEXT_ROOT%>/register.action?function=register&action=save" onsubmit="return validate();" method="post" enctype="multipart/form-data" class="form-horizontal" role="form">
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">姓名</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="candidateName" name="candidateName" value="<s:property value='candidateName'/>" placeholder="姓名" maxlength="15" data-required data-errortext="请输入姓名"/>
            </div>
        </div>
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">联系方式</label>
            <div class="col-xs-9">
            	<input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="<s:property value='phoneNumber'/>" placeholder="手机" data-pattern="^1[358]\d{9}$|^(\d{4}-?)?\d{7,8}$" data-errortext="请输入正确的手机或固话" maxlength="11" />
            </div>
        </div>
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">工作</label>
            <div class="col-xs-9"><input type="text" class="form-control" id="job" name="job" value="<s:property value='job'/>" placeholder="工作"  maxlength="200">
            </div>
        </div>
        <div class="best-padding ziwei-form form-group">
          <label class="label-padding col-xs-3">年龄</label>
          <div class="col-xs-9">
              <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄" data-pattern="^\d{n,}$" data-required data-errortext="请输入正确的年龄" maxlength="3" />
          </div>
      	</div>
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">性别</label>
            <div class="col-xs-9"><select name="gender"><option value="F">女</option><option value="M">男</option></select></div>
        </div>
        <div class="best-padding ziwei-form form-group">
          <label class="label-padding col-xs-3">身高 CM</label>
          <div class="col-xs-9">
              <input type="text" class="form-control" id="height" name="height" placeholder="请输入身高" data-pattern="^\d{n,}$" data-errortext="请输入正确的身高" maxlength="3" />
          </div>
      	</div>
      	<div class="best-padding ziwei-form form-group">
          <label class="label-padding col-xs-3">参赛宣言</label>
          <div class="col-xs-9">
              <textarea rows="3" cols="20" class="form-control" id="selfRemark" name="selfRemark" placeholder="请输入宣言" maxlength="200"><s:property value='selfRemark'/></textarea>
          </div>
      	</div>
        <div class="best-padding ziwei-form form-group">
		<label class="label-padding col-xs-3">图片秀</label>
		<div class="col-xs-9"><input type="file" class="form-control" id="image" name="image" style="pending-top:10"/></div>
		</div>
        <br>
        <div class="ziwei-padding form-group">
            <input type="submit" class="ziwei-btn btn btn-block" value="提交"/>
        </div>
    </form>
</div>	
<script type="text/javascript" src="jquery/1.9.1/jquery.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="./bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>