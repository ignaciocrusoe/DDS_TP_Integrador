
const idPersona = localStorage.getItem('idPersona');
console.log('Received idPersona:', idPersona);

document.addEventListener("DOMContentLoaded", function () {
  const incidentForm = document.getElementById("cerrar-incidente-form");

  incidentForm.addEventListener("submit", function (event) {
    event.preventDefault();

    const descriptionTextarea = incidentForm.querySelector('textarea[name="nuevaObservacion"]');
    const inputIdIncidente = incidentForm.querySelector('input[name="idIncidente"]');

    // Get the selected values
    const description = descriptionTextarea.value;
    const idIncidente = inputIdIncidente.value;

    console.log('Received description:', description);

    // Create a data object to send to the server
    const data = {
      description: description, // Include the description in the data object
      idIncidente: idIncidente,
    };

    console.log('Received description:', data.description);

    // Make an HTTP POST request to your Spring Boot backend
    fetch("/cerrar-incidente", {
      method: "POST",
      headers: {
        "Content-Type": "application/json", // Set the content type to JSON
      },
      body: JSON.stringify(data),
    })
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
