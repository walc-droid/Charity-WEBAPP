// let profileUpdateButton = document.querySelector("#updateButton");
//
//
//
// profileUpdateButton.addEventListener("click",() => {
//
//     let firstNameValidate = document.querySelector('[name="firstName"]');
//
//     if (firstNameValidate.value.length <3) {
//         this.text = "Imię musi posiadać od 3 do 12 znaków!"
//         document.querySelector("#firstNameValidate").innerHTML = this.text;
//         firstNameValidate.focus();
//
//     }else {
//         this.text = "";
//         document.querySelector("#firstNameValidate").innerHTML = this.text;
//     }
//
// })

import { firstNameValidate} from "./controller";

let firstName = document.querySelector('[name="firstName"]');
let firstNameTest = document.querySelector("#firstNameValidate");
firstNameTest.style.display = "none";

firstName.addEventListener('keypress', event => {
    let text = firstName.value + `${event.key}`;
    firstNameValidate(text, firstNameTest);
})