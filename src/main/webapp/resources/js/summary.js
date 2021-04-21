//Category

function getCheckedCategories() {
    const checkedInputs = document.querySelectorAll(`input[name="categories"]:checked`);
    let arrayOfCategories = [];

    for (let i = 0; i < checkedInputs.length; i++) {
        arrayOfCategories.push(checkedInputs[i].nextElementSibling.nextElementSibling.firstChild.textContent);
    }
    return arrayOfCategories;
}


//Institution

function getCheckedInstitutionTitle() {
    const checkedInstitution = document.querySelectorAll('input[name="institution"]:checked');
    let arrayOfInstitutions = [];

    for (let i = 0; i < checkedInstitution.length; i++) {
        arrayOfInstitutions.push(checkedInstitution[i].nextElementSibling.nextElementSibling.firstElementChild.textContent)
    }
    return arrayOfInstitutions;
}
function getCheckedInstitutionSubtitle() {
    const checkedInstitution = document.querySelectorAll('input[name="institution"]:checked');
    let arrayOfInstitutions = [];

    for (let i = 0; i < checkedInstitution.length; i++) {
        arrayOfInstitutions.push(checkedInstitution[i].nextElementSibling.nextElementSibling.lastElementChild.textContent)
    }
    return arrayOfInstitutions;
}


//Quantity
let quantityValue = document.querySelector('[name="quantity"]');

//Street
let street = document.querySelector('[name="street"]');

//City
let city = document.querySelector('[name="city"]');

//zipCode
let zipCode = document.querySelector('[name="zipCode"]');

//phone
let phone = document.querySelector('[name="phone"]');

//pickUpDate
let pickUpDate = document.querySelector('[name="pickUpDate"]')

//pickUpTime
let pickUpTime = document.querySelector('[name="pickUpTime"]')

//pickUpComment
let pickUpComment = document.querySelector('[name="pickUpComment"]')



//Button
let buttonStep1 = document.querySelector("#button1");
let buttonStep2prev = document.querySelector("#button2prev");
let buttonStep2 = document.querySelector("#button2");
let buttonStep3prev = document.querySelector("#button3prev");
let buttonStep3 = document.querySelector("#button3");
let buttonStep4prev = document.querySelector("#button4prev");
let buttonStep4 = document.querySelector("#button4");


//CategoryValidate

buttonStep1.addEventListener("click", () => {

    let checkedInputs = getCheckedCategories();

    if (checkedInputs.length <= 0) {
        this.text = "Wybierz kategorię!";
        document.querySelector("#validateCategory").innerHTML = this.text;
        buttonStep2prev.click();
    } else {
        this.text = "";
        document.querySelector("#validateCategory").innerHTML = this.text;
    }

});

//QuantityValidate

buttonStep2.addEventListener("click", () => {

    // quantityValue.onchange = function () {

    if (quantityValue.value > 200 || quantityValue.value == "") {
        this.text = "Niepoprawna wartość!";
        document.querySelector("#testValidate").innerHTML = this.text;
        quantityValue.focus();
        buttonStep3prev.click();
        // buttonStep2.disabled = true;
    } else {
        this.text = "";
        document.querySelector("#testValidate").innerHTML = this.text;
        // buttonStep2.disabled = false;
    }
    // }
});


buttonStep3.addEventListener("click", () => {

    let checkedInstitution = getCheckedInstitutionTitle();

    if (checkedInstitution.length <= 0) {
        this.text = "Wybierz instytucję!";
        document.querySelector("#validateInstitution").innerHTML = this.text;
        buttonStep4prev.click();
    } else {
        this.text = "";
        document.querySelector("#validateInstitution").innerHTML = this.text;
    }

});



buttonStep4.addEventListener("click", () => {

    document.querySelector("#categoryList").innerHTML = getCheckedCategories();
    document.querySelector("#quantityValue").innerHTML = quantityValue.value;
    document.querySelector("#institutionName").innerHTML = getCheckedInstitutionTitle();
    document.querySelector("#institutionSubtitle").innerHTML = getCheckedInstitutionSubtitle();
    document.querySelector("#streetValue").innerHTML = street.value;
    document.querySelector("#cityValue").innerHTML = city.value;
    document.querySelector("#zipCodeValue").innerHTML = zipCode.value;
    document.querySelector("#phoneValue").innerHTML = phone.value;
    document.querySelector("#pickUpDateValue").innerHTML = pickUpDate.value;
    document.querySelector("#pickUpTimeValue").innerHTML = pickUpTime.value;
    document.querySelector("#pickUpTimeComment").innerHTML = pickUpComment.value;

});


function quantityValidate() {
    let quantityValue = document.querySelector('[name="quantity"]').value;
    if (quantityValue > 100 || quantityValue == "") {
        this.text = "Niepoprawna wartość!";
        document.querySelector("#testValidate").innerHTML = this.text;
        return false;
    }
    return true;
}

