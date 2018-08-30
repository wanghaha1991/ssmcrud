    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%--
          Created by IntelliJ IDEA.
          User: asus
          Date: 2018/8/7
          Time: 17:52
          To change this template use File | Settings | File Templates.
        --%>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">

        <h2>菜单添加页面</h2>
        <form method="post" action="/menu">
        <div class="form-group">
        <label>菜单名</label>
        <input name="name" type="text" class="form-control" placeholder="menu" >
        </div>
        <div class="form-group">
        <label>URL</label>
        <input name="url" type="text" class="form-control" placeholder="url" >
        </div>
        <div class="form-group">
        <label>父节点</label>
        <select class="form-control" name="parentId" >
        <c:forEach items="${menus}" var="menu">
            <option value="${menu.id}" >${menu.name}</option>
        </c:forEach>
        </select>
        </div>
        <div class="form-group">
        <label>权限名</label>
        <input name="privilege" type="text" class="form-control">
        </div>
        <button type="button" onclick="Btnclick()" class="btn btn-primary" >添加</button>
        </form>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"
        th:src="@{/webjars/bootstrap/4.0.0/js/bootstrap.js}"></script>
        <script type="text/javascript">
        function Btnclick() {
        $('form').submit();
        window.parent.location.reload();
        }
        </script>
