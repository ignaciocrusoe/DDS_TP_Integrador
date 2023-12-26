import { signInWithEmailAndPassword,createUserWithEmailAndPassword,GoogleAuthProvider, signInWithPopup  } from "https://www.gstatic.com/firebasejs/10.2.0/firebase-auth.js"
import { auth } from "./firebase.js";
import { showMessage } from "./showMessage.js";
import './logout.js'


let loginInfo = {
  userId: null,
  loginTime: null,
  logoutTime: null,
  mail: null
};


const googleButton = document.querySelector("#googleLogin");

if(googleButton) {
  googleButton.addEventListener("click", async (e) => {
    e.preventDefault();

    const provider = new GoogleAuthProvider();
    try {
      const userCredentials = await signInWithPopup(auth, provider)
      console.log(userCredentials);
      console.log("google sign in");

      loginInfo.userId = userCredentials.user.uid;
      loginInfo.loginTime = new Date().toISOString();
      loginInfo.mail = userCredentials.user.mail;

      await sendLoginEvent(loginInfo);

      signInForm.reset();

    } catch (error) {
      console.log(error);
    }
  });
}

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
      loginInfo.mail = userCredentials.user.mail;
      // Enviar evento de inicio de sesión
      await sendLoginEvent(loginInfo);


      // Restablecer el formulario
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
      loginInfo.mail = userCredential.user.mail;

      // Enviar evento de inicio de sesión después del registro
      await sendLoginEvent(loginInfo);


      // Restablecer el formulario
      signUpForm.reset();
    } catch (error) {
      if (error.code === 'auth/email-already-in-use') {
        showMessage("Email already in use", "error")
      } else if (error.code === 'auth/invalid-email') {
        showMessage("Proporcione un email valido", "error")
      } else if (error.code === 'auth/missing-password') {
        showMessage("Proporcione una contraseña valida", "error")
      } else if (error.code === 'auth/weak-password') {
        showMessage("Weak password", "error")
      } else if (error.code) {
        showMessage("Something went wrong", "error")
      }
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