<%@page contentType="text/html; charset=UTF-8"%>

<%
String error = (String)request.getAttribute("error");
if(error == null){
	error = "";
}

String cmd = (String)request.getAttribute("cmd");
if(cmd == null){
	cmd = "buy";
}
%>

<html>
<head>
<title>エラー画面</title>
</head>
<body style = "background: linear-gradient(45deg, #e6e6fa, #afaffa)">
	<%@include file="/common/header.jsp" %>
	<div style="margin: auto; text-align: center;">
		<table style="margin: auto; text-align: center;">
			<tr>
				<td style="padding-top: 10px; padding-bottom: 10px;"><font
					size="4">●●エラー●●</font></td>
			</tr>
			<br>
			<tr>
				<td style="padding-top: 10px; padding-bottom: 10px;"><font
					size="4"><%= error %></font></td>
			</tr>
			<%
			if(cmd.equals("buy")){
			%>
				<tr><td>[<a href="<%=request.getContextPath()%>/view/buy.jsp">購入画面に戻る</a>]</td></tr>
			<%
			}else if(cmd.equals("confirm")){
			%>
				<tr><td>[<a href="<%=request.getContextPath()%>/view/customer.jsp">お届け先入力画面に戻る</a>]</td></tr>
			<%
			}else if(cmd.equals("logout")){
			%>
				<tr><td>[<a href="<%=request.getContextPath()%>/logout">ログイン画面に戻る</a>]</td></tr>
			<%
			}else if(cmd.equals("menu")){
			%>
				<tr><td>[<a href="<%=request.getContextPath()%>/view/menu.jsp">管理者メニューに戻る</a>]</td></tr>
			<%
			}else if(cmd.equals("insert")){
			%>
				<tr><td>[<a href="<%=request.getContextPath()%>/view/insert.jsp">商品登録画面に戻る</a>]</td></tr>
			<%
			}else if(cmd.equals("list")){
			%>
				<tr><td>[<a href="<%=request.getContextPath()%>/list">受注一覧画面に戻る</a>]</td></tr>
			<%
			}
			%>
		</table>
	</div>
	<div style="padding-bottom: 400px;"></div>
	<%@include file="/common/footer.jsp" %>
</body>
</html>
