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
			
				<form action="${pageContext.request.contextPath}/user/login" method="post">
					<div class="container py-2 h-100">
						<div
							class="row d-flex justify-content-center align-items-center h-100">
							<div class="col-12 col-md-8 col-lg-6 col-xl-5">
								<div class="card bg-dark text-white"
									style="border-radius: 1rem;">
									<div class="card-body p-5 text-center">
										<div class="mb-md-5 mt-md-4 pb-5">
											<h2 class="fw-bold mb-2 text-uppercase">Màn Hình Đăng
												Nhập</h2>
											<p class="text-white-50 mb-5">Hãy Nhập Tài Khoản Mật Khẩu
												Của Mày!</p>

											<div class="form-outline form-white mb-4">
												<label class="form-label" for="typeEmailX">Tài Khoản</label>
												<input type="text" class="form-control form-control-lg"
													name="username" />
											</div>

											<div class="form-outline form-white mb-4">
												<label class="form-label" for="typePasswordX">Mật
													Khẩu</label> <input type="password"
													class="form-control form-control-lg" name="password" />
											</div>

											<button class="btn btn-outline-light btn-lg px-5"
												type="submit">Đăng Nhập</button>
											<a style="margin-top: 15px" class="btn btn-outline-light btn-lg px-5"
											href="<c:url value = "/user/login/faceid"/>">Đăng Nhập FaceID</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>

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