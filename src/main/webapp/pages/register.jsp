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
	<s:actionerror/>
    <form action="<%=Constants.WEB_CONTEXT_ROOT%>/candidate.action" onsubmit="return validate();" method="post" enctype="multipart/form-data" class="form-horizontal" role="form">
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">姓名</label>
            <div class="col-xs-9">
                <input type="text" class="form-control" id="candidateName" name="candidate.candidateName" value="<s:property value='candidate.candidateName'/>" placeholder="姓名" maxlength="15" data-required data-errortext="请输入姓名"/>
            </div>
        </div>
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">联系方式</label>
            <div class="col-xs-9">
            	<input type="text" class="form-control" id="phoneNumber" name="candidate.phoneNumber" value="<s:property value='candidate.phoneNumber'/>" placeholder="手机" data-pattern="^1[358]\d{9}$|^(\d{4}-?)?\d{7,8}$" data-errortext="请输入正确的手机" maxlength="11" />
            </div>
        </div>
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">工作</label>
            <div class="col-xs-9"><input type="text" class="form-control" id="job" name="candidate.job" value="<s:property value='candidate.job'/>" placeholder="工作"  maxlength="200">
            </div>
        </div>
        <div class="best-padding ziwei-form form-group">
          <label class="label-padding col-xs-3">年龄</label>
          <div class="col-xs-9">
              <input type="text" class="form-control" id="age" name="candidate.age" 
              	value="<s:if test='candidate.age > 0'><s:property value='candidate.age'/></s:if>"
              placeholder="请输入年龄" data-pattern="^\d{n,}$" data-required data-errortext="请输入正确的年龄" maxlength="2" />
          </div>
      	</div>
        <div class="best-padding ziwei-form form-group">
            <label class="label-padding col-xs-3">性别</label>
            <div class="col-xs-9"><select name="candidate.gender"><option value="F">女</option><option value="M">男</option></select></div>
        </div>
        <div class="best-padding ziwei-form form-group">
          <label class="label-padding col-xs-3">身高 CM</label>
          <div class="col-xs-9">
              <input type="text" class="form-control" id="height" name="candidate.height" 
              value="<s:if test='candidate.height > 0'><s:property value='candidate.height'/></s:if>"
              placeholder="请输入身高" data-pattern="^(([1-9][0-9][0-9]|[1-9][0-9])(\.\d)?)$" data-errortext="请输入正确的身高" maxlength="5" />
          </div>
      	</div>
      	<div class="best-padding ziwei-form form-group">
          <label class="label-padding col-xs-3">参赛宣言</label>
          <div class="col-xs-9">
              <textarea rows="3" cols="20" class="form-control" id="selfRemark" name="candidate.selfRemark" placeholder="请输入宣言" maxlength="200"><s:property value='candidate.selfRemark'/></textarea>
          </div>
      	</div>
      	<s:if test="candidate.id > 0">
		<div class="best-padding ziwei-form form-group">
		<label class="label-padding col-xs-3">图片秀</label>
		<div class="col-xs-9"><img src="<s:property value='showImageFile'/>" style="border:0; margin:0; padding:0;max-width:300px; max-height:500px;"/></div>
		</div>
		</s:if>
        <div class="best-padding ziwei-form form-group">
		<label class="label-padding col-xs-3">选择图片</label>
		<div class="col-xs-9"><input type="file" class="form-control" id="image" name="image" style="pending-top:10"/></div>
		</div>
        <br>
        <div class="ziwei-padding form-group">
            <input type="submit" class="ziwei-btn btn btn-block" value="提交"/>
        </div>
        <input type="hidden" id="candidateId" name="candidateId" value="<s:property value='candidate.id'/>" />
        <input type="hidden" id="formToken" name="formToken" value="<s:property value='formToken'/>"/>
        <input type="hidden" id="function" name="function" value="<%=Constants.FUNCTION_MANAGE_CANDIDATE%>"/>
        <s:if test="candidate.id > 0">
        	<input type="hidden" id="action" name="action" value="<%=Constants.ACTION_UPDATE%>"/>
        </s:if>
        <s:else>
        	<input type="hidden" id="action" name="action" value="<%=Constants.ACTION_SAVE%>"/>
        </s:else>
    </form>
</div>	
<script type="text/javascript" src="jquery/1.9.1/jquery.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="./bootstrap/3.3.5/js/bootstrap.min.js"></script>
   <script type="text/javascript">
	function validate() {
	var errorMsg = "";
	if($('#candidateName').val() == "" || $('#candidateName').val() == undefined) {
		errorMsg ="请填写姓名\n";
	}
	if($('#phoneNumber').val() == "" || $('#phoneNumber').val() == undefined) {
		errorMsg = errorMsg + "请填写电话号码\n";
		return false;
	} 
	var phoneRegx = new RegExp("^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$");
	if(!phoneRegx.test($('#phoneNumber').val())) {
		errorMsg = errorMsg + "请输入正确的手机\n";
	}
	var ageRegx = new RegExp("^([1-4][0-9]*)$");
	if($('#age').val() == "" || $('#age').val() == undefined || !ageRegx.test($('#age').val()) || $('#age').val() < 18 || $('#age').val()  > 49 ) {
		errorMsg = errorMsg + "请输入正确的年龄\n";
	}
	if($('#job').val() == "" || $('#job').val() == undefined) {
		errorMsg = errorMsg + "请填写工作\n";
	}
	var heightRegx = new RegExp("^(([1-9][0-9][0-9]|[1-9][0-9])(\.\d)?)$");
	if($('#height').val() == "" || $('#height').val() == undefined || !heightRegx.test($('#height').val())) {
		errorMsg = errorMsg + "请填写正确的身高,比如 160 或者 160.5\n";
	}
	if($('#selfRemark').val() == "" || $('#selfRemark').val() == undefined) {
		errorMsg = errorMsg +"请填写参赛宣言\n";
	}	
	if($('#action').val()=="<%=Constants.ACTION_SAVE%>") { // image is not required when updating
		if($('#image').val() == "" || $('#image').val() == undefined) {
			errorMsg = errorMsg + "请选择照片\n";
		}
	}
	if(errorMsg != "") {
		alert(errorMsg);
		errorMsg = "";
		return false;
	} else {
		return true;
	}
}
</script>
</body>
</html>