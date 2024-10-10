<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    

<%@ page session="false" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <link rel="stylesheet" href="res/css/footer/style.css">   
    <link rel="stylesheet" href="res/css/header/style.css">
</head>
<!--header-->
	<tiles:insertAttribute name="header" />
<!-- /header -->
<!-- body -->
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
<!-- /body -->
<!-- footer -->
	<tiles:insertAttribute name="footer" />
<!-- /footer -->	
</html>
