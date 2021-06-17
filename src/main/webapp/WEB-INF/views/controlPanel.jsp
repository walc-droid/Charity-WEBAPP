<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<%@include file="header.jsp" %>

<section class="login-page">

    <h2>Panel Administracyjny</h2>

<div class="form-section form-section--columns">
    <div class="form-section--column">
        <div class="form-group form-group--inline">
            <a class="btn" href="/admin/category">Kategorie</a>
        </div>
    </div>
    <div class="form-section--column">
        <div class="form-group form-group--inline">
            <a class="btn" href="/admin/donation">Dotacje</a>
        </div>
    </div>
</div>



<%@include file="footer.jsp" %>