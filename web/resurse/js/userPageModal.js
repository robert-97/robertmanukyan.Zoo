/**
 * Created by robert.manukyan on 16.04.2018.
 */


// var elements = document.querySelectorAll('button  li:last-child');



// document.addEventListener("click", function(){

    function clickButton(buttonID) {


        var modal = document.getElementById('myModal');
        buttonID = "myBtn"+buttonID;
        var button = document.getElementById(buttonID);

        var span = document.getElementsByClassName("close")[0];

        button.onclick = function() {
            modal.style.display = "block";
        };

        span.onclick = function() {
            modal.style.display = "none";
        };

        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    }

// });