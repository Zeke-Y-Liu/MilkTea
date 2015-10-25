<%@ page language="java" isThreadSafe="true" pageEncoding="utf8"%>
<%@ page import="com.youzan.easyranking.util.Constants"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="./jquery/jquery-1.10.2.min.js"></script>
</head>
<body>
<%
String openId = request.getParameter("openid")== null? "" : (String)request.getParameter("openid").trim();
System.out.println("openid=" + request.getParameter("openid"));
String ipAddr = request.getRemoteAddr();
session.setAttribute(Constants.ATTRIBUTE_OPEN_ID, openId);
session.setAttribute(Constants.ATTRIBUTE_IP_ADDR, ipAddr);
response.sendRedirect(Constants.WEB_CONTEXT_ROOT + "/login.action");
%>
</body>
</html>