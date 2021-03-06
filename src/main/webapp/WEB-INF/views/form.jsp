<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>


<%@include file="header.jsp" %>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form method="post" modelAttribute="donation">

            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>


                <c:forEach items="${categories}" var="cat">
                <div class="form-group form-group--checkbox">

                    <label>
                            <%--                        <form:checkbox path="categories" value="#{cat.id}"/>--%>
                        <input type="checkbox" name="categories" value="${cat.id}" />
                        <span class="checkbox"></span>
                        <span class="description">${cat.name}</span>

                    </label>

                </div>
                </c:forEach>
                <form:errors path="categories"/>
                <span id="validateCategory" style="color: red;font-size: large"></span>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step" id="button1">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <input id="quantity" type="number" name="quantity" step="1" min="1" />
                        <form:errors path="quantity"/>
                        <span id="testValidate" style="color: red;font-size: large"/>

<%--                        <script>--%>
<%--                              function myFunction() {--%>
<%--                                  var quantityValue = document.querySelector('[name="quantity"]').value;--%>
<%--                                  document.getElementById("quantityID").innerHTML = quantityValue;--%>
<%--                              }--%>
<%--                        </script>--%>
                    </label>
                </div>


                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step" id="button2prev" >Wstecz</button>
                    <button type="button" class="btn next-step" id="button2">Dalej</button>
                </div>
            </div>


            <!-- STEP 3 -->
            <div data-step="3" id="step3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                <c:forEach items="${institutions}" var="inst" varStatus="idNumber">
                    <div class="form-group form-group--checkbox">
                        <label>
<%--                            <input type="radio" id="radioTest" name="institution" value="${inst.id}"/>--%>
                            <form:radiobutton path="institution" value="${inst.id}"/>
                            <span class="checkbox radio"></span>
                            <span class="description">
                  <div id="Z${idNumber.index}" class="title">${inst.name}</div>
                  <div id="X${idNumber.index}" class="subtitle">${inst.description}</div>
                </span>
                        </label>
                    </div>
                </c:forEach>
                <span id="validateInstitution" style="color: red;font-size: large"></span>
<%--                <script>--%>
<%--                    // function myFunction1() {--%>
<%--                    //--%>
<%--                    //     var x = document.getElementById("step3");--%>
<%--                    //     var input = x.getElementsByTagName("input");--%>
<%--                    //--%>
<%--                    //     for (var i = 1; i < input.length; i++) {--%>
<%--                    //--%>
<%--                    //         if (input[i].checked) {--%>
<%--                    //             var name = document.getElementById("Z"+i).textContent;--%>
<%--                    //             document.getElementById("institutionName").innerHTML = name;--%>
<%--                    //--%>
<%--                    //             var description = document.getElementById("X"+i).textContent;--%>
<%--                    //             document.getElementById("institutionDescription").innerHTML = description;--%>
<%--                    //--%>
<%--                    //         }--%>
<%--                    //     }--%>
<%--                    // }--%>
<%--&lt;%&ndash;                </script>&ndash;%&gt;--%>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step" id="button3prev">Wstecz</button>
                    <button type="button" class="btn next-step" id="button3">Dalej</button>
                </div>
            </div>

            <!-- STEP 4 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica <input type="text" name="street" /> </label>
                            <span id="validateStreet" style="color: red;font-size: large"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Miasto <input type="text" name="city" /> </label>
                            <span id="validateCity" style="color: red;font-size: large"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Kod pocztowy <input type="text" name="zipCode" /> </label>
                            <span id="validateZipCode" style="color: red;font-size: large"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu <input type="phone" name="phone" />
                            </label>
                            <span id="validatePhone" style="color: red;font-size: large"/>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data <input type="date" name="pickUpDate" /> </label>
                            <span id="validateDate" style="color: red;font-size: large"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Godzina <input type="time" name="pickUpTime" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <textarea name="pickUpComment" rows="5"></textarea>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step" id="button4prev">Wstecz</button>
                    <button type="button" class="btn next-step" id="button4">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text">

                                    Liczba oddanych worków : <span id="quantityValue"></span></span> kategorii : <span id="categoryList" ></span>

                                </span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text">

                                    <span id="institutionName"></span> : <span id="institutionSubtitle"></span>

                                </span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li id="streetValue"></li>
                                <li id="cityValue"></li>
                                <li id="zipCodeValue"></li>
                                <li id="phoneValue"></li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li id="pickUpDateValue"></li>
                                <li id="pickUpTimeValue"></li>
                                <li id="pickUpTimeComment"></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form:form>

    </div>
</section>

<script src="/<c:url value="resources/js/summary.js"/>"></script>


<%@include file="footer.jsp" %>