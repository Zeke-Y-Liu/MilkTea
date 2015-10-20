<%@ page language="java" isThreadSafe="true" pageEncoding="utf8"%>
<%@ page import="com.youzan.easyranking.util.Constants"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<!-- saved from url=(0039)http://wxtp.19louimg.cn/boss.php/mbb/bm -->
<html xmlns="http://www.w3.org/1999/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=no" name="format-detection">
<title>奶茶妹妹评选</title>
<meta name="description" content="">
<link rel="stylesheet" href="./css/touchboss.css">
<script type="text/javascript" src="./jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="./script/ajaxfileupload.js"></script>
<script src="./jquery/jquery.form.js" type="text/javascript"></script>
<script src="./jweixin/jweixin-1.0.0.js"></script>
<style>
.popWindow{display:none;position: fixed;top: 0px;left: 0px;right:0px;bottom:0px;background-color:#9D9D9D;-moz-opacity: 0.8;opacity:0.8;z-index:900;filter: alpha(opacity=40);}
.popMessage{display:none;position:absolute;z-index:10000;border-radius:10px;margin:0 auto;border:1px solid #cad4dd;background-color:#fafafa;width:90px;height:30px;line-height:30px;text-align:center;}
</style>
</head>
<body>
<header>
<div class="m_head clearfix"><img src="./images/title.jpg">
<div class="num_box" style="color: rgb(226,131,151);background:rgb(254,245,246)">
<ul class="num_box_ul">
	<li><span class="text" style="color: rgb(226,131,151);">已报名</span><span style="color: rgb(226,131,151);"><s:property value='pageView.TotalCandidateCount' /></span></li>
	<li><span class="text" style="color: rgb(226,131,151);">投票人次</span><span style="color: rgb(226,131,151);"><s:property value='pageView.TotalVoteCount' /></span></li>
	<li><span class="text" style="color: rgb(226,131,151);">访问量</span> <span style="color: rgb(226,131,151);"><s:property value='pageView.TotalVisitorCount' /></span></li>
</ul>
</div>
</div>
</header>
<div class="apply" style="background: rgb(254,245,246);">
<s:actionerror/>
<section class="rules">
<s:actionmessage />
</section>
<p style="color: rgb(226,131,151);">报名处</p>
<div class="blank10"></div>
<form action="<%=Constants.WEB_CONTEXT_ROOT%>/candidate.action" onsubmit="return validate();" method="post" enctype="multipart/form-data">
<dl class="clearfix"><dt style="color: rgb(226,131,151);">姓名:</dt>
<dd><input type="text" class="input_txt" id="candidateName" value="<s:property value='candidate.candidateName'/>" name="candidate.candidateName" placeholder="请输入姓名"></dd>
</dl>
<dl class="clearfix"><dt style="color: rgb(226,131,151);">年龄:</dt><dd>
<input type="number" class="input_txt" value="<s:if test='candidate.age > 0'><s:property value='candidate.age'/></s:if>" name="candidate.age" id="age" placeholder="请输入您的年龄"></dd>
</dl>
<dl class="clearfix"><dt style="color: rgb(226,131,151);">电话:</dt><dd>
<input type="number" class="input_txt" value="<s:property value='candidate.phoneNumber'/>" name="candidate.phoneNumber" id="phoneNumber" placeholder="请输入您的真实电话"></dd>
</dl>
<dl class="clearfix"><dt style="color: rgb(226,131,151);">身高:</dt>
<dd><input type="text" class="input_txt" id="height" value="<s:if test='candidate.height > 0'><s:property value='candidate.height'/></s:if>" name="candidate.height" placeholder="请输入身高"></dd>
</dl>

<dl class="upload clearfix">
<dt style="color: rgb(226,131,151);">上传照片<br>(最大2M):</dt>
<dd class="upload_area clearfix" style="width: 70%;">
<input type="file" onchange="showImg(this)" class="button" id="image" name="image" style="display:none"/>
<div class="upload_btn" style="float: left;" id="chooseImage" onclick="fileUpload()"></div>
<div id="show" style="float:right; display:none"><img id="imgshow" style="width:98px;height:198px;margin:0px;display:inline" src="" /></div>
</dd>
</dl>
<dl class="clearfix">
<dt style="color: rgb(226,131,151);">拉票宣言 :</dt>
<dd>
<textarea class="textarea" placeholder="一句话简绍自己,限制140字以内" name="candidate.selfRemark" id="selfRemark"><s:property value='candidate.selfRemark'/></textarea>
</dd>
</dl>
<div style="color: red;">凡是发布涉及政治军事题材、淫秽、色情、有违公德的不健康内容、赌博、暴力、凶杀、恐怖或教唆犯罪、宣扬邪教和封建迷信、诽谤他人等有害社会的内容，我们将直接删除内容、取消参赛资格并采用严厉手段追究法律责任。</div>
<br>
<div class="btn_box">
<input type="submit" class="button" value="确认报名" id="submit" style="background: rgb(224,102,122);">
<input type="button" onclick="goToMainPage()" class="button" value="返回主页面，查看投票情况" id="submit" style="background: rgb(224,102,122);">
</div>
<div class="blank10"></div>
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
<section class="rules">
<div class="text">
<span class="prize">活动介绍：</span>
</div>
<li style="color: rgb(245,100,100);">
<br>
&nbsp &nbsp &nbsp &nbsp 2015年第二季“奶茶妹妹”评选活动，由“有茶出沫”冠名，将“带着茶包去旅行”定为活动主题，
深度畅游斯里兰卡为奖励，吸引一批携带“放轻松，爱生活”基因的女性，通过参加活动，把这一理念传播给周围的朋友及群体，
让更多忙碌的社会人可以感受到“放轻松，爱生活”带来的一种态度，放慢忙碌的脚步，停下来歇一歇，让内心驻一个休息驿站，Chill-out~!
<br><br>
别忘了呼朋唤友拿起手机投上一票，奶茶妹妹投票，开始了！<br><br>
<font style="font-size: 20px;">请各位网友公平公正参加活动，切勿采用刷票等恶意竞争手段，一经发现，直接取消参赛资格 ！</font>
</li>
</div>
</section>
<div class="popWindow"></div><div class="popMessage"></div>
<div id="console"></div>
<script src="./jweixin/jweixin-1.0.0.js"></script>
<script type="text/javascript">
function showImg(fileInput) {
	var reader = new FileReader()
    reader.onload = function(e) {
        $('#imgshow').attr("src",e.target.result);
    	$('#show').attr("style", "float:left; display:inline;");
    }
    reader.readAsDataURL(fileInput.files[0]);
}
function fileUpload() {
	$('#image').click();
}
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
	var heightRegx = new RegExp("^(([1-9][0-9][0-9]|[1-9][0-9])(\.\d)?)$");
	if($('#height').val() == "" || $('#height').val() == undefined || !heightRegx.test($('#height').val())) {
		errorMsg = errorMsg + "请填写正确的身高,比如 160 或者 160.5\n";
	}
	if($('#selfRemark').val() == "" || $('#selfRemark').val() == undefined) {
		errorMsg = errorMsg +"请填写拉票宣言\n";
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
function goToMainPage() {
	window.location = "<%=Constants.WEB_CONTEXT_ROOT%>/main.action";
}
</script>
</body>
</html>