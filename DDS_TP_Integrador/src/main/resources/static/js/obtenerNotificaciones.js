
export const idPersona = localStorage.getItem('idPersona');

export class Notificacion {
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
function parsearJSONaNotificaciones(json) {
  return json.map(item => {
    // Convierte la fecha a un objeto Date si está presente
    const fechaApertura = item.fechaApertura ? new Date(item.fechaApertura) : null;

    return new Notificacion(
        item.idIncidente,
        fechaApertura,
        item.estado,
        item.nombreEstablecimiento,
        item.prestacionIncidentada,
        item.latitudEstablecimiento,
        item.longitudEstablecimiento,
        "Nuevo Incidente"
    );
  });
}

//se hace en notificaciones.html

// // Limpia el localStorage cada hora (3600000 milisegundos)
// const limpiarLocalStorageInterval = setInterval(() => {
//   localStorage.removeItem('notificaciones');
//   console.log("LocalStorage libre de notificaciones");
// }, 3600000);

export async function obtenerNotificacionesPersona(){
  let notificaciones = [];
  const notificacionesLocalStorage = localStorage.getItem('notificaciones');

  if(JSON.stringify(notificacionesLocalStorage) === '{}' || notificacionesLocalStorage === null){
    console.log('Solicitando notificaciones al backend...');
    notificaciones = await getNotificacionesBackend();

  }else{
    console.log('Usando notificaciones de localStorage:', notificacionesLocalStorage);
    notificaciones = parsearJSONaNotificaciones(JSON.parse(notificacionesLocalStorage))
  }


  return notificaciones;


}

export async function getNotificacionesBackend() {
  return new Promise((resolve, reject) => {
    fetch(`/${idPersona}/notificaciones`, {
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
          localStorage.setItem('notificaciones', JSON.stringify(data));
          console.log("Se guardan notificaciones actualizadas en LocalStorage");
          resolve(parsearJSONaNotificaciones(data));
        })
        .catch(error => {
          console.error('Error:', error);
          reject(error);
        });
  });
}