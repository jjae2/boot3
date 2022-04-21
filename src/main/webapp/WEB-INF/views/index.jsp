<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- 써줘야함 -->
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
   
  
   

   <!-- Option 1: Bootstrap Bundle with Popper -->
   <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"></script>

</script>
</body>
</html>