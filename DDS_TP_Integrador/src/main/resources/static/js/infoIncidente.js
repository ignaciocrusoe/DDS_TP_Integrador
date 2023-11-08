
const idPersona = localStorage.getItem('idPersona');
console.log('Received idPersona:', idPersona);

document.addEventListener("DOMContentLoaded", function () {
  const incidentForm = document.getElementById("buscar-incidente-form");

  incidentForm.addEventListener("submit", function (event) {
    event.preventDefault();

    const inputIdIncidente = incidentForm.querySelector('input[name="idIncidente"]');

    // Get the selected values
    const idIncidente = inputIdIncidente.value;

    console.log('Received id:', idIncidente);

    // Create a data object to send to the server
    fetch("/buscar-incidente-id?idIncidente=" + idIncidente, {
      method: "GET",
    })
      .then((response) => {
        if (response.ok) {
          // Handle the successful response, e.g., show a success message to the user
          console.log("Todo successfully!");
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
