<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Artist In the Movie</title>
</head>
<body>
	<h1>Artist in movie</h1>
	<table>
		<c:forEach var="artist" items="${artists}">
			<tr>
				<td>${artist.fullName}</td>
				<td>${artist.DOB}</td>
				<td>${artist.birthPlace}</td>
				<td>${artist.biography}</td>
				<td>${artist.characters}</td>
				<td>${artist.picture}</td>
				<td><a href="artists/${artist.actorId}">edit</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="addArtist.html"> Add a Artist</a>
</body>
</html>