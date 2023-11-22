const fs = require('fs');
const csv = require('csv-parser');

const HEADERS4 = ['nombre_establecimiento', 'id_entidad', 'localizacion', 'categoria'];
document.getElementById("boton-cargar-archivo").addEventListener("submit", leer_csv_entidades () {
    const incidentForm = document.getElementById("csv-file")});

function leer_csv_entidades(path) {
  const listaCsv = [];
  fs.createReadStream(path)
    .pipe(csv({
      headers: HEADERS4,
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