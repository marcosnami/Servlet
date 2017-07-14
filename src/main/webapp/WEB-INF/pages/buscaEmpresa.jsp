<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<body>
Resultado da busca:
<ul>
    <c:forEach items="${empresas}" var="empresa">
        <li>${empresa.id}: ${empresa.nome}</li>
    </c:forEach>

</ul>
</body>
</html>