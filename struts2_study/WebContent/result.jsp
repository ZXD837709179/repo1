<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@page import="com.opensymphony.xwork2.ActionContext" %>
<%@page import="com.opensymphony.xwork2.util.ValueStack" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>demo</title>
</head>
<body>
	<%
	ValueStack vs = ActionContext.getContext().getValueStack();
	out.write((String)vs.findValue("user.userName"));
	%>
	<!-- 用来看contextmap的数据 -->
	<s:debug></s:debug> 
</body>
</html>