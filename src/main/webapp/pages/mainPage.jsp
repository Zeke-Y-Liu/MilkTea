<%@ page language="java" isThreadSafe="true" pageEncoding="utf8"%>
<%@ page import="com.youzan.easyranking.util.Constants"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
<meta content="yes" name="apple-mobile-web-app-capable">
<meta content="black" name="apple-mobile-web-app-status-bar-style">
<meta content="telephone=no" name="format-detection">
<title>奶茶妹妹评选</title>
<link rel="stylesheet" href="./css/touchboss.css">
<script type="text/javascript" src="./jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="./jquery/jquery.masonry.min.js"></script>
<script src="./jweixin/jweixin-1.0.0.js"></script>
<style>
.listpage {
	height: 40px;
	line-height: 40px;
	text-align: center;
}

.listpage a {
	padding: 8px;
	border: 1px solid rgb(226, 131, 151);
	color: rgb(245, 100, 100);
}

.listpage .curr {
	background-color: rgb(226, 131, 151);
	padding: 8px;
	color: white;
}
</style>
</head>
<body>
<form id="mainForm" name="mainForm" action="" method="post">
<div style="background-color:rgb(254,245,246);color:white;line-height:20px;padding:5px;">
<header>
	<div class="m_head clearfix">
		<img src="./images/title.jpg">
		<div class="num_box" style="background: rgb(226, 131, 151)">
			<a href="javascript:void(0)" onclick="goToRegister()" class="join_us" style="color: white; background: rgb(226, 171, 191)">我要报名</a>
			<ul class="num_box_ul">
				<li><span class="text" style="color: white;">已报名</span><span style="color: white;"><s:property value='pageView.TotalCandidateCount' /></span></li>
				<li><span class="text" style="color: white;">投票人次</span><span style="color: white;"><s:property value='pageView.TotalVoteCount' /></span></li>
				<li><span class="text" style="color: white;">访问量</span> <span style="color: white;"><s:property value='pageView.TotalVisitorCount' /></span></li>
			</ul>
			<img src="./images/mw_004.jpg" />
		</div>
		<div style="background-color:rgb(226,131,151)" class="search">
			<div class="search_con">
				<div class="btn"><input type="button" onclick="searchCandidate()" style="background: rgb(226,171,191); border-bottom:none;" id="searchBtn" value="搜索"/></div>
    			<div class="text_box"><input type="text" id="searchText" value="" name="searchText" placeholder="搜姓名或编号" autocomplete="off"/></div>
			</div>
		</div>
	</div>
