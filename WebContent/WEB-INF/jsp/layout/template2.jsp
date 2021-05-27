<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
	<tiles:getAsString name="title"></tiles:getAsString>
</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
  <link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/styles.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath }/bootstarp/js/scripts.js"></script>
  <style>
    .fakeimg {
      height: 200px;
      background: #aaa;
    }
  </style>
</head>
<body>
	<tiles:insertAttribute name="menu">
	</tiles:insertAttribute>

	<hr>
	
	<tiles:insertAttribute name="head">
	</tiles:insertAttribute>

	<hr>

	<tiles:insertAttribute name="body">
	</tiles:insertAttribute>

	<hr>
	
	<tiles:insertAttribute name="foot">
	</tiles:insertAttribute>
</body>
</html>