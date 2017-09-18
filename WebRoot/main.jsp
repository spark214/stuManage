<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script src="easyui/jquery.min.js" type="text/javascript"></script>
    <script src="easyui/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="easyui/jquery.easyui.min.js" type="text/javascript"></script>
    <link type="text/css" href="easyui/themes/icon.css" rel="stylesheet">
    <link id="themeLink" type="text/css" href="easyui/themes/bootstrap/easyui.css" rel="stylesheet">
      <base href="<%=basePath%>">

      <title>My JSP 'main.jsp' starting page</title>
      <style type="text/css">
        a{
          color: #000000;
          text-decoration: none;
        }
        li{
          list-style: none;
          margin-bottom: 10px;
        }
      </style>

  </head>
  <jsp:include page="islogin.jsp"></jsp:include>
  <body class="easyui-layout">
  <!--顶部-->
  <div region="north" split="true" style="height:80px;">
    <div id="logo">
      LOGO
    </div>
    <div id="north-welcome" style="position: absolute;right: 20px;top: 20px;">
      欢迎你，[超级管理员],你使用<%=request.getRemoteAddr()%>登录!
    </div>
    <div id="north-themes" style="position: absolute;right: 20px;top:40px;">
      <a href="javascript:void(0)" id="north-mb" class="easyui-menubutton"  data-options="menu:'#Themesmeus',iconCls:'icon-edit'">切换风格</a>
      <div id="Themesmeus" style="width: 150px">
        <div>default</div>
        <div>gray</div>
        <div>black</div>
        <div>bootstrap</div>
        <div>material</div>
        <div>metro</div>
      </div>
    </div>
  </div>
  <!--底部-->
  <div region="south" split="true" style="height:30px;">
    <div id="copyright" style="text-align: center">&copy;ToZ LAB</div>
  </div>
  <!--左边-->
  <div region="west"  split="true" style="width:200px;">
    <div id="accordion" class="easyui-accordion"style="width:193px;" data-options="border:0,multiple:true">
      <div title="信息管理"  data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:10px;">
        <ul>

          <li><a href="javascript:void(0)" pageUrl="displaystuinfo.jsp">学生信息</a></li>

        </ul>
      </div>

      <div title="用户信息" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">
        <ul>
          <li><a href="user/exitservlet" >退出系统</a></li>
        </ul>

      </div>

    </div>

  </div>
  <!--中间-->
  <div region="center"  style="padding:5px;background:#eee;">
    <div id="center-title" class="easyui-tabs" style="width:500px;height:250px;" fit="true" border="false">
      <div title="起始页" style="padding:20px;display: none">
        欢迎登录后台管理系统
      </div>
    </div>
  </div>
  <script type="text/javascript">
      $(function () {
          $("a[pageUrl]").click(function () {
              var pageUrl=$(this).attr("pageUrl");
              var title=$(this).text();

              if($("#center-title").tabs("exists",title)){
                  $("#center-title").tabs("select",title);
              }
              else {
                  $("#center-title").tabs("add",{
                      title:title,
                      content:"<iframe src='"+pageUrl+"' width='100%' height='100%' frameborder='0'></iframe>",
                      closable:true
                  });
              }
          });

          $("#Themesmeus").menu({
              onClick:function (item) {
                  var themeName=item.text;
                  var href=$("#themeLink").attr("href");
                  href = href.substring(0,href.indexOf("themes"))+"themes/"+themeName+"/easyui.css";
                  $("#themeLink").attr("href",href);
              }
          });
      });
  </script>
  </body>
</html>
