import { onAuthStateChanged } from "https://www.gstatic.com/firebasejs/10.2.0/firebase-auth.js"
import { getDocs, collection } from "https://www.gstatic.com/firebasejs/10.2.0/firebase-firestore.js"
import { auth, db } from "./firebase.js";


import './signupForm.js'
import './signinForm.js'
import './googleLogin.js'
import './logout.js'


// Initialize loginInfo object
let loginInfo = {
  userId: null,
  loginTime: null,
  logoutTime: null,
};

// Handle user login
onAuthStateChanged(auth, async (user) => {
  if (user) {
    // User is signed in
    loginInfo.userId = user.uid;
    loginInfo.loginTime = new Date().toISOString();
    // Send a POST request to your Spring Boot endpoint to log the login event
    sendLoginEvent(loginInfo);
  } else {
    // User is signed out
    loginInfo.logoutTime = new Date().toISOString();
    // Send a POST request to your Spring Boot endpoint to log the logout event
    sendLogoutEvent(loginInfo);
  }
});

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