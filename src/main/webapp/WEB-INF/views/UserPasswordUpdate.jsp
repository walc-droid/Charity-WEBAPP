<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<%@include file="header.jsp" %>


<section class="login-page">
    <h2>Zmień hasło:</h2>

    
    <%--@elvariable id="currentUser" type=""--%>
    <form:form action="/password" method="post" modelAttribute="currentUser">
        <div class="form-section form-section--columns">
            <div class="form-section--column">

                <div class="form-group form-group--inline">
                    <form:label path="password">Podaj stare hasło: <form:input type="password" path="passwordConfirm" onfocus="this.value=''"/></form:label>
                    <form:errors path="passwordConfirm" cssStyle="color: red;font-size: large"/>
                </div>
                <div class="form-group form-group--inline">
                    <form:label path="passwordConfirm">Podaj nowe hasło: <form:input type="password" name="password" path="password" onfocus="this.value=''"/></form:label>
                </div>

            </div>
        </div>


        <div class="form-group form-group--buttons">

            <form:button class="btn" type="submit">Potwierdź</form:button>
                <%--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        </div>
    </form:form>


</section>

<script src="/<c:url value="resources/js/pwUpdate.js"/>"></script>

<%@include file="footer.jsp" %>