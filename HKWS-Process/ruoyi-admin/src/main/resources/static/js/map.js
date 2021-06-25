var map = new BMap.Map("container",{
    maxZoom:17,
    minZoom:15,
}); // 创建地图实例

 var componentId = $("#componentId").val();
 var videoPath = $("#videoPath").val();
 var longitude = $("#longitude").val();
 var latitude = $("#latitude").val();
var regionIndexCode = $("#regionIndexCode").val();
 if(!longitude || longitude.length < 1){
     longitude = 119.824595;
 }
if(!latitude || latitude.length < 1){
    latitude = 30.251007;
}
var cont = new BMap.Point(longitude, latitude);//地图中心点
map.centerAndZoom(cont, 18); // 初始化地图，设置中心点坐标和地图级别
map.enableScrollWheelZoom(true);
// map.disableDragging(); //禁止拖拽
$.ajax({
    url:"/system/region/queryParentRegionByRegionId",
    type:"post",
    data:{
        "regionId":regionIndexCode,
    },
    success:function (data) {
        if(data.code == 0){
            let parentId = data.data;
            //动态加载已绘制完成点位信息
            $.ajax({
                url:"/system/region/map/details",
                type:"post",
                data:{
                    "regionId":parentId,
                },
                success:function (data) {
                    if(data.code == 0){
                        let colors = [
                            '#BD5A47', '#C57E66', '#F2CBA1', '#DAD38A', '#E8E9B7', '#D9B262',
                            '#BDCE9D', '#BACE9A', '#87A481', '#7B7F6B', '#E0D3A5', '#E6C18B', '#F3CCC0', '#E5BCBE', '#C2A5A1', '#AD8175', '#8A6B61', '#6E546A', '#DBB1B4', '#A3AB6D', '#BBC6B9', '#95AD6E', '#C2BF8E', '#999E91',
                        ]
                        //遍历集合
                        if (data.data && data.data.length > 0) {
                            for (let i = 0; i < data.data.length; i++) {
                                let markerPoints = JSON.parse(data.data[i].markerPoints)
                                //覆盖物
                                let polygon;
                                //覆盖物标记点回显.
                                if (markerPoints && markerPoints.length > 3) {
                                    let settings = {
                                        strokeColor: colors[i],    //边线颜色。
                                        fillColor: colors[i],      //填充颜色。当参数为空时，圆形将没有填充效果。
                                        strokeWeight: 2,       //边线的宽度，以像素为单位。
                                        strokeOpacity: 0.8,    //边线透明度，取值范围0 - 1。
                                        fillOpacity: 0.6,      //填充的透明度，取值范围0 - 1。
                                        strokeStyle: 'solid' //边线的样式，solid或dashed。
                                    }
                                    let points = []
                                    for (let i = 0; i < markerPoints.length; i++) {
                                        points.push(new BMap.Point(markerPoints[i][0], markerPoints[i][1]))
                                    }
                                    //覆盖物点位
                                    polygon = new BMap.Polygon(points, settings)
                                }
                                //添加覆盖物到地图
                                map.addOverlay(polygon);

                            }
                        } else {
                        }
                    }
                }
            })
        }
    }
})

// map.addOverlay(marker);

// 地图板块
var tagMarkerIcon = new BMap.Icon("../img/markers.png", new BMap.Size(23, 25), {
    imageOffset: new BMap.Size(0, 0 - 13 * 25), // 设置图片偏移
});
// function initMark(obj) {
//     let {labelName, point, color, strokeColor, fillColor, polygon} = obj; // 结构参数
//     var label = new BMap.Label(labelName, {
//         offset: new BMap.Size(-15, 2),
//     });
//     var marker = new BMap.Marker(new BMap.Point(point.x, point.y), {
//         icon: tagMarkerIcon,
//     });
//     label.setStyle({
//         color,
//         fontSize: "18px",
//         backgroundColor: "0.05",
//         border: "0",
//         fontWeight: "bold",
//     });
//     marker.setLabel(label);
//     map.addOverlay(marker);
//     var Polygon = new BMap.Polygon(polygon, {
//         strokeColor,
//         strokeWeight: 4,
//         fillColor,
//     });
//     map.addOverlay(Polygon);
// }

