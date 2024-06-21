<%@page contentType="text/html; charset=UTF-8"%>

<%
//リクエストスコープからのデータの取得
//ArrayList<Book> list = (ArrayList<Book>) request.getAttribute("book_list");
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
				href="<%=request.getContextPath()%>/view/uniformList.jsp">一覧へ</a>]
			</td>
			<td><h2 style="padding-left: 430px;">入金・発送状況更新</h2></td>
		</tr>
	</table>
	<hr
		style="text-align: center; height: 5px; background-color: black; width: 100%;">
	<table style="margin:auto; padding-top: 20px; padding-bottom:20px;">
		<tr>
			<th style="margin: 3% 25%">注文番号：</th><td>0001（仮）</td>
		</tr>
	<table style="margin: auto; border-spacing: 100px 5px">
		<tr>
			<th style="text-align: left; padding-bottom:10px;">入金状況更新</th>
		</tr>
		<tr>
			<th style="background-color: #BBBBBB; width: 230px">現在のステータス</th>
			<th style="background-color: #BBBBBB">ステータス変更</th>
		</tr>
		<form action="<%=request.getContextPath()%>/view/list.jsp" method="get">
		<tr>
				<td style="text-align: center; background-color: #EEEEEE">入金待ち(仮)</td>
				<td><select name="updatePrice">
							<option value="stay1">変更なし</option>
							<option value="notPay">入金待ち</option>
							<option value="pay">入金済み（メールが送信されます）</option>
				</select></td>
			</form>
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
			<td style="text-align: center; background-color: #EEEEEE">未発送(仮)</td>
			<th><select name="updateCa">
						<option value="stay2">変更なし</option>
						<option value="non">未</option>
						<option value="notTr">発送準備中</option>
						<option value="trance">発送済み（メールが送信されます）</option>
			</select></th>
		</tr>
		
	</table>
	<table style="margin: auto; padding-top: 10px; padding-bottom: 60px;">
		<tr>
			<td><input style="margin: auto" type="submit" value="確定"></td>
		</tr>
	</table>	
	</form>
	<br>
<%@include file="/common/footer.jsp" %>
</body>
</html>