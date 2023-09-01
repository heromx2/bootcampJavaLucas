$(document).ready(function() {
   // on ready
});


async function registrarUsuario() {
  let datos = {};
  datos.nombre = document.getElementById('txtNombre').value; //txtNombre viene de la pagina registrar.html
  datos.apellido = document.getElementById('txtApellido').value;
  datos.telefono = document.getElementById('txtTelefono').value;
  datos.email = document.getElementById('txtEmail').value;
  datos.password = document.getElementById('txtPassword').value;

  let repetirPassword = document.getElementById('txtRepetirPassword').value;

  if (repetirPassword != datos.password) {
    alert('La contraseña que escribiste es diferente.');
    return;
  }

  const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos) // esta función toma cualquier objeto de javaScript y convertirlo a un string de JSON
  });
  alert("La cuenta fue creada con exito!");
  //console.log(datos);
  window.location.href = 'login.html'

}