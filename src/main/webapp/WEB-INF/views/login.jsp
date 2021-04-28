<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>


<%@include file="header.jsp" %>

<section class="login-page">
    <h2>Zaloguj się</h2>
<%--    <c:if test="${param.error ne null}">--%>
<%--        <div style="color: red">Invalid username or password.</div>--%>
<%--    </c:if>--%>
    <form method="post" action="/login">
        <div class="form-group">
            <input type="text" name="username" placeholder="Nazwa użytkownika" path="username"/>
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło" path="password"/>
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>
        <div class="form-group form-group--buttons">
            <a href="/register" class="btn btn--without-border">Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
    </form>
</section>


<%@include file="footer.jsp" %>