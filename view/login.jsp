<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>ログイン画面</title>
<h1 style="text-align: center;">受注管理システム</h1>
<hr style="text-align: center; height: 5px; background-color: black;">
</head>
<body style="background: linear-gradient(45deg, #e6e6fa, #afaffa);">
<h2 style="text-align: center;">ログイン画面</h2>
	<hr
		style="margin-top: 25px; text-align: center; height: 2px; background-color: black;">
	<div style="margin-top: 60px; margin-bottom: 290px">
		<form action="" method="POST">
			<table style="margin: auto; border: 0;">
				<tr>
					<td style="text-align: center; background-color: #BBBBBB; width: 100">ユーザーID</td>
					<td><input type=text size="30" name="user"></input></td>
				</tr>
				<tr>
					<td style="text-align: center; background-color: #BBBBBB; width: 100">パスワード</td>
					<td><input type=password size="30" name="password"></input></td>
				</tr>
			</table>
			<table style="margin: auto; margin-top: 60px">
				<tr>
					<td colspan=4 style="text-align: center"><input type=submit
						value="ログイン"></input></td>
				</tr>
			</table>
		</form>
	</div>
<hr style="text-align: center; height: 5px; background-color: black; width: 100%;">
	<table style="margin: auto; border: 0; width: 100%; text-align: center;">
		<tr>
			<td align="left">copyright (c) 2024 all rights reserved.</td>
		</tr>
	</table>
</body>
</html>
