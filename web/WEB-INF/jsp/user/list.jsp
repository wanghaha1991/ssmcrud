<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/8/7
  Time: 17:11
  To change this tuserlate use File | Settings | File Tuserlates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">

<h2><a class="btn btn-sm btn-success" href="/user">用户添加</a></h2>
<div class="table-responsive">
    <table class="table table-striped table-sm">
        <thead>
        <tr>
            <th>#</th>
            <th>编号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user" varStatus="stat">
            <tr>
                <td>${stat.count}</td>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
                <td>
                    <a class="btn btn-sm btn-primary" href="/user/${user.id}">编辑</a>
                    <button class="btn btn-sm btn-danger" onclick="del(${user.id})">删除</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<form id="delForm" method="post">
    <input type="hidden" name="_method" value="DELETE">
</form>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-treeview.js"></script>
<script type="text/javascript">
    function del(id) {
        var action = '/user/';
        if (confirm("确定删除吗？")) {
            $('#delForm').attr('action', action + id).submit();
        }
    }
</script>
