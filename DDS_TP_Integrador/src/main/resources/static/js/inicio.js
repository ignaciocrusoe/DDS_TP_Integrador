import { showMessage } from "./showMessage.js";

const justSignedUp = localStorage.getItem('justSignedUp');
export const idPersona = localStorage.getItem('idPersona');

console.log('Received idPersona:', idPersona);

if (justSignedUp === 'true') {
  // Display the welcome message
  showMessage("Welcome");

  // Reset the flag to avoid showing the message again on subsequent visits
  localStorage.setItem('justSignedUp', 'false');


}