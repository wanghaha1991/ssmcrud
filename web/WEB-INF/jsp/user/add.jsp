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

<h2>用户添加页面</h2>
<form  method="post" action="/user">
    <div class="form-group">
        <label>用户名</label>
        <input name="name" id="username" type="text" class="form-control" placeholder="zhangsan" >
        <span id="span"></span>
    </div>
    <div class="form-group">
        <label>password</label>
        <input name="password" type="text" class="form-control" placeholder="123456" >
    </div>
    <button type="submit" class="btn btn-primary" >添加</button>
</form>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js" th:src="@{/webjars/bootstrap/4.0.0/js/bootstrap.js}"></script>
<script type="text/javascript">
    $('#username').blur(function () {
        $.ajax({
            url:'isExist',
            data:{username:$('#username').val()},
            type:'post',
            success:function (data) {
                if (data==1){
                    $('#span').html(' ');
                    $('#span').html("用户名已经存在");
                } else {
                    $('#span').html(' ');
                }
            }
        })
    })
</script>

