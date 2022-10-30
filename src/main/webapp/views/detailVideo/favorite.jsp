<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Assignment</title>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
  <header class="row"></header>
  <%@ include file="/views/common/menu.jsp" %>
  <div style="padding-top: 25px"></div>
  <div class="row">
    <article class="row">
      <c:forEach items = "${videos}" var ="video">
        <div class="col-sm-4">
          <div class="card" style="width: 18rem;">
            <ul class="list-group list-group-flush">
              <a class="list-group-item" href="<c:url value = "/video?action=watch&id=${video.link}"/>">
                <img src="<c:url value = "views/detailVideo/images/${video.poster}"/>">
              </a>
              <li class="list-group-item">${video.title}</li>
              <li class="list-group-item">
                <a href="<c:url value = "/video?action=like&id=${video.link}"/>" type="button" class="btn btn-primary">
                  Unlike
                  </a>
                <a href="<c:url value = "/share?id=${video.link}"/>"type="button" class="btn btn-warning">Share</a>
              </li>
            </ul>
          </div>
        </div>
      </c:forEach>
    </article>
  </div>

</div>


<script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>