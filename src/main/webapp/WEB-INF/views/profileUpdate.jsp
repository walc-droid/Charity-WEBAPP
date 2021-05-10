<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>



    ${currentUser.firstName}

<form:form method="post" action="/logged" modelAttribute="currentUser">

    Zmien imię:  <form:input name="firstName" type="text" path="firstName"></form:input>
    <button type="submit" class="btn">Potwierdzam</button>

</form:form>