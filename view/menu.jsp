<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>受注管理メニュー画面</title>
</head>
<body style="background: linear-gradient(45deg, #e6e6fa, #afaffa);">
	<%@include file="/common/header.jsp" %>
	<p style="text-align: center; font-size: 24px;">メニュー</p>
	<hr
		style="text-align: center; height: 2px; background-color: black; width: 100%;">
	<div style="margin-bottom: 200px;">
	    <form>
		<table
			style="text-align: center; margin: auto; border: 0; padding-top: 40px; padding-bottom: 40px;">
			<tr>
				<td><a style="padding-bottom: 20px; font-size: 20px;"
					href="<%=request.getContextPath()%>/list">【受注状況一覧】</a></td>
			</tr>
			<tr>
				<td><a style="padding-bottom: 20px; font-size: 20px;"
					href="<%=request.getContextPath()%>/list">【商品一覧】</a></td>
			</tr>
			<tr>
				<td><a style="padding-bottom: 20px; font-size: 20px;"
					href="<%=request.getContextPath()%>/insert">【商品登録】</a></td>
			</tr>
		</table>
		<table style="margin: auto; text-align: center; padding-bottom: 40px;">
			<tr>
				<td>
				<td><a style="padding-bottom: 20px; font-size: 20px;"
					href="<%=request.getContextPath()%>/view/login.jsp">【ログアウト】</a></td>
			</tr>
		</table>
		</form>
	</div>
	<%@include file="/common/footer.jsp" %>
</body>
</html>