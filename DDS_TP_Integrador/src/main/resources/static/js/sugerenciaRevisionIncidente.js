export const idPersona = localStorage.getItem('idPersona');
/*la idea es poder tomar de este script la lista de notificaciones y tenerlas siempre actualizadas
tonces lo importamos en cualquier vista que tenga el boton de notificaciones
y al apretarlo actualizamos las notis*/


//tambien podemos importar este js en otra vista y ejecutar cada cierto tiempo
//// // Obtener la ubicación cada 10 segundos (10000 milisegundos)
// // setInterval(actualizarNotificaciones, 10000);
export async function actualizarNotificaciones(){

    try {
        await obtenerUbicacion();
        const notificacionesActualizadas = await getNotificacionesActualizadas();
        // Devuelve las notificaciones actualizadas como una lista
        return notificacionesActualizadas;
    } catch (error) {
        console.error('Error al actualizar notificaciones:', error);
        throw error;
    }


}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////
function obtenerUbicacion() {
    let latitudActualPersona, longitudActualPersona;

    return new Promise((resolve, reject) => {
        if ("geolocation" in navigator) {
            navigator.geolocation.getCurrentPosition(function(position) {
                latitudActualPersona = position.coords.latitude;
                longitudActualPersona = position.coords.longitude;
                resolve(); // Resolvemos la Promesa después de obtener la ubicación
            }, reject);
        } else {
            reject("Geolocalización no está disponible en tu navegador.");
        }
    });
}
export function getNotificacionesActualizadas(){
    return new Promise((resolve, reject) => {
        fetch(`/${idPersona}/notificacionesActualizadas/${latitudActualPersona}/${longitudActualPersona}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Error en la solicitud');
                }
            })
            .then(data => {
                // Manipular la lista de notificaciones actualizadas (data)
                // todo: actualizar el mapeo según cómo se arma el json devuelto
                // para eso hay que cargar datos en la bbdd y formatearlos correctamente con annotations
                const notificacionesActualizadas = data.map(item => ({
                    idPersona: item.idPersona,
                    idIncidente: item.incidente.idIncidente,
                    tipoNotificacion: item.tipoNotificacion
                }));
                resolve(notificacionesActualizadas); // Resolvemos la Promesa con la lista de notificaciones
            })
            .catch(error => {
                console.error('Error:', error);
                reject(error); // Rechazamos la Promesa en caso de error
            });
    });
}

