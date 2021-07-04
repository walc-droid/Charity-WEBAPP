<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<%@include file="../header.jsp" %>

<section class="login-page">

    <%--@elvariable id="donationEdit" type=""--%>
    <h2>Dodaj instytucje </h2>
    <form:form method="post" modelAttribute="instit">

        <div class="form-section form-section--columns">
            <div class="form-section--column">

                <div class="form-group form-group--inline">
                    <form:label path="name">Nazwa: <form:input type="text" name="name" path="name"/></form:label>
                    <form:errors path="name" cssStyle="color: red;font-size: large"/>
                </div>

                <div class="form-group form-group--inline">
                    <form:label path="description">Opis: <form:input type="text" name="description" path="description"/></form:label>
                    <form:errors path="description" cssStyle="color: red;font-size: large"/>
                </div>

        </div>



        <div class="form-group form-group--buttons">
            <form:button class="btn" type="submit">Dodaj instytucje</form:button>
                <%--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        </div>

            <div class="form-group form-group--buttons">
                <a class="btn" href="/admin/institution">Powrót</a>
            </div>
    </form:form>



</section>


<%@include file="../footer.jsp" %>