<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninja Gold</title>
	<link rel="stylesheet" href="style.css" />
</head>
<body>
	<nav>
		<h1>Ninja Gold</h1>
		<h2>Total Gold: <span><c:out value="${ gold }"/></span></h2>
	</nav>
	<div class="container">
		<c:forEach items="${ buildings }" var="building">
			<div class="building">
				<h3>${ building.name }</h3>
				<p>(earn/lose ${ building.minGold } - ${ building.maxGold })</p>
				<form action="/" method="POST">
					<input type="hidden" name="building" value="${ building.name }" />
					<input type="submit" value="Submit" />
				</form>
			</div>
		</c:forEach>
	</div>
</body>
</html>