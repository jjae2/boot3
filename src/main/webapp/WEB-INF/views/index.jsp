<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
<!-- header -->
<c:import url="./temp/header.jsp"></c:import>

   <div class="container mt-4">
      <div id="carouselExampleControls" class="carousel slide"
         data-bs-ride="carousel">
         <div class="carousel-inner">
            <div class="carousel-item active">
               <img
                  src="https://cdn.pharmnews.com/news/photo/202202/201305_71137_613.jpg"
                  class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
               <img
                  src="https://file.mk.co.kr/meet/neds/2022/04/image_readtop_2022_307579_16491633404999872.jpg"
                  class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
               <img
                  src="http://img.marieclairekorea.com/2019/03/mck_5c997e06a2dc0-750x499.jpg"
                  class="d-block w-100" alt="...">
            </div>
         </div>
         <button class="carousel-control-prev" type="button"
            data-bs-target="#carouselExampleControls" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
         </button>
         <button class="carousel-control-next" type="button"
            data-bs-target="#carouselExampleControls" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
         </button>
      </div>
   </div>
   
   <div class="container">
   <c:if test="${not empty member }">
   <c:forEach items="${member.roleVOs}" var ="vo">
     <h3>${vo.roleName}</h3>
     </c:forEach>
     </c:if>
   </div>
   
   
   
      <div class="container">
      <input type="text" id="v1">
      <input type="checkbox" class="num" name="num" value="a">
      <input type="checkbox" class="num" name="num" value="b">
      <input type="checkbox" class="num" name="num" value="c">
      <input type="checkbox" class="num" name="num" value="d">
     <button id="btn1">GET</button>
     <button id="btn2">POST</button>
     <button id="btn3">AJAX</button>
     </div>
   
 <c:import url="./temp/header_script.jsp"></c:import>
 
<script type="text/javascript">
$("#btn1").click(function(){
	let v = $('#v1').val()
	console.log(v);
	$.get("./getTest?msg="+v,function(data){
	console.log("응답 완료");
	console.log(data.trim());
	});
});
$("#btn2").click(function(){
	let v =$("#v1").val()
	console.log(v);
	$.post("./postTest",{msg:v},function(data){
		console.log(data.trim());
	});
	
});
$("#btn3").click(function(){
	let ar =[1,2,3];
	let nums=[];
	$(".num").each(function(idx,item){
		if($(item).prop("checked")){
			console.log($(item).val());
			nums.push($(item).val());
		}
	});
	let v =$("#v1").val();
	$.ajax({
		type:"POST",
		url:"./arrayTest",
		traditional:true,
	    data:{
	    	msg:v,
	    	numbers : ar,
	    	nums:nums
	    },
	    success:function(d){
	    	console.log(d.trim());
	    },
	    error:function(){
	    	alert("에러 발생");
	    }
	});
});

</script>
   


</body>
</html>