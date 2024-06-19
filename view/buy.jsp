<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>注文画面</title>
</head>
<body style = "background: linear-gradient(45deg, #ffff00, #ffccff)">
	<div style="text-align: center">
		<%--@ include file="/common/header.jsp" --%>
		<h2 style="text-align: center">注文画面</h2>
	</div>
	<A style="text-align: left" href="<%=request.getContextPath()%>/view/login.jsp">管理者画面</A>
	<A href="<%=request.getContextPath()%>/view/login.jsp">トップへ戻る</A>
	<div style="text-align: center"></div>
	
	<div style="text-align: center">
		<%--登録画面 --%>
		<hr style="height: 2; background-color: #000000" />
		<form action="<%=request.getContextPath()%>/view/cart.jsp">
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
					<th style="background-color: #bbbbbb; width: 150">商品</th>
					<td style="background-color: #eeeeee; width: 240"><select name="uniformname">
							<option value="">5つの選択肢を表示</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
					</select></td>
					
					<br>
				</tr>
				<tr>
					<th style="background-color: #bbbbbb; width: 150">購入個数</th>
					<td style="background-color: #eeeeee; width: 240"><input type=text size="30" name="amount"></input></td>
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
				style="margin: 0 auto" type="submit" value="カートへ入れる"></input>

		</form>

	</div>

	<%--@ include file="/common/footer.jsp" --%>
</body>
</html>