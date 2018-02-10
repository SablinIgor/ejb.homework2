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
        <title>Категрии продуктов</title>
    </head>
    <body>
        <h3>Категории продуктов</h3>

        <a href="/EE2_2/newcategory">Новая категория</a>

        <table border="1">
            <tr>
                <td>Идентификатор</td>
                <td>Код</td>
                <td>Имя</td>
                <td>Дата создания</td>
            </tr>

            <c:forEach var="category" items="${сategories}">
                <tr>
                    <td><a href="/EE2_2/category?cid=${category.id}">${category.id}</a></td>
                    <td><a href="/EE2_2/category?cid=${category.id}">${category.code}</a></td>
                    <td><a href="/EE2_2/category?cid=${category.id}">${category.name}</a></td>
                    <td><a href="/EE2_2/category?cid=${category.id}">${category.creationDate}</a></td>
                    <td><a href="/EE2_2/delcategory?cid=${category.id}">Удалить</a></td>
                </tr>
            </c:forEach>            
        </table> 
    </body>
</html>
