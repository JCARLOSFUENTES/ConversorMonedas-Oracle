// El principal objetivo de este desafío es fortalecer tus habilidades en lógica de programación. Aquí deberás desarrollar la lógica para resolver el problema.
let lista=[];

function agregarAmigo() {
    let nombre=document.getElementById('amigo').value;
    

    if(lista.includes(nombre) || nombre==''){
        alert('Este nombre ya esta incluido o no es valido');
    }else{
        lista.push(nombre);
    }
    
    let listaAmigos=document.getElementById('listaAmigos');


    listaAmigos.innerHTML = lista.map(nombre => `<li>${nombre}</li>`).join('');

    document.getElementById('amigo').value='';
}

function sortearAmigo() {    
    
    if(lista.length==0){
        alert('Necesitas agregar amigos primero');
    }else{
        let indice= Math.floor(Math.random() * lista.length);
       alert('El amigo secreto es: ' + lista[indice]);
    }

    return;

}