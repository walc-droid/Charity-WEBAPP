<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<%@include file="../header.jsp" %>

<section class="login-page">

    <h2>Lista instytucji</h2>
    <div class="table-wrapper">
        <table class="fl-table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nazwa</th>
                <th>Opis</th>
                <th>Edytuj</th>
                <th>Usuń</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${institution}" var="institution">
            <tr>
                <td><c:out value="${institution.id}"/></td>
                <td><c:out value="${institution.name}"/></td>
                <td><c:out value="${institution.description}"/></td>
                <td><a href="/admin/institution/edit/${institution.id}">Edytuj</a></td>
                <td><a href="/admin/institution/delete/${institution.id}">Usuń</a></td>
            </tr>
            </c:forEach>
            <tbody>
        </table>
    </div>

    <div class="form-group form-group--buttons">
        <a class="btn" href="/admin/controlPanel">Powrót</a>
        <a class="btn" href="/admin/institution/add">Dodaj instytucje</a>
    </div>


</section>

<%@include file="../footer.jsp" %>