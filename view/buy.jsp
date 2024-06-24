<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>注文画面</title>
</head>
<body style="background: linear-gradient(45deg, #ffff00, #ffccff)">
	<div style="text-align: center">
		<%--@ include file="/common/header.jsp" --%>
		<h2 style="text-align: center">商品注文</h2>
	</div>
	<table>
		<td><A href="<%=request.getContextPath()%>/view/login.jsp">[トップへ戻る]</A></td>
		<td style="text-align: right"><A
			href="<%=request.getContextPath()%>/view/menu.jsp">[管理者画面]</A></td>
	</table>

	<div style="text-align: center"></div>

	<div style="text-align: center">
		<%--登録画面 --%>
		<hr style="height: 2; background-color: #000000" />
		<table style="margin: auto">
			<th sytyle="text-align: center">商品一覧</th>
		</table>
		<table style="margin: auto">
			<tr>
				<th><img src="../img/A.png" width="250" height="200" border="3"></th>
				<th><img src="../img/B.png" width="250" height="200" border="3"></th>
				<th><img src="../img/C.png" width="250" height="200" border="3"></th>
				<th><img src="../img/D.png" width="250" height="200" border="3"></th>
				<th><img src="../img/E.png" width="250" height="200" border="3"></th>
			</tr>
			<tr>

				<th style="background-color: #eeeeee; width: 250; height: 50">商品A</th>
				<th style="background-color: #eeeeee; width: 250">商品B</th>
				<th style="background-color: #eeeeee; width: 250">商品C</th>
				<th style="background-color: #eeeeee; width: 250">商品D</th>
				<th style="background-color: #eeeeee; width: 250">商品E</th>
			</tr>
		</table>

		<form style="padding-bottom: 80px;"
			action="<%=request.getContextPath()%>/insertIntoCart" method="post">
			<table style="margin: auto; padding-bottom: 20px;">
				<tr>
					<th style="background-color: #bbbbbb; width: 150">商品</th>
					<td style="background-color: #eeeeee; width: 240; font-size: 100"><select
						name="uniname">
							<option value="*">5つの選択肢を表示</option>
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
							<option value="E">E</option>
					</select></td>

					<br>
				</tr>
				<tr>
					<th style="background-color: #bbbbbb; width: 150">購入個数</th>
					<td style="background-color: #eeeeee; width: 240"><input
						type=text size="30" name="buyQuantity"></input></td>
					<br>
				</tr>
			</table>

			<input style="margin: 0 auto" type="submit" value="カートへ入れる"></input>

		</form>

	</div>
	<%@include file="/common/footer.jsp"%>
	<%--@ include file="/common/footer.jsp" --%>
</body>
</html>