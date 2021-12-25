$().ready(function () {

    // Eventos de los botones
    $("#boton1").click(function () {
        addCart("boton1");
    });
    $("#boton2").click(function () {
        addCart("boton2");
    });
    $("#boton3").click(function () {
        addCart("boton3");
    });
    $("#boton4").click(function () {
        addCart("boton4");
    });
    $("#boton5").click(function () {
        addCart("boton5");
    });
    $("#boton6").click(function () {
        addCart("boton6");
    });
    $("#compra").click(function () {
        let cantProductos = $("#carrito").text();
        if (cantProductos >0) {
            Swal.fire({
                title: 'Tiene ' +cantProductos + " productos en el carrito",
                text: "¿Desea continuar con la compra?",
                icon: 'info',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Sí'
            }).then((result) => {
                if (result.isConfirmed) {
                    Swal.fire(
                        'Su compra está en camino',
                        '¡Gracias por confiar en nosotros!'
                    )
                }
    
            });
        }
        else{
            Swal.fire("No tiene productos en el carrito");
        }
    });
    $("#calificacion").click(function () {
        showValoracion();
    });
    $("#comentario").click(function () { 
        showValoracion();
        
    });

    // Función para añadir productos al carrito
    function addCart(boton) {
        let cant = "#cantidad" + boton.slice(5, 6);
        let ncant = $(cant).val();
        if (ncant > 0) {
            let newcant = parseInt($("#carrito").text()) + parseInt(ncant);
            $("#carrito").text(newcant);
            addSuccessful();
        }
        else
            showError();
    }

    // Mensaje por la valoración de la página
    function showValoracion() {
        Swal.fire(
            {
                icon: 'success',
                title: 'Gracias por su valoración'
            }
        );

    }

    // Mensaje de error
    function showError() {
        Swal.fire({
            icon: 'error',
            title: 'No se ha podido añadir',
            text: 'La cantidad de productos no es correcta'
        });
    }

    // Mensaje de correcto
    function addSuccessful() {
        Swal.fire(
            {
                icon: 'success',
                title: 'Añadido correctamente'
            }
        );
    }


});
