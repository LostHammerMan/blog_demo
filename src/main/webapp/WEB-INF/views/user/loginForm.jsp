<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %> <!-- ../layout/header.jsp 상위 폴더에서 해당 jsp 찾음 -->

<div class="container">
    <form action="/action_page.php">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" placeholder="Enter Username" id="username" autofocus>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" placeholder="Enter password" id="password">
        </div>

        <div class="form-group form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember me
            </label>
        </div>
        <button type="submit" class="btn btn-primary">로그인</button>
    </form>
</div>

<%@ include file="../layout/footer.jsp" %>

