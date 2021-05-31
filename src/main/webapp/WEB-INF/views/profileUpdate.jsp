<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>


<%@include file="header.jsp" %>

<section class="login-page">

    <h2>Twój profil</h2>
<form:form method="post" action="/logged" modelAttribute="currentUser">
    <div class="form-section form-section--columns">
        <div class="form-section--column">
            <div class="form-group form-group--inline">
                <form:label path="email">E-mail:  <form:input name="email" type="text" path="email" readonly="true"></form:input></form:label>
            </div>
            <div class="form-group form-group--inline">
                <form:label path="username">Login:  <form:input name="username" type="text" path="username"></form:input></form:label>
                <form:errors path="username" cssStyle="color: red;font-size: large"/>
            </div>
            <div class="form-group form-group--inline">
                <form:label path="firstName">Imię:  <form:input name="firstName" type="text" path="firstName"></form:input></form:label>
            </div>
            <div class="form-group form-group--inline">
                <form:label path="lastName">Nazwisko:  <form:input name="lastName" type="text" path="lastName"></form:input></form:label>
            </div>
            <div class="form-group form-group--inline">
                <form:label path="password">Hasło:  <form:input name="lastName" type="password" path="password"></form:input></form:label>
            </div>

        </div>
    </div>


    <div class="form-group form-group--buttons">

        <form:button class="btn" type="submit">Edytuj dane</form:button>
            <%--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    </div>
</form:form>

</section>




<%@include file="footer.jsp" %>