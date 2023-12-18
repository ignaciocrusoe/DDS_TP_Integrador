(function () {
  var DELIMITER = ';';
  var NEWLINE = '\n';
  var qRegex = /^"|"$/g;
  var button = document.getElementById('boton-cargar-archivo');
  var i = document.getElementById('csv-file');
  var listOfStrings;
  var object;
  var listOfObjects;

  var iterator = 0;

  if (!i) {
      return;
  }

  button.addEventListener('click', function () {
      if (!!i.files && i.files.length > 0) {
          parseCSV(i.files[0]);
      }
  });

  function parseCSV(file) {
      if (!file || !FileReader) {
          return;
      }

      var reader = new FileReader();

      reader.onload = function (e) {
          sendElements(e.target.result);
      };

      reader.readAsText(file);
  }

 

  function sendElements(text) {
      if (!text) {
          return;
      }

      listOfStrings = [];
      listOfObjects = [];

      var rows = text.split(NEWLINE);
      var headers = rows.shift().trim().split(DELIMITER);

      headers.forEach(function (h) {

          var ht = h.trim();

          if (!ht) {
              return;
          }


      });

      rows.forEach(function (r) {
          r = r.trim();

          if (!r) {
              return;
          }

          var cols = r.split(DELIMITER);

          if (cols.length === 0) {
              return;
          }


          cols.forEach(function (c) {
              var tc = c.trim();
              iterator = iterator + 1;

              console.log("Text = ", tc);
              listOfStrings.push(tc);

          });
          let object = {categoria: listOfStrings[0], nombre_entidad: listOfStrings[1], organismo_de_control: listOfStrings[2], prestador: listOfStrings[3]};
          console.log("object ",object);
          listOfObjects.push(object);
          listOfStrings = [];

      });
      console.log("listOfObjects: ", listOfObjects);
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
})();