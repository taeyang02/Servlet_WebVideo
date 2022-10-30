<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<%@ include file="/views/common/menu.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-sm-9">
			<article class="row">
				<div class="col-sm-12">
					<iframe width="820" height="455" src="https://www.youtube.com/embed/${video.link}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
				</div>
				<div class="col-sm-12">
					<h1>${video.title}</h1>
				</div>
				<div class="col-sm-12">
					<h3>${video.depscription}</h3>
				</div>
				<div class="col-sm-12">
					<a href="<c:url value = "/video?action=like&id=${video.link}"/>"type="button" class="btn btn-primary">
						<c:choose>
						<c:when test="${flagLikedBtn == true}">
								UnLike
						</c:when>
							<c:otherwise>
								Like
							</c:otherwise>
						</c:choose> </a>
					<a href="<c:url value = "/share?id=${video.link}"/>" type="button" class="btn btn-warning">Share</a>
				</div>
			</article>
			</div>
			<div class="col-sm-3">
			<aside class="row">
				<c:forEach items = "${videos}" var ="videoaside">
				<div class="col-sm-12" style="margin-bottom: 25px">
					<c:if test = "${videoaside.link != video.link}">
					<a href="<c:url value = "/video?action=watch&id=${videoaside.link}"/>" style="text-decoration: none;color: black">
						<img src="<c:url value = "views/detailVideo/images/${videoaside.poster}"/>" class="col-sm-6"><i class="col-sm-6">${videoaside.title}</i></a>
					</c:if>
				</div>
				</c:forEach>
			</aside>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>