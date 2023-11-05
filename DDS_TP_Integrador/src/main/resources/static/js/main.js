import { onAuthStateChanged } from "https://www.gstatic.com/firebasejs/10.2.0/firebase-auth.js"
import { getDocs, collection } from "https://www.gstatic.com/firebasejs/10.2.0/firebase-firestore.js"
import { auth, db } from "./firebase.js";
//import { loginCheck } from "./loginCheck.js";

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