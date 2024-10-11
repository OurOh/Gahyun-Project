<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/main/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/footer/style.css">   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/header/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/main/style.css" />


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
