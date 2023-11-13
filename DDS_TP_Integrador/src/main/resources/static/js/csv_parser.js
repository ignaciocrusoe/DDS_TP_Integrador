const fs = require('fs');
const csv = require('csv-parser');

const HEADERS3 = ['nombre_establecimiento', 'id_entidad', 'localizacion', 'categoria'];
document.addEventListener("submit", function () {
    const incidentForm = document.getElementById("csv-file")});

function leer_csv_entidades(path) {
  const listaCsv = [];
  fs.createReadStream(path)
    .pipe(csv({
      headers: HEADERS3,
      delimiter: ';',
      skipHeader: true
    }))
    .on('data', (data) => {
      const listaInterior = [];
      listaInterior.push(data.nombre_establecimiento);
      listaInterior.push(data.prestacion);
      listaInterior.push(data.localizacion);
      listaCsv.push(listaInterior);
    })
    .on('end', () => {
      console.log(listaCsv);
    });
    fetch("/importar-entidades-prestadoras/csv", {
    method: "POST",
    body: JSON.stringify(listaCsv)
    })
    .then((response) => response.json())
    .then((data) => console.log("Success:", data))
    .catch((error) => console.error("Error:", error));
}