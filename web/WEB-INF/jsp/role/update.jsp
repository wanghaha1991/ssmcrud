<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  role: asus
  Date: 2018/8/8
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">


<h2>修改页面</h2>
<form method="post" action="/role/${role.id}">
    <input type="hidden" name="_method" value="PUT">
    <div class="form-group">
        <label>id</label>
        <input name="id" readonly value="${role.id}" type="text" class="form-control" >
    </div>
    <div class="form-group">
        <label>角色名</label>
        <input name="name" value="${role.name}" type="text" class="form-control" >
    </div>
    <button type="submit" class="btn btn-primary">修改</button>
</form>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.slim.min.js"
        th:src="@{/webjars/jquery/3.3.1/jquery.js}"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"
        th:src="@{/webjars/bootstrap/4.0.0/js/bootstrap.js}"></script>

