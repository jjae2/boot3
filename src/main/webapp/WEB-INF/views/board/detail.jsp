<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="card" style="width: 18rem;">
<c:forEach items="${dto.boardFilesVO}" var="bf">
  <img src="../resources/upload/board/${bf.fileName}" class="card-img-top" alt="...">
  <p class="card-text"><a href="./fileDown?fileNum=${bf.fileNum}">${bf.oriName}</a></p>
  </c:forEach>
  <div class="card-body">
    <p class="card-text">${dto.title}</p>
    <p class="card-text">${dto.writer}</p>
    <p class="card-text">${dto.contents}</p>
  </div>
</div>
<div class="col-1">
	<a href="./update?num=${dto.num}" type="button" class="btn btn-outline-primary">UPDATE</a>
	<a href="./delete?num=${dto.num}" type="button" class="btn btn-outline-primary">DELETE</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>