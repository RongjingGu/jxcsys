<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="UTF-8">
    <link type="image/x-icon" href="./images/ymkd.ico" rel="shortcut icon">
    <title>网景科技</title>
    <link href="./css/0.css" rel="stylesheet">
</head>
<script>
    window.configs = {
        ADMIN_URL: 'http://127.0.0.1:8900',
        LOGOUT_URL: './#/login',
        MAP_KEY: 'acfe339236c6150eb8e5582f5362843d',
        MAP_Service_URL: '/portal',
    };
</script>
<body>
<!--[if lte IE 9]>
<div class="ie-support"
     style="width:100%;height:50px;background-color: #dc6356;color: #fff;text-align: center;line-height: 50px;font-size: 18px;">
    不支持IE9及IE9以下版本的IE浏览器，为得到更好的体验，建议使用Chrome浏览器
</div>
<![endif]-->
<div id="contentApp"></div>
</body>
<script type="text/javascript" src="./js/front.js"></script>
</html>
