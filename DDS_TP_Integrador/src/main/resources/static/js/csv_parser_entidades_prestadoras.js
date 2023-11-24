
document.getElementById("boton-cargar-archivo").addEventListener("click", function() {
  leer_csv_entidades();
});

function leer_csv_entidades() {
  var listOfObjects = [
    { categoria: 'Supermercado', nombre_entidad: 'Cotito', organismo_de_control: 1, prestador: 1},
    { categoria: 'Supermercado', nombre_entidad: 'Cototo', organismo_de_control: 1, prestador: 1}
  ];

  const firstNombreEntidad = listOfObjects[0].nombre_entidad;
        console.log(firstNombreEntidad);

  fetch('/importar-entidades-prestadoras/csv', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(listOfObjects),
  })
    .then(response => response.json())
    .then(data => {
      console.log(data);
    })
    .catch(error => {
      console.error('Error:', error);
    });
}
