<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>


<%@include file="header.jsp" %>

<section class="login-page">
    <h2>Zaloguj się</h2>
<%--    <form>--%>
<%--        <div class="form-group">--%>
<%--            <input type="email" name="email" placeholder="Email" />--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <input type="password" name="password" placeholder="Hasło" />--%>
<%--            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>--%>
<%--        </div>--%>

<%--        <div class="form-group form-group--buttons">--%>
<%--            <a href="#" class="btn btn--without-border">Załóż konto</a>--%>
<%--            <button class="btn" type="submit">Zaloguj się</button>--%>
<%--        </div>--%>
<%--    </form>--%>


    <form method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Sign In"/></div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>


</section>



<%@include file="footer.jsp" %>