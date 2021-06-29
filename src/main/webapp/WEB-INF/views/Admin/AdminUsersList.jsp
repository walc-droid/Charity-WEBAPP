<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<%@include file="../header.jsp" %>

<section class="login-page">

    <h2>Lista użytkowników</h2>
    <div class="table-wrapper">
        <table class="fl-table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Użytkownik</th>
                <th>Rola</th>
                <th>E-mail</th>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Hasło</th>
                <th>Blokada</th>
                <th>Aktywność</th>
                <th>Edytuj</th>
                <th>Usuń</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${appUsers}" var="appUsers">
            <tr>
                <td><c:out value="${appUsers.id}"/></td>
                <td><c:out value="${appUsers.username}"/></td>
                <td><c:out value="${appUsers.appUserRole}"/></td>
                <td><c:out value="${appUsers.email}"/></td>
                <td><c:out value="${appUsers.firstName}"/></td>
                <td><c:out value="${appUsers.lastName}"/></td>
                <td><c:out value="${appUsers.password}"/></td>
                <td><c:out value="${appUsers.locked}"/></td>
                <td><c:out value="${appUsers.enabled}"/></td>
                <td><a href="/admin/users/edit/${appUsers.id}">Edytuj</a></td>
                <td><a href="/admin/users/delete/${appUsers.id}">Usuń</a></td>
            </tr>
            </c:forEach>
            <tbody>
        </table>
    </div>

    <div class="form-group form-group--buttons">
        <a class="btn" href="/admin/controlPanel">Powrót</a>
    </div>


</section>

<%@include file="../footer.jsp" %>