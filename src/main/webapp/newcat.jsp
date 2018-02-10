<%-- 
    Document   : newcategory
    Created on : 03.02.2018, 14:17:59
    Author     : Igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Новая категория товара</title>
    </head>
    <body>
        <h3>Новая категория товара</h3>
        
        <form action="/EE2_2/newcategory" method="POST">
            <input type="text" name="todo" value="add" hidden="true" />           
            <input type="text" name="name" placeholder="Наименование"/>
            <input type="code" name="code" placeholder="Код"/>
            <input type="submit">      
        </form>
    </body>
</html>
