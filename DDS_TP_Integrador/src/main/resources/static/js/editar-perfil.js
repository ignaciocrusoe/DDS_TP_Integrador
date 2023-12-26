const idPersona = localStorage.getItem('idPersona');
console.log('Received idPersona:', idPersona);

var cambiarNombreForm = document.getElementById('cambiar-nombre-form');
var cambiarMedioForm = document.getElementById('cambiar-medio-form');

var idPersonaFormNombre = cambiarNombreForm.querySelector('.idPersonaInput');
var idPersonaMedioNombre = cambiarMedioForm.querySelector('.idPersonaInput');

idPersonaFormNombre.value = idPersona;
idPersonaMedioNombre.value = idPersona;

