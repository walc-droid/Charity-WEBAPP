<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<%@include file="header.jsp" %>


<section class="login-page">
    <h2>Załóż konto</h2>

    <sec:authorize access="isAuthenticated()">
        Logout
    </sec:authorize>

    <%--@elvariable id="user" type="java"--%>
    <form:form action="/register" method="post" modelAttribute="user">
        <div class="form-section form-section--columns">
            <div class="form-section--column">

                <div class="form-group form-group--inline">
                    <form:label path="username">Login: <form:input type="text" name="username" path="username"/></form:label>
                    <form:errors path="username" cssStyle="color: red;font-size: large"/>
                </div>

                <div class="form-group form-group--inline">
                    <form:label path="email">E-mail <form:input type="email" name="email" path="email"/></form:label>
                    <form:errors path="email" cssStyle="color: red;font-size: large"/>
                </div>

                <div class="form-group form-group--inline">
                    <form:label path="firstName">Imię: <form:input type="text" name="firstName" path="firstName"/></form:label>
                    <form:errors path="firstName" cssStyle="color: red;font-size: large"/>
                </div>

                <div class="form-group form-group--inline">
                    <form:label path="lastName">Nazwisko: <form:input type="text" name="lastName" path="lastName"/></form:label>
                    <form:errors path="lastName" cssStyle="color: red;font-size: large"/>
                </div>

                <div class="form-group form-group--inline">
                    <form:label path="password">Hasło: <form:input type="password" name="password" path="password"/></form:label>
                    <form:errors path="password" cssStyle="color: red;font-size: large"/>
                </div>
                <div class="form-group form-group--inline">
                    <form:label path="passwordConfirm">Powtórz hasło: <form:input type="password" name="passwordConfirm" path="passwordConfirm"/></form:label>
                    <form:errors path="passwordConfirm" cssStyle="color: red;font-size: large"/>
                </div>
            </div>
        </div>


        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <form:button class="btn" type="submit">Załóż konto</form:button>
<%--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        </div>
    </form:form>


</section>



<%@include file="footer.jsp" %>