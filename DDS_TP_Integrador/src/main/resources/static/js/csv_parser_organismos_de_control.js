const fs = require('fs');
const csv = require('csv-parser');

const HEADERS2 = ['nombre_organismo_control', 'mail_organismo_control'];

document.getElementById("boton-cargar-archivo").addEventListener("submit", function() {
  const incidentForm = document.getElementById("csv-file");
  leer_csv_entidades(incidentForm.files[0].path);
});

function leer_csv_entidades(path) {
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
      fetch("/importar-entidades-prestadoras/csv", {
        method: "POST",
        body: JSON.stringify(listaCsv)
      })
      .then((response) => response.json())
      .then((data) => console.log("Success:", data))
      .catch((error) => console.error("Error:", error));
    });
}