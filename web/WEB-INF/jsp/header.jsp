<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="http://getbootstrap.com/docs/4.0/examples/dashboard/#">欢迎您:<shiro:principal property="name"/></a>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="javascript:logout()">退出</a>
        </li>
    </ul>
</nav>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.slim.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-treeview.js" ></script>
<script type="text/javascript">
    function logout() {
        location.href="${pageContext.request.contextPath}/logout"
    }
</script>
