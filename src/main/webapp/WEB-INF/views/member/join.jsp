<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <label class="form-label" for="form2Example2">이름</label>
    <input type="text" id="form2Example2" name="name" class="form-control" />
  </div>
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example2">이메일</label>
    <input type="text" id="form2Example2" name="email" class="form-control" />
  </div>
  <div class="form-outline mb-4">
    <label class="form-label" for="form2Example2">전화번호</label>
    <input type="text" id="form2Example2" name="phone" class="form-control" />
  </div>
    <div class="form-outline mb-4">
    <label class="form-label" for="form2Example2">프로필</label>
    <input type="file" id="form2Example2" name="profile" class="form-control" />
  </div>

  <!-- Submit button -->
  <button type="submit" class="btn btn-primary btn-block mb-4">Join</button>
</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>