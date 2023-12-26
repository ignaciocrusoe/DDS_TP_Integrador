const idLocalStorage = localStorage.getItem('idPersona');
console.log('Received idPersona:', idLocalStorage);
console.log(idComunidad);

function goToIncidentes(idComunidad) {
  if (idLocalStorage) {
    window.location.href = "/comunidades-" + idLocalStorage + "/incidentes-" + idComunidad;
  }
}

function goToIncidentesAbiertos(idComunidad) { 
  if (idLocalStorage) {
    window.location.href = "/comunidades-" + idLocalStorage + "/incidentes-" + idComunidad + "-abiertos";
  }
}

function goToIncidentesCerrados(idComunidad) {
  if (idLocalStorage) {
    window.location.href = "/comunidades-" + idLocalStorage + "/incidentes-" + idComunidad + "-cerrados";
  }
}
