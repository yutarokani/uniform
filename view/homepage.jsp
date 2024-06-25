<%@page contentType="text/html; charset=UTF-8"%>


<html>
<head>
<title>ホームページ</title>
</head>
<body style = "background: linear-gradient(45deg, #e6e6fa, #afaffa)">
	<table style="margin: auto; width: 1300px;">
		<tr>
			
			<td><h2 style="padding-left: 470px;">ホームページ（仮）</h2></td>
		</tr>
	</table>
	<hr
		style="text-align: center; height: 2px; background-color: black; width: 100%">
	<div style="margin-top: 60px; margin-bottom: 270px">
	<td style="text-align: center">[<a
				href="<%=request.getContextPath()%>/uniformlist?cmd=buy">購入はこちら</a>]
			</td>
	
	</div>
	<%@include file="/common/footer.jsp" %>
</body>
</html>