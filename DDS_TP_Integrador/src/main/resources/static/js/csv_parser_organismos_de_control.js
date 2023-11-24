document.getElementById("boton-cargar-archivo").addEventListener("click", function() {
  const incidentForm = document.getElementById("csv-file");
  parseCSV(incidentForm.path);
});
function parseCSV(file) {
  
  let reader = new FileReader();
  reader.readAsText(file);
  reader.onload = function() {
    let rows = reader.result.split('\n');
    let headers = rows[0].split(',');
    let jsonData = [];
    for (let i = 1; i < rows.length; i++) {
      let data = rows[i].split(',');
      let obj = {};
      for (let j = 0; j < data.length; j++) {
        obj[headers[j]] = data[j];
      }
      jsonData.push(obj);
    }
    console.log(jsonData);
  };
}
//const fs = require('fs');
//const csv = require('csv-parser');
/*
const HEADERS2 = ['nombre_organismo_control', 'mail_organismo_control'];

document.getElementById("boton-cargar-archivo").addEventListener("click", function() {
  const incidentForm = document.getElementById("csv-file");
  leer_csv_entidades(incidentForm.path);
});

function leer_csv_entidades(path) {
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
      listaInterior.push(data.nombre_organismo_control);
      listaInterior.push(data.mail_organismo_control);
      console.log(data.nombre_organismo_control);
      console.log(data.mail_organismo_control);
      listaCsv.push(listaInterior);
    })
    .on('end', () => {
      console.log(listaCsv);
      fetch("loclalhost:8080/importar-organismos-de-control/csv", {
        method: "POST",
        body: JSON.stringify(listaCsv)
      })
      .then((response) => response.json())
      .then((data) => console.log("Success:", data))
      .catch((error) => console.error("Error:", error));
    });
    
    fetch("localhost:8080/importar-entidades-prestadoras/csv", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(
        {
          [{"nombre_organismo_control":"coto","mail_organismo_control":"coto@gmail.com"}]

    })
    .then((response) => response.json())
    .then((data) => console.log("Success:", data))
    .catch((error) => console.error("Error:", error));
   
} */