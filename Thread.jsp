<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>

<title>ふじちゃんねる！</title>
<meta charset="UTF-8">
<link href="css/ThreadStyle.css" rel="stylesheet">
</head>
<body>
<div id="part2">
<h1><img src="Image/title.png"></h1>
</div>
<div class = "inline">

<h2>${message}<br>スレッド一覧</h2>
<div class = "result">

<c:forEach var="th" items="${ThreadList}">
<div class="table1">
<a href="ShowResponseServlet?ThreadID=${th.threadID}" name="ThreadID">
<table>
  <tr>
    <th>タイトル</th>
		<td>

        ${th.title}

      </td>
    </tr>
    <tr>

      <th>投稿者名</th>
      <td>${th.name}</td>
	  </a>
     </tr>
     <tr>
       <th>投稿時間</th>
       <td>${th.postDate}</td>
     </tr>
</table>
</div>
</a>
<br>
</c:forEach>

</div>
<%-- end div result --%>
</div>


<form action="SearchServlet" method="post" name="name">
	<div class = "search">
		<p>検索はこちら↓</p>
<input type="text" name="searchtitle" value size="20" maxvalue="40" placeholder="検索" required>
	<br><button>検索</button>
	</div>
	<%-- end div search --%>
</form>
<div id="part1">
<form action="ThreadServlet" method="post">
	<p>新規スレッド作成はこちら↓</p>


	<input type="text" name="title" value size="36" maxvalue="30" placeholder="タイトル" required maxlength='20'>
	<input type="text" name="name" value size="12" maxvalue="6" placeholder="名前" required maxlength='8' value="名無し">
	<br>

	<textarea name="comments" rows="10" cols="42" class="input_comment" id="comment" placeholder="内容入力" required maxlength='420' required wrap="hard"></textarea>
	<button>送信</button>
	</form>
	</div>
	<div class = "home">
<a href="index.html"><img src="Image/homebutton1.png"></a>
</div>
</body>
</html>
