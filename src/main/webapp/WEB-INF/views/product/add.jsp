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
	  		<h4 style="text-transform: uppercase;">product Write</h4>
		</div>
	</div>
	
	<!-- 리스트 ajax -->
	<div class="row" id="list">
	
	</div>
	<!-- 리스트 ajax -->
	
	
	<div class="row mt-4">
		<form action="add" method="post" enctype="multipart/form-data" id="addform">
		
		  <div class="row mb-3">
		    <label for="productName" class="col-sm-2 col-form-label">Name</label>
		    <div class="col-sm-10">
		      <input type="text" name="productName" class="form-control" id="productName">
		    </div>
		  </div>
		  <div class="row mb-3">
		    <label for="productPrice" class="col-sm-2 col-form-label">Price</label>
		    <div class="col-sm-10">
		      <input type="text" name="productPrice" class="form-control" id="productPrice">
		    </div>
		  </div>
		 <div class="row mb-3">
		    <label for="productCount" class="col-sm-2 col-form-label">Count</label>
		    <div class="col-sm-10">
		      <input type="text" name="productCount" class="form-control" id="productCount">
		    </div>
		  </div>
		   <div class="row mb-3">
		    <label for="productDetail" class="col-sm-2 col-form-label">Detail</label>
		    <div class="col-sm-10">
		      <textarea name="productDetail" class="form-control" id="productDetail"></textarea>
		    </div>
			</div>
		  
	<div class="form-check">
  <input class="form-check-input sale" type="radio" value="1" name="sale">
  <label class="form-check-label" for="sale1">
    판매
  </label>
</div>
<div class="form-check">
  <input class="form-check-input sale" type="radio" value="0" name="sale" checked>
  <label class="form-check-label" for="sale0">
    판매중지
  </label>
</div>

		  <div id="fileResult"></div>
		  
		  <button type="button" id="fileAdd" class="btn btn-danger d-block my-4">FileADD</button>
		  
		  <button type="button" class="btn btn-primary" id="add">Write</button>
	</form>
	</div>	
</div>	
<script type="text/javascript" src="../resources/js/fileAdd.js"></script> <!-- fileAdd -->
<script type="text/javascript" src="../js/summernote.js"></script>   <!-- summernote -->

<script type="text/javascript">
fileAddInit(0);
summernoteInit("productDetail","");

//pager
//let pn=1;
$("#list").on("click",".pager",function(){
	let checkPn=$(this).attr("data-pn");
	if(checkPn>0){
		//pn=checkPn;
		getList(checkPn);
	}else{
		alert("마지막 페이지입니다.");
	};
});



//list
//GET ,URL:ajaxList
getList(1);
function getList(pn){
	$.ajax({
		type:"GET",
		url:"./ajaxList",
		data:{
			pn:pn,
			perPage:5
		},
		success:function(data){
			$("#list").html(data.trim());
		}
	});
};

//add
//upload
   $("#add").click(function(){
		let formData = new FormData();
	    let name=$("#productName").val();
	    let price=$("#productPrice").val();
	    let count=$("#productCount").val();
	    let detail=$("#productDetail").summernote("code");    //$("#detail").val();
	    let sale=0;
	    $(".sale").each(function(idx,item){
	    	if($(item).prop("checked")){
	    		sale =$(item).val();
	    	}
	    })
         $(".files").each(function(idx,item){
        	 if(item.files.length>0){
            console.log(idx);            //index번호
            console.log(item);            //<input type="file">
            console.log(item.files);      //input태그의 file List
            console.log(item.files[0]);      //files list 중 첫번쨰 파일
            console.log("length::",item.files.length);  
            console.log(item.files[0].name) //files list중 첫번째 파일의 이름
            //formData.append("파라미터명",값)
            formData.append("files",item.files[0]);
        	}
         });//each 끝
         formData.append("productName",name);//let name=$("#productName").val();
         formData.append("productPrice",price);
         formData.append("productCount",count);
         formData.append("productDetail",detail);
         formData.append("sale",sale);

    $.ajax({
        type:"POST",
        url :"./add",
        processData:false,
        contentType:false,
        data:formData/*{
           productName:name,
           productPrice:price,
           productCount:count,
           productDetail:detail
        }*/,
       success:function(data){
          if(data.trim()=='1'){
        	  alert("상품 등록 완료");
        	  getList();
        	  $("#productName").val("");
        	  $("#productPrice").val("");
        	  $("#productCount").val("");
        	  $("#productDetail").summernote("code","");
          } else{
        	  alert("상품 등록 실패");
          }
       },
       error:function(){
          alert("에러발생");
       }
    });
 }); 

</script>


</body>
</html>