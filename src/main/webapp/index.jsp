<html>
	<head>
		<title>EasyRanking</title>
	</head>
	<body>
		<table><tr><td>index</td></tr></table>
	<form action="${pageContext.request.contextPath}/candidate.action?function=candidate&action=entry" method="post">
		username:<input type="text" name="username"><br>
		password:<input type="password" name="password"><br>
		<input type="submit" value="login"><input type="reset" value="reset">
	</form>
	</body>
</html>
