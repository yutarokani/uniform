<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>受注詳細表示画面</title>
</head>
<body style="background: linear-gradient(45deg, #e6e6fa, #afaffa);">
	<h1 style="text-align: center;">受注管理システム</h1>
	<hr style="text-align: center; height: 5px; background-color: black; width: 100%;">
	<table style="margin: auto; width: 1300px;">
		<tr>
			<td style="text-align: left; width: 100px;">[<a
				href="<%=request.getContextPath()%>/view/list.jsp">一覧に戻る</a>]
			</td>
			<td><h2 style="padding-left: 470px;">受注詳細画面</h2></td>
		</tr>
	</table>
	<hr style="text-align: center; height: 2px; background-color: black; width: 100%;"></hr>
<div>
	<table style="margin: auto; padding-top: 20px; padding-bottom: 20px;">
		<tr>
			<th style="text-align: center; font-size: 20px;">受注番号:</th>
			<td style="text-align: center;">64567</td>
		</tr>
	</table>
	<table style="margin: auto; padding-bottom: 100px;">
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">購入者氏名</th>
			<td style="width: 400px; background-color: #EEEEEE;">山田太郎</td>
		</tr>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">購入者メールアドレス</th>
			<td style="width:400px; background-color: #EEEEEE;">sample@sample.com</td>
		</tr>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">購入者住所</th>
			<td style="width:400px; background-color: #EEEEEE;">〒111-11111　愛知県名古屋市○○区××</td>
		</tr>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">購入した商品</th>
			<td style="width:400px; background-color: #EEEEEE;">ユニフォームA</td>
		</tr>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">購入数</th>
			<td style="width:400px; background-color: #EEEEEE;">11</td>
		</tr>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">注文日</th>
			<td style="width:400px; background-color: #EEEEEE;">2024/07/01</td>
		</tr>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">入金状況</th>
			<td style="width:400px; background-color: #EEEEEE;"><a href="">入金待ち</a></td>
		</tr>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">発送状況</th>
			<td style="width:400px; background-color: #EEEEEE;"><a href="">未発送</a></td>
		</tr>
		<tr>
			<th style="text-align: center; background-color: #BBBBBB; width: 200px; height: 30px;">備考欄</th>
			<td style="width:400px; background-color: #EEEEEE;">購入品を使用したい日が近いため、なるべく早めに発送してほしいです。</td>
		</tr>
	</table>
</div>
<hr style="text-align: center; height: 5px; background-color: black; width: 100%;">
	<table style="margin: auto; border: 0; width: 100%; text-align: center;">
		<tr>
			<td align="left">copyright (c) 2024 all rights reserved.</td>
		</tr>
	</table>
</body>
</html>