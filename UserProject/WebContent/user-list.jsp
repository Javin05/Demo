<%@ page language="java" session="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 --%>
<html>
<body>
     <div align="center" class="text-primary" >
	  <h3>CMS</h3>
	  <a href="new" class="text-primary" >newuser</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list" class="text-primary" >userlist</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="logout" class="text-primary">Logout</a>
	  </div>
    <div align="center">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.password}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${user.id}'/>">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${user.id}'/>">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
