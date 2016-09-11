<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lisää uusi kysymys</title>
</head>
<link rel="stylesheet" type="text/css" href="main.css">
<script src="main.js"></script>
<body>
	<div class="maindiv">
		<form action="Add" method="post" id="add">
			<table class="table-add">
				<thead>
					<tr>
						<th>Lisää uusi kysymys</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="subject"></td>
					</tr>
					<tr>
						<td><input type="submit" onclick="return IsEmpty();"
							value="Lisää kysymys" class="button"></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td><a href="vote.jsp"><button class="button">Peruuta
									lisäys</button></a></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>