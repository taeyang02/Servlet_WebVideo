<%--
  Created by IntelliJ IDEA.
  User: 98tae
  Date: 13/08/2022
  Time: 11:12 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
<div class="container">
    <div>
<form action="${pageContext.request.contextPath}/admin/user" method="post">
    <div class="row">
        <div class="col-sm-6">
            <label>UserName</label>
            <input type="text" class="form-control" name="username">
        </div>
        <div class="col-sm-6">
            <label>Password</label>
            <input type="text" class="form-control" name="password">
        </div>
        <div class="col-sm-6">
            <label>Fullname</label>
            <input type="text" class="form-control" name="fullname">
        </div>
        <div class="col-sm-6">
            <label>Email</label>
            <input type="text" class="form-control" name="email">
        </div>
        <div class="col-sm-12 d-flex justify-content-end" style="padding-top: 25px;">
            <c:if test = "${isFuncion == true}">
                <button formaction="/asm/admin/user?funcion=update&idUser=${userCurren.id}" class="btn btn-primary" type="submit" style="margin-right: 25px">Update</button>
                <button formaction="/asm/admin/user?funcion=delete&idUser=${userCurren.id}" class="btn btn-primary" type="submit">Delete</button>
            </c:if>
        </div>
    </div>

</form>
    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">User</th>
                <th scope="col">Password</th>
                <th scope="col">Fullname</th>
                <th scope="col">Email</th>
                <th scope="col">Roll</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${users}" var = "user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.password}</td>
                    <td>${user.fullname}</td>
                    <td>${user.email}</td>
                    <c:choose>
                        <c:when test="${user.admin == true}">
                            <td>Admin</td>
                        </c:when>
                        <c:otherwise>
                            <td>User</td>
                        </c:otherwise>
                    </c:choose>

                    <td><a href="<c:url value = "/admin/user?funcion=update&idUser=${user.id}"/>">edit</a></td>
                </tr>
             </c:forEach>

            </tbody>
        </table>
    </div>


</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>

</body>
</html>
