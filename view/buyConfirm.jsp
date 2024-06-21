<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>購入確認画面</title>
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
		<p style="font-size: 36px">購入商品:
			<tr>
				<th style="background-color: #BBBBBB; width: 200">商品</th>
				<th style="background-color: #BBBBBB; width: 200">購入個数</th>
			</tr>
			<tr>
				<form action="<%=request.getContextPath()%>/view/buyConfirm.jsp" method="post">
					<td style="text-align: center; background-color: #EEEEEE">仮商品名</td>
					<td style="text-align: center; background-color: #EEEEEE">仮商品個数(個)</td>
			</tr>
		</table>
		</p>
		<p style="font-size: 24px; margin-top: 50px">
			下記のメールアドレスに<br> 注文情報を送信しました。
		</p>
		<p style="margin-top: 50px; margin-bottom: 30px">(仮)system.project.team17@kanda-it-school-system.com</p>
		<a href="<%=request.getContextPath()%>/view/buy.jsp">注文画面に戻る</a>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>