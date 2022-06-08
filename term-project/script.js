const username = document.getElementById('username')
const password = document.getElementById('password')
const password2 = document.getElementById('password2');
const form = document.getElementById('form')
const errorElement = document.getElementById('error')

document.querySelector('.buttn').onclick = function () {

    if (password === "") {
        alert("You must enter a password");
    }
    else if (password != password2) {
        alert("Password does not match, try again!");
        return false;
    }
    else if (password == password2) {
        alert("successful Entry");
    }
    return true;
}

form.addEventListener('submit', (e) => {
    let messages = []
    if (username.value === '' || username.value == null) {
        messages.push('You must enter a username!')
    }

    if (password.value.length <= 6) {
        messages.push('Password must be longer than 6 characters')
    }

    if (password.value.length >= 20) {
        messages.push('Password must be less than 20 characters')
    }

    if (password.value === 'password') {
        messages.push('Password cannot be password')
        alert(messages);
    }

    if (messages.length > 0) {
        e.preventDefault()
        errorElement.innerText = messages.join(', ')
    }
})