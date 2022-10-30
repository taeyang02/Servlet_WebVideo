
<c:if test="${isAdmin == 'user'}">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand"
			   href="${pageContext.request.contextPath}/index" style="color: red">Online
				Entertainment</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
					data-bs-target="#navbarNav" aria-controls="navbarNav"
					aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
											aria-current="page" href="${pageContext.request.contextPath}/favorite">My Favorite</a></li>
					<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown"
							aria-expanded="false"> Account </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<c:if test="${empty sessionScope.userCurrent}">
								<li><a class="dropdown-item"
									   href="${pageContext.request.contextPath}/user/login">Login</a></li>
								<li><a class="dropdown-item" href="#">Forgot Password</a></li>
								<li><a class="dropdown-item"
									   href="${pageContext.request.contextPath}/user/register">Registration</a></li>
							</c:if>
							<c:if test="${not empty sessionScope.userCurrent}">
								<li><a class="dropdown-item"
									   href="${pageContext.request.contextPath}/user/logout">Logoff</a></li>
								<li><a class="dropdown-item" href="${pageContext.request.contextPath}/user/changepass">Change Password</a></li>
								<li><a class="dropdown-item" href="${pageContext.request.contextPath}/user/updateaccount">Edit Profile</a></li>
							</c:if>
						</ul>
					</li>
					<c:if test="${not empty sessionScope.userCurrent}">
						<c:if test="${sessionScope.userCurrent.admin == true}">
							<li class="nav-item"><a class="nav-link active"
													aria-current="page"
													href="${pageContext.request.contextPath}/admin/homepage">Administrion Tool</a></li>
						</c:if>
					</c:if>

				</ul>
			</div>
			<div>
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					 fill="currentColor" class="bi bi-outlet" viewBox="0 0 16 16">
					<path
							d="M3.34 2.994c.275-.338.68-.494 1.074-.494h7.172c.393 0 .798.156 1.074.494.578.708 1.84 2.534 1.84 5.006 0 2.472-1.262 4.297-1.84 5.006-.276.338-.68.494-1.074.494H4.414c-.394 0-.799-.156-1.074-.494C2.762 12.297 1.5 10.472 1.5 8c0-2.472 1.262-4.297 1.84-5.006zm1.074.506a.376.376 0 0 0-.299.126C3.599 4.259 2.5 5.863 2.5 8c0 2.137 1.099 3.74 1.615 4.374.06.073.163.126.3.126h7.17c.137 0 .24-.053.3-.126.516-.633 1.615-2.237 1.615-4.374 0-2.137-1.099-3.74-1.615-4.374a.376.376 0 0 0-.3-.126h-7.17z" />
					<path
							d="M6 5.5a.5.5 0 0 1 .5.5v1.5a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm4 0a.5.5 0 0 1 .5.5v1.5a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zM7 10v1h2v-1a1 1 0 0 0-2 0z" />
				</svg>
				<c:if test="${not empty sessionScope.userCurrent}">
					Hello ${sessionScope.userCurrent.fullname}
				</c:if>
			</div>
		</div>
	</nav>
</c:if>
<c:if test="${isAdmin == 'admin'}">
	<%@ include file="/views/admin/common/menu.jsp" %>
</c:if>
