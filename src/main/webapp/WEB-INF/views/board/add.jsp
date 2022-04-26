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
<c:import url="../temp/header_script.jsp"></c:import>
<!-- 에디터 -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<title>Insert title here</title>
</head>
<body>
 <c:import url="../temp/header.jsp"></c:import> 

<div class="container mt-4">
	<div class="row mt-4">
		<div class="alert alert-light" role="alert">
	  		<h4 style="text-transform: uppercase;">${board} Write</h4>
		</div>
	</div>
	
	
	<div class="row mt-4">
		<form action="add" method="post" enctype="multipart/form-data">
		  <div class="row mb-3">
		    <label for="title" class="col-sm-2 col-form-label">Title</label>
		    <div class="col-sm-10">
		      <input type="text" name="title" class="form-control" id="title">
		    </div>
		  </div>
		  <div class="row mb-3">
		    <label for="writer" class="col-sm-2 col-form-label">Writer</label>
		    <div class="col-sm-10">
		      <input type="text" name="writer" class="form-control" id="writer">
		    </div>
		  </div>
		 <div class="row mb-3">
		    <label for="contents" class="col-sm-2 col-form-label">Contents</label>
		    <div class="col-sm-10">
		      <textarea name="contents" class="form-control" id="contents"></textarea>
		    </div>
		  </div>
		  
		  <div id="fileResult"></div>
		  
		  <button type="button" id="fileAdd" class="btn btn-danger d-block my-4">FileADD</button>
		  
		  <button type="submit" class="btn btn-primary">Write</button>
	</form>
	</div>	
</div>	


<script type="text/javascript">
$(document).ready(function() {
	  $('#contents').summernote();
});

let count=0;
 $("#fileAdd").click(function() {
	 if(count>4){
	        alert('첨부파일은 최대 5개 까지만 가능합니다.');
	        return;
	    }
	 let f=' <div class="row mb-3">';
	 f=f+' <label for="contents" class="col-sm-2 col-form-label">Contents</label>';
	 f=f+'<div class="col-sm-10">';
	 f=f+'<div class="input-group">';
	 f=f+'<input type="file" class="form-control" id="files" name="files" aria-describedby="inputGroupFileAddon04" aria-label="Upload">'; 
	 f=f+'<button class="btn btn-outline-secondary del" type="button" id="inputGroupFileAddon04">X</button>';
	 f=f+'</div>';
	 f=f+'</div>';
	 f=f+'</div>';
	 count++;
	 
	$("#fileResult").append(f)
});
	//속성 안에 ""이 있어서 ''으로 묶는다

	$("#fileResult").on("click", ".del",function(){
		$(this).parent().parent().parent().remove();
		count--;
	})
</script>


</body>
</html>