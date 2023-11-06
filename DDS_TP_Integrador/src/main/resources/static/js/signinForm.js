import { signInWithEmailAndPassword } from "https://www.gstatic.com/firebasejs/10.2.0/firebase-auth.js"
import { auth } from "./firebase.js";
import { showMessage } from "./showMessage.js";

const signInForm = document.querySelector("#login-form");

if (signInForm){
    signInForm.addEventListener("submit", async (e) => {
      e.preventDefault();
      const email = signInForm["login-email"].value;
      const password = signInForm["login-password"].value;

      try {
        const userCredentials = await signInWithEmailAndPassword(auth, email, password)
        console.log(userCredentials)

        localStorage.setItem('justSignedUp', 'true');

        window.location.href = '/inicio';

        // reset the form
        signInForm.reset();



      } catch (error) {
        console.log(error)
        if (error.code === 'auth/wrong-password') {
          showMessage("Wrong password", "error")
        } else if (error.code === 'auth/user-not-found') {
          showMessage("User not found", "error")
        } else if (error.code === 'auth/invalid-email') {
          showMessage("Proporcione un email valido", "error")
        } else if (error.code === 'auth/missing-password') {
          showMessage("Proporcione una contraseña valida", "error")
        } else {
          showMessage("Something went wrong", "error")
        }
      }
    });
}