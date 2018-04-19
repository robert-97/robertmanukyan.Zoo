$('.message a').click(function () {
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});


function deleteCookie (name) {
    sessionStorage.removeItem('user');
    document.cookie = name + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
};

