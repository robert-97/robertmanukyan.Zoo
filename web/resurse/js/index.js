$('.message a').click(function () {
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});
//

$("#clear-cart").click( function(e){

});


function deleteCookie (name) {
    console.log("hjgajagskj")
    sessionStorage.removeItem('user');

    document.cookie = name + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
};

function checkEmail(email) {
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    if (!reg.test(email)) return false;
    return true;
}