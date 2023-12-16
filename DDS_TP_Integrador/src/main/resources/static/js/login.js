import { signInWithEmailAndPassword } from "https://www.gstatic.com/firebasejs/10.2.0/firebase-auth.js"
import { auth } from "./firebase.js";
// import { showMessage } from "./showMessage.js";

// import './signupForm.js'
// import './signinForm.js'
// import './googleLogin.js'
// import './logout.js'
//

// Initialize loginInfo object
let loginInfo = {
  userId: null,
  loginTime: null,
  logoutTime: null,
};

// Handle user login
// onAuthStateChanged(auth, async (user) => {
//   if (user) {
//     // User is signed in
//     loginInfo.userId = user.uid;
//     loginInfo.loginTime = new Date().toISOString();
//     // Send a POST request to your Spring Boot endpoint to log the login event
//     sendLoginEvent(loginInfo);
//   } else {
//     // User is signed out
//     loginInfo.logoutTime = new Date().toISOString();
//     // Send a POST request to your Spring Boot endpoint to log the logout event
//     sendLogoutEvent(loginInfo);
//   }
// });

// Manejador de eventos para el formulario de inicio de sesión
const signInForm = document.querySelector("#login-form");

if (signInForm) {
  signInForm.addEventListener("submit", async (e) => {
    e.preventDefault();
    const email = signInForm["login-email"].value;
    const password = signInForm["login-password"].value;

    try {
      const userCredentials = await signInWithEmailAndPassword(auth, email, password);
      console.log(userCredentials);

      // Actualizar información de inicio de sesión
      loginInfo.userId = userCredentials.user.uid;
      loginInfo.loginTime = new Date().toISOString();

      // Enviar evento de inicio de sesión
      await sendLoginEvent(loginInfo);

      // Redirigir a la página de inicio
      // window.location.href = '/inicio';

      // Restablecer el formulario
      signInForm.reset();
    } catch (error) {
      console.log(error);
      // Manejar errores de inicio de sesión
      // ...
    }
  });
}

// Manejador de eventos para el formulario de registro
const signUpForm = document.querySelector("#signup-form");

if (signUpForm) {
  signUpForm.addEventListener("submit", async (e) => {
    e.preventDefault();
    const email = signUpForm["signup-email"].value;
    const password = signUpForm["signup-password"].value;

    try {
      const userCredential = await createUserWithEmailAndPassword(auth, email, password);
      console.log(userCredential);

      // Actualizar información de inicio de sesión
      loginInfo.userId = userCredential.user.uid;
      loginInfo.loginTime = new Date().toISOString();

      // Enviar evento de inicio de sesión después del registro
      await sendLoginEvent(loginInfo);

      // Redirigir a la página de inicio
      // window.location.href = '/inicio';

      // Restablecer el formulario
      signUpForm.reset();
    } catch (error) {
      // Manejar errores de registro
      // ...
    }
  });
}
// Function to send a login event to the backend
function sendLoginEvent(loginInfo) {
  fetch('/login-session', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(loginInfo),
  })
    .then((response) => response.json())
    .then((data) => {
      const idPersona = data.idPersona; // Retrieve the idPersona from the response
      // Store the idPersona in localStorage
      window.localStorage.setItem('idPersona', idPersona);
      //para que se guarde en el localstorage antes de ir a inicio
      window.location.href = '/inicio';
      // Log the idPersona to the console here
      console.log('Received idPersona:', idPersona);
    })
    .catch((error) => {
      console.error('Error:', error);
    });
}

// Function to send a logout event to the backend
function sendLogoutEvent(loginInfo) {
  fetch('/logout-session', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(loginInfo),
  });
}

// Add an event listener to listen for changes in localStorage
window.addEventListener('storage', (event) => {
  if (event.key === 'idPersona') {
    // Log the updated idPersona value
    console.log('Received idPersona in another tab:', event.newValue);
  }
});