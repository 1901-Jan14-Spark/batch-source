const img = document.getElementById('img_holder');
const textHolder = document.getElementById("text_holder");
const pokemon = document.getElementById("pokemon");
const pokemonBtn = document.getElementById('submit');
let imgURL = "https://pokeapi.co/api/v2/pokemon-form/";

pokemon.addEventListener("keyup", function(e) {
    e.preventDefault();
    if(e.keyCode === 13) {
        pokemonBtn.click();
    }
})

pokemonBtn.addEventListener("click", function() {
    let XHR = new XMLHttpRequest();
    XHR.onreadystatechange = function () {
        if (XHR.readyState == 4 && XHR.status == 200) {
            let data = JSON.parse(XHR.responseText);
            // console.log(data);
            img.setAttribute("src", data.sprites.front_default);
            const name1 = data.name.slice(0, 1)
            const name2 = data.name.slice(1, data.name.length)
            textHolder.innerHTML = name1.toUpperCase() + name2;
        }
    }
    XHR.open("GET", imgURL + pokemon.value);
    XHR.send();

    // console.log(pokemon.value);
})
