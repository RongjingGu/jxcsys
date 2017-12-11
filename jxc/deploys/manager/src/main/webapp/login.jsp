<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cas登录</title>
    <script type="text/javascript" src="js/jquery-1.12.1.js"></script>
    <script type="text/javascript" src="js/jquery-form.js"></script>
    <script type="text/javascript">
        var errorMessage = '${errorMessage}';
        var loginUrl = '${loginUrl}';
        var redirectUrl = '${redirectUrl}';
        var casServiceHost = '${casServiceHost}';
    </script>
</head>
<body>

<form action="${casServiceHost}/remoteLogin" method="POST">
    <ul>
        <li>
            <em>错误信息：</em>
            <label type="text" style="width: 180px">${errorMessage}</label>
        </li>
        <li>
            <em>用户名：</em>
            <input name="username" id="id_username" type="text" style="width: 180px" />
        </li>
        <li>
            <em>密　码：</em>
            <input name="password" type="password"  id="id_password" style="width: 180px" />
        </li>

        <li class="mai">
            <em>记住我</em>
            <input type="checkbox" name="rememberMe" id="id_rememberMe" value="true"/>
        </li>
        <li>
            <em>当前登录地址</em>
            <input name="loginUrl" id="id_loginUrl" style="width: 300px" value="${loginUrl}" />
        </li>
        <li>
            <em>登录成功跳转</em>
            <input name="service" id="id_service" style="width: 300px" value="${redirectUrl}" />
        </li>
        <li>
            <em>表示远程登录</em>
            <input name="loginsubmit" id="id_loginsubmit" value="true" />
        </li>
        <li>
            <input name="" type="submit" value="登录" />
        </li>
    </ul>
</form>
</body>
</html>