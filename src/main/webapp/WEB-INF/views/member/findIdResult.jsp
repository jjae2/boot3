<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

<div class="container">
<h1>ID 찾기 결과 page</h1>

<div class="row">
<c:choose>
<c:when test="${not empty idResult}">
<h1><spring:message code="member.findID" arguments="${idResult.id}"></spring:message></h1>
</c:when>
<c:otherwise>
<h1><spring:message code="member.notFindId"></spring:message></h1>
</c:otherwise>
</c:choose>

</div>
</div>

</body>
</html>