<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lottery Page</title>
</head>
<body>
	<form action="draw" method="post">
		n: <input type="text" name="n" value="${param.n}" />
		<button>Draw</button>
	</form>
	<table>
		<tbody>
			<c:forEach items="${lottery.numbers}" var="numbers">
				<tr>
					<c:forEach items="${numbers}" var="number">
						<td>${number}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>