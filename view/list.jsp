<%@page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="base.css">

<html>
<head>
<title>受注一覧</title>
</head>
<body style = "background: linear-gradient(45deg, #e6e6fa, #afaffa)">
<%@include file="/common/header.jsp" %>
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
	<div class = "font_test">
	
		<tr>
			<th>受注管理状況</th>
		</tr>

		<table style="margin: auto; padding-bottom: 250px;">
			
			<tr>
				<th style="background-color: #bbbbbb; width: 200px">No.</th>
				<th style="background-color: #bbbbbb; width: 200px">氏名</th>
				<th style="background-color: #bbbbbb; width: 200px">種類</th>
				<th style="background-color: #bbbbbb; width: 200px">個数</th>
				<th style="background-color: #bbbbbb; width: 200px">合計金額</th>
				<th style="background-color: #bbbbbb; width: 200px">発送日</th>
				<th style="background-color: #bbbbbb; width: 200px">入金状況</th>
				<th style="background-color: #bbbbbb; width: 200px">発送状況</th>
				<th style="background-color: #bbbbbb; width: 250px" colspan="2">
				
			<tr>
				<td style="text-align: center; background-color: #eeeeee; width: 200px">12</td>
				<td style="text-align: center; background-color: #eeeeee; width: 200px">山本大誠</td>
				<td style="text-align: center; background-color: #eeeeee; width: 200px">A</td>
				<td style="text-align: center; background-color: #eeeeee; width: 200px">5</td>
				<td style="text-align: center; background-color: #eeeeee; width: 200px">25000円</td>
				<td style="text-align: center; background-color: #eeeeee; width: 200px">2024/06/18</td>
				<td style="text-align: center; background-color: #eeeeee; width: 200px">入金済み</td>
				<td style="text-align: center; background-color: #eeeeee; width: 200px">未</td>
				<td style="text-align: center; background-color: #eeeeee; width: 300px">
				
				<a href="<%=request.getContextPath()%>/view/detail.jsp">詳細</a>
				<a href="<%=request.getContextPath()%>/view/update.jsp">更新</a>

				</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 200px">&nbsp;</td>
				<td style="text-align: center; width: 200px">&nbsp;</td>
				<td style="text-align: center; width: 200px">&nbsp;</td>
				<td style="text-align: center; width: 250px" colspan="2">&nbsp;</td>
			</tr>
		</table>

	</div>
	<%@include file="/common/footer.jsp" %>
</body>
</html>