const idLocalStorage = localStorage.getItem('idPersona');
console.log('Received idPersona:', idLocalStorage);

function goToIncidentes() {
	window.location.href = "/comunidades/"+idLocalStorage.toString()+[[${comunidad.idComunidad}]].toString()+"/incidentes"
}

function goToIncidentesAbiertos() {
	window.location.href = "/comunidades/"+idLocalStorage.toString()+[[${comunidad.idComunidad}]].toString()+"/incidentes/abiertos"
}

function goToIncidentesCerrados() {
	window.location.href = "/comunidades/"+idLocalStorage.toString()+[[${comunidad.idComunidad}]].toString()+"/incidentes/cerrados"
}