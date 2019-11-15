/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * */
function validarDuda(forma)
{
    var pregunta = forma.pregunta.value;  //nombre del componente en HTML
    if (pregunta==="")
    {
        alert("Debe proporcionar una pregunta");
        pregunta.focus();
        pregunta.select();
        return false;
    }
    
       var comentario = forma.comentario.value;  //nombre del componente en HTML
    if (comentario==="")
    {
        alert("Debe proporcionar un comentario");
        comentario.focus();
        comentario.select();
        return false;
    }
   
     
     
     alert("Enviando formulario");
     return true;
     
     
}
