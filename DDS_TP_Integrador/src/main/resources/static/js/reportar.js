const idPersona = localStorage.getItem('idPersona');
console.log('Received idPersona:', idPersona);
document.getElementById('idPersonaInput').value = idPersona;


/*
document.addEventListener("DOMContentLoaded", function () {
  const incidentForm = document.getElementById("reportar-incidente-form");

  incidentForm.addEventListener("submit", function (event) {
    event.preventDefault();

    const establecimientoSelect = incidentForm.querySelector('select[name="establecimiento"]');
    const prestacionSelect = incidentForm.querySelector('select[name="prestacion"]');
    const descriptionTextarea = incidentForm.querySelector('textarea[name="descripcion"]');

    // Get the selected values
    const selectedEstablecimiento = establecimientoSelect.value;
    const selectedPrestacion = prestacionSelect.value;
    const description = descriptionTextarea.value;

    console.log('Received description:', description);

    // Create a data object to send to the server
    const data = {
      establecimiento: selectedEstablecimiento,
      prestacion: selectedPrestacion,
      descripcion: description, // Include the description in the data object
      idPersona: idPersona,
    };

    // Make an HTTP POST request to your Spring Boot backend
    fetch("/crear-incidente", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
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
});*/
