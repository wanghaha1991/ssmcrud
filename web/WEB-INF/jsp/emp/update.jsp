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
    <link href="${pageContext.request.contextPath}/css/dashboard.css"  rel="stylesheet">


            <h2>修改页面</h2>
            <form  method="post" action="/emp/${emp.id}">
                <input type="hidden" name="_method" value="PUT">
                <div class="form-group">
                    <label>姓名</label>
                    <input name="name" value="${emp.name}" type="text" class="form-control" placeholder="zhangsan" >
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input name="email" value="${emp.email}" type="email" class="form-control" placeholder="zhangsan@qq.com" >
                </div>
                <div class="form-group">
                    <label>性别</label><br/>
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
                    <input name="birthday" value="<fmt:formatDate value="${emp.birthday}" pattern="yyyy-MM-dd"/>" type="date" class="form-control" placeholder="zhangsan" >
                </div>
                <button type="submit" class="btn btn-primary" >修改</button>
            </form>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.slim.min.js" th:src="@{/webjars/jquery/3.3.1/jquery.js}"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" th:src="@{/webjars/bootstrap/4.0.0/js/bootstrap.js}"></script>
<script type="text/javascript">
    $(function () {
        $("input[name='gender'][value=${emp.gender}]").attr("checked","checked");
        $("select").val(${emp.department.id});
    })
</script>

