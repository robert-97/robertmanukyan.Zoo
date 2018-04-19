let cache = {} ;

/**
 * load animals from DB with ajax request
 * @param cageNumberID
 */
function getAnimals(cageNumberID) {
        if (cache.hasOwnProperty(cageNumberID)) {
            document.getElementById("animals-info").innerHTML = cache[cageNumberID] ;
        }else{
            let xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
                    let animals = JSON.parse(this.responseText);
                    let animalsString = "";

                    for (let i = 0; i < animals.length; ++i) {
                        animalsString += animals[i].animalType;
                        animalsString += " - ";
                        animalsString += animals[i].animalName;
                        animalsString += "<br>";
                    }

                    if (animals.length === 0) {
                        animalsString = "<h3>Empty<h3>"
                    }
                    cache[cageNumberID] = animalsString ;
                    document.getElementById("animals-info").innerHTML = animalsString;
                }
            };
            xhttp.open("POST", "AnimalsGetter?cageNumberID=" + cageNumberID, true);
            xhttp.send();
        }





    // let cageNumberID = "#cageNumber" + cageNumber
    // $(document).on("click", cageNumberID, () => {
    //     $.get("AnimalsGetter", {"cageNumber": cageNumber},  (responseText)=> {
    //
    //         let animals = JSON.parse(responseText) ;
    //         let animalsString = "";
    //
    //         for(var i = 0 ; i < animals.length ;++i ){
    //             animalsString += animals[i].animalType;
    //             animalsString += " - " ;
    //             animalsString += animals[i].animalName ;
    //             animalsString += "<br>" ;
    //         }
    //
    //         if(animals.length == 0){
    //             animalsString = "<h3>Empty<h3>"
    //         }
    //         $("#animals-info").html(animalsString);
    //
    //     });
    // });
}

