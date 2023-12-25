const idLocalStorage = localStorage.getItem('idPersona');
console.log('Received idPersona:', idLocalStorage);
console.log(idComunidad);

function goToIncidentes(idComunidad) {
  if (idLocalStorage) {
    window.location.href = "/comunidades/" + idLocalStorage + "/" + idComunidad + "/incidentes";
  }
}

function goToIncidentesAbiertos(idComunidad) { 
  if (idLocalStorage) {
    window.location.href = "/comunidades/" + idLocalStorage + "/" + idComunidad + "/incidentes/abiertos";
  }
}

function goToIncidentesCerrados(idComunidad) {
  if (idLocalStorage) {
    window.location.href = "/comunidades/" + idLocalStorage + "/" + idComunidad + "/incidentes/cerrados";
  }
}
