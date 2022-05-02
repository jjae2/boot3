<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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
	<c:import url="../temp/header.jsp"></c:import>

	<div class="container">

		<div class="container mt-4">
				<div class="row mt-4 ">
					<div class="alert alert-primary" role="alert">
						<h4 class="text-center" style="text-transform: capitalize;">${board}
							DETAIL</h4>
					</div>
				</div>
		</div>
			<ul class="list-group">
  				<li class="list-group-item disabled" aria-disabled="true">NO. ${vo.num}</li>
 				<li class="list-group-item">Title : ${vo.title }</li>
  				<li class="list-group-item">Contents : ${vo.contents }</li>
  				<li class="list-group-item">Writer : ${vo.writer }</li>
  				
  				<c:forEach items="${vo.boardFilesVO}" var="f">
					<li class="list-group-item">File : <a href="./fileDown?fileNum=${f.fileNum}" class="card-img-top">${f.oriName }</a></li>
				</c:forEach>
			</ul>				

		<div class="btn-group mt-3">
			<a href="./update?num=${vo.num}" class="btn btn-primary">UPDATE</a> <a
				href="./delete?num=${vo.num}" class="btn btn-primary">DELETE</a>
		</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>