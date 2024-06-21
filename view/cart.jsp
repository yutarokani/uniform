<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%
//リクエストスコープからのデータの取得
//ArrayList<Book> list = (ArrayList<Book>) request.getAttribute("book_list");
%>

<html>
<head>
<title>カート画面</title>
</head>
<body style = "background: linear-gradient(45deg, #ffff00, #ffccff)">
	<table style="margin: auto; width: 1300px;">
		<tr>
			<td style="text-align: left; width: 100px;">[<a
				href="<%=request.getContextPath()%>/view/buy.jsp">購入画面へ</a>]
			</td>
			<td><h2 style="padding-left: 400px;">商品をカートへ追加しました。</h2></td>
		</tr>
	</table>
		<hr
			style="text-align: center; height: 5px; background-color: black; width: 100%;">
		<table style="margin: auto; padding-top: 130px; padding-bottom: 60px; width: 50%">
			<tr>
				<th style="background-color: #BBBBBB; width: 200">商品</th>
				<th style="background-color: #BBBBBB; width: 200">購入個数</th>
				<th style="background-color: #BBBBBB; width: 200">小計</th>
			</tr>

			<%
//if (list != null) {
//for (int i = 0; i < list.size(); i++) {
%>
			<tr>
				<form action="<%=request.getContextPath()%>/view/customer.jsp" method="post">
					<td style="text-align: center; background-color: #EEEEEE">仮商品名</td>
					<td style="text-align: center; background-color: #EEEEEE">仮商品個数(個)</td>
					<td style="text-align: center; background-color: #EEEEEE">商品名 * 個数</td>
			</tr>
			<%
//}
//}
%>
		</table>
		<br>
		<table style="margin: auto; padding-bottom: 30px">
			<tr>
			<th style="background-color: #BBBBBB; width: 100px">合計</th>
			<th style="text-align: center; background-color: #EEEEEE; width: 150px">小計 + 小計</th>
			</tr>
		</table>
		<table style="margin: auto; padding-bottom: 30px;">
		<center>
			<input type="submit" value="購入">
		</center>
		</form>
		<form action="<%=request.getContextPath()%>/view/buy.jsp" method="buy">
		<center style="padding-top: 30px; padding-bottom: 110px;">
			<input type="submit" value="さらに追加">
		</center>
		</form>
		</table>
		<%@include file="/common/footer.jsp"%>
</body>
</html>