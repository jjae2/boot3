<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.all{
width:500px;
height:500px;
margin: 100px auto;
}
h1{
text-align: center;
}
</style>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="all">
<h1> 회원가입 </h1>
<form action="./join" method="post" enctype="multipart/form-data">
  <!-- Email input -->
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example1">아이디</label>
    <input type="text" id="form2Example1" name="id" class="form-control" />
  </div>

  <!-- Password input -->
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example2">비밀번호</label>
    <input type="password" id="form2Example2" name="pw" class="form-control" />
  </div>
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example3">이름</label>
    <input type="text" id="form2Example3" name="name" class="form-control" />
  </div>
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example4">이메일</label>
    <input type="text" id="form2Example4" name="email" class="form-control" />
  </div>
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example5">전화번호</label>
    <input type="text" id="form2Example5" name="phone" class="form-control" />
  </div>
    <div class="form-outline mb-4">
    <label class="form-label" for="form2Example6">프로필</label>
    <input type="file" id="form2Example6" name="profile" class="form-control" />
  </div>

  <!-- Submit button -->
  <button type="submit" class="btn btn-primary btn-block mb-4">Join</button>
</form>



<div class="form-check">
  <input class="form-check-input chall" type="checkbox" value="" id="all">
  <label class="form-check-label" for="all">
    checkbox-ALL
  </label>
</div>
<div class="form-check">
  <input class="form-check-input ch" type="checkbox" value="" id="check1" >
  <label class="form-check-label" for="check1">
    checkbox2
  </label>
</div>
<div class="form-check">
  <input class="form-check-input ch" type="checkbox" value="" id="check2">
  <label class="form-check-label" for="check2">
    checkbox3
  </label>
</div>
<div class="form-check">
  <input class="form-check-input ch" type="checkbox" value="" id="check3" >
  <label class="form-check-label" for="check3">
   checkbox4
  </label>
</div>
</div>

 <c:import url="../temp/header_script.jsp"></c:import>
 <script type="text/javascript">
 
 $("#all").click(function(){
	 $(".ch").prop("checked",$("#all").prop("checked"));
 });
 $(".ch").on("click",function(){
	   let check=true;
	   $(".ch").each(function(idx,item){
	      if(!$(item).prop("checked")){
	         check=false;
	      }
	   });
	   $("#all").prop("checked",check);
});
 </script>


</body>
</html>