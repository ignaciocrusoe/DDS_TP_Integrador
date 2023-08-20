import { onAuthStateChanged } from "https://www.gstatic.com/firebasejs/10.2.0/firebase-auth.js"
import { getDocs, collection } from "https://www.gstatic.com/firebasejs/10.2.0/firebase-firestore.js"
import { auth, db } from "./firebase.js";
import { loginCheck } from "./loginCheck.js";

import './signupForm.js'
import './signinForm.js'
import './googleLogin.js'
import './logout.js'

// list for auth state changes
onAuthStateChanged(auth, async (user) => {
    loginCheck(user);
});