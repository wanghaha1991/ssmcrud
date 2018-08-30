    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <%--
          Created by IntelliJ IDEA.
          User: asus
          Date: 2018/8/8
          Time: 16:54
          To change this tmenulate use File | Settings | File Tmenulates.
        --%>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this tmenulate -->
        <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">


        <h2>菜单修改页面</h2>
        <form method="post" action="/menu/${menu.id}">
        <input type="hidden" name="_method" value="PUT">
        <div class="form-group">
        <label>菜单名</label>
        <input name="name" value="${menu.name}" type="text" class="form-control" placeholder="zhangsan" >
        </div>
        <div class="form-group">
        <label>URL</label>
        <input name="url" value="${menu.url}" type="text" class="form-control" placeholder="zhangsan@qq.com" >
        </div>
        <div class="form-group">
        <label>父菜单编号</label>
        <input name="parentId" value="${menu.parentId}" type="text" class="form-control" placeholder="zhangsan@qq.com" >
        </div>
        <div class="form-group">
        <label>权限名</label>
        <input name="privilege" value="${menu.privilege}" type="text" class="form-control" placeholder="zhangsan@qq.com"
        >
        </div>
        <div class="form-group">
        <label>菜单级别</label>
        <input name="level" value="${menu.level}" type="text" class="form-control" placeholder="zhangsan@qq.com" >
        </div>
        <button type="submit" class="btn btn-primary" >修改</button>
        </form>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.slim.min.js"
        th:src="@{/webjars/jquery/3.3.1/jquery.js}"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"
        th:src="@{/webjars/bootstrap/4.0.0/js/bootstrap.js}"></script>



