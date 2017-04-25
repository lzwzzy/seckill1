<%--
  Created by IntelliJ IDEA.
  User: lzw
  Date: 2017/4/15
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String rootPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Forms</title>

    <link href="<%=rootPath%>/resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=rootPath%>/resource/css/datepicker3.css" rel="stylesheet">
    <link href="<%=rootPath%>/resource/css/styles.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="<%=rootPath%>/resource/js/html5shiv.js"></script>
    <script src="<%=rootPath%>/resource/js/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">登陆</div>
            <div class="panel-body">
                <form role="form" action="/seckill/dologin" method="post">
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="用户名" name="username" type="text" autofocus>
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="密码" name="password" type="password" >
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="remember" type="checkbox" value="Remember Me">记住我
                            </label>
                        </div>
                        <input type="submit" value="登陆" class="btn btn-primary">
                        <a href="#" class="btn btn-primary">注册</a>
                    </fieldset>
                </form>
            </div>
        </div>
    </div><!-- /.col-->
</div><!-- /.row -->



<script src="<%=rootPath%>/resource/js/jquery-1.11.1.min.js"></script>
<script src="<%=rootPath%>/resource/js/bootstrap.min.js"></script>
<script src="<%=rootPath%>/resource/js/chart.min.js"></script>
<script src="<%=rootPath%>/resource/js/chart-data.js"></script>
<script src="<%=rootPath%>/resource/js/easypiechart.js"></script>
<script src="<%=rootPath%>/resource/js/easypiechart-data.js"></script>
<script src="<%=rootPath%>/resource/js/bootstrap-datepicker.js"></script>
<script>
    !function ($) {
        $(document).on("click","ul.nav li.parent > a > span.icon", function(){
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    })
    $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    })
</script>
</body>

</html>
