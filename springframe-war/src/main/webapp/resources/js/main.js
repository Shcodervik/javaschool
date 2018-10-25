
    function checkForm(form) {
        var e = 0;
        for (var i = 0; i < form.length - 1; i++) {
            if (!form[i].value.replace(/^\s+|\s+$/g, '')) {
                form[i].style.border = '1px solid red';
                e = 1;
            }
        }
        if (e) {
            alert('Please, enter all fields!');
            return false;
        }
    }


$(function () {
    $('.sf-menu a').each(function () {
        var location = window.location.href;
        var link = this.href;
        if(location == link) {
            $(this).parent('li').addClass('active');
        }
    });
});