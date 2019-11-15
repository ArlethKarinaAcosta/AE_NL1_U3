/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * */
function validarFormulario(forma)
{
    var usuario = forma.usuario.value;  //nombre del componente en HTML
    if (usuario==="")
    {
        alert("Debe proporcionar un nombre de usuario");
        usuario.focus();
        usuario.select();
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
     
     
     alert("Enviando formulario");
     return true;
     
     
}




