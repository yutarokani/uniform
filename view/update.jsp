<%@page contentType="text/html; charset=UTF-8"%>

<%
//リクエストスコープからのデータの取得
//ArrayList<Book> list = (ArrayList<Book>) request.getAttribute("book_list");
%>

<html>
<head>
<title>update</title>
</head>
<body style = "background: linear-gradient(45deg, #e6e6fa, #afaffa); color: #333300">
	<h1 style="text-align: center">更新</h1>
	<hr
		style="text-align: center; height: 5px; background-color: black; width: 100%;">
	<h4 style="margin: 3% 25%">商品No</h4>

	<h4 style="padding-left: 30%">入金状況更新</h4>
	<table style="margin: auto; border-spacing: 100px 5px">
		<tr>
			<td><h3 style="background-color: #BBBBBB">現在のステータス</h3></td>
			<td><h3 style="background-color: #BBBBBB">ステータス変更</h3></td>
		</tr>
		<form action="<%=request.getContextPath()%>/view/list.jsp" method="get">
		<tr>
				<td style="text-align: center; background-color: #EEEEEE">入金待ち</td>
				<td><select name="updatePrice">
							<option value="">ステータスを選択</option>
							<option>入金待ち</option>
							<option>入金済み</option>
							<option>その他</option>
				</select></td>
			</form>
		</tr>
	</table>
	<br>
	<h4 style="padding-left: 30%">発送状況更新</h4>
	<table style="margin: auto; border-spacing: 100px 5px">
		<tr>
			<td><h3 style="background-color: #BBBBBB">現在のステータス</h3></td>
			<td><h3 style="background-color: #BBBBBB">ステータス変更</h3></td>
		</tr>
		<tr>
				<td style="text-align: center; background-color: #EEEEEE">未発送</td>
				<td><select name="updateCa">
							<option value="">ステータスを選択</option>
							<option>未</option>
							<option>発送準備中</option>
							<option>発送済み</option>
							<option>その他</option>
				</select></td>
		</tr>
		
	</table>
	<table>
		<tr>
			<input style="margin: 0 auto" type="submit" value="確定">
		</tr>
	</table>
		
	</form>
	<br>
	<center>
		<td style="text-align: left; width: 100px;">[<a
				href="<%=request.getContextPath()%>/view/list.jsp">一覧へ</a>]
			</td>
	</center>
</body>
</html>