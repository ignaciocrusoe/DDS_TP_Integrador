import { showMessage } from "./showMessage.js";

const justSignedUp = localStorage.getItem('justSignedUp');
export const idPersona = localStorage.getItem('idPersona');

console.log('Received idPersona:', idPersona);

if (justSignedUp === 'true') {

  showMessage("Welcome");


  localStorage.setItem('justSignedUp', 'false');


}