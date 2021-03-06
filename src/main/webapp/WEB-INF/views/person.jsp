<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Person Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>

</head>
<body>
	<h1>Add a Person</h1>

	<c:url var="addAction" value="/person/add"></c:url>

	<form:form action="${addAction}" commandName="person" id="myform"
		name="myForm">
		<table>
			<c:if test="${!empty person.name}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="country">
						<spring:message text="Country" />
					</form:label></td>
				<td><form:input path="country" /></td>
			</tr>

			<tr>
				<td><form:label path="nationality">
						<spring:message text="Nationality" />
					</form:label></td>
				<td><form:select path="nationality.id">
						<option value="-1">Select a type</option>
						<c:forEach items="${listNationalities}" var="nationalityItem">
							<option
								<c:if test="${nationalityItem.id eq person.nationality.id}">selected='selected'</c:if>
								value="${nationalityItem.id}">${nationalityItem.name}</option>
						</c:forEach>
					</form:select></td>
			</tr>

			<tr>
				<td colspan="2"><c:if test="${!empty person.name}">
						<input type="submit" value="<spring:message text="Edit Person"/>" />
					</c:if> <c:if test="${empty person.name}">
						<input type="submit" value="<spring:message text="Add Person"/>" />
					</c:if></td>
			</tr>

		</table>
	</form:form>

	<script type="text/javascript">
		var frmvalidator = new Validator("myform");
		frmvalidator.addValidation("name", "maxlen=20",
				"Max length for Name is 20");
	</script>

	<br>
	<h3>Persons List</h3>
	<c:if test="${!empty listPersons}">
		<table class="tg">
			<tr>
				<th width="80">Person ID</th>
				<th width="120">Person Name</th>
				<th width="120">Person Country</th>
				<th width="120">Nationality</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listPersons}" var="person">
				<tr>
					<td>${person.id}</td>
					<td>${person.name}</td>
					<td>${person.country}</td>
					<td>${person.nationality.name}</td>
					<td><a href="<c:url value='/edit/${person.id}' />">Edit</a></td>
					<td><a href="<c:url value='/remove/${person.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
