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
<c:import url="../temp/header_script.jsp"></c:import>
<!-- 에디터 -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>


<title>Insert title here</title>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import> 

<div class="container mt-4">
	<div class="row mt-4">
		<div class="alert alert-light" role="alert">
	  		<h4 style="text-transform: uppercase;">${board} Update</h4>
		</div>
	</div>
	
	<div class="row mt-4">
		<form action="./update" method="post"   enctype="multipart/form-data">
		<input type="hidden" name="num" value="${vo.num}">
		 <div class="row mb-3">
		    <label for="contents" class="col-sm-2 col-form-label">Contents</label>
		    <div class="col-sm-10">
		      <textarea name="contents" class="form-control" id="contents"></textarea>
		    </div>
		  </div>
		  
			<div id="fileResult"></div>

			<button type="button" id="fileAdd" class="btn btn-primary">FileAdd</button>
			<div>
			<c:forEach items="${vo.boardFilesVO}" var="fileVO">
			<h4>${fileVO.oriName}<button data-num="${fileVO.fileNum}" type="button" class="col-1 btn btn-danger del">DELETE</button></h4>
			</c:forEach>
			</div>
			<div id="fileResult"></div>
		  
		  <button type="submit" class="btn btn-primary">Update</button>
		</form>
	
	</div>
	
	
</div>	

<script type="text/javascript" src="../resources/js/fileAdd.js"></script> <!-- fileAdd -->
<script type="text/javascript" src="../js/summernote.js"></script>   <!-- summernote -->
<script type="text/javascript">
	summernoteInit("contents","${vo.contents}");
	fileAddInit(${vo.boardFilesVO.size()})		//원래 있던 파일 갯수 매개변수로 넘겨줌
	fileDeleteInit();
</script>



</body>
</html>