</header>
<section class="rules">
<div class="text"><span class="prize">活动介绍：</span></div>
<li style="color: rgb(245,100,100);"><br>
&nbsp &nbsp &nbsp &nbsp 2015年第二季“奶茶妹妹”评选活动，由“有茶出沫”冠名，将“带着茶包去旅行”定为活动主题，
深度畅游斯里兰卡为奖励，吸引一批携带“放轻松，爱生活”基因的女性，通过参加活动，把这一理念传播给周围的朋友及群体，
让更多忙碌的社会人可以感受到“放轻松，爱生活”带来的一种态度，放慢忙碌的脚步，停下来歇一歇，让内心驻一个休息驿站，Chill-out~!
<br><br>
别忘了呼朋唤友拿起手机投上一票，奶茶妹妹投票，开始了！<br><br>
<font style="font-size: 20px;">请各位网友公平公正参加活动，切勿采用刷票等恶意竞争手段，一经发现，直接取消参赛资格 ！</font>
</li>
</div>
</section> 
<section class="content" id="get_info" data-rid="503" data-sort="" data-kw="" data-page="">
<div class="text_a clearfix" id="sort">
<a id="newestCandidate" onClick="switchTab(this)" href="#" onClick="activeTab()" class="active" style="background:rgb(226,131,151)">最新参赛</a>
<a id="awardsLink" onClick="switchTab(this)" href="#awards" style="background:rgb(224,171,191)">奖&nbsp;项</a>
<a id="ruleLink" onClick="switchTab(this)" href="#rule" style="background:rgb(224,171,191)">投票规则</a>
</div>
<div class="blank20"></div>
<div id="pageCon" class="match_page masonry" style="padding-bottom: 50px;">
<ul class="list_box masonry clearfix" style="position: relative; height: 2365px;">
<s:iterator value='pagination.pageList' status='stat'>
  <s:if test="#stat.odd ==true"> 
	<s:if test="#stat.last ==true">
	<li class="picCon masonry-brick" style="position: absolute; top: <s:property value='#stat.index*388'/>px; left: 0px;">
    <div>
       <i class="number" style="background:rgb(226,131,151);"><s:property value='pagination.pageList[#stat.index].id'/>号</i>
	   <a href="javascript:void(0)" onClick="voteCandidate('<s:property value='pagination.pageList[#stat.index].id'/>')" class="img"><img src="<s:property value='showImageFilePath'/><s:property value='pagination.pageList[#stat.index].imageFileName' />" style="border-color: red;"></a>
       <div class="clearfix" style="background: rgb(226,131,151);">
       	<p style="background: rgb(226,131,151);"><s:property value='pagination.pageList[#stat.index].candidateName'/><br><s:property value='pagination.pageList[#stat.index].poll'/>票</p>
        <a href="javascript:void(0)" onClick="voteCandidate('<s:property value='pagination.pageList[#stat.index].id'/>')" class="vote" style="background:rgb(224,171,191);"><span style="position:relative;left:-13px;">简介</span><br><img style="width: 30px;position:relative;top:-33px;left:40px;" src="./images/z2.png"></a>
       </div>
      </div>
     </li>
	</s:if>
	<s:else>
	<li class="picCon masonry-brick" style="position: absolute; top: <s:property value='#stat.index*388'/>px; left: 0px;">
      <div>
       <i class="number" style="background:rgb(226,131,151);"><s:property value='pagination.pageList[#stat.index].id'/>号</i>
	   <a href="javascript:void(0)" onClick="voteCandidate('<s:property value='pagination.pageList[#stat.index].id'/>')" class="img"><img src="<s:property value='showImageFilePath'/><s:property value='pagination.pageList[#stat.index].imageFileName' />" style="border-color: red;"></a>
       <div class="clearfix" style="background: rgb(226,131,151);">
       	<p style="background: rgb(226,131,151);"><s:property value='pagination.pageList[#stat.index].candidateName'/><br><s:property value='pagination.pageList[#stat.index].poll'/>票</p>
        <a href="javascript:void(0)" onClick="voteCandidate('<s:property value='pagination.pageList[#stat.index].id'/>')" class="vote" style="background:rgb(224,171,191);"><span style="position:relative;left:-13px;">简介</span><br><img style="width: 30px;position:relative;top:-33px;left:40px;" src="./images/z2.png"></a>
       </div>
     </div>
    </li>
    <li class="picCon masonry-brick" style="position: absolute; top: <s:property value='#stat.index*388'/>px; left: 304px;">
    <div>
     <i class="number" style="background:rgb(226,131,151);"><s:property value='pagination.pageList[#stat.index+1].id'/>号</i>
	   <a href="javascript:void(0)" onClick="voteCandidate('<s:property value='pagination.pageList[#stat.index+1].id'/>')" class="img"><img src="<s:property value='showImageFilePath'/><s:property value='pagination.pageList[#stat.index+1].imageFileName' />" style="border-color: red;"></a>
       <div class="clearfix" style="background: rgb(226,131,151);">
       	<p style="background: rgb(226,131,151);"><s:property value='pagination.pageList[#stat.index+1].candidateName'/><br><s:property value='pagination.pageList[#stat.index+1].poll'/>票</p>
        <a href="javascript:void(0)" onClick="voteCandidate('<s:property value='pagination.pageList[#stat.index+1].id'/>')" class="vote" style="background:rgb(224,171,191);"><span style="position:relative;left:-13px;">简介</span><br><img style="width: 30px;position:relative;top:-33px;left:40px;" src="./images/z2.png"></a>
       </div>
	</div>
    </li>
	</s:else>
	</s:if>
</s:iterator>
</ul>
</div>
<div class="listpage mar10">

