<%--
  Created by IntelliJ IDEA.
  User: 98tae
  Date: 10/08/2022
  Time: 8:22 am
  To change this template use File | Settings | File Templates.
--%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/homepage">Adminnistration Tool</a>
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index">Manager User Tool</a>
        <a class="navbar-brand"
               href="${pageContext.request.contextPath}/user/logout">Logoff</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="d-flex justify-content-end collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/admin/video?funcion=homepage">Videos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/admin/user">User</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/admin/video/">Report</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
