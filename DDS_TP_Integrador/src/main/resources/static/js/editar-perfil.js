const idPersona = localStorage.getItem('idPersona');
console.log('Received idPersona:', idPersona);

var cambiarNombreForm = document.getElementById('cambiar-nombre-form');
var cambiarMedioForm = document.getElementById('cambiar-medio-form');
var cambiarImagenForm = document.getElementById('cambiar-imagen-form');

var idPersonaFormNombre = cambiarNombreForm.querySelector('.idPersonaInput');
var idPersonaFormImagen = cambiarImagenForm.querySelector('.idPersonaInput');
var idPersonaMedioNombre = cambiarMedioForm.querySelector('.idPersonaInput');


idPersonaFormImagen.value = idPersona;
idPersonaFormNombre.value = idPersona;
idPersonaMedioNombre.value = idPersona;





