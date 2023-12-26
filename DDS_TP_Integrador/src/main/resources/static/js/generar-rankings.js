function ordenarPorIncidentes(array) {
  var listaOrdenada = array.sort((a, b) => {
    var lengthA = a.incidentes ? a.incidentes.filter(incidente => incidente.estado).length : 0;
    var lengthB = b.incidentes ? b.incidentes.filter(incidente => incidente.estado).length : 0;
    return lengthB - lengthA;
  });

  var listaNueva = [];
  var posicion = 1;

  listaOrdenada.forEach(function (entidad) {
    listaNueva.push({
      nombre: entidad.nombreEntidad,
      posicion: posicion,
      tam: entidad.incidentes ? entidad.incidentes.filter(incidente => incidente.estado).length : 0,
    });

    posicion++;
  });

  return listaNueva;
}

function ordenarPorTiempo(array) {
  var listaOrdenada = array.sort((a, b) => {
    var tiempo1 = 0;
    var tiempo2 = 0;
    var incidentesCerrados1 = a.incidentes.filter(incidente => !incidente.estado);
    var incidentesCerrados2 = b.incidentes.filter(incidente => !incidente.estado);

    incidentesCerrados1.forEach(function (incidente) {
      tiempo1 += incidente.cierre - incidente.apertura;
    });

    incidentesCerrados2.forEach(function (incidente) {
      tiempo2 += incidente.cierre - incidente.apertura;
    });

    return tiempo1 / incidentesCerrados1.length - tiempo2 / incidentesCerrados2.length;
  });

    var listaNueva = [];
    var posicion = 1;

  listaOrdenada.reverse().forEach(function (entidad) {
    listaNueva.push({
      nombre: entidad.nombreEntidad,
      posicion: posicion,
    });

    posicion++;
  });

  return listaNueva;
}

function ordenarPorImpacto(array){

    var listaOrdenada = array.sort((a, b) => {
     var sumaTiempoResolucion1 = 0;
      var incidentesCerrados1 = a.incidentes.filter(incidente => !incidente.estado);
      incidentesCerrados1.forEach(function(incidente){
      sumaTiempoResolucion1 = incidente.cierre + incidente.apertura;
      });

      var sumaTiempoResolucion2 = 0;
            var incidentesCerrados2 = b.incidentes.filter(incidente => !incidente.estado);
            incidentesCerrados2.forEach(function(incidente){
            sumaTiempoResolucion2 = incidente.cierre + incidente.apertura;
            });
        console.log(sumaTiempoResolucion2);
        console.log(b.incidentes.filter(incidente => incidente.estado).length)
        console.log(sumaTiempoResolucion1);
        console.log(a.incidentes.filter(incidente => incidente.estado).length)
       return -(sumaTiempoResolucion2 + 1 * b.incidentes.filter(incidente => incidente.estado).length) + (sumaTiempoResolucion1 + 1 * a.incidentes.filter(incidente => incidente.estado).length);
    });

    var listaNueva = [];
        var posicion = 1;

      listaOrdenada.reverse().forEach(function (entidad) {
        listaNueva.push({
          nombre: entidad.nombreEntidad,
          posicion: posicion,
        });

        posicion++;
      });

      return listaNueva;
/*
fetch('localhost:8082/calculoRanking')
.then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {
      const list = Array.isArray(data) ? data : [data];
*/
var listaNueva = [];


      listaOrdenada.forEach(function (ranking) {
        listaNueva.push({
          entidad: ranking.entidad,
          posicion: ranking.posicion,
        });

      });

      return listaNueva;




      })
            .catch(error => {
              console.error('There has been a problem with your fetch operation:', error);
            });
}

document.addEventListener('DOMContentLoaded', function () {
  fetch('/obtener-entidades')
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {
      const list = Array.isArray(data) ? data : [data];

      var listaNueva1 = ordenarPorTiempo(list);
      console.log(listaNueva1);
      var listaNueva2 = ordenarPorIncidentes(list);
      console.log(listaNueva2);
      var listaNueva3 = ordenarPorImpacto(list);
      console.log(listaNueva3);

      var ulElement1 = document.getElementById('ranking1');

      if (ulElement1) {
        ulElement1.innerHTML = '';

        listaNueva1.forEach(function (entidad) {
          var listItem = document.createElement('li');
          listItem.classList.add('list-group-item');
          listItem.textContent = `${entidad.nombre}, ${entidad.posicion}`;
          ulElement1.appendChild(listItem);
        });

        } else {
                  console.error('No hay ranking1');
                }

        var ulElement2 = document.getElementById('ranking2');

        if (ulElement2) {
          ulElement2.innerHTML = '';

          listaNueva2.forEach(function (entidad) {
            var listItem = document.createElement('li');
            listItem.classList.add('list-group-item');
            listItem.textContent = `${entidad.nombre}, ${entidad.posicion}`;
            ulElement2.appendChild(listItem);
          });
        } else {
          console.error('No hay ranking2');
        }

        var ulElement3 = document.getElementById('ranking3');

              if (ulElement3) {
                ulElement3.innerHTML = '';

                listaNueva3.forEach(function (entidad) {
                  var listItem = document.createElement('li');
                  listItem.classList.add('list-group-item');
                  listItem.textContent = `${entidad.nombre}, ${entidad.posicion}`;
                  ulElement3.appendChild(listItem);
                });

                } else {
                    console.error('No hay ranking3');
                }

      })
      .catch(error => {
        console.error('There has been a problem with your fetch operation:', error);
      });
});
