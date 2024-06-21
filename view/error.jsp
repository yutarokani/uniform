<%@page contentType="text/html; charset=UTF-8"%>

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
					size="4">※エラー内容</font></td>
			</tr>
			<tr>
				<td>[<a href="<%=request.getContextPath()%>">一覧に戻る</a>]
				</td>
			</tr>
		</table>
	</div>
	<div style="padding-bottom: 400px;"></div>
	<%@include file="/common/footer.jsp" %>
</body>
</html>