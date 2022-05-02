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


	<form action="./update" method="post" enctype="multipart/form-data">
	<div class="container">

			<div class="container mt-4">
				<div class="row mt-4 ">
					<div class="alert alert-primary" role="alert">
						<h4 class="text-center" style="text-transform: capitalize;">Product
							UPDATE</h4>
					</div>
				</div>
				<div class="mb-3">
					<input type="hidden" name="productNum" value="${vo.productNum}">
					<label for="exampleInputPassword1" class="form-label">NAME</label>
					<input type="text" class="form-control" id="productName" name="productName"
						value="${vo.productName }">
				</div>
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Count</label> <input
						type="text" class="form-control" id="count"
						aria-describedby="emailHelp" name="productCount" value="${vo.productCount}">
				</div>
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">PRICE</label> <input
						type="text" class="form-control" id="price"
						aria-describedby="emailHelp" name="productPrice" value="${vo.productPrice}">
				</div>
					<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Detail</label> 
					<textarea class="form-control" id="productDetail" name="productDetail"></textarea>
					
				</div>
			
			</div>
		

			<div class="mb-3">
				<div class="form-check">
					<input class="form-check-input sale" type="radio"
						name="sale" value="1" ${vo.sale eq 1?'checked':''}  id="flexRadioDefault1"> <label
						class="form-check-label" for="flexRadioDefault1"> 판매</label>
				</div>
				<div class="form-check">
					<input class="form-check-input sale" type="radio"
						name="sale" value="0" ${vo.sale eq 0?'checked':''} id="flexRadioDefault2" > <label
						class="form-check-label" for="flexRadioDefault2"> 판매중지</label>
				</div>
			</div>


			<div id="fileResult"></div>

			<button type="button" id="fileAdd" class="btn btn-primary">FileAdd</button>
			<div>
			<c:forEach items="${vo.productFilesVO}" var="fileVO">
			<h4>${fileVO.oriName}<button data-num="${fileVO.fileNum}" type="button" class="col-1 btn btn-danger del">DELETE</button></h4>
			</c:forEach>
			</div>
			<div id="fileResult"></div>

			
		<div class="row justify-content-end">
					<button type="submit" class="col-1 btn btn-primary ">Update!!!!</button>

				</div>
				</div>
		</form>
	</div>

<script type="text/javascript" src="../resources/js/fileAdd.js"></script> <!-- fileAdd -->
<script type="text/javascript" src="../js/summernote.js"></script>   <!-- summernote -->
<script type="text/javascript">
	summernoteInit("productDetail","${vo.productDetail}");
	fileAddInit(${vo.productFilesVO.size()})		//원래 있던 파일 갯수 매개변수로 넘겨줌
	 fileDeleteInit();
</script>



</body>
</html>