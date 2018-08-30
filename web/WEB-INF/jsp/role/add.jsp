<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  role: asus
  Date: 2018/8/7
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/dashboard.css"  rel="stylesheet">

<h2>角色添加页面</h2>
<form  method="post" action="/role">
    <div class="form-group">
        <label>角色</label>
        <input name="name" type="text" class="form-control" placeholder="admin" >
    </div>
    <button type="submit" class="btn btn-primary" >添加</button>
</form>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.slim.min.js" th:src="@{/webjars/jquery/3.3.1/jquery.js}"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" th:src="@{/webjars/bootstrap/4.0.0/js/bootstrap.js}"></script>

