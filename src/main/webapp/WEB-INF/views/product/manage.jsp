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
<c:import url="../temp/header_script.jsp"></c:import>
<c:import url="../temp/header.jsp"></c:import>
<h1> manage page</h1>
<div class= "container">
   <c:import url="../common/productList.jsp"></c:import>
   <form id="frm" action="./manage">
      <input type="hidden" id="pn" name="pn" value="${pager.pn}">
   </form>
   		<div class="col-1">
			<a href="./add" type="button" class="btn btn-outline-primary">WRITE</a>
		</div>

</div>


<c:import url="../temp/header_script.jsp"></c:import>

<script type="text/javascript">
   $(".pager").click(function(){
      let pn=$(this).attr("pn");
   $("#pn").val(pn);
   $("#frm").submit();
   })


</script>


</body>
</html>