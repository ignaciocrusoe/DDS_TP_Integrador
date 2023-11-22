const idPersona = 1; // Replace this with your actual idPersona value
console.log('Received idPersona:', idPersona);

// Find the form by ID
var cambiarNombreForm = document.getElementById('cambiar-nombre-form');

// Find the input element within the form using its class
var idPersonaInput = cambiarNombreForm.querySelector('.idPersonaInput');

// Set the value of the input element
idPersonaInput.value = idPersona;