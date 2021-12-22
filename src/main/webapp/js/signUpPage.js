function checkUsername() {
    const username = document.getElementById("username")
    const xhr = new XMLHttpRequest()

    if (username.value.length > 4) {
        document.getElementById("login").disable = false
        document.getElementById("username-error").style.display = "none"
    } else {
        document.getElementById("login").disable = true
        document.getElementById("username-error").style.display = "block"
    }

    xhr.open("GET", "http://localhost:8080//UsernameCheck?username=" + username.value, false)
    xhr.send()

    const result = xhr.responseText

    if (result === "true") {
        document.getElementById("login").disable = false
        document.getElementById("username-error").style.display = "none"
    }

    if (xhr.status !== 200) {
        document.getElementById("login").disable = true
        document.getElementById("username-error").style.display = "block"
    } else {
        if (result === "false") {
            document.getElementById("login").disable = true
            document.getElementById("username-error").style.display = "block"
        }
    }
}

function checkTwoPasswords() {
    const password = document.getElementById("password")
    const confirmPassword = document.getElementById("second-password")

    if (password.value === confirmPassword.value) {
        document.getElementById("passwords-confirm-error").style.display = "none"
        document.getElementById("login").disabled = false
    } else {
        document.getElementById("passwords-confirm-error").style.display = "block"
        document.getElementById("login").disabled = true
    }
}

function checkPasswordLength() {
    const password = document.getElementById("password");

    if (password.value.length > 5){
        document.getElementById("login").disabled = false
        document.getElementById("empty_password-error").style.display = "none"
    } else {
        document.getElementById("login").disabled = true
        document.getElementById("empty_password-error").style.display = "block"
    }
}