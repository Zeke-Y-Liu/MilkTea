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
<li><span class="text" style="color: rgb(226,131,151);">已报名</span><span style="color: rgb(226,131,151);">564</span></li>
<li><span class="text" style="color: rgb(226,131,151);">投票人次</span><span style="color: rgb(226,131,151);">144269</span></li>
<li><span class="text" style="color: rgb(226,131,151);">访问量</span><span style="color: rgb(226,131,151);">401550</span></li>
</ul>
</div>
</div>
</header>
<div class="apply" style="background: rgb(254,245,246);">
<p style="color: rgb(226,131,151);">报名处</p>
<div class="blank10"></div>
<form action="" method="post" id="su">
<input type="hidden" name="pic" id="pic">
<dl class="clearfix"><dt style="color: rgb(226,131,151);">姓名:</dt>
<dd><input type="text" class="input_txt" id="name" value="" name="name" placeholder="请输入姓名"></dd>
</dl>
<dl class="clearfix"><dt style="color: rgb(226,131,151);">年龄:</dt><dd>
<input type="number" class="input_txt" value="" name="age" id="age" placeholder="请输入您的年龄"></dd>
</dl>
<dl class="clearfix"><dt style="color: rgb(226,131,151);">电话:</dt><dd>
<input type="number" class="input_txt" value="" name="tel" id="tel" placeholder="请输入您的真实电话"></dd>
</dl>
<dl class="clearfix"><dt style="color: rgb(226,131,151);">身高:</dt>
<dd><input type="text" class="input_txt" id="high" value="" name="high" placeholder="请输入身高"></dd>
</dl>
<dl class="upload clearfix"><dt style="color: rgb(226,131,151);">上传照片<br>(最大2M):</dt>
<dd class="upload_area clearfix" style="width: 50%;">
<ul id="imglist" class="post_imglist">
<li id="listimg"></li></ul>
<div id="show" style="float: left;"></div>
<div class="upload_btn" style="float: left;" id="chooseImage" onclick="ajaxFileUpload()">
</div>
</dd>
</dl>
<dl class="clearfix">
<dt style="color: rgb(226,131,151);">拉票宣言 :</dt>
<dd>
<textarea class="textarea" placeholder="一句话简绍自己,限制140字以内" name="intro" id="intro"></textarea>
</dd>
</dl>
<div style="color: red;">凡是发布涉及政治军事题材、淫秽、色情、有违公德的不健康内容、赌博、暴力、凶杀、恐怖或教唆犯罪、宣扬邪教和封建迷信、诽谤他人等有害社会的内容，我们将直接删除内容、取消参赛资格并采用严厉手段追究法律责任。</div>
<br>
<input type="submit" id="sss" style="display: none;">
<div class="btn_box">
<input type="button" class="button" value="确认报名" id="submit" style="background: rgb(224,102,122);"></div>
<div class="btn_box" style="margin-top:20px;">
<input type="button" class="button" value="返回主页面，查看投票情况" style="background: rgb(226,131,151);border-bottom:0;" onclick="location.href=&#39;./mainRank.html&#39;"></div><div class="blank10"></div>
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
<script src="./jweixin/jweixin-1.0.0.js"></script><script type="text/javascript">
function ajaxFileUpload() {
		showMessage(true, '上传中...');
		$.ajaxFileUpload({
				url:'http://www.afeel.net/image.html',
				secureuri:false,
				fileElementId:'fileToUpload',
				dataType: 'json',
				type:'post',
				data:{encrypts:'MjQ5NWxZUmRqVE1MSUN4WGlTcWdON0VuVWZPM3FZbkNId0Ixckx0K1hXMUp5anJxNzAzMkVSOHdEbkxCTWlCdGFrZ1ZHOE1kaEJvd1VUMnFObm9GZkFaT0N6Mng5TXBsSFJmczVNN0hzNXZORWh2cQ@3D@3D', 'PHPSESSID':'kun757ba1itvj1lg9f4b224940'},
				success: function (data) {
					showMessage(false);
					if(data.flg < 1) {
						alert(data.msg);
					} else {
						$('#listimg').html('<img src="'+data.msg.imgsrc+data.msg.filepath+'" style="width:48px;height:48px;" />');
						$('#att_id').attr('value', data.msg.att_id);
						$('#filepath').attr('value', data.msg.filepath);
					}
				},
				error: function (data, status, e) {
					showMessage(false);
					alert('error('+e+')');
				}
			});
}

function subs() {
  var name = $('#name').val();
	var tel = $('#tel').val();
	var intro = $('#intro').val();
  var high = $('#high').val();
  var age = $('#age').val();

	if(name == '') {
		alert('请输入称呼！');
		return false;
	}
	if(tel == '') {
		alert('请输入电话！');
		return false;
	}
 if(high == '') {
		alert('请输入身高！');
		return false;
	}
  if(age == '') {
		alert('请输入年龄！');
		return false;
	}
	if(intro == '') {
		alert('请输入宣言！');
		return false;
	}
    if(intro.length > 140) {
		alert('我与小店字数不能超过140字');
		return false;
	}
    return true;	
}
wx.config({
    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    appId: 'wxc98e2c600062a34b', // 必填，公众号的唯一标识
    timestamp:1444658646 , // 必填，生成签名的时间戳
    nonceStr: 'ajuh5mjerudcqrjy', // 必填，生成签名的随机串
    signature: 'ef94446f554187de295a351e9de86af0b5b9413c',// 必填，签名，见附录1
    jsApiList: ['onMenuShareTimeline','onMenuShareAppMessage','chooseImage','uploadImage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
});

var wxInfo = {
	titleToFriend:'谁能当选奶茶妹妹？投她一票！',
	titleToArea:'评选开始了！奶茶妹妹都在这！',
	descToFriend:'奶茶妹妹评选开始了！',
	link: './mainRank.html',
    imgUrl: './images/title1.jpg'
}
var setShareToFriend = function(){
	//分享给朋友
	wx.onMenuShareAppMessage({
		title:wxInfo.titleToFriend,
		desc: wxInfo.descToFriend,
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
wx.ready(function(){
     var images = {
    localId: [],
    serverId: []
  };
document.querySelector('#chooseImage').onclick = function () {
    wx.chooseImage({
      success: function (res) {
            if(res.localIds.length>1){
                alert('只能上传一张图片');
                return false;
            }
            $("#show").html('');
            for(var i=0;i<res.localIds.length;i++){
                $("#show").append('<img style="width:50px;height:50px;margin:10px;display:inline" src="'+res.localIds[i]+'" id="show" />');
            }
        images.localId = res.localIds;
      }
    });
  };
   // 5.3 上传图片
  document.querySelector('#submit').onclick = function () {
     var bj= subs();
     if(!bj){
        return false;
     }
    if (images.localId.length == 0) {
      alert('请先上传图片');
      return;
    }
    var i = 0, length = images.localId.length;str='';
    images.serverId = [];
    function upload() {
      wx.uploadImage({
        localId: images.localId[i],
        success: function (res) {
          i++;
          images.serverId.push(res.serverId);
          str= res.serverId;
          if (i < length) {
            upload();
            return ;
          }
          $("#pic").val(str);
          $('#sss').click();
        },
        fail: function (res) {
          alert(JSON.stringify(res));
        }
      });
    }
    upload();
  };
setShareToFriend();
setShareToArea();
})
</script>
</body>
</html>