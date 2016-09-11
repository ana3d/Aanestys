<%-- If data is empty, do stuff --%>
<%
	if (request.getAttribute("data") == null) {
		response.sendRedirect("vote");
		return;
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Äänestystulos</title>
</head>
<link rel="stylesheet" type="text/css" href="main.css">
<body>
	<div class="maindiv">
		<table class="flat-table flat-table-1">
			<thead>
				<tr>
					<th>Vote id</th> <!-- hide?  -->
					<th>Subject</th>
					<th>Vote count</th>
					<th>Yes votes</th>
					<th>No votes</th>
					<th colspan=2>Vote</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vote_data" items="${data}">
					<tr>
						<td><c:out value="${vote_data.id}" /></td>
						<td><c:out value="${vote_data.subject}" /></td>
						<td><c:out value="${vote_data.count}" /></td>
						<td><c:out value="${vote_data.vote_yes}" /> (<c:out
								value="${vote_data.vote_yes_prcnt}" />%)</td>
						<td><c:out value="${vote_data.vote_no}" /> (<c:out
								value="${vote_data.vote_no_prcnt}" />%)</td>

						<td><form method="post" name="vote" action="HandleVote">
								<input type="hidden" name="id" value="${vote_data.id}">
								<input type="hidden" name="type" value="yes">
								<button class="button">Yes</button>
							</form></td>

						<td><form method="post" name="no" action="HandleVote">
								<input type="hidden" name="id" value="${vote_data.id}">
								<input type="hidden" name="type" value="no">
								<button class="button">No</button>
							</form></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="7"></td>
				</tr>
				<tr>
					<td colspan="7"><a href="add.jsp"><button class="button">Lisää
								uusi äänestys</button></a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>