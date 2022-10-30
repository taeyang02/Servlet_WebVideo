<div class="row">
  <article class="row">
    <c:forEach items = "${videos}" var ="video">
      <div class="col-sm-4">
        <div class="card d-flex" style="width: 18rem;">
          <ul class="list-group list-group-flush">
            <a class="list-group-item" href="<c:url value = "/video?action=watch&id=${video.link}"/>">
              <img src="<c:url value = "/views/detailVideo/images/${video.poster}"/>" width="246" height="138">
            </a>
            <li class="list-group-item">${video.title}</li>
            <li class="list-group-item">
              <i>Views : ${video.views}</i>
            </li>
          </ul>
        </div>
      </div>
    </c:forEach>
  </article>
</div>
<div style="padding-top: 25px" class="d-flex justify-content-center">
  <a type="button" class="btn btn-primary" href="${requestScope['javax.servlet.forward.request_uri']}?indexpage=1"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-bar-left" viewBox="0 0 16 16">
    <path fill-rule="evenodd" d="M11.854 3.646a.5.5 0 0 1 0 .708L8.207 8l3.647 3.646a.5.5 0 0 1-.708.708l-4-4a.5.5 0 0 1 0-.708l4-4a.5.5 0 0 1 .708 0zM4.5 1a.5.5 0 0 0-.5.5v13a.5.5 0 0 0 1 0v-13a.5.5 0 0 0-.5-.5z"/>
  </svg></a>
  <c:choose>
    <c:when test="${currentPage == 1}">
      <a type="button" class="btn btn-primary" href="${requestScope['javax.servlet.forward.request_uri']}?indexpage=${pagesize}" style="margin: 0px 15px 0px 15px"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
      </svg></a>
    </c:when>
    <c:otherwise>
      <a type="button" class="btn btn-primary" href="${requestScope['javax.servlet.forward.request_uri']}?indexpage=${currentPage-1}" style="margin: 0px 15px 0px 15px"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-compact-left" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M9.224 1.553a.5.5 0 0 1 .223.67L6.56 8l2.888 5.776a.5.5 0 1 1-.894.448l-3-6a.5.5 0 0 1 0-.448l3-6a.5.5 0 0 1 .67-.223z"/>
      </svg></a>
    </c:otherwise>
  </c:choose>
  <h3 style="margin-right: 15px">${currentPage}/${pagesize}</h3>
  <c:choose>
    <c:when test="${currentPage == pagesize}">
      <a type="button" class="btn btn-primary" href="${requestScope['javax.servlet.forward.request_uri']}?indexpage=1"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
      </svg></a>
    </c:when>
    <c:otherwise>
      <a type="button" class="btn btn-primary" href="${requestScope['javax.servlet.forward.request_uri']}?indexpage=${currentPage+1}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708z"/>
      </svg></a>
    </c:otherwise>
  </c:choose>
  <a type="button" class="btn btn-primary" href="${requestScope['javax.servlet.forward.request_uri']}?indexpage=${pagesize}" style="margin-left: 15px"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-bar-right" viewBox="0 0 16 16">
    <path fill-rule="evenodd" d="M4.146 3.646a.5.5 0 0 0 0 .708L7.793 8l-3.647 3.646a.5.5 0 0 0 .708.708l4-4a.5.5 0 0 0 0-.708l-4-4a.5.5 0 0 0-.708 0zM11.5 1a.5.5 0 0 1 .5.5v13a.5.5 0 0 1-1 0v-13a.5.5 0 0 1 .5-.5z"/>
  </svg></a>
</div>
</div>

