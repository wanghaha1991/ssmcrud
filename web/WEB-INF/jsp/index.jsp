<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2018/8/7
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>登录</title>
  <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
</head>

<body class="text-center">
<form class="form-signin" action="/login" method="post">
  <img class="mb-4" src="${pageContext.request.contextPath}/img/bootstrap-solid.svg" alt="" width="72" height="72">
  <h1 class="h3 mb-3 font-weight-normal"><spring:message code="sign"/></h1>
  <label class="sr-only"><spring:message code="username"/></label>
  <input type="text" name="name" class="form-control" placeholder="<spring:message code="username"/>" required="" autofocus="">
  <label class="sr-only"><spring:message code="password"/></label>
  <input type="password" name="password" class="form-control" placeholder="<spring:message code="password"/>" required="">
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> <spring:message code="remember"/>
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="btn"/></button>
  <p class="mt-5 mb-3 text-muted">© 2017-2018</p>
  <a class="btn btn-sm" href="?locale=zh_CN">中文</a>
  <a class="btn btn-sm"  href="?locale=en_US">English</a>
</form>

</body>

</html>
