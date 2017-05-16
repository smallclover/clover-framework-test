<%--
  Created by IntelliJ IDEA.
  User: smallclover
  Date: 2017/2/20
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="assert/jquery-3.2.1.min.js"></script>
</head>
<body>
    welcome ${username}!!
    <form>
        <input type="text" name="username" id="username">
        <input type="button" name="submit" value="查询" onclick="search()">
    </form>
    <div>

    </div>
    <script type="text/javascript">
        function search() {
            var username = document.getElementById("username").value;

            $.ajax({
                type:"POST",
                url:"search",
                data:{username:username},
                dataType:"json",
                success:function (msg) {
                    var username = msg.username;
                    var password = msg.password;
                    alert("username: " + username + "\n password: " + password);
                }
            })

        }
    </script>
</body>
</html>
