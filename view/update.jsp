<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.OrderInfo"%>

<%
//DetailServletからデータを受け取る
OrderInfo orderInfo = (OrderInfo)request.getAttribute("orderInfo");	
%>

<html>
<head>
<title>更新画面</title>
</head>
<body style = "background: linear-gradient(45deg, #e6e6fa, #afaffa); color: #333300">
	<%@include file="/common/header.jsp" %>
	<table style="margin: auto; width: 1300px;">
		<tr>
			<td style="text-align: left; width: 100px;">[<a
				href="<%=request.getContextPath()%>/list">一覧へ</a>]
			</td>
			<td><h2 style="padding-left: 430px;">入金・発送状況更新</h2></td>
		</tr>
	</table>
	<hr
		style="text-align: center; height: 5px; background-color: black; width: 100%;">
	<table style="margin:auto; padding-top: 20px; padding-bottom:20px;">
		<tr>
			<th style="margin: 3% 25%">注文番号：</th><td><%=orderInfo.getOrderNumber() %></td>
		</tr>
	<table style="margin: auto; border-spacing: 100px 5px">
		<tr>
			<th style="text-align: left; padding-bottom:10px;">入金状況更新</th>
		</tr>
		<tr>
			<th style="background-color: #BBBBBB; width: 230px">現在のステータス</th>
			<th style="background-color: #BBBBBB">ステータス変更</th>
		</tr>
		<form action="<%=request.getContextPath()%>/update" method="get">
		<tr>
				<td style="text-align: center; background-color: #EEEEEE"><%=orderInfo.getPayment() %></td>
				<td><select name="updatePrice">
							<option value="">変更なし</option>
							<option value="notPay">入金待ち</option>
							<option value="pay">入金済み（メールが送信されます）</option>
				</select></td>
		</tr>
	</table>
	<br>
	<table style="margin: auto; border-spacing: 100px 5px; padding-bottom: 40px;">
		<tr>
			<th style="text-align: left; padding-bottom:10px;">入金状況更新</th>
		</tr>
		<tr>
			<th style="background-color: #BBBBBB; width: 230px">現在のステータス</th>
			<th style="background-color: #BBBBBB">ステータス変更</th>
		</tr>
		<tr>
			<td style="text-align: center; background-color: #EEEEEE"><%=orderInfo.getShipping() %></td>
			<th><select name="updateTr">
						<option value="">変更なし</option>
						<option value="non">未発送</option>
						<option value="notTr">発送準備中</option>
						<option value="trance">発送済み（メールが送信されます）</option>
			</select></th>
		</tr>
		
	</table>
	<table style="margin: auto; padding-top: 10px; padding-bottom: 60px;">
		<tr>
			<td><input style="margin: auto" type="submit" value="確定"></input></td>
		</tr>
	</table>
	
	<input type="hidden"name="ordernumber"value="<%=orderInfo.getOrderNumber() %>">	
	<input type="hidden"name="name"value="<%=orderInfo.getName() %>	">
	<input type="hidden"name="mail"value="<%=orderInfo.getMail() %>	">
	</form>
	<br>
<%@include file="/common/footer.jsp" %>
</body>
</html>