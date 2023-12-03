//dao
export class Incidente {
    constructor(idIncidente, observaciones, prestacionIncidentada, establecimiento, apertura, cierre, estado) {
        this.idIncidente = idIncidente;
        this.observaciones = observaciones;
        this.prestacionIncidentada = prestacionIncidentada;
        this.establecimiento = establecimiento;
        this.apertura = apertura;
        this.cierre = cierre;
        this.estado = estado;
    }
}

export class Establecimiento {
    constructor(idEstablecimiento, nombreEstablecimiento, localizacion, entidad) {
        this.idEstablecimiento = idEstablecimiento;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.localizacion = localizacion;
        this.entidad = entidad;
    }
}

export class Localizacion {
    constructor(idLocalizacion, nombreLocalizacion, latitudLocalizacion, longuitudLocalizacion) {
        this.idLocalizacion = idLocalizacion;
        this.nombreLocalizacion = nombreLocalizacion;
        this.latitudLocalizacion = latitudLocalizacion;
        this.longuitudLocalizacion = longuitudLocalizacion;
    }
}

export class Entidad {
    constructor(id_entidad, nombre_entidad) {
        this.id_entidad = id_entidad;
        this.nombre_entidad = nombre_entidad;
    }
}
class PrestacionIncidentada {
    constructor(idPrestacion, nombrePrestacion, root, leaf) {
        this.idPrestacion = idPrestacion;
        this.nombrePrestacion = nombrePrestacion;
        this.root = root;
        this.leaf = leaf;
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
        const localizacion = new Localizacion(
            item.establecimiento.localizacion.idLocalizacion,
            item.establecimiento.localizacion.nombreLocalizacion,
            item.establecimiento.localizacion.latitudLocalizacion,
            item.establecimiento.localizacion.longuitudLocalizacion
        );


        const entidad = new Entidad(
            item.establecimiento.entidad.id_entidad,
            item.establecimiento.entidad.nombre_entidad
        );

        const prestacionIncidentada = new PrestacionIncidentada(
            item.prestacionIncidentada.idPrestacion,
            item.prestacionIncidentada.nombrePrestacion,
            item.prestacionIncidentada.root,
            item.prestacionIncidentada.leaf
        )

        const establecimiento = new Establecimiento(
            item.establecimiento.idEstablecimiento,
            item.establecimiento.nombreEstablecimiento,
            localizacion,
            entidad
        );

        return new Incidente(
            item.idIncidente,
            item.observaciones,
            item.prestacionIncidentada,
            establecimiento,
            item.apertura,
            item.cierre,
            item.estado
        );
    });
}

export const idPersona = localStorage.getItem('idPersona');



///////////////////////////////////////////////////////////////////////////////////////////////////////////////

export async function incidentesASugerirModificar(){
    const ubicacionActual = await obtenerUbicacion();
    const incidentesDeInteres = await getIncidentesDeInteres();
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
export async function getIncidentesDeInteres(){
    return new Promise((resolve, reject) => {
        fetch(`/${idPersona}/incidentesDeInteres`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Error en la solicitud de incidentes');
                }
            })
            .then(data => {

                const listaIncidentes = parsearJSONaIncidentes(data);

                resolve(listaIncidentes); // Resolvemos la Promesa con la lista de incidentes
            })
            .catch(error => {
                console.error('Error:', error);
                reject(error); // Rechazamos la Promesa en caso de error
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

        incidente.establecimiento.localizacion.latitudLocalizacion,
        incidente.establecimiento.localizacion.longuitudLocalizacion,
        ubicacionActual.latitud,
        ubicacionActual.longitud,
        radio

    )) {
        incidentesASugerirModificar.push(incidente);
    }
}