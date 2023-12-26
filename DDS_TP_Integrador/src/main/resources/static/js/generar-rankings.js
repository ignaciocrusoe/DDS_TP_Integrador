
function ordenarPorIncidentes(array) {
    return array.sort((a, b) => {
      const comparison = a.incidentes_reportados.length.localeCompare(b.incidentes_reportados.length);
      return (comparison === 1) ? 1 : (comparison === -1) ? -1 : 0;
    });
  }

document.addEventListener('DOMContentLoaded',function(){


    fetch('/obtener-entidades') 
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {
      const list = Array.isArray(data) ? data : [data];
      console.log(list);
      ordenarPorIncidentes(list);
    })
    .catch(error => {
      console.error('There has been a problem with your fetch operation:', error);
    });
  

})