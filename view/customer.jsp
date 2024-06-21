<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>お届け先確認画面</title>
</head>
<body style="background: linear-gradient(45deg, #ffff00, #ffccff);">
	<table style="margin: auto; width: 1300px;">
		<tr>
			<td><h2 style="margin: auto; text-align: center;">お届け先確認</h2></td>
		</tr>
		<tr>
			<td><A style="text-align: left" href="<%=request.getContextPath()%>/view/cart.jsp">カート確認画面へ戻る</A></td>
		</tr>
	</table>
	<hr
		style="text-align: center; height: 2px; background-color: black; width: 100%;"></hr>
	<div>
		<table
			style="margin: auto; text-align: center; padding-top: 40px; padding-bottom: 30px;">
			<tr style="font-size: 22px;">
				<td>お届け先の情報を入力してください</td>
			</tr>
		</table>
		<form action="<%=request.getContextPath()%>/view/buyConfirm.jsp">
			<table style="margin: auto; padding-bottom: 30px;">
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
					<td style="background-color: #eeeeee; width: 240"><textarea maxlength= "200" rows="4" cols="30" name="comment"></textarea></td>
					<br>
				</tr>
				<tr>

				</tr>
			</table>
			<table style="margin: auto; text-align: center; padding-bottom: 180px;">
			<tr><td><input type="submit" value="確定"></td></tr>
			</input>
			</table>
		</form>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>