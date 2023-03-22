<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %> <!-- ../layout/header.jsp 상위 폴더에서 해당 jsp 찾음 -->

<div class="container">
<%--    <form action="${root}user/join" method="post">--%>
    <form>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" placeholder="Enter Username" id="username">
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password">
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" placeholder="Enter email" id="email">
        </div>



        <%--<div class="form-group form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember me
            </label>
        </div>--%>
        <button id="btn-save" class="btn btn-primary">회원가입완료</button>
    </form>
</div>

<script src="${root}static/js/user/user.js"></script>
<%@ include file="../layout/footer.jsp" %>

