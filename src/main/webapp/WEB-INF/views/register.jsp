<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>


<%@include file="header.jsp" %>


<section class="login-page">
    <h2>Załóż konto</h2>
    <form method="post">
        <div class="form-section form-section--columns">
            <div class="form-section--column">
                <div class="form-group form-group--inline ">
                    <label>Login: <input type="text" name="login"/> </label>
                </div>
                <div class="form-group form-group--inline">
                    <label>Imię: <input type="text" name="name"/> </label>
                </div>
                <div class="form-group form-group--inline">
                    <label>Nazwisko: <input type="text" name="lastName"/></label>
                </div>
                <div class="form-group form-group--inline">
                    <label>E-mail: <input type="email" name="email"/></label>
                </div>
                <div class="form-group form-group--inline">
                    <label>Hasło: <input type="password" name="password"/></label>
                </div>
                <div class="form-group form-group--inline">
                    <label>Potwierdz hasło: <input type="password" name="passwordConfirm"/></label>
                </div>
            </div>
        </div>
        <div class="form-group form-group--buttons">
            <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form>
</section>



<%@include file="footer.jsp" %>