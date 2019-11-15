/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(
            function () {
                $('#tbDuda').DataTable({
                    "ajax": "ConsultaDuda",
                    "columns": [//Atributos que se pondrán en cada columna
                        { "data": "idduda" },
                        { "data": "pregunta" },
                        { "data": "comentario" },

                        {
                            "data":
                                function (row) {
                                    var r = row['idduda']
                                            + "-" + row['pregunta']
                                        + "-" + row['comentario']; //Acceder

                                    console.log('valor de r' + r);

                                    var
                                        botones = "<button id='btnBorrar' class='btn btn-primary btn-xs' onClick='eliminaDuda("
                                            + row['idduda']
                                            + ")'> Borrar </button>";

                                    botones += "<button id='btnEditar' class='btn btn-xs btn-danger' onClick='showDuda(" 
                                            + row['idduda'] 
                                            + ",\"" + row['pregunta'] + "\""
                                            +",\"" + row['comentario']
                                                    + "\")'>Editar</button>";

                                    return botones;
                                }
                        }
                    ]
                });

                $('#frmDuda').validate({
                    rules: {
                        
                        pregunta: {
                            minlength: 1,
                            maxlength: 50,
                            required: true
                        },
                        comentario: {
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
                        nuevoDuda();
                        return false;
                    },
                    messages: {
                       
                        pregunta: {
                            minlength: "Introduzca al menos 1 caracter",
                            maxlength: "Introduzca máximo 50 caracter",
                            required: "Se requiere jna pregunta"
                        },
                        comentario: {
                            minlength: "Introduzca al menos 1 caracter",
                            maxlength: "Introduzca máximo 50 caracter",
                            required: "Se requiere un comentario"
                        }
                    }
                });


                $('#frmDuda2').validate({
                    rules: {
                        
                        pregunta: {
                            minlength: 1,
                            maxlength: 50,
                            required: true
                        },
                        comentario: {
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
                        updateDuda();
                        return false;
                    }
                });


                $('#btnEditar').on('click', function () {
                    $('#frmDuda2').submit();
                });

            });

        function eliminaDuda(idduda) {

       Swal.fire({
            title: '¿Estás seguro?',
            text: "¡Se va a eliminar el registro!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '¡Si, estoy seguro!'
        }).then((result) => {
            if (result.value) {
                 $.ajax({
        url: "EliminarDuda", //Url del Servlet
        type: "POST", //Método HTTP por el que se hace la petición
        data: {//Es la información que mando al servlet
            idduda: idduda
        }
    }).done(function (json) { //Se ejecuta cuando todo sale bien
        //alert(json.msj);
        
        Swal.fire(
                        '¡Eliminado!',
                        'El registro ha sido eliminado exitosamente. ' + json.msj,
                        'success'
                        );


        //Refrescando la tabla
        $('#tbDuda').dataTable().api().ajax.reload();
    }).fail(function (json) { //Se ejecuta cuando algo sale mal
        //alert(json.msj);
        Swal.fire({
            icon: 'error',
            title: 'Algo salió mal.',
            text: 'No se ha podido eliminar! ' + json.msj
        });

        //alert("error");
    });
                
            }
        });
        }

        function nuevoDuda() {
            $.ajax({
                url: 'NuevoDuda',
                type: 'POST',
                data: {
                    pregunta: $("#pregunta").val(),
                    comentario: $("#comentario").val(),
                }
            }).done(function (json) { //Se ejecuta cuando todo sale bien
                //alert(json.msj);
                //Refrescando la tabla
                
                Swal.fire(
                'Se ha insertado correctamente!',
                '' + json.msj,
                'success'
                );
                $('#tbDuda').dataTable().api().ajax.reload();
            }).fail(function (json) { //Se ejecuta cuando algo sale mal
                //alert(json.msj);
                Swal.fire({
            icon: 'error',
            title: 'Algo salió mal',
            text: '¡No se ha podido insertar! ' + json.msj
        });
            });


        }

        function showDuda(idduda, pregunta, comentario) {
            $("#idduda2").val(idduda);
            $("#pregunta2").val(pregunta);
            $("#comentario2").val(comentario);
            $("#modalDuda").modal("show");

        }

        function updateDuda() {
            $.ajax({
                url: 'ActualizarDuda',
                type: 'POST',
                data: {
                    idduda: $("#idduda2").val(),
                    pregunta: $("#pregunta2").val(),
                    comentario: $("#comentario2").val(),
                }
            }).done(function (json) { //Se ejecuta cuando todo sale bien
                //alert(json.msj);
                //Refrescando la tabla
                
                Swal.fire(
                '¡Se ha actualizado correctamente!',
                '' + json.msj,
                'success'
                );
                $('#tbDuda').dataTable().api().ajax.reload();

                //Cerrando el modal
                $('#modalDuda').modal("toggle");
            }).fail(function (json) { //Se ejecuta cuando algo sale mal
                //alert(json.msj);
                Swal.fire({
            icon: 'error',
            title: 'Algo salió mal',
            text: '¡No se ha podido actualizar! ' + json.msj
        });
            });
        }