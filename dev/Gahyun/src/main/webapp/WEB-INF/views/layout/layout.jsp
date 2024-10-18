<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/main/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/footer/style.css">   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/header/style.css">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.14.0/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/UserRegister/UserRegister.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/Reservation_confirm/confirm.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/Reservation_select/select.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/facilites/facilites.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/login/login.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/UserMyPage/UserMyPage.css" />
      
    <script src="${pageContext.request.contextPath}/res/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/res/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/res/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/res/js/regex.js"></script>
	<script src="${pageContext.request.contextPath}/res/js/script.js"></script>
	<script src="https://code.jquery.com/ui/1.14.0/jquery-ui.min.js"></script>
	
	
	
	
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
