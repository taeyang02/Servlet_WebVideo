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
			<div class="d-flex justify-content-center">
        <form action="${pageContext.request.contextPath}/user/changepass" method="post">
            <div></div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Tài Khoản</label>
                ${sessionScope.userCurrent.fullname}
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">
                    Mật Khẩu Cũ</label>
                <input type="password" class="form-control" id="txtMatKhau" name="passwordOld" />
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Mật Khẩu Mới</label>
                <input type="password" class="form-control" id="txtHoVaTen" name="passwordChange" />
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Nhập Lại Mật Khẩu</label>
                <input type="password" class="form-control" id="txtGmail" name="confimPasswordChange" />
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
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