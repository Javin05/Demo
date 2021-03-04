<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 --%><html>
<head>
 
</head>
<body id="corpo">
    <div align="center">
     <div align="center" class="text-primary" >
	  <h3>USER</h3>
	  <a href="new" class="text-primary" >newuser</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list" class="text-primary" >userlist</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="logout" class="text-primary">Logout</a>
	  </div>
		<c:if test="${user != null}">
			<form action="insert" method="post">
        </c:if>
        <c:if test="${user == null}">
			<form action="update" method="post">
        </c:if>
        <table border="1" cellpadding="5">
        		<c:if test="${user != null}">
        			<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
        		</c:if>            
            <tr>
                <th>Name: </th>
                <td>
                	<input type="text" name="name" size="45"
                			value='${user.name}' />"
                		
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                	<input type="text" name="email" size="45"
                			 value='${user.email}' />"
                	
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                	<input type="text" name="password" size="15"
                			 value='${user.password}' />"
                	
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Insert" />
            	</td>
            </tr>
        </table>
        </form>
         <div class="text-secondary">
            		<c:if test="${user != null}">
            			Editar Utilizador
            		</c:if>
            		<c:if test="${user == null}">
            			Novo Utilizador
            		</c:if>
            </div>
    </div>	
</body>
</html>
