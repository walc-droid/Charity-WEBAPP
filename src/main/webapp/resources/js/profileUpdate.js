let firstNameValidate = document.querySelector('[name="firstName"]');
let firstNameError = document.querySelector("#firstNameError");

let lastNameValidate = document.querySelector('[name="lastName"]');
let lastNameError = document.querySelector("#lastNameError");

let form = document.querySelector('#currentUser');


form.addEventListener('submit', function (event) {

    if (firstNameValidate.value.length < 3) {
        firstNameError.innerText = 'Imię musi posiadać od 3 do 12 znaków!';
        event.preventDefault();
    }else {
        firstNameError.innerText = '';
    }

    if (lastNameValidate.value.length < 3) {
        lastNameError.innerText = 'Nazwisko musi posiadać od 3 do 12 znaków!';
        event.preventDefault();
    }else {
        lastNameError.innerText = '';
    }


})



