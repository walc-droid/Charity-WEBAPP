export const firstNameValidate = (text, firstNameCheck) => {

    let profileUpdateButton = document.querySelector("#updateButton");

    if (profileUpdateButton.value.length <3) {
        firstNameCheck.style.display = "block";
        firstNameCheck.innerText = "Imię musi posiadać od 3 do 12 znaków!";
        return;
    }

    firstNameCheck.style.display = "none";
    return;
}