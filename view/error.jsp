<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>エラー画面</title>
</head>
<body style="background: linear-gradient(45deg, #e6e6fa, #afaffa);">
<h1 style="text-align: center;">受注管理システム</h1>
	<hr style="text-align: center; height: 5px; background-color: black; width: 100%;"></hr>
<div style="margin: auto; text-align: center;">
		<table style="margin: auto; text-align: center;">
			<tr><td style="padding-top: 10px; padding-bottom: 10px;"><font size="4">●●エラー●●</font></td></tr><br>
			<tr><td style="padding-top: 10px; padding-bottom: 10px;"><font size="4">※エラー内容</font></td></tr>
			<tr><td>[<a href="<%=request.getContextPath()%>">一覧に戻る</a>]</td></tr>
		</table>
</div>
<div style="padding-bottom: 400px;">
</div>
<hr style="text-align: center; height: 5px; background-color: black; width: 100%;">
	<table style="margin: auto; border: 0; width: 100%; text-align: center;">
		<tr>
			<td align="left">copyright (c) 2024 all rights reserved.</td>
		</tr>
	</table>
</body>
</html>