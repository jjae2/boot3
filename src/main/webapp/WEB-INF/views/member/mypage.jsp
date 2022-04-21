<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<div class="all">
<div class="card">
  <img src="../resources/upload/member/${dto.memberFilesVO.fileName}" class="card-img-top" alt=""/>
  <div class="card-body">
    <h1 class="card-title">회원 마이페이지</h1>
    <p class="card-text">아이디: ${member.id}</p>
    <p class="card-text">이름: ${dto.name}</p>
    <p class="card-text">이메일: ${dto.email}</p>
    <p class="card-text">전화번호: ${dto.phone}</p>
    <a href="./update?id=${member.id}" class="btn btn-primary">회원정보 수정</a>
    <a href="./delete?id=${member.id}" class="btn btn-primary">회원 탈퇴</a>
  </div>
</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>