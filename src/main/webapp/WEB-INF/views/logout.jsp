<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<%@include file="header.jsp" %>

<section class="login-page">
    <h2>Wyloguj się</h2>

    <sec:authorize access="isAuthenticated()">
        <div class="form-section form-section--columns">
            <div class="form-group form-group--buttons">
                <form action="<c:url value="/logout"/>" method="post">
                    <button class="btn" type="submit" >Wyloguj się</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
    </sec:authorize>


</section>



<%@include file="footer.jsp" %>