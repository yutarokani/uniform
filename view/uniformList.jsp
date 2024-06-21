<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>商品一覧画面</title>
</head>
<body style="background: linear-gradient(45deg, #e6e6fa, #afaffa);">
	<%@include file="/common/header.jsp" %>
	<table style="margin: auto; width: 1300px;">
		<tr>
			<td style="text-align: left; width: 100px;">[<a
				href="<%=request.getContextPath()%>/view/menu.jsp">メニュー</a>]
			</td>
			<td style="text-align: left; width: 100px;">[<a
				href="<%=request.getContextPath()%>/view/insert.jsp">商品登録</a>]
			</td>
			<td><h2 style="padding-left: 370px;">商品一覧画面</h2></td>
		</tr>
	</table>
	<hr
		style="text-align: center; height: 2px; background-color: black; width: 100%;"></hr>
	<table style="margin: auto; padding-top: 20px; padding-bottom: 330px;">
		<tr>
			<th
				style="text-align: center; background-color: #bbbbbb; width: 150px; height: 24px;">商品ID</th>
			<th
				style="text-align: center; background-color: #bbbbbb; width: 150px; height: 24px;">商品名</th>
			<th
				style="text-align: center; background-color: #bbbbbb; width: 150px; height: 24px;">価格</th>
			<th
				style="text-align: center; background-color: #bbbbbb; width: 150px; height: 24px;">在庫数</th>
			<th
				style="text-align: center; background-color: #bbbbbb; width: 150px; height: 24px;">削除</th>
		</tr>
		<%
		//ここにJavaコード記述
		%>
		<tr>
			<td style="text-align: center; background-color: #eeeeee; width: 200px;">0001</a></td>
			<td style="text-align: center; background-color: #eeeeee; width: 200px;">ユニフォームA</td>
			<td style="text-align: center; background-color: #eeeeee; width: 200px;">\5,000</td>
			<td style="text-align: center; background-color: #eeeeee; width: 200px;">100</td>
			<td style="text-align: center; background-color: #eeeeee; width: 200px;"><a
				href="<%=request.getContextPath()%>">削除</a></td>
		</tr>
		<tr>
			<td style="text-align: center; width: 200px;">&nbsp;</td>
			<td style="text-align: center; width: 200px;">&nbsp;</td>
			<td style="text-align: center; width: 200px;">&nbsp;</td>
			<td style="text-align: center; width: 200px;" colspan="2">&nbsp;</td>
		</tr>
	</table>
	<%@include file="/common/footer.jsp" %>
</body>
</html>