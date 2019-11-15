/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(
            function () {
                $('#tbRol').DataTable({
                    "ajax": "ConsultaRol",
                    "columns": [//Atributos que se pondrán en cada columna
                        { "data": "idrol" },
                        { "data": "nombrerol" },

                        {
                            "data":
                                function (row) {
                                    var r = row['idrol']
                                        + "-" + row['nombrerol']; //Acceder

                                    console.log('valor de r' + r);

                                    var
                                        botones = "<button id='btnBorrar' class='btn btn-primary btn-xs' onClick='eliminaRol("
                                            + row['idrol']
                                            + ")'> Borrar </button>";

                                    botones += "<button id='btnEditar' class='btn btn-xs btn-danger' onClick='showRol(" + row['idrol'] + ",\"" + row['nombrerol']
                                                    + "\")'>Editar</button>";

                                    return botones;
                                }
                        }
                    ]
                });

                $('#frmRol').validate({
                    rules: {
                        
                        nombrerol: {
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
                        nuevoRol();
                        return false;
                    },
                    messages: {
                       
                        nombrerol: {
                            minlength: "Introduzca al menos 1 caracter",
                            maxlength: "Introduzca máximo 50 caracter",
                            required: "Se requiere el nombre del rol"
                        }
                    }
                });


                $('#frmRol2').validate({
                    rules: {
                        
                        nombrerol: {
                            minlength: 1,
                            maxlength: 50,
                            required: true
                        }
                    },
                    messages: {
                        nombrerol: {
                            minlength: "Introduzca al menos 1 caracter",
                            maxlength: "Introduzca máximo 50 caracter",
                            required: "Se requiere el nombre del rol"
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
                        updateRol();
                        return false;
                    }
                });


                $('#btnEditar').on('click', function () {
                    $('#frmRol2').submit();
                });

            });

        function eliminaRol(idrol) {

            //Utilizando Ajax para realizar una petición al servlet que elimina personas
            Swal.fire({
            title: '¿Estás seguro?',
            text: "¡Se va a eliminar el regisro!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '¡Sí, estoy seguro!'
        }).then((result) => {
            if (result.value) {
                 $.ajax({
        url: "EliminarRol", //Url del Servlet
        type: "POST", //Método HTTP por el que se hace la petición
        data: {//Es la información que mando al servlet
            idrol: idrol
        }
    }).done(function (json) { //Se ejecuta cuando todo sale bien
        //alert(json.msj);
        
        Swal.fire(
                        '¡Eliminado!',
                        'El archivo ha sido eliminado. ' + json.msj,
                        'success'
                        );


        //Refrescando la tabla
        $('#tbRol').dataTable().api().ajax.reload();
    }).fail(function (json) { //Se ejecuta cuando algo sale mal
        //alert(json.msj);
        Swal.fire({
            icon: 'error',
            title: 'Algo salió mal',
            text: '¡No se ha podido eliminar! ' + json.msj
        });

        //alert("error");
    });
                
            }
        });
        }

        function nuevoRol() {
            $.ajax({
                url: 'NuevoRol',
                type: 'POST',
                data: {
                    nombrerol: $("#nombrerol").val(),
                }
            }).done(function (json) { //Se ejecuta cuando todo sale bien
                //alert(json.msj);
                //Refrescando la tabla
                
                Swal.fire(
                'Se ha insertado correctamente!',
                '' + json.msj,
                'success'
                );
                $('#tbRol').dataTable().api().ajax.reload();
            }).fail(function (json) { //Se ejecuta cuando algo sale mal
                //alert(json.msj);
                Swal.fire({
            icon: 'error',
            title: 'Algo salió mal',
            text: 'No se ha podido insertar! ' + json.msj
        });
            });


        }

        function showRol(idrol, nombrerol) {
            $("#idrol2").val(idrol);
            $("#nombrerol2").val(nombrerol);
            $("#modalRol").modal("show");

        }

        function updateRol() {
            $.ajax({
                url: 'ActualizarRol',
                type: 'POST',
                data: {
                    idrol: $("#idrol2").val(),
                    nombrerol: $("#nombrerol2").val(),
                }
            }).done(function (json) { //Se ejecuta cuando todo sale bien
                //alert(json.msj);
                //Refrescando la tabla
                
                
                Swal.fire(
                'Se ha actualizado correctamente!',
                '' + json.msj,
                'success'
                );
                $('#tbRol').dataTable().api().ajax.reload();

                //Cerrando el modal
                $('#modalRol').modal("toggle");
            }).fail(function (json) { //Se ejecuta cuando algo sale mal
                //alert(json.msj);
                Swal.fire({
            icon: 'error',
            title: 'Algo salió mal',
            text: '¡No se ha podido actualizado! ' + json.msj
        });
            });
        }