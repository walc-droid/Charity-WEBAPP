<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<%@include file="header.jsp" %>

<section class="stats">

    <div class="container container--85">

        <form:form method="post" modelAttribute="donation">
            <div class="stats--item"><h2>Add Donation</h2></div>

            <div class="stats--item">
               <h3> <form:label path="categories">Categories :</form:label>
                <form:checkboxes path="categories"
                                 items="${categories}" itemValue="id" itemLabel="name" multiple="true"/></h3>
            </div>

            <div class="stats--item">
                <h3><form:label path="institution">Institutions :</form:label>
                <form:select items="${institutions}" itemValue="id" itemLabel="name" path="institution.id"/></h3>
            </div>

            <div class="stats--item">
                <h3> <form:label path="zipCode">Zip code :</form:label>
                <form:input path="zipCode"/></h3>
            </div>

            <div class="stats--item">
               <h3> <form:label path="zipCode">Street :</form:label>
                <form:input path="street"/></h3>
            </div>

            <div class="stats--item">
                <h3> <form:label path="city">City :</form:label>
                <form:input path="city"/></h3>
            </div>

            <div class="stats--item">
                <h3> <form:label path="quantity">Quantity :</form:label>
                <form:input path="quantity"/></h3>
            </div>

            <div class="stats--item">
                <h3> <form:label path="pickUpComment">PickUpComment :</form:label>
                <form:textarea path="pickUpComment"/> </h3>
            </div>

            <div class="stats--item">
                <h3> <form:label path="pickUpDate">Date :</form:label>
                <form:input type="date" path="pickUpDate"/></h3>
            </div>

            <div class="stats--item">
                <h3> <form:label path="pickUpTime">Time :</form:label>
                <form:input type="time" path="pickUpTime"/></h3>
            </div>

            <div class="stats--item">
                <h3><input type="submit" value="send"></h3>
            </div>

        </form:form>

    </div>
</section>


<%@include file="footer.jsp" %>

