<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/11
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script type="text/javascript">
        function ajax(){
            var ajax = new XMLHttpRequest();
            var username = document.getElementById("username").value;
            var url = "Ajax_Test_Servlet";
            ajax.open("post",url,true);
            ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            ajax.onreadystatechange = function(){
                if(ajax.readyState == 4 && ajax.status == 200){
                    var text = ajax.responseText;
                    var spanText = document.getElementById("checkusername");
                    spanText.innerHTML = text;
                }
            }
            ajax.send("username=" + username);
        }
    </script>
</head>
<body>
<div align="center">
    <form action="RegisterServlet" method="post">
    用户名：<input type="text" id="username" name="username" onblur="ajax();"/>
    <span id="checkusername"></span><br>
    密码：<input type="password" name="username"><br>
    <input type="submit" value="注册">
    </form>
</div>
</body>
</html>