// function Mark(){
//     initMark({
//         labelName: "胜利社区", // 雪峰社区
//         point: {
//             x: 120.071864,
//             y: 29.309829,
//         },
//         color: "#89AEDF",
//         strokeColor: "#89AEDF",
//         fillColor: "rgba(137,174,223,0.7)",
//         polygon: [
//             new BMap.Point(120.076596, 29.305986),
//             new BMap.Point(120.066317, 29.308652),
//             new BMap.Point(120.074763, 29.314986),
//             new BMap.Point(120.076398, 29.310195),
//         ],
//     });
//     initMark({
//         labelName: "绣湖社区", // 雪峰社区
//         point: {
//             x: 120.079554,
//             y: 29.309924,
//         },
//         color: "#25dfd1",
//         strokeColor: "#A2D7CE",
//         fillColor: "rgba(162,215,206,0.7)",
//         polygon: [
//             new BMap.Point(120.075329, 29.313383),
//             new BMap.Point(120.076398, 29.310195),
//             new BMap.Point(120.076596, 29.305986),
//             new BMap.Point(120.083423, 29.308813),
//             new BMap.Point(120.083908, 29.309411),
//             new BMap.Point(120.085022, 29.313116),
//         ],
//     });
//     initMark({
//         labelName: "通惠社区", // 雪峰社区
//         point: {
//             x: 120.080883,
//             y: 29.316191,
//         },
//         color: "#8AB3C8",
//         strokeColor: "#8AB3C8",
//         fillColor: "rgba(138,179,200,0.7)",
//         polygon: [
//             new BMap.Point(120.074763, 29.314986),
//             new BMap.Point(120.075329, 29.313383),
//             new BMap.Point(120.085022, 29.313116),
//             new BMap.Point(120.087037, 29.31801),
//             new BMap.Point(120.083111, 29.319411),
//             new BMap.Point(120.082024, 29.320537),
//         ],
//     });
//     initMark({
//         labelName: "下车门社区", // 雪峰社区
//         point: {
//             x: 120.079015,
//             y: 29.305451,
//         },
//         color: "#A2B1DE",
//         strokeColor: "#A2B1DE",
//         fillColor: "rgba(162,177,222,0.7)",
//         polygon: [
//             new BMap.Point(120.076596, 29.305986),
//             new BMap.Point(120.075458, 29.300933),
//             new BMap.Point(120.086403, 29.306396),
//             new BMap.Point(120.083423, 29.308813),
//         ],
//     });
//     initMark({
//         labelName: "江滨社区", // 雪峰社区
//         point: {
//             x: 120.080632,
//             y: 29.301262,
//         },
//         color: "#7FA5D8",
//         strokeColor: "#7FA5D8",
//         fillColor: "rgba(127,165,216,0.7)",
//         polygon: [
//             new BMap.Point(120.075458, 29.300933),
//             new BMap.Point(120.074892, 29.293988),
//             new BMap.Point(120.079644, 29.296128),
//             new BMap.Point(120.082806, 29.298278),
//             new BMap.Point(120.089785, 29.303554),
//             new BMap.Point(120.086403, 29.306396),
//         ],
//     });
//     initMark({
//         labelName: "向阳社区", // 雪峰社区
//         point: {
//             x: 120.086165,
//             y: 29.311467,
//         },
//         color: "#D5DDB2",
//         strokeColor: "#D5DDB2",
//         fillColor: "rgba(213,221,178,0.7)",
//         polygon: [
//             new BMap.Point(120.086403, 29.306396),
//             new BMap.Point(120.083423, 29.308813),
//             new BMap.Point(120.083908, 29.309411),
//             new BMap.Point(120.085022, 29.313116),
//             new BMap.Point(120.087037, 29.31801),
//             new BMap.Point(120.087854, 29.315317),
//             new BMap.Point(120.091919, 29.311396),
//         ],
//     });
//     initMark({
//         labelName: "市场社区", // 雪峰社区
//         point: {
//             x: 120.090052,
//             y: 29.308057,
//         },
//         color: "#C8D5B7",
//         strokeColor: "#C8D5B7",
//         fillColor: "rgba(200,213,183,0.7)",
//         polygon: [
//             new BMap.Point(120.086403, 29.306396),
//             new BMap.Point(120.089785, 29.303554),
//             new BMap.Point(120.092112, 29.306199),
//             new BMap.Point(120.095445, 29.311109),
//             new BMap.Point(120.094007, 29.313301),
//         ],
//     });
//     initMark({
//         labelName: "宾王社区", // 雪峰社区
//         point: {
//             x: 120.094759,
//             y: 29.317851,
//         },
//         color: "#0FC3C0",
//         strokeColor: "#0FC3C0",
//         fillColor: "rgba(15,195,192,0.7)",
//         polygon: [
//             new BMap.Point(120.095445, 29.31105),
//             new BMap.Point(120.103988, 29.318317),
//             new BMap.Point(120.09443, 29.323544),
//             new BMap.Point(120.091699, 29.317025),
//         ],
//     });
//     initMark({
//         labelName: "孝子祠社区", // 雪峰社区
//         point: {
//             x: 120.088795,
//             y: 29.317757,
//         },
//         color: "#90BBD2",
//         strokeColor: "#90BBD2",
//         fillColor: "rgba(144,187,210,0.7)",
//         polygon: [
//             new BMap.Point(120.091919, 29.311396),
//             new BMap.Point(120.094007, 29.313301),
//             new BMap.Point(120.091699, 29.317025),
//             new BMap.Point(120.09443, 29.323544),
//             new BMap.Point(120.090347, 29.325626),
//             new BMap.Point(120.087037, 29.31801),
//             new BMap.Point(120.087854, 29.315317),
//         ],
//     });
//     initMark({
//         labelName: "车站社区", // 雪峰社区
//         point: {
//             x: 120.08592,
//             y: 29.322859,
//         },
//         color: "#B3CD8F",
//         strokeColor: "#B3CD8F",
//         fillColor: "rgba(179,205,143,0.7)",
//         polygon: [
//             new BMap.Point(120.087037, 29.31801),
//             new BMap.Point(120.083111, 29.319411),
//             new BMap.Point(120.082024, 29.320537),
//             new BMap.Point(120.089082, 29.330278),
//             new BMap.Point(120.091849, 29.332341),
//             new BMap.Point(120.093567, 29.330881),
//             new BMap.Point(120.091663, 29.32852),
//         ],
//     });
//     initMark({
//         labelName: "银苑社区", // 雪峰社区
//         point: {
//             x: 120.105683,
//             y: 29.324905,
//         },
//         color: "#6E8BD0",
//         strokeColor: "#6E8BD0",
//         fillColor: "rgba(110,139,208,0.7)",
//         polygon: [
//             new BMap.Point(120.10388, 29.318348),
//             new BMap.Point(120.108515, 29.320017),
//             new BMap.Point(120.113366, 29.328441),
//             new BMap.Point(120.118253, 29.330739),
//             new BMap.Point(120.105425, 29.331259),
//             new BMap.Point(120.098634, 29.321308),
//         ],
//     });
//     initMark({
//         labelName: "词林社区", // 雪峰社区
//         point: {
//             x: 120.09537,
//             y: 29.328058,
//         },
//         color: "#197DA3",
//         strokeColor: "#197DA3",
//         fillColor: "rgba(25,125,163,0.7)",
//         polygon: [
//             new BMap.Point(120.090347, 29.325626),
//             new BMap.Point(120.098634, 29.321308),
//             new BMap.Point(120.105425, 29.331259),
//             new BMap.Point(120.100598, 29.331593),
//             new BMap.Point(120.096412, 29.335411),
//             new BMap.Point(120.091849, 29.332341),
//             new BMap.Point(120.093567, 29.330881),
//             new BMap.Point(120.091663, 29.32852),
//         ],
//     });
//     initMark({
//         labelName: "雪峰社区", // 雪峰社区
//         point: {
//             x: 120.089275,
//             y: 29.340783,
//         },
//         color: "#759ACA",
//         strokeColor: "#759ACA",
//         fillColor: "rgba(117,154,202,0.7)",
//         polygon: [
//             new BMap.Point(120.089082, 29.330278),
//             new BMap.Point(120.087815, 29.335655),
//             new BMap.Point(120.085947, 29.33704),
//             new BMap.Point(120.078644, 29.345218),
//             new BMap.Point(120.077853, 29.347005),
//             new BMap.Point(120.081267, 29.346249),
//             new BMap.Point(120.08283, 29.347713),
//             new BMap.Point(120.081734, 29.35227),
//             new BMap.Point(120.081384, 29.354159),
//             new BMap.Point(120.083373, 29.356556),
//             new BMap.Point(120.084276, 29.356694),
//             new BMap.Point(120.084492, 29.35641),
//             new BMap.Point(120.084339, 29.355143),
//             new BMap.Point(120.089194, 29.348575),
//             new BMap.Point(120.093228, 29.345451),
//             new BMap.Point(120.1016, 29.341192),
//             new BMap.Point(120.096412, 29.335411),
//             new BMap.Point(120.091849, 29.332341),
//         ],
//     });
//     // 地图当前标注
//     var marker = new BMap.Marker(cont);        // 创建标注
//     marker.setIcon(new BMap.Icon("../img/sxt.png", new BMap.Size(40, 40)));
//     map.addOverlay(marker);
//     // 标注点击事件
//     marker.addEventListener("click", function () {
//         $('.Play').css('display','none');
//         if(componentId == '1001'){
//             if(oWebControl ==null){
//                 initPlugin();
//             }
//             startPlayback();
//             oWebControl.JS_ShowWnd();
//         }else{
//             if(videoPath.length > 10){
//                 var myPlayer = videojs(
//                     'playVideojs', {
//                         width: 360,
//                         height: 266,
//                     }
//                 );
//                 if(videoPath.substring(videoPath.length-6).indexOf("mp4") > -1){
//                     myPlayer.src({src: videoPath, type: "video/mp4"});
//                 }else if(videoPath.substring(videoPath.length-6).indexOf("m3u8") > -1){
//                     myPlayer.src({src: videoPath, type: "application/x-mpegURL"});
//                 }
//             }else{
//                 layer.msg("该事件无视频资料");
//             }
//         }
//         $('.Play').css('display', 'none');
//         if (oWebControl == null) {
//             initPlugin();
//         }
//         startPlayback();
//         oWebControl.JS_ShowWnd();
//     });
// }
//
// Mark();

