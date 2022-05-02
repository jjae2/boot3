<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="all">
<form action="./findId" method="post">
  <!-- Email input -->
  <h1>아이디 찾기 페이지</h1>
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example1">이메일</label>
    <input type="text" id="form2Example1" name="email"  class="form-control" />
  </div>
   <div class="row">
  <button type="submit" class="btn btn-primary btn-block mb-4">아이디 찾기</button>
  </div>
  </form>
</div>
</body>
</html>