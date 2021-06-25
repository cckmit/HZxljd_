//异步单图片上传
function initAsyncImage(ctrlName, uploadUrl) {
    let control = $('#' + ctrlName);
    control.fileinput({
        language: 'zh', //设置语言
        uploadUrl: uploadUrl,  //上传地址
        uploadAsync: true, //是否异步上传
        showCaption: false, //是否显示输入框
        showUpload: false, //是否显示上传按钮
        showRemove: true, //是否显示移除按钮
        removeFromPreviewOnError:true, //当文件不符合规则，就不显示预览
        showRemove: true,
        dropZoneEnabled: false, //是否显示拖拽区域
        allowedPreviewTypes: ['image'],
        allowedFileTypes: ['image'],
        allowedFileExtensions:  ['jpg', 'png','gif'],
        maxFileSize : 0,//设置为0表示不限制大小
        maxFileCount: 1,
        autoOrientImage:false,
        overwriteInitial: true,
        initialPreviewAsData: true,
        previewClass:"uploadPreview",
        layoutTemplates :{
            actionDelete:'', //去除上传预览的缩略图中的删除图标
            actionUpload:'',//去除上传预览缩略图中的上传图片；
            //actionZoom:''   //去除上传预览缩略图中的查看详情预览的缩略图标。
        },
        initialPreview: [
            //预览图片的设置
        ],
    }).on("change", function() {
        // 清除掉上次上传的图片
        $(".uploadPreview").find(".file-preview-frame:first").remove();
        $(".uploadPreview").find(".kv-zoom-cache:first").remove();
    }).on("filebatchselected", function(event, files) {
        $(this).fileinput("upload");
    }).on('fileuploaded',function(event,data, previewId, index){
        $('#filepath').attr('value',data.response.url)
    });
}

//同步单图片上传
function initSyncImage(ctrlName, uploadUrl) {
    let control = $('#' + ctrlName);
    control.fileinput({
        language: 'zh', //设置语言
        uploadUrl: uploadUrl,  //上传地址
        uploadAsync: false, //是否异步上传
        showCaption: false, //是否显示输入框
        showUpload: false, //是否显示上传按钮
        showRemove: true, //是否显示移除按钮
        removeFromPreviewOnError:true, //当文件不符合规则，就不显示预览
        showRemove: true,
        dropZoneEnabled: false, //是否显示拖拽区域
        allowedPreviewTypes: ['image'],
        allowedFileTypes: ['image'],
        allowedFileExtensions:  ['jpg', 'png','gif'],
        maxFileSize : 0,//设置为0表示不限制大小
        maxFileCount: 1,
        autoOrientImage:false,
        overwriteInitial: true,
        initialPreviewAsData: true,
        previewClass:"uploadPreview",
        layoutTemplates :{
            actionDelete:'', //去除上传预览的缩略图中的删除图标
            actionUpload:'',//去除上传预览缩略图中的上传图片；
            //actionZoom:''   //去除上传预览缩略图中的查看详情预览的缩略图标。
        },
        initialPreview: [
            //预览图片的设置
        ],
    }).on("change", function() {
        // 清除掉上次上传的图片
        $(".uploadPreview").find(".file-preview-frame:first").remove();
        $(".uploadPreview").find(".kv-zoom-cache:first").remove();
    }).on('fileuploaded',function(event,data, previewId, index){
        $('#filepath').attr('value',data.response.url)
    });
}



//同步多图片上传
function initSyncImages(ctrlName,url){
    let control = $('#' + ctrlName);
    control.fileinput({
        'theme': 'explorer-fas',
        'uploadUrl': url,
        showUpload: false, //是否显示上传按钮
        showCaption: true, //是否显示输入框
        dropZoneEnabled: true, //是否显示拖拽区域
        showRemove: true, //是否显示移除按钮
        overwriteInitial: false,
        initialPreviewAsData: true,
        allowedPreviewTypes: ['image'],
        allowedFileTypes: ['image'],
        allowedFileExtensions:  ['jpg', 'png','gif'],
        removeFromPreviewOnError:true, //当文件不符合规则，就不显示预览
        maxFileSize : 0, //设置为0表示不限制大小
        maxFileCount: 9,
        autoOrientImage:false,
        layoutTemplates :{
            //actionDelete:'', //去除上传预览的缩略图中的删除图标
            actionUpload:'', //去除上传预览缩略图中的上传图片；
            //actionZoom:''  //去除上传预览缩略图中的查看详情预览的缩略图标。
        },
        uploadAsync:false,   //是否异步上传
    });
}

