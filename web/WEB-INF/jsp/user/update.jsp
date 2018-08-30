<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/8/8
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">


<h2>修改页面</h2>
<form method="post" action="/user/${user.id}">
    <input type="hidden" name="_method" value="PUT">
    <div class="form-group">
        <label>姓名</label>
        <input name="name" value="${user.name}" type="text" class="form-control" >
    </div>
    <div class="form-group">
        <label>密码</label>
        <input name="password"  type="text" class="form-control" >
    </div>
    <button type="submit" class="btn btn-primary">修改</button>
</form>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"
        th:src="@{/webjars/bootstrap/4.0.0/js/bootstrap.js}"></script>

