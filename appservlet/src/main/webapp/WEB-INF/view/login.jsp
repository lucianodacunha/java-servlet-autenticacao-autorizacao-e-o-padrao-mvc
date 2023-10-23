<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script
      src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
  <a class="navbar-brand" href="#">Top navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarCollapse">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <c:url value="/controller" var="controller">
          <c:param name="action" value="Menu"></c:param>
        </c:url>
        <a class="nav-link" href="${controller}">Home <span class="sr-only">(current)</span></a>
      </li>
    </ul>
  </div>
</nav>
<main role="main" class="container">
      <c:if test="${loginError}">
        <div class="alert alert-warning" role="alert">
          Falha ao efetuar login. Username ou Password incorretos.
        </div>
      </c:if>
      <h1>Login</h1>
      <c:url value="/controller" var="controller">
        <c:param name="action" value="Login"></c:param>
      </c:url>
      <form action="${controller}" method="post">
        <div class="form-group">
          <label for="login" class="form-text">Login:</label>
          <input type="text" name="login" id="login" class="form-control" required>
        </div>
        <div class="form-group">
          <label for="password" class="form-text">Password:</label>
          <input type="password" name="password" id="password" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
      </form>
</main>
</body>
</html>