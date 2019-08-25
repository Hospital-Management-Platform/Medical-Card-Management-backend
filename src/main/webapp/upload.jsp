<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>
	<form name='uploadForm'
		  action="<c:url value='/uploadFile' />" method='POST' enctype='multipart/form-data'>

		<table>
			<tr>
				<td>image:</td>
				<td><input type='file' name='file'></td>
			</tr>
			<tr>
				<td>image:</td>
				<td><input type='file' name='file'></td>
			</tr>
			<tr>
				<td>imagename:</td>
				<td><input type='text' name='name' /></td>
			</tr>
			<tr> 
				<td>imagename:</td>
				<td><input type='text' name='name' /></td>
			</tr>
			<tr>
				<td colspan='2'> <input name="submit" type="submit"
				  value="submit" /></td>
			</tr>
		  </table>

		 
		</form>
</body>
</html>
