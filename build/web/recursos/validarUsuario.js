function validarUsuario(forma)
{
    var usuario = forma.usuario.value;  //nombre del componente en HTML
    if (usuario==="")
    {
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
        return false;
    }
    
    var id = forma.id.value;
    if (id==="")
    {
        alert("Debe proporcionar un id");
        id.focus();
        id.select();
        return false;
    }
    
    var password = forma.password.value;
  if(password === "")
  {
      alert("Introduzca su contrasena");
      return false;
  }
  else
  {
      if(password.length<8)
      {
          alert("Debe introducir por lo menos 8 caracteres");
          return false;
      }
  }


    var password2 = forma.password2.value;
  if(password2 === "")
  {
      alert("Introduzca su contrasena");
      return false;
  }
  else
  {
      if(password2.length<8)
      {
          alert("Debe introducir por lo menos 8 caracteres");
          return false;
      }
  }
    
         var email = forma.email.value;  //nombre del componente en HTML
    if (email==="")
    {
        alert("Debe proporcionar su correo");
        email.focus();
        email.select();
        return false;
    }
     

                if (password.equals(password2))
                {
                    //En caso de que ya exista una cookie indicando.
                    //ya que existe un usuario registrado con anterioridad
                    //ponemos la bandera en falso y salimos del ciclo.
                    return true;
                    
                }
                else
                {
                    alert("Los passwords no coinciden");
                }
           
     
     alert("Enviando formulario. Ya puedes iniciar sesion");
     return true;
     
     
}

