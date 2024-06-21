<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.OrderInfo"%>

<%
//DetailServletからデータを受け取る
OrderInfo orderInfo = (OrderInfo)request.getAttribute("orderInfo");	
ArrayList<OrderInfo> order_list = (ArrayList<OrderInfo>)request.getAttribute("order_list");
%>

<html>
<head>
<meta charset="UTF-8">
<title>受注詳細表示画面</title>
</head>
<body style="background: linear-gradient(45deg, #e6e6fa, #afaffa);">
	<%@include file="/common/header.jsp" %>
	<table style="margin: auto; width: 1300px;">
		<tr>
			<td style="text-align: left; width: 100px;">[<a
				href="<%=request.getContextPath()%>/list">一覧に戻る</a>]
			</td>
			<td><h2 style="padding-left: 470px;">受注詳細情報</h2></td>
		</tr>
	</table>
	<hr style="text-align: center; height: 2px; background-color: black; width: 100%;"></hr>
<div>
	<table style="margin: auto; padding-top: 20px; padding-bottom: 20px;">
		<tr>
			<th style="text-align: center; font-size: 20px;">注文番号:</th>
			<td style="text-align: center;"><%=orderInfo.getOrderNumber() %></td>
		</tr>
	</table>
	<table style="margin: auto; padding-bottom: 100px;">
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">購入者氏名</th>
			<td style="width: 400px; background-color: #EEEEEE;"><%=orderInfo.getName() %></td>
		</tr>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">購入者メールアドレス</th>
			<td style="width:400px; background-color: #EEEEEE;"><%=orderInfo.getMail() %></td>
		</tr>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">購入者住所</th>
			<td style="width:400px; background-color: #EEEEEE;"><%=orderInfo.getAddress() %></td>
		</tr>
		<%for(int i = 0; i < order_list.size(); i++){ %>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">購入した商品番号</th>
			<td style="width:400px; background-color: #EEEEEE;"><%=order_list.get(i).getUniId() %></td>
		</tr>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">購入数</th>
			<td style="width:400px; background-color: #EEEEEE;"><%=order_list.get(i).getBuyQuantity() %></td>
		</tr>
		<%} %>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">注文日</th>
			<td style="width:400px; background-color: #EEEEEE;"><%=orderInfo.getDay() %></td>
		</tr>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">入金状況</th>
			<td style="width:400px; background-color: #EEEEEE;"><a href="<%=request.getContextPath()%>/view/update.jsp"><%=orderInfo.getPayment() %></a></td>
		</tr>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">発送状況</th>
			<td style="width:400px; background-color: #EEEEEE;"><a href="<%=request.getContextPath()%>/view/update.jsp"><%=orderInfo.getShipping() %></a></td>
		</tr>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">備考欄</th>
			<td style="width:400px; background-color: #EEEEEE;"><%=orderInfo.getOther() %></td>
		</tr>
	</table>
</div>
<%@include file="/common/footer.jsp" %>
</body>
</html>