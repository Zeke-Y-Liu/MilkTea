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
<form name="welcome" id="welcome" action="<%=Constants.WEB_CONTEXT_ROOT%>/main.action" method="post">
<input type="hidden" name="openId" value='<%=request.getParameter("openid")%>'>
</form>
<script type="text/javascript">
$("#welcome").submit();
</script>
</body>
</html>