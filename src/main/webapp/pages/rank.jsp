<%@page import="com.youzan.easyranking.util.Constants"%>
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
</head>
<body>
	<table border="1">
		<s:iterator value='pagination.pageList' status='stat'>
		<s:if test="#stat.odd ==true"> 
		<tr>
			<s:if test="#stat.last ==true">
				<td colSpan="2"><img width="150px" height="150px" src="<s:property value='showImageFilePath'/><s:property value='pagination.pageList[#stat.index].imageFileName' /> "/></td>
				<td colSpan="2" style="visibility: hidden" />
			</s:if>
			<s:else>
				<td colSpan="2"><img width="150px" height="150px" src="<s:property value='showImageFilePath'/><s:property value='pagination.pageList[#stat.index].imageFileName' /> "/></td>
				<td colSpan="2"><img width="150px" height="150px" src="<s:property value='showImageFilePath'/><s:property value='pagination.pageList[#stat.index+1].imageFileName' /> "/></td>
			</s:else>				
		</tr>
		<tr>
			<s:if test="#stat.last ==true">
				<td><s:property value='pagination.pageList[#stat.index].candidateName' /></td><td id='<s:property value='pagination.pageList[#stat.index].id'/>'><s:property value='pagination.pageList[#stat.index].poll'/></td>
				<td style="visibility: hidden"/><td style="visibility: hidden"/>
			</s:if>
			<s:else>
				<td><s:property value='pagination.pageList[#stat.index].candidateName' /></td><td id='<s:property value='pagination.pageList[#stat.index].id'/>'><s:property value='pagination.pageList[#stat.index].poll' /></td>
				<td><s:property value='pagination.pageList[#stat.index+1].candidateName' /></td><td id='<s:property value='pagination.pageList[#stat.index+1].id'/>'><s:property value='pagination.pageList[#stat.index+1].poll' /></td>
			</s:else>
		</tr>
		<tr>
			<s:if test="#stat.last==true">
				<td colSpan="2"  align="center"><button type="button" onClick="vote('<s:property value='pagination.pageList[#stat.index].id'/>')">投票</button></td>
				<td colSpan="2" style="visibility: hidden" />
			</s:if>
			<s:else>
			<td colSpan="2" align="center"><button type="button" onClick="vote('<s:property value='pagination.pageList[#stat.index].id'/>')">投票</button></td>
			<td colSpan="2" align="center"><button type="button" onClick="vote('<s:property value='pagination.pageList[#stat.index+1].id'/>')">投票</button></td>
			</s:else>
		</tr>
		<tr><td colSpan="4" style="visibility: hidden" height="10px">&nbsp;</td>
		</s:if>
		</s:iterator>
        <tr><td><button type="button" <s:if test="pagination.firstPage">disabled</s:if> onClick="gotoPage('<%=Constants.ACTION_PREVIOUS%>')">上一页</button></td>
		<td colSpan="2"><button type="button" onClick="gotoPage('<%=Constants.ACTION_VIEW_VOTE_RESULT%>')">查看投票结果</button></td>
		<td><button type="button" <s:if test="pagination.lastPage">disabled</s:if> onClick="gotoPage('<%=Constants.ACTION_NEXT%>')">下一页</button></td>
		</tr>
	</table>
	<form id="rankForm" name="rankForm" action="<%=Constants.WEB_CONTEXT_ROOT%>/rank.action" method="post">
		<input type="hidden" id="currentPageNum" name="pagination.currentPageNum" value="<s:property value='pagination.currentPageNum'/>" />
		<input type="hidden" id="function" name="function" value="<%=Constants.FUNCTION_VOTE%>"/>
        <input type="hidden" id="action" name="action" value=""/>
	</form>
<script type="text/javascript" src="jquery/1.9.1/jquery.min.js" charset="UTF-8"></script>
<script type="text/javascript">
function vote(id) {  
    $.ajax({  
        url  : "<%=Constants.WEB_CONTEXT_ROOT%>/vote.action?function=<%=Constants.FUNCTION_VOTE%>&action=<%=Constants.ACTION_VOTE%>",  
        type : "GET",  
        data : "candidateId=" + id, 
        success : function(data, textStatus) {
            $('#' + id).html(data["poll"]);
        }  
    });
}
function gotoPage(action) {
	$('#action').val(action);	
	$("#rankForm").submit();
}
</script>
</body>
</html>
