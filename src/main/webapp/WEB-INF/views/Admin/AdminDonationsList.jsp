<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<%@include file="../header.jsp" %>

<section class="login-page">

    <h2>Lista dotacji</h2>
    <div class="table-wrapper">
        <table class="fl-table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Kategoria</th>
                <th>Ilość worków</th>
                <th>Ulica</th>
                <th>Kod Pocztowy</th>
                <th>Miasto</th>
                <th>Numer telefonu</th>
                <th>Data odbioru</th>
                <th>Godzina odbioru</th>
                <th>Komentarz</th>
                <th>Instytucja</th>
                <th>Edytuj</th>
                <th>Usuń</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach items="${donations}" var="donation">
            <tr>
                <td><c:out value="${donation.id}"/></td>
                <td><c:out value="${donation.categoriesNames}"/></td>
                <td><c:out value="${donation.quantity}"/></td>
                <td><c:out value="${donation.street}"/></td>
                <td><c:out value="${donation.zipCode}"/></td>
                <td><c:out value="${donation.city}"/></td>
                <td><c:out value="${donation.phone}"/></td>
                <td><c:out value="${donation.pickUpDate}"/></td>
                <td><c:out value="${donation.pickUpTime}"/></td>
                <td><c:out value="${donation.pickUpComment}"/></td>
                <td><c:out value="${donation.institution.name}"/></td>
                <td><a href="/admin/donations/edit/${donation.id}">Edytuj</a></td>
                <td><a href="/admin/donations/delete/${donation.id}">Usuń</a></td>
            </tr>
            </c:forEach>
            <tbody>
        </table>
    </div>

    <div class="form-group form-group--buttons">
        <a class="btn" href="/admin/controlPanel">Powrót</a>
        <a class="btn" href="/donations/add">Dodaj dotacje</a>
    </div>


</section>

<%@include file="../footer.jsp" %>