// 点位上图
function initLabel(obj) {
    let {
        labelName,
        point,
        color,
        strokeColor,
        fillColor,
        src,
    } = obj; // 结构参数
    var label = new BMap.Label(labelName, {
        position: point, // 指定文本标注所在的地理位置
        offset: new BMap.Size(10, 43),
    });

    var marker = new BMap.Marker(new BMap.Point(point.x, point.y), {
        icon: tagMarkerIcon,
    });
    label.setStyle({
        color: "#fff",
        borderRadius: "20px",
        padding: "1px 5px",
        maxWidth: "none",
        fontSize: "12px",
        backgroundColor: "#6395f9",
        border: "2px solid " + color + "",
        fontWeight: "bold",
    });
    marker.setLabel(label);
    map.addOverlay(marker);
    marker.setIcon(
        new BMap.Icon(
            "../img/" + src + ".png",
            new BMap.Size(40, 40)
        )
    );
    map.addOverlay(marker);
}

initLabel({
    labelName: "1", // 雪峰社区
    point: {
        x: 120.082024,
        y: 29.320537,
    },
    color: "#fff",
    src: "dian",
});

map.addEventListener("zoomend", function (type) {
    if (!type.lD) {
        if (map.getZoom() == 11) {

            map.clearOverlays();
            Mark();
            initLabel({
                labelName: "1", // 点位个数
                point: {//点位定位
                    x: 120.082024,
                    y: 29.320537,
                },
                color: "#fff",
                src: "dian",
            });
        } else if (map.getZoom() == 12) {
            map.clearOverlays();
            initLabel({
                labelName: "1", // 点位个数
                point: {//点位定位
                    x: 120.082024,
                    y: 29.320537,
                },
                color: "#fff",
                src: "dian",
            });
        }else if (map.getZoom() == 13) {
            map.clearOverlays();
            Mark();
            initLabel({
                labelName: "1", // 点位个数
                point: {//点位定位
                    x: 120.082024,
                    y: 29.320537,
                },
                color: "#fff",
                src: "dian",
            });
        }else if (map.getZoom() == 14) {
            map.clearOverlays();
            Mark();
            initLabel({
                labelName: "1", // 点位个数
                point: {//点位定位
                    x: 120.082024,
                    y: 29.320537,
                },
                color: "#fff",
                src: "dian",
            });
        }else if (map.getZoom() == 16) {
            // map.disableScrollWheelZoom(); //禁止鼠标滚轮缩放,
            // map.maxZoom(15);
            map.clearOverlays();
            initLabel({
                labelName: "1", // 点位个数
                point: {//点位定位
                    x: 120.082024,
                    y: 29.320537,
                },
                color: "#fff",
                src: "dian",
            });
        }
        Mark();
    }
});
