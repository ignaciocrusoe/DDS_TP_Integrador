const fs = require('fs');
const csv = require('csv-parser');

const HEADERS4 = ['categoria', 'nombre_entidad', 'organismo_de_control', 'prestador'];

document.getElementById("boton-cargar-archivo").addEventListener("submit", function() {
  const incidentForm = document.getElementById("csv-file");
  leer_csv_entidades(incidentForm.files[0].path);
});

function leer_csv_entidades(path) {

  const listaCsv = [];
  fs.createReadStream(path)
    .pipe(csv({
      headers: HEADERS4,
      delimiter: ';',
      skipHeader: true
    }))
    .on('data', (data) => {
      // Create an object for each row and add it to the list
      const objetoCsv = {
        nombre_establecimiento: data.nombre_entidad,
        id_entidad: data.id_entidad,
        localizacion: data.organismo_de_control,
        categoria: data.categoria
      };
      listaCsv.push(objetoCsv);
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
