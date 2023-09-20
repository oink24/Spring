<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>annotation::param</title>
	</head>
	<body>
		<h3>@requestParam 어노테이션 실습</h3>
		
		<a href="/Ch04/index">index</a>
		
		<h4>Param1 실습</h4>
		<form action="/Ch04/annotation/param1" method="post">
			<input type="text" name="uid"/>
			<input type="submit" value="전송"/>
		</form>
		
		<h4>Param2 실습</h4>
		<form action="/Ch04/annotation/param2" method="post">
			<input type="text" name="uid"/>
			<input type="text" name="name"/>
			<input type="submit" value="전송"/>
		</form>
		
		<h4>Param3 실습</h4>
		<form action="/Ch04/annotation/param3" method="post">
			<input type="text" name="uid"/>
			<input type="text" name="name"/>
			<input type="text" name="hp"/>
			<input type="number" name="age"/>
			<input type="submit" value="전송"/>
		</form>
	</body>
</html>