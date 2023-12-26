import { initializeApp } from "https://www.gstatic.com/firebasejs/10.2.0/firebase-app.js";
import { getAuth } from "https://www.gstatic.com/firebasejs/10.2.0/firebase-auth.js"
import { getFirestore } from "https://www.gstatic.com/firebasejs/10.2.0/firebase-firestore.js"
import { getAnalytics } from "https://www.gstatic.com/firebasejs/10.2.0/firebase-analytics.js";

const firebaseConfig = {
    apiKey: "AIzaSyDx47u1M7WyNRpqIUc3cGStZDSMuS4rCaY",
    authDomain: "dds-tp-integrador.firebaseapp.com",
    projectId: "dds-tp-integrador",
    storageBucket: "dds-tp-integrador.appspot.com",
    messagingSenderId: "509213619852",
    appId: "1:509213619852:web:2c17d6438d4636d3f36da9",
    measurementId: "G-RZ1XM64ZS8"
  };


export const app = initializeApp(firebaseConfig);
export const auth = getAuth(app)
export const db = getFirestore(app)