<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.toz.model.stuInfo"%>
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
    <title>My JSP 'displaystuinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style type="text/css">
		*{
			padding: 0;
			margin: 0;
		}
	</style>

  </head>
  
  <body>
  <%request.setCharacterEncoding("utf-8") ;%>
  <script type="text/javascript">

	  var url;
          function openAddDialog() {
              $("#dlg-add").dialog("open");
              url="student/inputstuinfo";
          }
          function saveAdd() {
              $("#fm-add").form("submit",{
                  url:url,
                  success:function (result) {
                      if(result.errorMsg){
                          $.messager.alert("系统提示",result.errorMsg);
                          return;
                      }
                      else {
                          $.messager.alert("系统提示","保存成功");
//                          resetValue();
                          $("#dlg-add").dialog("close");
                          $("#tt").datagrid("reload");
                      }
                  }
              })
          }
          
          function openModifyDialog() {
			  var selectedRows=$("#tt").datagrid("getSelections");
			  if(selectedRows.length!=1){
			      $.messager.alert("系统提示","请选择一条要编辑的数据");
			      return;
			  }
			  var row=selectedRows[0];
			  $("#dlg-add").dialog("open").dialog("setTitle","编辑学生信息");
			  $("#fm-add").form("load",row);
			  url="student/modifyonestuinfo?id="+row.id;
          }
          
          function deleteStudent() {
			  var selectedRows=$("#tt").datagrid("getSelections");
			  if(selectedRows.length==0){
			      $.messager.alert("系统提示","请选择要删除的数据");
			      return;
			  }
			  var selectedIds=[];
			  for(var i=0;i<selectedRows.length;i++){
			      selectedIds.push(selectedRows[i].id);
			  }
			  var ids=selectedIds.join(",");
			  $.messager.confirm("系统提示","您确定要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function (r) {
				  if(r){
				      $.post("student/deletestudent",{ids:ids},function (result) {
						  if(result.success){
                              $.messager.alert("系统提示","您已成功删除<font color=red>"+result.delNums+"</font>条数据！");
                              $("#tt").datagrid("reload");
						  }else {
                              $.messager.alert('系统提示',result.errorMsg);
                              $("#tt").datagrid("reload");
						  }
                      },"json");

				  }
              });

          }

          function searchStudent() {
			  $("#tt").datagrid("load",{
			     truename:$("#search_name").val()
			  });
          }

          function closeDialog() {
			  $("#dlg-add").dialog("close");
//			  resetValue();
          }

  </script>

  <table id="tt" class="easyui-datagrid"  pagination="true" fitColumns="true"
  rownumbers="true" fit="true" toolbar="#toolbar" url="studisplay" title="学生信息" >
	<thead>
	<tr>
		<th field="id" checkbox="true" ></th>
		<th field="nicheng" width="150">昵称</th>
		<th field="truename" width="150">真实姓名</th>
		<th field="csrq" width="150">出生日期</th>
		<th field="zy" width="200">专业</th>
	</tr>
	</thead>
  </table>
<div id="toolbar">
	<a href="javascript:openAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
	<a href="javascript:openModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
	<a href="javascript:deleteStudent()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
	<div><input type="text" name="search_name" id="search_name"><a href="javascript:searchStudent()" class="easyui-linkbutton"
																   iconCls="icon-search" plain="true">搜索</a> </div>
</div>
  <div id="dlg-add" class="easyui-dialog" style="width: 570px;height: 350px;padding: 10px 20px" closed="true"
	   buttons="#dlg-buttons" >
		<form method="post" id="fm-add">
			<table cellspacing="5px">
				<tr>
					<td><input class="easyui-textbox" type="text" name="nicheng"
							   data-options="label:'Name:',required:true"></td>
					<td><label for="truename">真实姓名</label><input type="text" name="truename" id="truename"
																  class="easyui-validatebox" required="true"></td>
					<td><input class="easyui-textbox" name="csrq" data-options="label:'CSRQ:',required:true"></td>
				</tr>
			</table>
		</form>
  </div>
  <div id="dlg-buttons">
	  <a href="javascript:saveAdd()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
	  <a href="javascript:closeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
  </div>


  </body>
</html>
