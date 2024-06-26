
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.Goods"%>
<%@page import="util.MyFormat"%>

<%
MyFormat format = new MyFormat();

//セッションからのデータの取得
ArrayList<Goods> list = (ArrayList<Goods>)session.getAttribute("goods_list");
String cmd = "";
%>

<html>
<head>
<title>カート画面</title>
</head>
<body style = "background: linear-gradient(45deg, #ffff00, #ffccff)">
	<table style="margin: auto; width: 1300px;">
		<tr>
			<td style="text-align: left; width: 100px;">[<a
				href="<%=request.getContextPath()%>/uniformlist?cmd=buy">商品画面へ</a>]
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
				<th style="background-color: #BBBBBB; width: 200">削除</th>
				
			</tr>

			<%
				int total=0;
				if(!list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					int price=5000 *(list.get(i).getBuyQuantity());
				total+=price;
			%>
			<tr>
				<form action="<%=request.getContextPath()%>/view/customer.jsp" method="get">
					<td style="text-align: center; background-color: #EEEEEE"><%=list.get(i).getUniName()%></td>
					<td style="text-align: center; background-color: #EEEEEE"><%=list.get(i).getBuyQuantity()%>個</td>		
					<td style="text-align: center; background-color: #EEEEEE"> <%=format.moneyFormat(price)%></td>
					<td style="text-align: center; background-color: #EEEEEE"><a 
					href="<%=request.getContextPath()%>/insertIntoCart?delno=<%= i %>"onclick="return confirm('商品:<%= list.get(i).getUniName()%>を削除します。本当によろしいですか？')">削除</a></td>
					
			</tr>
			<%
					}
				%>
					
			
		</table>
		<br>
		<table style="margin: auto; padding-bottom: 30px">
			<tr>
			<th style="background-color: #BBBBBB; width: 100px">合計</th>
			<th style="text-align: center; background-color: #EEEEEE; width: 150px"><%= format.moneyFormat(total)%></th>
			</tr>
			<%} %>
		</table>
		<table style="margin: auto; padding-bottom: 30px;">
		<center>
		<form action="<%=request.getContextPath()%>/view/buyConfirm.jsp" method="get">
			<input type="submit" value="購入">
		</center>
		</form>
		<form action="<%=request.getContextPath()%>/uniformlist?cmd=buy" method="get">
		<center style="padding-top: 30px; padding-bottom: 110px;">
			<input type="submit" value="さらに追加">
			<input type="hidden" name="cmd" value="buy">
		</center>
		</form>
		</table>
		<%@include file="/common/footer.jsp"%>
</body>
</html>
