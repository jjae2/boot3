<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<table class="table table-dark table-hover">
	<thead>
		<tr>
			<th>num</th>
			<th>name</th>
			<th>price</th>
			<th>count</th>
			<th>detail</th>
		</tr>
	</thead>
	<tbody>
	

<c:forEach items="${list}" var="vo">
		<tr>
		<td>${vo.productNum}</td>
		<td>${vo.productName}</td>
		<td>${vo.productPrice}</td>
		<td>${vo.productCount}</td>
		<td>${vo.productDetail}</td>
		</tr>
</c:forEach>
</tbody>
	</table>
		<div class="row">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a data-pn="${pager.pre?pager.startNum-1:0}" class="page-link pager"
					href="#"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>

				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li class="page-item"><a data-pn="${i}" class="page-link pager"
						href="#">${i}</a></li>
				</c:forEach>

				<li class="page-item"><a data-pn="${pager.next?pager.lastNum+1:0}" class="page-link pager"
					href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
	</div>
	