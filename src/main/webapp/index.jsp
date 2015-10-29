<%@ page language="java" isThreadSafe="true" pageEncoding="utf8"%>
<%@ page import="com.youzan.easyranking.util.Constants"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="./jquery/jquery-1.10.2.min.js"></script>
</head>
<body>
<%
System.out.println("index.jsp openid=" + request.getParameter("openid"));
%>
<form id="loginForm" name="loginForm" action="<%=Constants.WEB_CONTEXT_ROOT%>/login.action" method="post">
<input type="hidden" id="openId" name="openId" value="<%= request.getParameter("openid")== null? "" : (String)request.getParameter("openid").trim()%>" />
<input type="hidden" id="ipAddr" name="ipAddr" value="<%= request.getRemoteAddr()%>"/>
</form>
<script type="text/javascript">
$("#loginForm").submit();
</script>
</body>
</html>