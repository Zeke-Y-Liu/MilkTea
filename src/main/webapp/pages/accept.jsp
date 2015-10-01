<%@ page language="java" isThreadSafe="true" pageEncoding="utf8" %>
<%@ page import="com.youzan.easyranking.util.Constants" %>
<%@ page contentType="text/html; charset=UTF-8" %>
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
    <link href="./bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="./css/main.css" type="text/css" rel="stylesheet"/>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="ziwei-padding container">
    <div class="best-padding ziwei-form form-group bast-font">
        <%@ include file="/pages/ruleBody.html" %>
        <form action="<%=Constants.WEB_CONTEXT_ROOT%>/register.action" method="post" class="form-horizontal">
            <input type="submit" value="我现在就要参加！" class="ziwei-btn btn btn-block"/>
             <input type="hidden" name="function" value="<%=Constants.FUNCTION_REGISTER%>"/>
        	<input type="hidden" name="action" value="<%=Constants.ACTION_ENTRY%>"/>
        </form>
    </div>
</div>
</body>
</html>