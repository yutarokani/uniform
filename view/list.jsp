<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.OrderInfo"%>
<%@page import="util.MyFormat"%>

<%
	MyFormat format = new MyFormat();

	ArrayList<OrderInfo> orderList = (ArrayList<OrderInfo>)request.getAttribute("order_list");
	int orderNumber = 0;
	String cmd = "";
	/* 日付に関するデータの取得 */
	int thisMonth = (int)request.getAttribute("thisMonth");
	int lastMonth = (int)request.getAttribute("lastMonth");
	int thisSum = (int)request.getAttribute("thisSum");
	int lastSum = (int)request.getAttribute("lastSum");
%>

<html>
<head>
<title>受注一覧</title>
</head>
<body style="background: linear-gradient(45deg, #e6e6fa, #afaffa)">
	<%@include file="/common/header.jsp"%>
	<table style="margin: auto; width: 1300px;">
		<tr>
			<td style="text-align: left; width: 100px;">[<a
				href="<%=request.getContextPath()%>/view/menu.jsp">メニューへ</a>]
			</td>
			<td><h2 style="padding-left: 470px;">受注一覧画面</h2></td>
		</tr>
	</table>

	<hr
		style="text-align: center; height: 2px; background-color: black; width: 100%">
	<div>
	<table style="padding-top: 20px; padding-bottom: 15px; margin-right: auto; width: 100%;">
		<tr style="text-align: left;">
			<th>受注管理状況</th>
		</tr>
		<tr  style="text-align: right;">
			<th><%= thisMonth %>月の売り上げ（発送完了分）　<%= format.moneyFormat(thisSum) %>円</th>
		</tr>
		<tr  style="text-align: right;">
			<th><%= lastMonth %>月の売り上げ（発送完了分）　<%= format.moneyFormat(lastSum) %>円</th>
		</tr>
	</table>
		<table style="margin: auto; padding-bottom: 250px;">

			<tr>
				<th style="background-color: #bbbbbb; width: 200px">No.</th>
				<th style="background-color: #bbbbbb; width: 200px">氏名</th>
				<th style="background-color: #bbbbbb; width: 200px">個数</th>
				<th style="background-color: #bbbbbb; width: 200px">合計金額</th>
				<th style="background-color: #bbbbbb; width: 200px">発注日</th>
				<th style="background-color: #bbbbbb; width: 200px">入金状況</th>
				<th style="background-color: #bbbbbb; width: 200px">発送状況</th>
				<th style="background-color: #bbbbbb; width: 250px" colspan="2">
			<tr>
			<%
			if (orderList != null) {
				for (int i = 0; i < orderList.size(); i++) {
					OrderInfo orderInfo = (OrderInfo)orderList.get(i);
			%>
				<td
					style="text-align: center; background-color: #eeeeee; width: 200px"><%=orderInfo.getOrderNumber()%></td>
				<td
					style="text-align: center; background-color: #eeeeee; width: 200px"><%=orderInfo.getName()%></td>
				<td
					style="text-align: center; background-color: #eeeeee; width: 200px"><%=orderInfo.getBuyQuantity()%></td>
					
				<td
					style="text-align: center; background-color: #eeeeee; width: 200px"><%=format.moneyFormat(Integer.parseInt(orderInfo.getUniId()))%></td>
				<td
					style="text-align: center; background-color: #eeeeee; width: 200px"><%=orderInfo.getDay()%></td>
				<td
					style="text-align: center; background-color: #eeeeee; width: 200px"><%=orderInfo.getPayment()%></td>
				<td
					style="text-align: center; background-color: #eeeeee; width: 200px"><%=orderInfo.getShipping()%></td>
				<td
					style="text-align: center; background-color: #eeeeee; width: 300px">

					<a href="<%=request.getContextPath()%>/detail?orderNumber=<%=orderInfo.getOrderNumber()%>&cmd=detail">詳細</a> 
					<a href="<%=request.getContextPath()%>/detail?orderNumber=<%=orderInfo.getOrderNumber()%>&cmd=update">更新</a>

				</td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td class="px200">&nbsp;</td>
				<td class="px200">&nbsp;</td>
				<td class="px200">&nbsp;</td>
				<td class="px250" colspan="2">&nbsp;</td>
			</tr>
			<%
			}
			%>
		</table>

	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>