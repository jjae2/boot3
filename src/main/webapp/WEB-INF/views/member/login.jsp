<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
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
	<c:import url="../temp/header.jsp"></c:import>
	<c:import url="../temp/header_script.jsp"></c:import>
<div class="all">
<h1> 로그인 </h1>
<form action="./login" method="post">
  <!-- Email input -->
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example1">아이디</label>
    <input type="text" id="form2Example1" name="id" value="${cookie.remember.value}" class="form-control" />
  </div>

  <!-- Password input -->
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example2">비밀번호</label>
    <input type="password" id="form2Example2" name="pw" class="form-control" />
  </div>

  <!-- 2 column grid layout for inline styling -->
  <div class="row mb-4">
    <div class="col d-flex justify-content-center">
      <!-- Checkbox -->
      <div class="form-check">
        <input class="form-check-input" name="remember" value="1" type="checkbox" id="form2Example31" checked />
        <label class="form-check-label" for="form2Example31"> 아이디 저장 </label>
      </div>
   
    </div>
    </div>

  <!-- Submit button -->
  <div class="row">
  <button type="submit" class="btn btn-primary btn-block mb-4">Login</button>
  </div>

  <!-- Register buttons -->
  <div class="text-center">
    <p>회원이 아닌가요? <a href="/member/join">회원가입</a></p>
  </div>
  <div class="row">
  <button type="button" id="find" class="btn btn-primary btn-block mb-4">ID 찾기</button>
  </div>
  
</form>
</div>

     <script type="text/javascript">
     $("#find").click(function(){
    	 location.href="./findId";
     })
     </script>

</body>
</html>