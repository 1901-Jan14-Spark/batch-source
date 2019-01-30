document.addEventListener("DOMContentLoaded", function () {
    getPokemons();
})

const img = document.getElementById('img_holder');
const catBtn = document.getElementById('cat_btn');
const textHolder = document.getElementById("text_holder");
const url = "https://pokeapi.co/api/v2/pokemon";
let imgURL = "https://pokeapi.co/api/v2/pokemon-form/6";

let test = imgURL.slice(39, 40);
let test2 = imgURL.slice(0, 39);
console.log(test);
console.log(test2);
for (i = 0; i < 151; i++) {
    test = i;
}

const getPokemons = () => {
    let XHR = new XMLHttpRequest();
    XHR.open("GET", imgURL2);
    XHR.onreadystatechange = function () {
        if (XHR.readyState == 4 && XHR.status == 200) {
            let data = JSON.parse(XHR.responseText);
            // console.log(data.pokemon.name);
            console.log(data);


            img.setAttribute("src", data.sprites.front_shiny)
            const name1 = data.name.slice(0, 1)
            const name2 = data.name.slice(1, data.name.length)
            textHolder.innerHTML = name1.toUpperCase() + name2;
        }
    }
    XHR.send();
}

// const showPokemon = (xmlhttp) => {
//     let xmlDoc = XMLHttpRequest.
// }

const addPokemonFromApi = (jsonNodes, tableNode) => {
    let theTable = tableNode.parentNode;

}


imgURL2 = test2 + test;