<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<%@include file="../header.jsp" %>

<section class="login-page">

    <%--@elvariable id="donationEdit" type=""--%>
    <h2>Uźytkonik ${appUser.username} </h2>
    <form:form method="post" modelAttribute="appUser">

        <div class="form-section form-section--columns">
            <div class="form-section--column">

                <div class="form-group form-group--inline">
                    <form:label path="username">Użytkownik: <form:input type="text" name="username" path="username"/></form:label>
                    <form:errors path="username" cssStyle="color: red;font-size: large"/>
                </div>


                <div class="form-group form-group--inline">
                    <form:label path="appUserRole">Rola użytkownika:
                        <form:select type="text" name="appUserRole" path="appUserRole">
                            <form:option value="ROLE_ADMIN">Admin</form:option>
                            <form:option value="ROLE_USER">User</form:option>
                        </form:select>
                    </form:label>
                </div>


                <div class="form-group form-group--inline">
                    <form:label path="email">E-mail: <form:input type="text" name="email" path="email"/></form:label>
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
                    <form:label path="password">Hasło: <form:input type="text" name="password" path="password"/></form:label>
                    <form:errors path="password" cssStyle="color: red;font-size: large"/>
                </div>

                <div class="form-group form-group--inline">
                    <form:label path="locked">Blokada użytkownika:
                        <form:select type="text" name="locked" path="locked">
                           <form:option value="true">Tak</form:option>
                           <form:option value="false">Nie</form:option>
                        </form:select>
                    </form:label>
                </div>


                <div class="form-group form-group--inline">
                    <form:label path="enabled">Aktywny użytkownik:
                        <form:select type="text" name="enabled" path="enabled">
                            <form:option value="true">Tak</form:option>
                            <form:option value="false">Nie</form:option>
                        </form:select>
                    </form:label>
                </div>


            </div>
        </div>
        
        <div class="form-group form-group--buttons">
            <form:button class="btn" type="submit">Edytuj użytkownika</form:button>
                <%--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        </div>
        <div class="form-group form-group--buttons">
            <a class="btn" href="/admin/users">Powrót</a>
        </div>
    </form:form>



</section>


<%@include file="../footer.jsp" %>