<s:bean name="org.apache.struts2.util.Counter" id="counter">
<s:param name="first" value="1" />
<s:param name="last" value="pagination.totalPageCount" />
<s:iterator status='stat'>
<a href="javascript:void(0)" <s:if test="#stat.index == pagination.currentPageNum">class="curr"</s:if><s:else>onClick="goToPage('<s:property value='#stat.index'/>')"</s:else>><s:property value='#stat.index+1'/></a>
</s:iterator>
</s:bean>
</div>
</section>
<%@ include file="/pages/notice.jsp" %>
<input type="hidden" id="function" name="function" value=""/>
<input type="hidden" id="action" name="action" value=""/>
<input type="hidden" id="currentPageNum" name="pagination.currentPageNum" value="<s:property value='pagination.currentPageNum'/>"/>
<input type="hidden" id="candidateId" name="candidateId" value="" />
</form>
<script type="text/javascript">
function searchCandidate() {
	$("#mainForm").attr("action","<%=Constants.WEB_CONTEXT_ROOT%>/main.action");
	$("#function").val("<%=Constants.FUNCTION_MANAGE_CANDIDATE%>");	
	$("#action").val("<%=Constants.ACTION_SEARCH_CANDIDATE%>");
	$("#candidateId").remove();
	$("#currentPageNum").val('0');
	$("#mainForm").submit();
}
function goToRegister() {
	$("#mainForm").attr("action","<%=Constants.WEB_CONTEXT_ROOT%>/candidate.action");
	$("#function").val("<%=Constants.FUNCTION_MANAGE_CANDIDATE%>");	
	$("#action").val("<%=Constants.ACTION_ENTRY%>");
	$("#candidateId").remove();
	$("#currentPageNum").remove();
	$("#searchText").remove();
	$("#mainForm").submit();
}
function voteCandidate(candidateId) {
	$("#mainForm").attr("action","<%=Constants.WEB_CONTEXT_ROOT%>/voteCandidate.action");
	$("#function").val("<%=Constants.FUNCTION_VOTE%>");	
	$("#action").val("<%=Constants.ACTION_VOTE%>");
	$("#candidateId").val(candidateId);
	$("#searchText").remove();
	$("#currentPageNum").remove();
	$("#mainForm").submit();
}

function switchTab(link) {
	$("#newestCandidate").attr("class","");
	$("#newestCandidate").attr("style","background:rgb(224,171,191)");
	$("#awardsLink").attr("class","");
	$("#awardsLink").attr("style","background:rgb(224,171,191)");
	$("#ruleLink").attr("class","");
	$("#ruleLink").attr("style","background:rgb(224,171,191)");
	$("#"+link.id).attr("style","");
	$("#"+link.id).attr("class","active");
}

function goToPage(pageNum) {
	$("#mainForm").attr("action","<%=Constants.WEB_CONTEXT_ROOT%>/main.action");
	$("#function").val("<%=Constants.FUNCTION_MANAGE_CANDIDATE%>");	
	$("#action").val("<%=Constants.ACTION_SPECIFIED_PAGE%>");
	$("#currentPageNum").val(pageNum);
	$("#candidateId").remove();
	$("#mainForm").submit();
}

$(function(){
	var $container = $('#pageCon ul');
	$container.imagesLoaded(function(){
		$container.masonry({ itemSelector: '.picCon' });
	});
});
wx.config({
    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    appId: 'wxc98e2c600062a34b', // 必填，公众号的唯一标识
    timestamp:1444658646 , // 必填，生成签名的时间戳
    nonceStr: 'ajuh5mjerudcqrjy', // 必填，生成签名的随机串
    signature: '679f502cc399fd4e133dba21af065f4f824ff593',// 必填，签名，见附录1
    jsApiList: ['onMenuShareTimeline','onMenuShareAppMessage','chooseImage','uploadImage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
});
var wxInfo = {
	titleToFriend:'谁能当选奶茶妹妹？投她一票！',
	titleToArea:'评选开始了！奶茶妹妹都在这！',
	descToFriend:'评选开始了！',
	link: './mainRank.html',
    imgUrl: './images/title.jpg'
}
var setShareToFriend = function(){
	//分享给朋友
	wx.onMenuShareAppMessage({
		title:wxInfo.titleToFriend,
		desc: '奶茶妹妹评选开始了！',
		link: wxInfo.link,
		imgUrl: wxInfo.imgUrl,
		success: function (res) {}, 
		cancel: function (res) {},
		fail: function (res) {}});
}
var setShareToArea = function(){
	//分享到朋友圈
	wx.onMenuShareTimeline({
		title: wxInfo.titleToArea,
		link: wxInfo.link,
		imgUrl: wxInfo.imgUrl,
		success: function (res) {},
		cancel: function (res) {},
		fail: function (res) {}});	
}
wx.ready(function () { 
  setShareToFriend();
	setShareToArea();
});
</script>
</body>
</html>