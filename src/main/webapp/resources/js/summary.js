//Category

function getCheckedCategories() {
    const checkedInputs = document.querySelectorAll(`input[name="categories"]:checked`);
    let arrayOfCategories = [];

    for (let i = 0; i < checkedInputs.length; i++) {
        arrayOfCategories.push(checkedInputs[i].nextElementSibling.nextElementSibling.firstChild.textContent);
    }
    return arrayOfCategories;
}

//Quantity
let quantityValue = document.querySelector('[name="quantity"]');


//Institution
let institutionCheck = document.querySelector('input[name="institution"]:checked');
let institutionName = institutionCheck.parentElement.querySelector(".title");
let institutionSubtitle = institutionCheck.parentElement.querySelector(".subtitle");

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
let buttonStep4 = document.querySelector("#button4");

buttonStep4.addEventListener("click", () => {

    document.querySelector("#categoryList").innerHTML = getCheckedCategories();
    document.querySelector("#quantityValue").innerHTML = quantityValue.value;
    document.querySelector("#institutionName").innerText = institutionName.innerHTML;
    document.querySelector("#institutionSubtitle").innerText = institutionSubtitle.innerHTML;
    document.querySelector("#streetValue").innerHTML = street.value;
    document.querySelector("#cityValue").innerHTML = city.value;
    document.querySelector("#zipCodeValue").innerHTML = zipCode.value;
    document.querySelector("#phoneValue").innerHTML = phone.value;
    document.querySelector("#pickUpDateValue").innerHTML = pickUpDate.value;
    document.querySelector("#pickUpTimeValue").innerHTML = pickUpTime.value;
    document.querySelector("#pickUpTimeComment").innerHTML = pickUpComment.value;

});

