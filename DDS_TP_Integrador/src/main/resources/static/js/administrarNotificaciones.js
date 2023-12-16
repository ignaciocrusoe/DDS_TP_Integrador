const idPersona = localStorage.getItem('idPersona');
console.log('Received idPersona:', idPersona);

export class ConfiguracionNotificaciones {
    constructor(idPersona, horarios,mail, rangoSeleccionado) {
        this.idPersona = idPersona;
        this.horarios = horarios;
        this.mail = mail;
        this.rangoSeleccionado = rangoSeleccionado;
    }
}

export class RangoHorario {
    constructor(segundos) {
        this.segundos = segundos;
    }
}

//se hace en notificaciones.html
// // Limpia el localStorage cada hora (3600000 milisegundos)
// const limpiarLocalStorageInterval = setInterval(() => {
//     localStorage.removeItem('configuracionNotificaciones');
//     console.log("LocalStorage libre de configuraciones de notificaciones");
// }, 3600000);

export async function obtenerConfigNotificacionesPersona(){
    let configNotis;
    const configNotisLocalStorage = localStorage.getItem('configuracionNotificaciones');

    if(JSON.stringify(configNotisLocalStorage) === '{}' || configNotisLocalStorage === null){
        console.log('Solicitando configuracion notificaciones al backend...');
        configNotis = await getConfigNotificacionesPersonaBackend();

    }else{
        console.log('Usando configuracion notificaciones de localStorage:', configNotisLocalStorage);
        configNotis = parsearJSONAConfiguracionNotificaciones(JSON.parse(configNotisLocalStorage))
    }


    return configNotis;


}
function parsearJSONAConfiguracionNotificaciones(json) {

        let rangosHorarios = [];
        if (Array.isArray(json.horarios)) {
            rangosHorarios = json.horarios.map(horario => new RangoHorario(horario.segundos));
        }

        return new ConfiguracionNotificaciones(
            json.idPersona,
            rangosHorarios,
            json.mail,
            json.rangoSeleccionado
        );

}

export async function getConfigNotificacionesPersonaBackend() {
    return new Promise((resolve, reject) => {
        fetch(`/${idPersona}/notificaciones/configuracion`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        })
            .then(response => {
                if (response.ok) {
                    // Devuelve la Promise directamente, que se resuelve con el JSON real
                    return response.json();
                } else {
                    throw new Error('Error en la solicitud de incidentes');
                }
            })
            .then(data => {
                // Almacena en localStorage y resuelve la Promise con el JSON
                localStorage.setItem('configuracionNotificaciones', JSON.stringify(data));
                console.log("Se guarda configuracion de notificaciones actualizada en LocalStorage");
                resolve(parsearJSONAConfiguracionNotificaciones(data));
            })
            .catch(error => {
                console.error('Error:', error);
                reject(error);
            });
    });
}

//
//
// document.addEventListener("DOMContentLoaded", function () {
//   const incidentForm = document.getElementById("buscar-incidente-form");
//
//   incidentForm.addEventListener("submit", function (event) {
//     event.preventDefault();
//
//     const inputIdIncidente = incidentForm.querySelector('input[name="idIncidente"]');
//
//     // Get the selected values
//     const idIncidente = inputIdIncidente.value;
//
//     console.log('Received id:', idIncidente);
//
//     window.location.href = "../buscar_incidente/" + idIncidente;
//
//    });
// });