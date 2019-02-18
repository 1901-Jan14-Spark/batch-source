function show_image(src) {
    const img = document.createElement("img");
    img.src = src;
    document.getElementById("append_pic").appendChild(img);
}

