<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>
<main class="container">
    <h1>Listar Máquinas</h1>
    <c:choose>
        <c:when test="${empty machines}">
            <div class="alert alert-warning">
                Nehnum registro encontrado
            </div>
        </c:when>
        <c:otherwise>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Modelo</th>
                    <th scope="col">Ano</th>
                    <th scope="col">Remover</th>
                    <th scope="col">Atualizar</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${machines}" var="machine">
                    <tr>
                        <th scope="row">${machine.id}</th>
                        <td>${machine.type}</td>
                        <td>${machine.model}</td>
                        <td>${machine.year}</td>
                        <c:url var="controller" value="/controller">
                            <c:param name="action" value="DeleteMachine"></c:param>
                            <c:param name="id" value="${machine.id}"></c:param>
                        </c:url>
                        <td><a href="${controller}"><i class="fas fa-trash"></i></a></td>
                        <c:url var="controller" value="/controller">
                            <c:param name="action" value="UpdateMachine"></c:param>
                            <c:param name="id" value="${machine.id}"></c:param>
                        </c:url>
                        <td><a href="${controller}"><i class="fas fa-edit"></i></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
    <c:url value="/controller" var="controller">
        <c:param name="action" value="NewMachine"></c:param>
    </c:url>
    <a type="submit" class="btn btn-success" href="${controller}" role="button">Nova Máquina</a>
</main>
</body>
</html>