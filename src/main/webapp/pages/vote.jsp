<%@ page language="java" isThreadSafe="true" pageEncoding="utf8"%>
<%@ page import="com.youzan.easyranking.util.Constants"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=no" name="format-detection">
<title>Its me，正在奶茶妹妹评选</title>
<link rel="stylesheet" href="./css/touchboss.css">
<script type="text/javascript" src="./jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="./jquery/jquery.masonry.min.js"></script>
<script src="./jweixin/jweixin-1.0.0.js"></script>
<script src="./jquery/jquery.slides.min.js"></script>
<style type="text/css">
#home-slides{margin:0 auto;}
#home-slides .slidesjs-container{width:auto;height:auto;overflow:hidden}
#home-slides .slidesjs-container img{width:100%}
#home-slides .slidesjs-pagination{width:100%;height:2px;background:#d4d4d4}
#home-slides .slidesjs-pagination li{float:left}
#home-slides .slidesjs-pagination a{display:block;height:2px;text-indent:-999em}
#home-slides .slidesjs-pagination a.active{background:#ffd200}
</style>
</head>
<body>
<form id="voteForm" name="voteForm" action="" method="post">
<div id="show" style="width: 100%;height:100%;color:white;display:none;position:fixed;background:url(./images/share.png);z-index:1008;background-size:100% 100%;"></div>
<div class="m_head clearfix">
<img src="./images/title.jpg">
<section class="content" id="get_info">
<div class="detial_box">
<span class="closed close_detial_box" data-refer="">&nbsp;</span>
<p class="num clearfix">
<span class="fl" id="baby_info">252号&nbsp;<s:property value='candidate.candidateName'/></span>
<span id="poll" class="fr"><s:property value='candidate.poll'/>票</span></p>
<div class="blank10"></div><p>年龄: <s:property value='candidate.age'/></p>
<div class="blank10"></div><p>身高：<s:property value='candidate.height'/></p>
<div class="blank10"></div><p>拉票宣言：<s:property value='candidate.selfRemark'/></p>
<div class="blank10"></div><div style="position: relative;">
<img src="<s:property value='showImageFilePath'/><s:property value='candidate.imageFileName'/>"></div>
</div><div class="blank10"></div>
<div class="abtn_box">
<a href="javascript:void(0)" onclick="return vote1(this);" id="vote" class="a_btn toupiao vote"  data-itid="10389" style="background:rgb(224,102,122);">我要投票</a>
<a href="javascript:void(0)" onClick="goToRegister()" class="a_btn look">我也要参与</a>
<a href="javascript:void(0)" onClick="goToMainPage()" class="a_btn look">返回主页面，查看投票情况</a>
<a href="javascript:void(0)" onClick="" class="a_btn look">为我拉票</a>
<div id="phpqrcode" class="a_btn look" style="display:none;">
</div>
</div>
</section>
</div>
<%@ include file="/pages/notice.jsp" %>
<input type="hidden" id="function" name="function" value=""/>
<input type="hidden" id="action" name="action" value=""/>
<input type="hidden" id="candidateId" name="candidateId" value="<s:property value='candidate.id'/>" />
</form>
<script type="text/javascript">
alert("HHHHHH");
function vote1(voteLink) {
	alert("AAA");
	var param = new Object();
	param["function"] = "<%=Constants.FUNCTION_VOTE%>";
	param["action"] = "<%=Constants.ACTION_VOTE%>";
	param["candidateId"] = $("#candidateId").val();
	alert("candidateId=" + $("#candidateId").val());
	$.ajax({  
		url  : "<%=Constants.WEB_CONTEXT_ROOT%>/vote.action",  
		type : "POST",  
		data : param, 
		success : function(data, textStatus) {
			alert("data[poll]" + data["poll"]);
		$('#poll').html(data["poll"] + "票");
		$("#poll").attr("style","background: rgb(224,102,122);");
		// $("#poll").attr("onClick","");
		alert("OK");
		}  
	});
}
function goToRegister() {
	$("#voteForm").attr("action","<%=Constants.WEB_CONTEXT_ROOT%>/register.action");
	$("#function").val("<%=Constants.FUNCTION_MANAGE_CANDIDATE%>");	
	$("#action").val("");
	$("#candidateId").remove();
	$("#voteForm").submit();
}
function goToMainPage() {
	$("#voteForm").attr("action","<%=Constants.WEB_CONTEXT_ROOT%>/main.action");
	$("#function").val("<%=Constants.FUNCTION_MANAGE_CANDIDATE%>");	
	$("#action").val("");
	$("#candidateId").remove();
	$("#voteForm").submit();
}
</script>
</body>
</html>