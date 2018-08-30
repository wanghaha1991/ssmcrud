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

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/dashboard.css"  rel="stylesheet">

            <h2>添加页面</h2>
            <form  method="post" action="/emp">
                <div class="form-group">
                    <label>姓名</label>
                    <input name="name" type="text" class="form-control" placeholder="zhangsan" >
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input name="email" type="email" class="form-control" placeholder="zhangsan@qq.com" >
                </div>
                <div class="form-group">
                    <label>Gender</label><br/>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="1" >
                        <label class="form-check-label">男</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="0" >
                        <label class="form-check-label">女</label>
                    </div>
                </div>
                <div class="form-group">
                    <label>部门</label>
                    <select class="form-control" name="department.id" >
                        <c:forEach items="${depts}" var="dept">
                            <option value="${dept.id}" >${dept.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label>生日</label>
                    <input name="birthday" type="date" class="form-control" placeholder="zhangsan" >
                </div>
                <button type="submit" class="btn btn-primary" >添加</button>
            </form>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.slim.min.js" th:src="@{/webjars/jquery/3.3.1/jquery.js}"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" th:src="@{/webjars/bootstrap/4.0.0/js/bootstrap.js}"></script>

