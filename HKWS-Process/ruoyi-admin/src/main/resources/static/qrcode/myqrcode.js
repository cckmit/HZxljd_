//生成二维码
function generQrcode(qrCode){
    //清除旧二维码
    $('#qrcode').empty();
    let code = utf16to8(qrCode); //转换为utf-8
    jQuery('#qrcode').qrcode({
        render: "canvas",
        text: code,                  //二维码内容
        width : "200",               //二维码的宽度
        height : "200",              //二维码的高度
        background : "#ffffff",      //二维码的后景色
        foreground : "#000000",      //二维码的前景色
    });
}

//下载二维码
function downLoadQrcode(qrCode){
    if(qrCode){
        //二维码内容存在 生成二维码
        generQrcode(qrCode);
        //下载
        var canvas = $("#qrcode").find("canvas").get(0);
        downLoadImage(canvas);
    }else{
        //提示先生成二维码
        $.modal.alertWarning("请先点击二维码图标生成二维码！");
    }
}

//下载
function downLoadImage(canvas) {
    var a = document.createElement("a");
    a.href = canvas.toDataURL();
    a.download = name;
    a.click();
}

//将字符串转换为utf-8
function utf16to8(str) {
    var out, i, len, c;
    out = "";
    len = str.length;
    for(i = 0; i < len; i++) {
        c = str.charCodeAt(i);
        if ((c >= 0x0001) && (c <= 0x007F)) {
            out += str.charAt(i);
        } else if (c > 0x07FF) {
            out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
            out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));
            out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
        } else {
            out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));
            out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));
        }
    }
    return out;
}