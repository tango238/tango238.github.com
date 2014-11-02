$(function(){
    //$('#playground').hide();

    $('.p5').click(function(event){
        event.preventDefault();

        $('playground').innerHTML = '<b>hello</b>';
        $('playground').show();
    });
});
