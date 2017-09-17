<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

	<script src="easyui/jquery.min.js" type="text/javascript"></script>
	<script src="easyui/jquery.easyui.min.js" type="text/javascript"></script>
	<script src="easyui/jquery.easyui.min.js" type="text/javascript"></script>
	<link type="text/css" href="easyui/themes/icon.css" rel="stylesheet">
	<link id="themeLink" type="text/css" href="easyui/themes/bootstrap/easyui.css" rel="stylesheet">
	<title>My JSP 'inputstuinfo.jsp' starting page</title>



</head>

<body>
<%request.setCharacterEncoding("utf-8"); %>
		<form action="student/inputstuinfo" method="post" id="ff">
			<div style="margin-bottom:20px">
			<input class="easyui-textbox" type="text"  name="nicheng" data-options="label:'Name:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="truename"  data-options="label:'Name:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<label>SEX:</label>
				<input type="radio" name="xb" checked value="1">男&nbsp;&nbsp;<input type="radio" name="xb" value="0">女</td>
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="csrq"  data-options="label:'CSRQ:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<select class="easyui-combobox" label="Language" name="zy" style="width: 175px">
					<option selected>&nbsp;</option>
					<option>计算机科学与技术</option>
					<option>通信工程</option>
					<option>电气工程</option>
				</select>
			</div>
			<div style="margin-bottom:20px">
					<input type="checkbox" value="music" name="xq">听音乐
					<input type="checkbox" value="book" name="xq">看小说
					<input type="checkbox" value="web" name="xq">上网
			</div>

			<div style="margin-bottom:20px">
					<td><textarea rows=3 cols=20 name="bz"></textarea></td>
			</div>

			<div style="margin-bottom:20px;">
				<input class="easyui-linkbutton" type="submit" value="提交">
			</div>
		</form>

<%
	session=request.getSession();
	String s=null;
	if(session.getAttribute("aa").toString().equals("11")){%>
	<div class="easyui-window" title=" " iconCls="icon-save" style="width: 200px;height: 200px">录入成功</div>
<%
		session.setAttribute("aa",0);
	}
%>

</body>
</html>