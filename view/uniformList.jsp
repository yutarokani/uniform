<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Goods"%>
<%@page import="util.MyFormat"%>

<%
	MyFormat format = new MyFormat();
%>

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
		ArrayList<Goods> list = (ArrayList<Goods>)request.getAttribute("goods_list");
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Goods goods = (Goods) list.get(i);
				if(!goods.getUniName().equals("")){
					
		%>
		<tr>
			<td style="text-align: center; background-color: #eeeeee; width: 200px;"><%= goods.getUniId() %></a></td>
			<td style="text-align: center; background-color: #eeeeee; width: 200px;"><%= goods.getUniName() %></td>
			<td style="text-align: center; background-color: #eeeeee; width: 200px;"><%= format.moneyFormat(goods.getPrice()) %></td>
			<td style="text-align: center; background-color: #eeeeee; width: 200px;"><%= goods.getStock() %></td>
			<td style="text-align: center; background-color: #eeeeee; width: 200px;"><a 
				href="<%=request.getContextPath()%>/delete?uniId=<%= goods.getUniId()%>" onclick="return confirm('商品:<%= goods.getUniName() %> を削除します。本当によろしいですか？')">削除</a></td>
		</tr>
		<%
		} 
		}
		} else {
		%>
		<tr>
			<td style="text-align: center; width: 200px;">&nbsp;</td>
			<td style="text-align: center; width: 200px;">&nbsp;</td>
			<td style="text-align: center; width: 200px;">&nbsp;</td>
			<td style="text-align: center; width: 200px;" colspan="2">&nbsp;</td>
		</tr>
		<%
		}
		%>
	</table>
	<%@include file="/common/footer.jsp" %>
</body>
</html>