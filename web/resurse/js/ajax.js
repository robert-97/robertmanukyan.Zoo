function getAnimals(cageNumber) {
    let cageNumberID = "#cageNumber" + cageNumber
    $(document).on("click", cageNumberID, () => {
        $.get("AnimalsGetter", {"cageNumber": cageNumber},  (responseText)=> {

            let animals = JSON.parse(responseText) ;
            let animalsString = "";

            for(var i = 0 ; i < animals.length ;++i ){
                animalsString += animals[i].animalType;
                animalsString += " - " ;
                animalsString += animals[i].animalName ;
                animalsString += "<br>" ;
            }

            if(animals.length == 0){
                animalsString = "<h3>Empty<h3>"
            }
            $("#animals-info").html(animalsString);

        });
    });
}

