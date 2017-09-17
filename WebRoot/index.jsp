<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta http-equiv="pragma" content="no-cache">
      <meta http-equiv="cache-control" content="no-cache">
      <meta http-equiv="expires" content="0">
      <title>My JSP 'index.jsp' starting page</title>
      <link rel="stylesheet" type="text/css" href="bootstrap/bootstrap.min.css">
      <script type="text/javascript" href="bootstrap/bootstrap.min.js"></script>
        <style type="text/css">
            *{
                margin: 0;
                padding: 0;
            }
            html,body{
                width: 100%;
                height: 100%;
            }
            .container{
                position: absolute;
                left: 50%;
                top: 50%;
                transform: translate(-50%,-80%);
                text-align: center;
            }

            .form-group{
                height: 30px;
                text-align: center;
                position: relative;
            }
            input{
                position: absolute;
                left: 50%;
                top: 50%;
                transform: translate(-50%,-50%);
            }
        </style>
  </head>
  
  <body>
  <div class="container"style=" width: 200px;height: 200px;">
          <form action="user/loginservlet" name="login"  method="post">
          <div class="form-group">
              <input type="text" name="username" id="Input-Username" placeholder="Username" class="form-control" style="width: 150px">
          </div>
          <div class="form-group">
              <input type="password" name="password"id="Input-Password" placeholder="Password" class="form-control" style="width: 150px">
          </div>
              <div class="form-group">
                  <input type="submit" class="btn btn-default" value="Submit">
              </div>
<%
    session=request.getSession();
    session.setAttribute("aa",0);
%>



          </form>

  </div>

  </body>
</html>
