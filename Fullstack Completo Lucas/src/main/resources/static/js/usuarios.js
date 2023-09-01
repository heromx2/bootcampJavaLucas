// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
    $('#usuarios').DataTable();
});

async function cargarUsuarios() {
  const request = await fetch('api/usuarios', {  // <-- esta es nuestra url del control
    method: 'GET',
    headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
    }
  });
  const usuarios = await request.json(); // <-- la variable se convierte a JSON
  console.log(usuarios); // solo lo ponemor para checar lo que hace en el inspector de código, hasta aquí funciona toodo

  //ahora sigue el listado y ponerlo en la web
  let listadoHtml = '';
  for (let usuario of usuarios) {
    let botonEliminar = '<a href="#" onclick="eliminarUsuario(' + usuario.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

    let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>'
                    + usuario.email+'</td><td>'+ usuario.telefono
                    + '</td><td>' + botonEliminar + '</td></tr>';
    listadoHtml += usuarioHtml;
  }

document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}

async function eliminarUsuario(id) {

  if (!confirm('¿Desea eliminar este usuario?')) {
    return;
  }

 const request = await fetch('api/usuarios/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'

    }
  });

  location.reload()
}
