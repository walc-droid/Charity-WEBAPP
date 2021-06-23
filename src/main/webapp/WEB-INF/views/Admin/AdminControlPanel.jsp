<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<%@include file="../header.jsp" %>

<section class="login-page">

    <h2>Panel Administracyjny</h2>


        <ul>
            <li style="display: inline"><a href="/admin/donation" class="btn btn--without-border active">Ustawienia dotacji</a></li>
            <li style="display: inline"><a href="/admin/users" class="btn btn--without-border active">Ustawienia użytkowników</a></li>
        </ul>


</section>


<%@include file="../footer.jsp" %>