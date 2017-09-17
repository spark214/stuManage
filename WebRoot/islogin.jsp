<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.toz.model.userTable" %>
<%@ page import="com.toz.service.userservice" %>
<% userTable user=(userTable)session.getAttribute("user");
if(user==null){
%>
<jsp:forward page="index.jsp"></jsp:forward>
<%
}

 %>