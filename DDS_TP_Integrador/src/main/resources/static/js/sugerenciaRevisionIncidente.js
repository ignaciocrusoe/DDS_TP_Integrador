export const idPersona = localStorage.getItem('idPersona');
export class NotificacionModificarIncidente {
    constructor(idIncidente, fechaApertura, estado, nombreEstablecimiento, prestacionIncidentada,latitudEstablecimiento, longitudEstablecimiento, tipo) {
        this.idIncidente = idIncidente;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.prestacionIncidentada = prestacionIncidentada;
        this.latitudEstablecimiento = latitudEstablecimiento;
        this.longitudEstablecimiento = longitudEstablecimiento;
        this.tipo = tipo;
    }
}

class UbicacionActual{

    constructor(latitud, longitud) {
        this.latitud = latitud;
        this.longitud = longitud;

    }

}

// Función para parsear el JSON a objetos "Incidente"
function parsearJSONaIncidentes(json) {
    return json.map(item => {
        // Convierte la fecha a un objeto Date si está presente
        const fechaApertura = item.fechaApertura ? new Date(item.fechaApertura) : null;

        return new NotificacionModificarIncidente(
            item.idIncidente,
            fechaApertura,
            item.estado,
            item.nombreEstablecimiento,
            item.prestacionIncidentada,
            item.latitudEstablecimiento,
            item.longitudEstablecimiento,
            "Modificar Incidente"
        );
    });
}

//se hace en notifiaciones.html
// // Limpia el localStorage cada hora (3600000 milisegundos)
// const limpiarLocalStorageInterval = setInterval(() => {
//     localStorage.removeItem('incidentesDeInteres');
//     console.log("LocalStorage libre de incidentes de interés");
// }, 3600000);
//

export async function incidentesASugerirModificar(){
    const ubicacionActual = await obtenerUbicacion();
    let incidentesDeInteres = [];
    const incidentesDeInteresLocalStorage = localStorage.getItem('incidentesDeInteres');

    if(JSON.stringify(incidentesDeInteresLocalStorage) === '{}' || incidentesDeInteresLocalStorage === null){
        console.log('Solicitando incidentes de interés al backend...');
        incidentesDeInteres = await getIncidentesDeInteres();

    }else{
        console.log('Usando incidentes de interés de localStorage:', incidentesDeInteresLocalStorage);
        incidentesDeInteres = parsearJSONaIncidentes(JSON.parse(incidentesDeInteresLocalStorage))
    }

    let incidentesASugerirModificar = [];
    incidentesDeInteres.forEach((incidente)=>{
        agregarIncidenteASugerirModificar(incidente,incidentesASugerirModificar,ubicacionActual,100000000000)
    });
    return incidentesASugerirModificar;


}

async function obtenerUbicacion(){
    return new Promise((resolve, reject) => {
        if ("geolocation" in navigator) {
            navigator.geolocation.getCurrentPosition(function(position) {
                let ubicacion = new UbicacionActual(position.coords.latitude,position.coords.longitude)
                console.log("latitud " + ubicacion.latitud + " longitud " + ubicacion.longitud);
                resolve(ubicacion); // Resolvemos la Promesa después de obtener la ubicación
            }, reject);
        } else {
            reject("Geolocalización no está disponible en tu navegador.");
        }
    });
}
export async function getIncidentesDeInteres() {
    return new Promise((resolve, reject) => {
        fetch(`/${idPersona}/incidentesDeInteres`, {
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
                localStorage.setItem('incidentesDeInteres', JSON.stringify(data));
                console.log("Se guardan intereses de interés actualizados en LocalStorage");
                resolve(parsearJSONaIncidentes(data));
            })
            .catch(error => {
                console.error('Error:', error);
                reject(error);
            });
    });
}

///// calculo radio

function calcularDistancia(lat1, lon1, lat2, lon2) {
    const radioTierra = 6371; // Radio de la Tierra en kilómetros

    // Convertir grados a radianes
    const dLat = toRad(lat2 - lat1);
    const dLon = toRad(lon2 - lon1);

    // Calcular la distancia haversine
    const a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
        Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
        Math.sin(dLon / 2) * Math.sin(dLon / 2);
    const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    // Distancia en kilómetros
    const distancia = radioTierra * c;

    return distancia;
}

function toRad(grados) {
    return grados * Math.PI / 180;
}

function estaDentroDelRadio(latitudPunto, longitudPunto, latitudCentro, longitudCentro, radio) {
    const distancia = calcularDistancia(latitudPunto, longitudPunto, latitudCentro, longitudCentro);

    return distancia <= radio;
}
///meter dentro de la lista de incidentes a modificar

function agregarIncidenteASugerirModificar(incidente,incidentesASugerirModificar, ubicacionActual,radio) {


    if (estaDentroDelRadio(

        incidente.latitudEstablecimiento,
        incidente.longitudEstablecimiento,
        ubicacionActual.latitud,
        ubicacionActual.longitud,
        radio

    )) {
        incidentesASugerirModificar.push(incidente);
    }
}