<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 10.02.2018
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Новая категория товара</title>
</head>
<body>
<h3>Калькулятор</h3>

    <form action="/EE2_2/calculator" method="POST">
        <input type="v1" name="v1" placeholder="Число" value="${last_v1}"/>
        <input type="operator" name="operator" placeholder="Оператор"  value="${last_operator}" />
        <input type="v2" name="v2" placeholder="Число" value="${last_v2}" />
        <input type="resalt" name="resalt" placeholder="Результат" value="${res}" readonly="true" />
        <input type="submit">
    </form>


<h3>Последние операции</h3>
    <table border="1">
        <tr>
            <td>Переменная</td>
            <td>Оператор</td>
            <td>Переменная</td>
            <td>Результат</td>
        </tr>

        <c:forEach var="o" items="${operations}">
            <tr>
                <td>${o.v1}</td>
                <td>${o.operator}</td>
                <td>${o.v2}</td>
                <td>${o.result}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
