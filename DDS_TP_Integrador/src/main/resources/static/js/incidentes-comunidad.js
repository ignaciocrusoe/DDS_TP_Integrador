const idLocalStorage = localStorage.getItem('idPersona');
console.log('Received idPersona:', idLocalStorage);
var idComunidad = "${idComunidad}";
console.log(idComunidad);

function goToIncidentes() {
  if (idLocalStorage) {
    window.location.href = "/comunidades/" + idLocalStorage + "/" + idComunidad + "/incidentes";
  }
}

function goToIncidentesAbiertos() {
  if (idLocalStorage) {
    window.location.href = "/comunidades/" + idLocalStorage + "/" + idComunidad + "/incidentes/abiertos";
  }
}

function goToIncidentesCerrados() {
  if (idLocalStorage) {
    window.location.href = "/comunidades/" + idLocalStorage + "/" + idComunidad + "/incidentes/cerrados";
  }
}
