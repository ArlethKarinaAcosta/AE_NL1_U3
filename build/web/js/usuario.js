/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(
        function () {
            $('#tbUsuario').DataTable({
                "ajax": "ConsultaUsuario",
                "columns": [//Atributos que se pondrán en cada columna
                    {"data": "idusuario"},
                    {"data": "nombreusuario"},
                    {"data": "email"},
                    {"data": "contrasena"},

                    {
                        "data":
                                function (row) {
                                    var r = row['idusuario']
                                            + "-" + row['nombreusuario']
                                            + "-" + row['email']
                                            + "-" + row['contrasena']; //Acceder

                                    console.log('valor de r' + r);

                                    var
                                            botones = "<button id='btnBorrar' class='btn btn-primary btn-xs' onClick='eliminaUser("
                                            + row['idusuario']
                                            + ")'> Borrar </button>";

                                    botones += "<button id='btnEditar' class='btn btn-xs btn-danger' onClick='showUser("
                                            + row['idusuario']
                                            + ",\"" + row['nombreusuario'] + "\""
                                            + ",\"" + row['email'] + "\""
                                            + ",\"" + row['contrasena']
                                            + "\")'>Editar</button>";
                                    
                                    console.log(botones);

                                    return botones;
                                }
                    }
                ]
            });

            $('#frmUser').validate({
                rules: {

                    nombreusuario: {
                        minlength: 1,
                        maxlength: 50,
                        required: true
                    },
                    email: {
                        minlength: 1,
                        maxlength: 50,
                        required: true
                    },
                    contrasena: {
                        minlength: 1,
                        maxlength: 50,
                        required: true
                    }
                },
                highlight: function (element) {
                    $(element).closest('.form-group').addClass('has-error');
                },
                unhighlight: function (element) {
                    $(element).closest('.form-group').removeClass('has-error');
                },

                errorElement: 'span',
                errorClass: 'help-block',

                errorPlacement: function (error, element) {
                    if (element.parent('.input-group'.length)) {
                        error.insertAfter(element.parent());
                    } else {
                        error.insertAfter(element)
                    }
                },
                submitHandler: function (form) {
                    console.log('Formulario modal válido');
                    nuevoUser();
                    return false;
                },
                messages: {

                    nombreusuario: {
                        minlength: "Introduzca al menos 1 caracter",
                        maxlength: "Introduzca máximo 50 caracter",
                        required: "Se requiere un nombre de usuario"
                    },
                    email: {
                        minlength: "Introduzca al menos 1 caracter",
                        maxlength: "Introduzca máximo 50 caracter",
                        required: "Se requiere un correo electronico"
                    },
                    contrasena: {
                        minlength: "Introduzca al menos 1 caracter",
                        maxlength: "Introduzca máximo 50 caracter",
                        required: "Se requiere una contrasena"
                    }
                }
            });


            $('#frmUser2').validate({
                rules: {

                    nombreusuario: {
                        minlength: 1,
                        maxlength: 50,
                        required: true
                    },
                    email: {
                        minlength: 1,
                        maxlength: 50,
                        required: true
                    },
                    contrasena: {
                        minlength: 1,
                        maxlength: 50,
                        required: true
                    }
                },
                messages: {
                    nombreusuario: {
                        minlength: "Introduzca al menos 1 caracter",
                        maxlength: "Introduzca máximo 50 caracter",
                        required: "Se requiere un nombre de usuario"
                    },
                    email: {
                        minlength: "Introduzca al menos 1 caracter",
                        maxlength: "Introduzca máximo 50 caracter",
                        required: "Se requiere un correo electronico"
                    },
                    contrasena: {
                        minlength: "Introduzca al menos 1 caracter",
                        maxlength: "Introduzca máximo 50 caracter",
                        required: "Se requiere una contrasena"
                    }
                },
                highlight: function (element) {
                    $(element).closest('.form-group').addClass('has-error');
                },
                unhighlight: function (element) {
                    $(element).closest('.form-group').removeClass('has-error');
                },
                errorElement: 'span',
                errorClass: 'help-block',

                errorPlacement: function (error, element) {
                    if (element.parent('.input-group'.length)) {
                        error.insertAfter(element.parent());
                    } else {
                        error.insertAfter(element)
                    }
                },
                submitHandler: function (form) {
                    console.log('Formulario modal válido');
                    updateUser();
                    return false;
                }
            });


            $('#btnEditar').on('click', function () {
                $('#frmUser2').submit();
            });

        });

function eliminaUser(idusuario) {

    //Utilizando Ajax para realizar una petición al servlet que elimina personas
    Swal.fire({
            title: '¿Estás seguro?',
            text: "¡Se va a eliminar el registro!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sí, estoy seguro!'
        }).then((result) => {
            if (result.value) {
                 $.ajax({
        url: "EliminarUsuario", //Url del Servlet
        type: "POST", //Método HTTP por el que se hace la petición
        data: {//Es la información que mando al servlet
            idusuario: idusuario
        }
    }).done(function (json) { //Se ejecuta cuando todo sale bien
        //alert(json.msj);
        
        Swal.fire(
                        'Eliminado!',
                        'El registro ha sido eliminado. ' + json.msj,
                        'success'
                        );


        //Refrescando la tabla
        $('#tbUsuario').dataTable().api().ajax.reload();
    }).fail(function (json) { //Se ejecuta cuando algo sale mal
        //alert(json.msj);
        Swal.fire({
            icon: 'error',
            title: 'Algo salió mal',
            text: 'No se ha podido eliminar! ' + json.msj
        });

        //alert("error");
    });
                
            }
        });
}

function nuevoUser() {
    $.ajax({
        url: 'NuevoUsuario',
        type: 'POST',
        data: {
            nombreusuario: $("#nombreusuario").val(),
            email: $("#email").val(),
            contrasena: $("#contrasena").val(),
        }
    }).done(function (json) { //Se ejecuta cuando todo sale bien
        //alert(json.msj);
        //
        //
        Swal.fire(
                'Se ha insertado correctamente!',
                '' + json.msj,
                'success'
                );
        //
        //Refrescando la tabla
        $('#tbUsuario').dataTable().api().ajax.reload();
    }).fail(function (json) { //Se ejecuta cuando algo sale mal
        //alert(json.msj);
        Swal.fire({
            icon: 'error',
            title: 'Algo salió mal',
            text: 'No se ha podido insertar! ' + json.msj
        });
    });


}

function showUser(idusuario, nombreusuario, email, contrasena) {
    $("#idusuario2").val(idusuario);
    $("#nombreusuario2").val(nombreusuario);
    $("#email2").val(email);
    $("#contrasena2").val(contrasena);
    $("#modalUser").modal("show");

}

function updateUser() {
    $.ajax({
        url: 'ActualizarUsuario',
        type: 'POST',
        data: {
            idusuario: $("#idusuario2").val(),
            nombreusuario: $("#nombreusuario2").val(),
            email: $("#email2").val(),
            contrasena: $("#contrasena2").val(),
        }
    }).done(function (json) { //Se ejecuta cuando todo sale bien
        //alert(json.msj);
        //
        //Refrescando la tabla
        
        Swal.fire(
                'Se ha actualizado correctamente!',
                '' + json.msj,
                'success'
                );
        $('#tbUsuario').dataTable().api().ajax.reload();

        //Cerrando el modal
        $('#modalUser').modal("toggle");
    }).fail(function (json) { //Se ejecuta cuando algo sale mal
        //alert(json.msj);
        
        Swal.fire({
            icon: 'error',
            title: 'Algo salió mal',
            text: 'No se ha podido actualizar! ' + json.msj
        });
    });
}