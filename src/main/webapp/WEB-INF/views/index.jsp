<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>

<%@ include file="layout/header.jsp"%> <!-- 상대 경로로 작성-->

<div class="container">
    <div class="card m-2">
<%--        <img class="card-img-top" src="img_avatar1.png" alt="Card image">--%>
        <div class="card-body">
            <h4 class="card-title">제목 적는 부분</h4>
            <p class="card-text">내용 적는 부분</p>
            <a href="#" class="btn btn-primary">상세 보기</a>
        </div>
    </div>
    <div class="card m-2">
        <%--        <img class="card-img-top" src="img_avatar1.png" alt="Card image">--%>
        <div class="card-body">
            <h4 class="card-title">제목 적는 부분</h4>
            <p class="card-text">내용 적는 부분</p>
            <a href="#" class="btn btn-primary">상세 보기</a>
        </div>
    </div>
    <div class="card m-2">
        <%--        <img class="card-img-top" src="img_avatar1.png" alt="Card image">--%>
        <div class="card-body">
            <h4 class="card-title">제목 적는 부분</h4>
            <p class="card-text">내용 적는 부분</p>
            <a href="#" class="btn btn-primary">상세 보기</a>
        </div>
    </div>
</div>

<%@ include file="layout/footer.jsp"%>





