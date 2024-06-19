<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>受注管理メニュー画面</title>
</head>
<body style="background: linear-gradient(45deg, #e6e6fa, #afaffa);">
	<h1 style="text-align: center;">受注管理システム</h1>
	<hr
		style="text-align: center; height: 5px; background-color: black; width: 100%;">
	<p style="text-align: center; font-size: 24px;">メニュー</p>
	<hr
		style="text-align: center; height: 2px; background-color: black; width: 100%;">
	<div style="margin-bottom: 200px;">
		<table
			style="text-align: center; margin: auto; border: 0; padding-top: 40px; padding-bottom: 40px;">
			<tr>
				<td><a style="padding-bottom: 20px; font-size: 20px;"
					href="<%=request.getContextPath()%>/view/list.jsp">【受注状況一覧】</a></td>
			</tr>
			<tr>
				<td><a style="padding-bottom: 20px; font-size: 20px;"
					href="<%=request.getContextPath()%>/view/uniformList.jsp">【商品一覧】</a></td>
			</tr>
			<tr>
				<td><a style="padding-bottom: 20px; font-size: 20px;"
					href="<%=request.getContextPath()%>/view/insert.jsp">【商品登録】</a></td>
			</tr>
		</table>
		<table style="margin: auto; text-align: center; padding-bottom: 40px;">
			<tr>
				<td>
				<td><a style="padding-bottom: 20px; font-size: 20px;"
					href="<%=request.getContextPath()%>/view/login.jsp">【ログアウト】</a></td>
			</tr>
		</table>
	</div>
	<hr
		style="text-align: center; height: 5px; background-color: black; width: 100%;">
	<table
		style="margin: auto; border: 0; width: 100%; text-align: center;">
		<tr>
			<td align="left">copyright (c) 2024 all rights reserved.</td>
		</tr>
	</table>
</body>
</html>