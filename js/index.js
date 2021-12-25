$(document).ready(function () {
    // Evento click del botón ingresar
    $("#ingresar").click(function () {
        let datos = {
            "correo": $("#inputEmail").val(),
            "contraseña": $("#InputPassword").val()
        };
        if (verificarCamposVacios(datos)) {

            if (datos.correo === "prueba@gmail.com" && datos.contraseña === "54321")
                location.href = "/plantillas/inicio.html"
            else
                alert("Datos incorrectos");
        }
        else
            alert("Hay campos vacios");
    });

    // Se verifica que los campos no estén en blanco
    function verificarCamposVacios(datos) {
        return datos.correo.trim() !== "" && datos.contraseña.trim() !== "";
    }

    // Evento click para obtener las credenciales de acceso 
    $("#credenciales").click(function () {
        alert("Correo: prueba@gmail.com, Contraseña: 54321");

    });
});