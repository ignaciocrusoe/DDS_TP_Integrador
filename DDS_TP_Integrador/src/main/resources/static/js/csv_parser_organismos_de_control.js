//const fs = require('fs');
//const csv = require('csv-parser');

const HEADERS2 = ['nombre_organismo_control', 'mail_organismo_control'];

document.getElementById("boton-cargar-archivo").addEventListener("click", function() {
  const incidentForm = document.getElementById("csv-file");
  leer_csv_entidades(incidentForm.path);
});

function leer_csv_entidades(path) {
  /*
  alert("Hello world");
  const listaCsv = [];
  fs.createReadStream(path)
    .pipe(csv({
      headers: HEADERS2,
      delimiter: ';',
      skipHeader: true
    }))
    .on('data', (data) => {
      const listaInterior = [];
      listaInterior.push(data.nombre_establecimiento);
      listaInterior.push(data.id_entidad);
      listaInterior.push(data.localizacion);
      listaInterior.push(data.categoria);
      listaCsv.push(listaInterior);
    })
    .on('end', () => {
      console.log(listaCsv);
      fetch("loclalhost:8080/importar-entidades-prestadoras/csv", {
        method: "POST",
        body: JSON.stringify(listaCsv)
      })
      .then((response) => response.json())
      .then((data) => console.log("Success:", data))
      .catch((error) => console.error("Error:", error));
    });
    */
    fetch("localhost:8080/importar-entidades-prestadoras/csv", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({
        nombre_organismo_control: "Coto",
        mail_organismo_control: "coto@gmail.com"
      })
    })
    .then((response) => response.json())
    .then((data) => console.log("Success:", data))
    .catch((error) => console.error("Error:", error));
}