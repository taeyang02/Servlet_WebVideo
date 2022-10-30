<%--
  Created by IntelliJ IDEA.
  User: 98tae
  Date: 10/08/2022
  Time: 8:17 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Admin</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<%@ include file="/views/admin/common/menu.jsp" %>
<h1>Video Edit</h1>
<div class="container d-flex justify-content-center">
  <div class="row">
    <form action="${pageContext.request.contextPath}/admin/video" method="post" enctype="multipart/form-data">
      <div class="row">
        <div class="col-sm-6 d-flex justify-content-center">
<%--          <img src="<c:url value = "views/detailVideo/images/${videoCurren.poster}"/>">--%>
          <input type="file" name="fileUploadDetail"/>
        </div>
        <div class="col-sm-6">
          <div class="mb-3 mt-3">
            <label class="form-label">Youtube ID:</label>
            <input class="form-control"  name="youtubeid" value="${videoCurren.id}">
          </div>
            <div class="mb-3 mt-3">
                <label class="form-label">Link:</label>
                <input class="form-control"  name="youtubeLink" value="${videoCurren.link}">
            </div>
          <div class="mb-3 mt-3">
            <label for="title" class="form-label">Video Title:</label>
            <input class="form-control"  name="title"  value="${videoCurren.title}">
          </div>
          <div class="mb-3 mt-3">
            <label for="count" class="form-label">Video Count:</label>
            <input class="form-control"  name="count" value="${videoCurren.views}">
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="isActive" value="active" ${videoCurren.active == true?"checked":""}>
            <label class="form-check-label" for="inlineRadio1">Active</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="isActive" value="unactive" ${videoCurren.active == false?"checked":""}>
            <label class="form-check-label" for="inlineRadio2">inActive</label>
          </div>
        </div>
        <div class="col-sm-12">
          <div class="mb-3">
            <label class="form-label">Example textarea</label>
            <textarea class="form-control"  rows="3" name="textarea"> ${videoCurren.depscription}</textarea>
          </div>
        </div>
        <div class="col d-flex justify-content-end"  style="margin-top: 15px;">
          <button class="btn btn-primary" type="submit" formaction="/asm/admin/video?funcion=homepage">Create</button>
          <button class="btn btn-primary" type="submit" formaction="/asm/admin/video?funcion=update">Update</button>
          <button class="btn btn-primary" type="submit" formaction="/asm/admin/video?funcion=delete">Delete</button>
          <a class="btn btn-primary" href="/asm/admin/video?funcion=homepage">Reset</a>
        </div>
      </div>
    </form>

    <div class="row" style="margin-top: 15px;">
      <table class="table">
        <thead>

        <tr>
          <th scope="col">User</th>
          <th scope="col">Password</th>
          <th scope="col">Fullname</th>
          <th scope="col">Status</th>
          <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items = "${videos}" var = "video">
        <tr>
          <td>${video.id}</td>
          <td>${video.title}</td>
          <td>${video.views}</td>
          <td>
            <c:choose>
              <c:when test = "${video.active == true}">
                Active
              </c:when>
              <c:otherwise>
                Un_Active
              </c:otherwise>
            </c:choose>
          </td>
          <td><a href="<c:url value = "/admin/video?funcion=edit&idvideohelf=${video.link}"/>">edit</a></td>
        </tr>
        </c:forEach>
        </tbody>

      </table>
      <div class="col d-flex justify-content-end"  style="margin-top: 55px;">
        <a class="btn btn-primary" href=""> |< </a>
        <a class="btn btn-primary" href="" style="margin:0px 15px 0px 15px ;"> < </a>
        <a class="btn btn-primary" href=""> > </a>
        <a class="btn btn-primary" href="" style="margin-left: 15px;">>| </a>
      </div>
    </div>
  </div>
</div>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
