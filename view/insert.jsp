<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>商品登録画面</title>
</head>
<body style = "background: linear-gradient(45deg, #e6e6fa, #afaffa)">
	<%@include file="/common/header.jsp" %>
	<table style="margin: auto; width: 1300px;">
		<tr>
			<td style="text-align: left; width: 100px;">[<a
				href="<%=request.getContextPath()%>/uniformlist">商品一覧</a>]
			</td>
			<td><h2 style="padding-left: 470px;">商品登録画面</h2></td>
		</tr>
	</table>
	<hr
		style="text-align: center; height: 2px; background-color: black; width: 100%;"></hr>
	<div>
		<div style="text-align: center; margin: auto; padding-bottom: 210px;">
			<form style="text-align: center; margin: auto;"
				action="<%=request.getContextPath()%>/insert">
				<table
					style="text-align: center; margin: auto; padding-bottom: 100px; padding-top: 30px;">
					<tr>
						<th
							style="text-align: center; background-color: #bbbbbb; width: 150px; height: 24px;">商品ID</th>
						<td><input type="text" name="uniId"></td>
					</tr>
					<tr>
						<th
							style="text-align: center; background-color: #bbbbbb; width: 150px; height: 24px;">商品名</th>
						<td><input type="text" name="uniName"></td>
					</tr>
					<tr>
						<th
							style="text-align: center; background-color: #bbbbbb; width: 150px; height: 24px;">価格</th>
						<td><input type="text" name="price"></td>
					</tr>
					<tr>
						<th
							style="text-align: center; background-color: #bbbbbb; width: 150px; height: 24px;">在庫数</th>
						<td><input type="text" name="stock"></td>
					</tr>
				</table>
				<tr>
					<td style="width: 80px;">&nbsp;</td>
					<td style="width: 80px;"><input type="submit" value="登録"></td>
					<td style="width: 80px;">&nbsp;</td>
				</tr>
			</form>
		</div>
		<%@include file="/common/footer.jsp" %>
</body>
</html>