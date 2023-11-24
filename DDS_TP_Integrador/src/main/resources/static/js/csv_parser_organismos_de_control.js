document.getElementById("boton-cargar-archivo").addEventListener("submit", function() {
  const incidentForm = document.getElementById("csv-file");
  parseCSV(incidentForm.path);
});

function parse() {
  const incidentForm = document.getElementById("csv-file");
  parseCSV(incidentForm.path);
}
function parseCSV(file) {
  console.log("parseCSV");
  console.log(file);
  Papa.parse(file, {
    header: true,
    dynamicTyping: true,
    complete: function(results) {
      // Convert the parsed CSV data to a JSON object
      var jsonData = JSON.stringify(results.data);
      console.log("Parsed CSV data as JSON:", jsonData);
    }
  });
}