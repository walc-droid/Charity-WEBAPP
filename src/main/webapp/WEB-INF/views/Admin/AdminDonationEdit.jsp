<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<%@include file="../header.jsp" %>

<section class="login-page">

    <%--@elvariable id="donationEdit" type=""--%>
    <h2>Dotacja numer ${donationEdit.id} </h2>
        <form:form method="post" modelAttribute="donationEdit">

    <div class="form-section form-section--columns">
        <div class="form-section--column">

            <div class="form-group form-group--inline">
                <label for="category">Kategoria: </label>
                <select class="dropdownEDIT" id="category" name="categories">
                    <c:forEach var="category" items="${category}">
                        <option value="${category.id}">${category.name}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group form-group--inline">
                <form:label path="quantity">Ilość worków: <form:input type="text" name="quantity" path="quantity"/></form:label>
                <form:errors path="quantity" cssStyle="color: red;font-size: large"/>
            </div>
            <div class="form-group form-group--inline">
                <form:label path="street">Ulica: <form:input type="text" name="street" path="street"/></form:label>
                <form:errors path="street" cssStyle="color: red;font-size: large"/>
            </div>
            <div class="form-group form-group--inline">
                <form:label path="zipCode">Kod pocztowy: <form:input type="text" name="zipCode" path="zipCode"/></form:label>
                <form:errors path="zipCode" cssStyle="color: red;font-size: large"/>
            </div>
            <div class="form-group form-group--inline">
                <form:label path="city">Miasto: <form:input type="text" name="city" path="city"/></form:label>
                <form:errors path="city" cssStyle="color: red;font-size: large"/>
            </div>
            <div class="form-group form-group--inline">
                <form:label path="phone">Telefon: <form:input type="text" name="phone" path="phone"/></form:label>
                <form:errors path="phone" cssStyle="color: red;font-size: large"/>
            </div>
            <div class="form-group form-group--inline">
                <form:label path="pickUpDate">Data odbioru: <form:input type="date" name="pickUpDate" path="pickUpDate"/></form:label>
                <form:errors path="pickUpDate" cssStyle="color: red;font-size: large"/>
            </div>
            <div class="form-group form-group--inline">
                <form:label path="pickUpTime">Godzina odbioru: <form:input type="time" name="pickUpTime" path="pickUpTime"/></form:label>
                <form:errors path="pickUpTime" cssStyle="color: red;font-size: large"/>
            </div>
            <div class="form-group form-group--inline">
                <form:label path="pickUpComment">Komentarz: <form:input type="text" name="pickUpComment" path="pickUpComment"/></form:label>
                <form:errors path="pickUpComment" cssStyle="color: red;font-size: large"/>
            </div>
            <div class="form-group form-group--inline">
                <label for="institution">Instytucja: </label>
                <select class="dropdownEDIT" id="institution" name="institution">
                    <c:forEach var="institution" items="${institution}">
                        <option value="${institution.id}">${institution.name}</option>
                    </c:forEach>
                </select>
            </div>

        </div>
    </div>


    <div class="form-group form-group--buttons">
        <form:button class="btn" type="submit">Edytuj dotacje</form:button>
            <%--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    </div>
        </form:form>



</section>


<%@include file="../footer.jsp" %>