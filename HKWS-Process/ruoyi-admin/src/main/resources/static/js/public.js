var scrWidth = window.innerWidth;
var scrHeight = window.innerHeight;
if (scrWidth > 3860 && scrHeight >= 2160) {
    $('body').css({
        "width": '3860px',
        "height": '2160px',
        "margin": '0 auto'
    })
} else if (scrWidth == 3860 && scrHeight == 1080) {
    $('body').css({
        "width": '1920px',
        "height": '1080px',
        "margin": 'auto',
    })
} else {
    $('body').css({
        "width": '100%',
        "height": '100%',
        "margin": '0',

    })
}
window.onresize = function () {
    if (scrWidth > 3860 && scrHeight >= 2160) {
        // console.log('a')
        $('body').css({
            "width": '3860px',
            "height": '2160px',
            "margin": '0 auto'
        })
    } else if (scrWidth == 3860 && scrHeight == 1080) {
        $('body').css({
            "width": '1920px',
            "height": '1080px',
            "margin": 'auto',
        })
    } else {
        $('body').css({
            "width": '100%',
            "height": '100%',
            "margin": '0',

        })
    }
}