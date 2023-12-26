document.addEventListener("DOMContentLoaded", function () {
  const cambiarTipoForm = document.getElementById('cambiar-rol-form-pesado');

  cambiarTipoForm.addEventListener("submit", function (event) {
    event.preventDefault();

    const nuevoTipoSelect = cambiarTipoForm.querySelector('select[name="tipo"]');
    const idMiembroSelect = cambiarTipoForm.querySelector('input[name="idMiembro"]');

    const selectednuevoTipo = nuevoTipoSelect.value;
    const selectedidMiembro = idMiembroSelect.value;

    console.log('Received tipo:', selectednuevoTipo);
    console.log('Received idMiembro:', selectedidMiembro);

    const data = {
      tipo: selectednuevoTipo,
      idMiembro: selectedidMiembro,
    };

    // Make an HTTP POST request to your Spring Boot backend
    fetch("/cambiar_tipo_pesado", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })

      .then((response) => {
        if (response.ok) {
          // Handle the successful response, e.g., show a success message to the user
          console.log("Tipo cambiado correctamente!");
        } else {
          // Handle any errors, e.g., show an error message to the user
          console.error("Error cambiando tipo");
        }
      })
      .catch((error) => {
        console.error("Error: " + error);
      });
  });
});
