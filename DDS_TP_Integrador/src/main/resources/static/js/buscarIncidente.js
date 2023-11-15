
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

    window.location.href = "/buscar_incidente/" + idIncidente;

   });
});