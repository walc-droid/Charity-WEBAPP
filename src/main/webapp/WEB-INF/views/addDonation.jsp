<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>


<form:form method="post" modelAttribute="donation">


    <div>
        <form:label path="categories">Categories :</form:label>
        <form:checkboxes path="categories"
                     items="${categories}" itemValue="id" itemLabel="name" multiple="true"/>
    </div>

    <div>
        <form:label path="institution">Institutions :</form:label>
        <form:select items="${institutions}" itemValue="id" itemLabel="name" path="institution.id" />
    </div>

    <div>
        <form:label path="zipCode">Zip code :</form:label>
        <form:input path="zipCode" />
    </div>

    <div>
        <form:label path="zipCode">Street :</form:label>
        <form:input path="street" />
    </div>

    <div>
        <form:label path="city">City :</form:label>
        <form:input path="city"/>
    </div>

    <div>
        <form:label path="quantity">Quantity :</form:label>
        <form:input path="quantity"/>
    </div>

    <div>
        <form:label path="pickUpComment">PickUpComment :</form:label>
        <form:textarea path="pickUpComment"/>
    </div>

    <div>
        <form:label path="pickUpDate">Date :</form:label>
        <form:input type="date" path="pickUpDate"/>
    </div>

    <div>
        <form:label path="pickUpTime">Time :</form:label>
        <form:input type="time" path="pickUpTime" />
    </div>

    <div>
        <input type="submit" value="send">
    </div>

</form:form>




<script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>