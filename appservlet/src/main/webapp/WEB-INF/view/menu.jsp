<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>
<main class="container">
    <h1>Máquinas & Agregados</h1>

    <ul class="list-group">
        <c:url value="controller" var="listmachines">
            <c:param name="action" value="ListMachines"></c:param>
        </c:url>
        <a class="list-group-item" href="${listmachines}">Listar Máquinas</a>
        <c:url value="controller" var="listaggregates">
            <c:param name="action" value="ListAggregates"></c:param>
        </c:url>
        <a class="list-group-item disabled" aria-disabled="true" href="${listaggregates}">Listar Agregados</a>
    </ul>
</main>
<c:import url="footer.jsp"/>