//文件批量上传
function initSyncFiles(ctrlName, uploadUrl, previewJson, initPreviewConfig) {
    let control = $('#' + ctrlName);
    control.fileinput({
        'theme': 'explorer-fas',
        'uploadUrl': uploadUrl,
        showUpload: false, //是否显示上传按钮
        showCaption: false, //是否显示输入框
        dropZoneEnabled: false, //是否显示拖拽区域
        showRemove: true, //是否显示移除按钮
        overwriteInitial: false, //是否覆盖已上传的图片
        initialPreviewAsData: true,
        allowedFileTypes: [], //不限制文件上传类型
        maxFileSize: 0, //设置为0表示不限制大小
        maxFileCount: 9,
        autoOrientImage: false,
        initialPreviewShowDelete: true,	//是否显示初始化数据的删除按钮
        initialPreview: previewJson,		//初始化图片
        initialPreviewConfig: initPreviewConfig,	//初始化图片配置
        previewFileIcon: '<i class="fa fa-file"></i>',
        preferIconicZoomPreview: true,
        previewFileIconSettings: {
            'doc': '<i class="fa fa-file-word-o text-primary"></i>',
            'xls': '<i class="fa fa-file-excel-o text-success"></i>',
            'ppt': '<i class="fa fa-file-powerpoint-o text-danger"></i>',
            'pdf': '<i class="fa fa-file-pdf-o text-danger"></i>',
            'zip': '<i class="fa fa-file-archive-o text-muted"></i>',
            'htm': '<i class="fa fa-file-code-o text-info"></i>',
            'txt': '<i class="fa fa-file-text-o text-info"></i>',
            'mov': '<i class="fa fa-file-movie-o text-warning"></i>',
            'mp3': '<i class="fa fa-file-audio-o text-warning"></i>',
            'jpg': '<i class="fa fa-file-image-o text-danger"></i>',
            'gif': '<i class="fa fa-file-image-o text-warning"></i>',
            'png': '<i class="fa fa-file-image-o text-primary"></i>'
        },
        previewFileExtSettings: {
            'doc': function(ext) {
                return ext.match(/(doc|docx)$/i);
            },
            'xls': function(ext) {
                return ext.match(/(xls|xlsx)$/i);
            },
            'ppt': function(ext) {
                return ext.match(/(ppt|pptx)$/i);
            },
            'zip': function(ext) {
                return ext.match(/(zip|rar|tar|gzip|gz|7z)$/i);
            },
            'htm': function(ext) {
                return ext.match(/(htm|html)$/i);
            },
            'txt': function(ext) {
                return ext.match(/(txt|ini|csv|java|php|js|css)$/i);
            },
            'mov': function(ext) {
                return ext.match(/(avi|mpg|mkv|mov|mp4|3gp|webm|wmv)$/i);
            },
            'mp3': function(ext) {
                return ext.match(/(mp3|wav)$/i);
            },
        },
        layoutTemplates: {
            //actionDelete:'', //去除上传预览的缩略图中的删除图标
            //actionZoom:'',  //去除上传预览缩略图中的查看详情预览的缩略图标。
            actionUpload: '', //去除上传预览缩略图中的上传图片；
        },
        uploadAsync: false,   //是否异步上传
    });
}

//判断文件是否是图片类型
function checkImageType(fileName){
    let index = fileName.indexOf("."); //获取"."的位置
    let fileType = fileName.substring(index);
    if(fileType == '.png' || fileType == '.PNG' || fileType == '.jpg' || fileType == '.JPG' ||
        fileType == '.gif' || fileType == '.GIF'){
        return true;
    }
    return false;
}

//判断文件是否是文本类型
function checkTextType(fileName){
    let index = fileName.indexOf("."); //获取"."的位置
    let fileType = fileName.substring(index);
    if(fileType == '.txt' || fileType == '..doc' || fileType == 'ppt' || fileType == '.xls' || fileType == '.xlsx'){
        return true;
    }
    return false;
}
