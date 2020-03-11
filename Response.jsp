
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>

	<title>スレッド</title>
	<link href="css/ResponseStyle.css" rel="stylesheet">
</head>
<body>
	<h1><img src="Image/title.png"></h1>
	<h2>スレッド名：${title}</h2>
<div id = "inline2">
<table border="1" id="res" width = "150">
<c:forEach var="rs" items="${Response}">
	<table border="1" id="res">
<tr>
	<th>投稿者名</th>	<td>${rs.name}</td>
</tr>
<tr>
	<th>コメント</th>	<td>${rs.comments}</td>
</tr>
<tr>
	<th>投稿時間</th><td>${rs.responseDate}</td>
</tr>

</table>
<br>
</c:forEach>


</div>
<form method="post" action="ResponseServlet">
<div id="part1">
	<a href=#bottom>最新のコメントへ</a>
	<input type="hidden" name="title" value="${title}">
		<p>返信はこちら↓</p>
	<input type="text" name="name" value size="12" maxvalue="6" placeholder="名前" required maxlength='8' value="名無し"><br>
	<textarea name="comments" rows="10" cols="42" class="input_comment" id="comment" placeholder="内容入力" required maxlength='420' required wrap="hard"></textarea><br>
	<button>送信</button>
	<input type="hidden" name="ThreadID" value="${ThreadID}">
</div>
</form>
<div class="thread">
<a href="ShowThreadServlet" id="backTop"><img src="Image/threadbutton1.png"></a>
</div>
<div id=bottom></div>
</body>
</html>
