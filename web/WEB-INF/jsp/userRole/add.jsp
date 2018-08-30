<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/8/7
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-select.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/defaults-zh_CN.min.js"></script>

<h2>用户授权页面</h2>
<form method="post" action="/userRole">
    <div class="form-group">
        <label>用户名</label>
        <select id="userId" class="form-control" name="userId">
            <c:forEach items="${users}" var="user">
                <option value="${user.id}">${user.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>角色名</label>
        <select id="roleId" class="selectpicker" multiple data-done-button="true" name="roleIds" >
        </select>
    </div>
    <button type="submit" class="btn btn-primary">授权</button>
</form>
<script type="text/javascript">
    $('#userId').blur(function () {
        $.ajax({
            data:{userId:$('#userId').val()},
            url:'getRole',
            type:'post',
            success:function (data) {
                $('#roleId').html('');
                $.each(data,function (n,value) {
                    $("#roleId").append("<option value='"+value.id+"'>"+value.name+"</option>");
                });
                $('#roleId').selectpicker('refresh');
                $('#roleId').selectpicker('render');
            }
        })
    })
</script>


