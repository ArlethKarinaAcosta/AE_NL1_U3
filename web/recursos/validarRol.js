function validarRol(forma)
{
    var rol = forma.rol.value;  //nombre del componente en HTML
    if (rol==="")
    {
        alert("Debe proporcionar un rol");
        rol.focus();
        rol.select();
        return false;
    }
    
    

     
     
     alert("Enviando formulario");
     return true;
     
     
}

