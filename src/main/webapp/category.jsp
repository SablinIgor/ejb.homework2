<%--
  Created by IntelliJ IDEA.
  User: Igor
  Date: 03.02.2018
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<html>
<head>
    <title>Категория продукта</title>
</head>
<body>
    <h3>Категория продукта</h3>

    <ul>
        <li>
            Идентификатор: ${сat.id}
        </li>
        <li>
            Код: ${сat.code}
        </li>
        <li>
            Имя: ${сat.name}
        </li>
        <li>
            Дата создания: ${сat.creationDate}
        </li>
    </ul>
</body>
</html>
