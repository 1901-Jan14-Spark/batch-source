document.addEventListener("DOMContentLoaded", function (e) {
  createOnStartUp();
})


// variable initialized
let loginForm = document.getElementById("emplogin");


const createOnStartUp = () => {
  loginForm.classList.add("hidden");
}
