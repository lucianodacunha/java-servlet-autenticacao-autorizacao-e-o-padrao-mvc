<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="header.jsp"/>
<main role="main" class="container">
  <c:choose>
    <c:when test="${empty machine}">
      <h1>Cadastro de nova máquina</h1>
      <c:url value="/controller" var="controller">
        <c:param name="action" value="CreateMachine"></c:param>
      </c:url>
      <form action="${controller}" method="post">
        <div class="form-group">
          <label for="type" class="form-text">Máquina:</label>
          <input type="text" name="type" id="type" class="form-control" required>
        </div>
        <div class="form-group">
          <label for="model" class="form-text">Modelo:</label>
          <input type="text" name="model" id="model" class="form-control" required>
        </div>
        <div class="form-group">
          <label for="year" class="form-text">Ano:</label>
          <input type="text" name="year" id="year" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Enviar</button>
      </form>
    </c:when>
    <c:otherwise>
      <h1>Atualização de máquina</h1>
      <c:url value="/controller" var="controller">
        <c:param name="action" value="UpdateMachine"></c:param>
      </c:url>
      <form action="${controller}" method="post">
        <input type="hidden" name="id" value="${machine.id}">
        <div class="form-group">
          <label for="type" class="form-text">Máquina:</label>
          <input type="text" name="type" id="type" class="form-control" value="${machine.type}" required>
        </div>
        <div class="form-group">
          <label for="model" class="form-text">Modelo:</label>
          <input type="text" name="model" id="model" class="form-control" value="${machine.model}" required>
        </div>
        <div class="form-group">
          <label for="year" class="form-text">Ano:</label>
          <input type="text" name="year" id="year" class="form-control" value="${machine.year}" required>
        </div>
        <button type="submit" class="btn btn-primary">Enviar</button>
      </form>
    </c:otherwise>
  </c:choose>
</main>
<c:import url="footer.jsp"/>