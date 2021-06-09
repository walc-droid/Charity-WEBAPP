let profileUpdateButton = document.querySelector("#updateButton");


profileUpdateButton.addEventListener("click",() => {

    let firstNameValidate = document.querySelector('[name="firstName"]');

    if (firstNameValidate.value.length <3) {
        this.text = "Imię musi posiadać od 3 do 12 znaków!"
        document.querySelector("#firstNameValidate").innerHTML = this.text;
        firstNameValidate.focus();
        profileUpdateButton.disabled = true;
    }else {
        this.text = "";
        document.querySelector("#firstNameValidate").innerHTML = this.text;
        profileUpdateButton.disabled = false;
    }

})

