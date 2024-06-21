<%@page contentType="text/html; charset=UTF-8"%>

<%
String message = (String) request.getAttribute("message");
//クッキーの取得
Cookie[] userCookie = request.getCookies();

//ユーザーを管理する変数
String user = "";
//パスワードを管理する変数
String pass = "";

if (userCookie != null) {
	for(int i = 0; i < userCookie.length; i++) {
		// クッキーからユーザー情報の取得
		if (userCookie[i].getName().equals("user")) {
			user = userCookie[i].getValue();
		}
		// クッキーからパスワード情報の取得
		if (userCookie[i].getName().equals("password")) {
			pass = userCookie[i].getValue();
		}
	}
}
%>

<html>
<head>
<title>ログイン画面</title>
<%@include file="/common/header.jsp" %>
</head>
<body style = "background: linear-gradient(45deg, #e6e6fa, #afaffa)">
	<table style="margin: auto; width: 1300px;">
		<tr>
			<td style="text-align: left; width: 100px;">[<a
				href="<%=request.getContextPath()%>/view/buy.jsp">購入画面へ</a>]
			</td>
			<td><h2 style="padding-left: 470px;">ログイン画面</h2></td>
		</tr>
	</table>
	<hr
		style="text-align: center; height: 2px; background-color: black; width: 100%">
	<div style="margin-top: 60px; margin-bottom: 270px">
	<table style="margin: auto; border: 0;">
		<form action="<%=request.getContextPath()%>/login" method="post">
			<table style="margin: auto; border: 0;">
				<tr>
					<td
						style="text-align: center; background-color: #BBBBBB; width: 100">ユーザーID</td>
					<td><input type=text size="30" name="user"></input></td>
				</tr>
				<tr>
					<td
						style="text-align: center; background-color: #BBBBBB; width: 100">パスワード</td>
					<td><input type=password size="30" name="password"></input></td>
				</tr>
				<%
					if (message != null) {
				%>
				<table style="margin: auto; color: red">
				<td>
					<p><%= message %></p>
				</td>
				<%
				}
				%>
			</table>
			<table style="margin: auto; margin-top: 60px">
				<tr>
					<td colspan=4 style="text-align: center"><input type=submit
						value="ログイン"></input></td>
				</tr>
			</table>
		</form>
	</div>
	<%@include file="/common/footer.jsp" %>
</body>
</html>