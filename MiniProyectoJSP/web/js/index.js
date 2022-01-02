$(document).ready(function () {
     //Evento click del botón ingresar
       $("#ingresar").click(function () {
       ingresar();
    });
    // Evento keydown para ingresar
    $("input").keyup(function (event) { 
        if(event.which == "13")
            ingresar();
    });

    // Se hace el procedimiento de validación y se redirige 
    // a la siguiente página
    function ingresar() {
        let datos = {
            "correo": $("#inputEmail").val(),
            "contraseña": $("#InputPassword").val()
        };
        if (verificarCamposVacios(datos)) {

            if (datos.correo === "prueba@gmail.com" && datos.contraseña === "54321")
                location.href = "../docs/inicio.html"
            else
                viewErorr("Datos incorrectos","Intente nuevamente o solicite recordar las credenciales")
            
                
        }
        else
            viewErorr("Hay campos vacios", "Llene todos los campos");
    }
    // Se verifica que los campos no estén en blanco
    function verificarCamposVacios(datos) {
        return datos.correo.trim() !== "" && datos.contraseña.trim() !== "";
    }

    // Evento click para obtener las credenciales de acceso 
    $("#credenciales").click(function () {
        Swal.fire(
            "Correo: prueba@gmail.com",
            "Contraseña: 54321"
        );
    });

    const viewErorr = (titulo, texto) => {
        Swal.fire({
            icon: 'error',
            title: titulo,
            text: texto
        });
    }
});
