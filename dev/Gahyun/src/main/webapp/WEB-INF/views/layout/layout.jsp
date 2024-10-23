<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/main/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/footer/style.css">   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/header/style.css">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.14.0/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/event/event.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/facilites/facilites.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/login/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/main/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/resortdetail/resortdetail.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/roomdetail/roomdetail.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/userEdit/userEdit.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/UserRegister/UserRegister.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/facilites/facilites.css?v=<%= System.currentTimeMillis() %>">

    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> <!-- jQuery 최신 버전 -->
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script> <!-- jQuery UI 버전 조정 -->
    
	<script src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/res/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/res/js/regex.js"></script>
	<script src="${pageContext.request.contextPath}/res/js/script.js"></script>
	
	
	
	
	
</head>
<!--header-->
	<tiles:insertAttribute name="header" />
<!-- /header -->
<!-- body -->
	<tiles:insertAttribute name="body" />
<!-- /body -->
<!-- footer -->
	<tiles:insertAttribute name="footer" />
<!-- /footer -->	
