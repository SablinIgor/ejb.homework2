<%-- 
    Document   : catalog
    Created on : 28.01.2018, 0:10:56
    Author     : Igor
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Домашнее задание</title>
    </head>
    <body>
        <h1>Каталог</h1>
        <table border="1">
            <tr>
                <td>Идентификатор</td>
                <td>Код</td>
                <td>Имя</td>
                <td>Дата создания</td>
            </tr>

            <c:forEach var="category" items="${сategories}">
		<tr>
			<td>${category.id}</td>
			<td>${category.code}</td>
			<td>${category.name}</td>
			<td>${category.creationDate}</td>
		</tr>
            </c:forEach>            
        </table> 
    </body>
</html>
