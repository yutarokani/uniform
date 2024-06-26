<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Goods"%>
<%
ArrayList<Goods> goodsList = (ArrayList<Goods>)request.getAttribute("goods_list");
%>


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
		<td><A href="<%=request.getContextPath()%>/view/homepage.jsp">[トップへ戻る]</A></td>
		<td style="text-align: right"><A
			href="<%=request.getContextPath()%>/view/login.jsp">[管理者画面]</A></td>
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
				<th><img src="<%=request.getContextPath()%>/img/A.png" width="250" height="200" border="3"></th>
				<th><img src="<%=request.getContextPath()%>/img/B.png" width="250" height="200" border="3"></th>
				<th><img src="<%=request.getContextPath()%>/img/C.png" width="250" height="200" border="3"></th>
				<th><img src="<%=request.getContextPath()%>/img/D.png" width="250" height="200" border="3"></th>
				<th><img src="<%=request.getContextPath()%>/img/E.png" width="250" height="200" border="3"></th>
			</tr>
			<tr>
			
				
				<%for(int i=0; i < goodsList.size(); i++){ %>
							<%if(!goodsList.get(i).getUniName().equals("")) {%>
							<th style="background-color: #eeeeee; width: 250; height: 50"><%=goodsList.get(i).getUniName() %></th>
							<%
							} 
							}
							%>
			</tr>
		</table>

		<form style="padding-bottom: 80px;"
			action="<%=request.getContextPath()%>/insertIntoCart" method="get">
			<table style="margin: auto; padding-bottom: 20px;">
				<tr>
					<th style="background-color: #bbbbbb; width: 150">商品</th>
					<td style="background-color: #eeeeee; width: 240; font-size: 100"><select
						name="uniname">
							<option value="*">選択肢を表示</option>
							<%for(int i=0; i < goodsList.size(); i++){ %>
							<%if(!goodsList.get(i).getUniName().equals("")) {%>
							<option value="<%=goodsList.get(i).getUniName() %>"><%=goodsList.get(i).getUniName() %></option>
							<%
							} 
							}
							%>
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
