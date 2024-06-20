<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>お届け先確認画面</title>
</head>
<body style="background: linear-gradient(45deg, #ffff00, #ffccff);">
	<h1 style="text-align: center;">受注管理システム</h1>
	<hr
		style="text-align: center; height: 5px; background-color: black; width: 100%;">
	<table style="margin: auto; width: 1300px;">
		<tr>
			<A style="text-align: left" href="<%=request.getContextPath()%>/view/cart.jsp">カート確認画面へ戻る</A>
		</tr>
		<tr>
			<td><h2 style="margin: auto; text-align: center;">お届け先確認</h2></td>
		</tr>
	</table>
	<hr
		style="text-align: center; height: 2px; background-color: black; width: 100%;"></hr>
	<div>
		<table
			style="margin: auto; text-align: center; padding-top: 20px; padding-bottom: 20px;">
			<tr style="font-size: 22px;">
				<td>お届け先の情報を入力してください</td>
			</tr>
		</table>
		<form action="<%=request.getContextPath()%>/view/buyConfirm.jsp">
			<table style="margin: 0 auto">
				<tr>
					<th style="background-color: #bbbbbb; width: 150">氏名</th>
					<td style="background-color: #eeeeee; width: 240"><input type=text size="30" name="name"></input></td>
				</tr>
				<tr>
					<th style="background-color: #bbbbbb; width: 150">mail</th>
					<td style="background-color: #eeeeee; width: 240"><input type=text size="30" name="email"></input></td>
				</tr>
				<tr>
					<th style="background-color: #bbbbbb; width: 150">住所</th>
					<td style="background-color: #eeeeee; width: 240"><input type=text size="30" name="address"></input></td>
					<br>
				</tr>
				<tr>
					<th style="background-color: #bbbbbb; width: 150">備考欄</th>
					<td style="background-color: #eeeeee; width: 240"><input type=text size="30" name="comment"></input></td>
					<br>
				</tr>
				<tr>

				</tr>
			</table>

			<input
				style="margin: 0 auto" type="submit" value="確定">
			</input>

		</form>
	</div>
</body>
</html>