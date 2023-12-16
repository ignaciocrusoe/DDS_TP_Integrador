const idPersona = localStorage.getItem('idPersona');
console.log('Received idPersona:', idPersona);

// Find the form by ID
var cambiarNombreForm = document.getElementById('cambiar-nombre-form');
var cambiarMedioForm = document.getElementById('cambiar-medio-form');

// Find the input element within the form using its class
var idPersonaFormNombre = cambiarNombreForm.querySelector('.idPersonaInput');
var idPersonaMedioNombre = cambiarMedioForm.querySelector('.idPersonaInput');

idPersonaFormNombre.value = idPersona;
idPersonaMedioNombre.value = idPersona;

/*

document.addEventListener("DOMContentLoaded", function () {
  const incidentForm = document.getElementById("cambiar-nombre-form");

  incidentForm.addEventListener("submit", function (event) {
    event.preventDefault();

    const nuevoNombreSelect = incidentForm.querySelector('select[name="nuevoNombre"]');
    const nuevoApellidoSelect = incidentForm.querySelector('select[name="nuevoApellido"]');

    // Get the selected values
    const selectednuevoNombre = nuevoNombreSelect.value;
    const selectednuevoApellido = nuevoApellidoSelect.value;

    // Create a data object to send to the server
    const data = {
      nuevoNombre: selectednuevoNombre,
      nuevoApellido: selectednuevoApellido,
      idPersona: idPersona,
    };

    // Make an HTTP POST request to your Spring Boot backend
    fetch("/cambiar_nombre", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })

    //faltaria probarlo, recibir la vista desde el back end y abrirla con js

      .then((response) => {
        if (response.ok) {
          // Handle the successful response, e.g., show a success message to the user
          console.log("Incident reported successfully!");
        } else {
          // Handle any errors, e.g., show an error message to the user
          console.error("Error reporting the incident.");
        }
      })
      .catch((error) => {
        console.error("Error: " + error);
      });
  });
});

*/

// document.getElementById('myForm').addEventListener('submit', (e) => {
//   e.preventDefault();
//
//   const formData = new FormData(document.getElementById('myForm'));
//
//   fetch('your-api-endpoint-url', {
//     method: 'POST',
//     body: formData
//   })
//     .then((response) => response.text())
//     .then((responseData) => {
//       const newWindow = window.open();
//       newWindow.document.write(responseData);
//     })
//     .catch((error) => {
//       console.error(error);
//     });
// });