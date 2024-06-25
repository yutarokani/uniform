<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.OrderInfo" %>

<%
ArrayList<OrderInfo> order_list = (ArrayList<OrderInfo>)session.getAttribute("order_list");
ArrayList<String> uniname_list = (ArrayList<String>)session.getAttribute("uniname_list");
%>

<html>
<head>
<title>購入確認画面</title>
<link rel="icon" type="image/x-icon" href="../img/rogofabi.ico">
</head>
<body style="background: linear-gradient(45deg, #ffff00, #ffccff)">
	<div align="center" style="text-align: center; padding-bottom: 20px;">
		<p style="font-size: 24px">購入確認画面</p>
		<hr color="black"></hr>
		<p style="font-size: 32px">
			<b>商品を購入しました。<br> ご購入ありがとうございました。
			</b>
		</p>
		
		<table style="margin: auto; width: 50%">
		<p style="font-size: 36px">購入商品
			<tr>
				<th style="background-color: #BBBBBB; width: 200">商品</th>
				<th style="background-color: #BBBBBB; width: 200">購入個数</th>
			</tr>
			<% for(int i = 0; i < order_list.size(); i++){ %>
				<tr>
					<td style="text-align: center; background-color: #EEEEEE"><%= uniname_list.get(i) %></td>
					<td style="text-align: center; background-color: #EEEEEE"><%= order_list.get(i).getBuyQuantity() %></td>
				</tr>
			<% } %>
		</table>
		</p>
		<p style="font-size: 24px; margin-top: 50px">
			下記のメールアドレスに<br> 注文情報を送信しました。
		</p>
		<p style="margin-top: 50px; margin-bottom: 30px"><%= order_list.get(0).getMail() %></p>
		<a href="<%=request.getContextPath()%>/uniformlist?cmd=buy">注文画面に戻る</a>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>