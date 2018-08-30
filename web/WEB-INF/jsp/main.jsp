<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>main界面</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <%@include file="aside.jsp" %>
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <iframe id="centerFrame" src="${pageContext.request.contextPath}/center" class="col-md-12" frameborder="0"
                    scrolling="no" height="600px"></iframe>
        </main>
    </div>
    <input type="hidden" value="<shiro:principal property="name"/>" id="username">
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-treeview.js"></script>
<script>
    function getTree() {
        $.ajax({
                url: '/getTree',
                data: {username: $('#username').val()},
                type: 'post',
                dataType: 'json',
                success: function (data) {
                        $('#tree').treeview({
                            data: data,
                            onNodeSelected: function (event, node) {
                                if (node.href != null && node.href != undefined) {
                                    $("#centerFrame").attr("src", node.href);
                                }
                            }
                        })
                    }
            }
        )
        ;
    }

    $(function () {
        getTree();
    });
</script>
</body>

</html>