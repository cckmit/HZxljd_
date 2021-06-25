// 区域分析
// 赋能流转
var regio1 = echarts.init(document.getElementById("regio1"));
var Toption1 = {
    // tooltip: {
    //   trigger: "axis",
    //   axisPointer: {
    //     type: "cross",
    //   },
    // },
    legend: {
        top: "bottom",
        itemWidth: 15,
        itemHeight: 15,
        textStyle:{
            color:'#555'
        }
    },
    grid: {
        left: "5%",
        top: "5%",
        right: "5%",
        bottom: "10%",
        containLabel: true,
    },
    xAxis: {
        type: "category",
        axisLine: {
            lineStyle: {
                color: "#888",
            },
        },
        axisTick: {
            show: false,
        },
        axisLabel: {
            textStyle: {
                color: "#333",
            },
        },
        data: [
            "雪峰",
            "下车门",
            "通惠",
            "词林",
            "银苑",
            "孝子祠",
            "宾王",
            "向阳",
            "胜利",
            "江滨",
            "绣湖",
            "市场",
            "车站",
        ],
    },
    yAxis: {
        type: "value",
        axisLine: {
            show: false,
        },
        axisTick: {
            show: false,
        },
        splitLine: {
            show: true,
            lineStyle: {
                type: "dashed",
            },
        },
        axisLabel: {
            textStyle: {
                color: "#333",
            },
        },
        // boundaryGap: [0, 0.01],
    },
    color: ["#0070cc", "#2Aca96"],
    series: [
        {
            name: "预警事件发生数",
            type: "line",
            data: [
                40,
                38,
                80,
                94,
                141,
                87,
                104,
                120,
                78,
                88,
                69,
                100,
                67,
            ],
            smooth: true,
            itemStyle: {
                borderWidth: 2,
                color: {
                    type: "linear",
                    x: 0,
                    y: 0,
                    x2: 0,
                    y2: 1,
                    colorStops: [
                        {
                            offset: 0,
                            color: "rgba(42,202,150,0.5)", // 0% 处的颜色
                        },
                        {
                            offset: 1,
                            color: "rgba(255,255,255,0.3)", // 100% 处的颜色
                        },
                    ],
                    global: false, // 缺省为 false
                },
            },
            symbolSize: 0,
            lineStyle: {
                width: 2,
                color: {
                    type: "linear",
                    x: 0,
                    y: 0,
                    x2: 1,
                    y2: 1,
                    colorStops: [
                        {
                            offset: 0,
                            color: "rgba(42,202,150)", // 0% 处的颜色
                        },
                        {
                            offset: 0.5,
                            color: "rgba(42,202,150)", // 0% 处的颜色
                        },
                        {
                            offset: 1,
                            color: "rgba(42,202,150)", // 100% 处的颜色
                        },
                    ],
                    global: true, // 缺省为 false
                },
            },
            areaStyle: [],
        },
    ],
};
regio1.setOption(Toption1);
// 店铺信誉
var regio2 = echarts.init(document.getElementById("regio2"));
var toption2 = {
    // tooltip: {
    //   trigger: "axis",
    //   axisPointer: {
    //     // 坐标轴指示器，坐标轴触发有效
    //     type: "cross", // 默认为直线，可选为：'line' | 'shadow'
    //   },
    //   formatter: function (params) {
    //     console.log(params);
    //     var str =
    //             params[0].name +
    //             "<br/>" +
    //             params[0].marker +
    //             params[0].seriesName +
    //             "：" +
    //             params[0].data +
    //             "%";
    //     return str;
    //   },
    // },
    grid: {
        top: "5%",
        left: "3%",
        right: "4%",
        bottom: "5%",
        containLabel: true,
    },
    xAxis: {
        type: "value",
        axisLine: {
            show: false,
            lineStyle: {
                color: "#888",
            },
        },
        axisTick: {
            show: false,
        },
        splitLine: {
            show: true,
            lineStyle: {
                type: "dashed",
            },
        },
    },
    yAxis: {
        type: "category",
        data: [
            "爱婴室",
            "樊图",
            "行易堂",
            "百鲜果园",
            "半斗水果",
            "花鸟工作室",
            "龙龙粮油店",
            "元成小菜场",
            "英树",
        ],
        axisLine: {
            show: false,
        },
        axisTick: {
            show: false,
        },
        axisLabel:{
            color:'#333'
        }
    },
    color: ["#0070cc"],
    series: [
        {
            name: "信誉率",
            type: "bar",
            data: [20, 30, 40, 50, 60, 70, 80, 90, 95],
            barWidth: 15,
        },
    ],
};
regio2.setOption(toption2);
// 类型统计
var regio3 = echarts.init(document.getElementById("regio3"));
var Soption3 = {
    // tooltip: {
    //   trigger: "item",
    //   formatter: "{a} <br/>{b}: {c} ({d}%)",
    // },
    grid: {
        top: "5%",
        left: 5,
        right: 5,
        bottom: "20%",
        containLabel: true,
    },
    legend: {
        // orient: 'or',
        top: "bottom",
        itemWidth: 15,
        itemHeight: 15,
    },
    color: ["#217FCD", "#44CCA0", "#F8C721", "#6E7E9B", "#F98A65"],
    series: [
        {
            name: "类型统计",
            type: "pie",
            radius: ["0%", "70%"],
            avoidLabelOverlap: false,
            label: {
                show: true,
                position: "outside",
                formatter: "{d}% {b} ",
            },

            labelLine: {
                show: true,
            },
            data: [
                {
                    value: 35,
                    name: "向阳"
                },
                {
                    value: 12,
                    name: "绣湖"
                },
                {
                    value: 13,
                    name: "胜利"
                },
                {
                    value: 16,
                    name: "下车门"
                },
                {
                    value: 24,
                    name: "江滨"
                },
            ],
        },
    ],
};
regio3.setOption(Soption3);

// 对象分析
// 事件趋势
var obj1 = echarts.init(document.getElementById("obj1"));
var Option1 = {
    // tooltip: {
    //     trigger: "axis",
    //     axisPointer: {
    //         type: "cross",
    //     },
    // },
    legend: {
        top: "bottom",
        itemWidth: 15,
        itemHeight: 15,
        textStyle:{
            color:'#555'
        }
    },
    grid: {
        left: "5%",
        top: "5%",
        right: "5%",
        bottom: "10%",
        containLabel: true,
    },
    xAxis: {
        type: "category",
        axisLine: {
            lineStyle: {
                color: "#888",
            },
        },
        axisTick: {
            show: false,
        },
        axisLabel: {
            formatter: function (params) {
                var newParamsName = "";
                var paramsNameNumber = params.length;
                var provideNumber = 6; //一行显示几个字
                var rowNumber = Math.ceil(
                    paramsNameNumber / provideNumber
                );
                if (paramsNameNumber > provideNumber) {
                    for (var p = 0; p < rowNumber; p++) {
                        var tempStr = "";
                        var start = p * provideNumber;
                        var end = start + provideNumber;
                        if (p == rowNumber - 1) {
                            tempStr = params.substring(
                                start,
                                paramsNameNumber
                            );
                        } else {
                            tempStr =
                                params.substring(start, end) + "\n";
                        }
                        newParamsName += tempStr;
                    }
                } else {
                    newParamsName = params;
                }
                return newParamsName;
            },
            textStyle: {
                color: "#333",
            },
        },
        data: [
            "00:00-02:00",
            "02:00-04:00",
            "04:00-06:00",
            "08:00-10:00",
            "10:00-12:00",
            "14:00-16:00",
            "16:00-18:00",
            "20:00-20:00",
            "22:00-00:00",
        ],
    },
    yAxis: {
        type: "value",
        axisLine: {
            show: false,
        },
        axisTick: {
            show: false,
        },
        splitLine: {
            show: true,
            lineStyle: {
                type: "dashed",
            },
        },
        axisLabel: {
            textStyle: {
                color: "#333",
            },
        },
        // boundaryGap: [0, 0.01],
    },
    color: ["#0070cc", "#2aca96"],
    series: [
        {
            name: "店铺",
            type: "bar",
            data: [70, 89, 34, 70, 124, 230, 40, 180, 70],
            barGap: 0,
            barWidth: 15,
        },
        {
            name: "街道",
            type: "bar",
            data: [40, 38, 80, 94, 141, 87, 104, 150, 48],
            barGap: 0,
            barWidth: 15,
        },
    ],
};
obj1.setOption(Option1);
// 社区检测
var obj2 = echarts.init(document.getElementById("obj2"));
var Option2 = {
    // tooltip: {
    //     trigger: "axis",
    //     axisPointer: {
    //         // 坐标轴指示器，坐标轴触发有效
    //         type: "shadow", // 默认为直线，可选为：'line' | 'shadow'
    //     },
    // },
    legend: {
        top: "bottom",
        itemWidth: 15,
        itemHeight: 15,
        textStyle:{
            color:'#555'
        }
    },
    grid: {
        top: 5,
        left: "3%",
        right: "4%",
        bottom: "8%",
        containLabel: true,
    },
    xAxis: {
        type: "value",
        axisLine: {
            show: false,
            lineStyle: {
                color: "#888",
            },
        },
        axisTick: {
            show: false,
        },
        splitLine: {
            show: true,
            lineStyle: {
                type: "dashed",
            },
        },
        axisLabel:{
            color:'#333'
        }
    },
    yAxis: {
        type: "category",
        data: [
            "孝子祠",
            "市场",
            "雪峰",
            "宾王",
            "词林",
            "车站",
            "银苑",
            "通惠",
            "向阳",
            "绣湖",
            "胜利",
            "江滨",
            "下车门",
        ],
        axisLine: {
            lineStyle: {
                color: "#888",
            },
        },
        axisTick: {
            show: false,
        },
        axisLabel:{
            color:'#333'
        }
    },
    color: ["#0070cc", "#2aca96"],
    series: [
        {
            name: "店铺",
            type: "bar",
            stack: "总量",
            data: [
                20,
                32,
                101,
                34,
                90,
                30,
                120,
                40,
                70,
                70,
                90,
                30,
                160,
            ],
            barWidth: 15,
        },
        {
            name: "街道",
            type: "bar",
            stack: "总量",
            data: [
                20,
                32,
                101,
                134,
                90,
                30,
                10,
                50,
                70,
                80,
                100,
                40,
                50,
            ],
            barWidth: 15,
        },
    ],
};
obj2.setOption(Option2);
// 事件分析
var obj3 = echarts.init(document.getElementById("obj3"));
var Option3 = {
    // tooltip: {
    //     trigger: "axis",
    //     axisPointer: {
    //         // 坐标轴指示器，坐标轴触发有效
    //         type: "line", // 默认为直线，可选为：'line' | 'shadow'
    //     },
    // },
    grid: {
        top: "5%",
        left: "5%",
        right: "4%",
        bottom: "3%",
        containLabel: true,
    },
    xAxis: [
        {
            type: "value",

            axisTick: {
                show: false,
            },
            axisLine: {
                show: false,
            },
            axisLabel: {
                show: false,
            },
            splitLine: {
                show: false,
            },
        },
    ],
    yAxis: [
        {
            type: "category",
            axisTick: {
                show: false,
            },
            axisLine: {
                show: false,
            },
            data: [
                "聚众斗殴",
                "机动车违停",
                "人员聚集",
                "非机动车违停",
                "沿街晾晒",
                "游商摊贩",
                "垃圾堆放",
                "出店经营",
            ],
            axisLabel:{
                color:'#333'
            }
        },
    ],

    series: [
        {
            name: "assist",
            type: "bar",
            stack: "1",
            itemStyle: {
                normal: {
                    barBorderColor: "rgba(0,0,0,0)",
                    color: "rgba(0,0,0,0)",
                },
                emphasis: {
                    barBorderColor: "rgba(0,0,0,0)",
                    color: "rgba(0,0,0,0)",
                },
            },
            tooltip: {
                trigger: "none",
            },
            data: [40, 40, 40, 40, 40, 40, 40, 40, 40],
        },
        {
            name: "分析率",
            type: "bar",
            barWidth: "60%",
            stack: 1,
            data: [11, 22, 41, 53, 84, 100, 123, 187],
            barWidth: 10,
            label: {
                show: true,
                position: "left",
            },
            itemStyle: {
                barBorderRadius: 15,
                color: function (params) {
                    var colorList = [
                        "#FFEF8E",
                        "#FECD27",
                        "#C4CCE7",
                        "#7484A0",
                        "#A0F4CA",
                        "#4AD2A6",
                        "#97DDFF",
                        "#2785D3",
                    ];
                    return colorList[params.dataIndex];
                },
            },
        },
    ],
};
obj3.setOption(Option3);

// 现象分析
// 区域检测
var Cont1 = echarts.init(document.getElementById("Cont1"));
var Cption1 = {
    // tooltip: {
    //   trigger: "axis",
    //   axisPointer: {
    //     type: "cross",
    //   },
    // },
    legend: {
        top: "bottom",
        itemWidth: 15,
        itemHeight: 15,
        textStyle:{
            color:'#555'
        }
    },
    grid: {
        left: "5%",
        top: "5%",
        right: "5%",
        bottom: "10%",
        containLabel: true,
    },
    xAxis: {
        type: "category",
        axisLabel: {
            textStyle: {
                color: "#333",
            },
        },
        axisLine: {
            lineStyle: {
                color: "#888",
            },
        },
        axisTick: {
            show: false,
        },
        data: [
            "雪峰",
            "下车门",
            "通惠",
            "词林",
            "银苑",
            "孝子祠",
            "宾王",
            "向阳",
            "胜利",
            "江滨",
            "绣湖",
            "市场",
            "车站",
        ],
    },
    yAxis: {
        type: "value",
        axisLine: {
            show: false,
        },
        axisTick: {
            show: false,
        },
        splitLine: {
            show: true,
            lineStyle: {
                type: "dashed",
            },
        },
        axisLabel: {
            textStyle: {
                color: "#333",
            },
        },
        // boundaryGap: [0, 0.01],
    },
    color: ["#0070cc", "#2aca96"],
    series: [
        {
            name: "店铺",
            type: "bar",
            data: [
                70,
                89,
                34,
                70,
                124,
                230,
                40,
                180,
                70,
                50,
                90,
                120,
                170,
            ],
            barGap: 0,
            barWidth: 15,
        },
        {
            name: "街道",
            type: "line",
            data: [
                40,
                38,
                80,
                94,
                141,
                87,
                104,
                120,
                48,
                60,
                100,
                140,
                160,
            ],
            smooth: true,
            itemStyle: {
                color: {
                    type: "linear",
                    x: 0,
                    y: 0,
                    x2: 0,
                    y2: 1,
                    colorStops: [
                        {
                            offset: 0,
                            color: "rgba(42,202,150)", // 0% 处的颜色
                        },
                        {
                            offset: 1,
                            color: "#ffffff", // 100% 处的颜色
                        },
                    ],
                    global: false, // 缺省为 false
                },
            },
            symbolSize: 0,
            lineStyle: {
                width: 3,
                color: {
                    type: "linear",
                    x: 0,
                    y: 0,
                    x2: 1,
                    y2: 1,
                    colorStops: [
                        {
                            offset: 0,
                            color: "rgba(42,202,150)", // 0% 处的颜色
                        },
                        {
                            offset: 0.5,
                            color: "rgba(42,202,150)", // 0% 处的颜色
                        },
                        {
                            offset: 1,
                            color: "rgba(42,202,150)", // 100% 处的颜色
                        },
                    ],
                    global: true, // 缺省为 false
                },
            },
            areaStyle: [],
        },
    ],
};
Cont1.setOption(Cption1);
// 效率分析
var Cont2 = echarts.init(document.getElementById("Cont2"));
var Cption2 = {
    // tooltip: {
    //     trigger: "axis",
    //     axisPointer: {
    //         // 坐标轴指示器，坐标轴触发有效
    //         type: "shadow", // 默认为直线，可选为：'line' | 'shadow'
    //     },
    // },
    legend: {
        top: "bottom",
        itemWidth: 15,
        itemHeight: 15,
        textStyle:{
            color:'#555'
        }
    },
    grid: {
        top: 5,
        left: "3%",
        right: "4%",
        bottom: "8%",
        containLabel: true,
    },
    xAxis: {
        type: "value",
        axisLine: {
            show: false,
            lineStyle: {
                color: "#888",
            },
        },
        axisTick: {
            show: false,
        },
        splitLine: {
            show: true,
            lineStyle: {
                type: "dashed",
            },
        },
        axisLabel:{
            color:'#333'
        }
    },
    yAxis: {
        type: "category",
        data: [
            "孝子祠",
            "市场",
            "雪峰",
            "宾王",
            "词林",
            "车站",
            "银苑",
            "通惠",
            "向阳",
            "绣湖",
            "胜利",
            "江滨",
            "下车门",
        ],
        axisLine: {
            lineStyle: {
                color: "#999",
            },
        },
        axisTick: {
            show: false,
        },
    },
    color: ["#0070cc", "#2aca96"],
    series: [
        {
            name: "店铺",
            type: "bar",
            stack: "总量",
            data: [
                20,
                32,
                101,
                34,
                90,
                30,
                120,
                40,
                70,
                70,
                90,
                30,
                160,
            ],
            barWidth: 10,
        },
        {
            name: "街道",
            type: "bar",
            stack: "总量",
            data: [
                20,
                32,
                101,
                134,
                90,
                30,
                10,
                50,
                70,
                80,
                100,
                40,
                50,
            ],
            barWidth: 10,
        },
    ],
};
Cont2.setOption(Cption2);
// 类型统计
var Cont3 = echarts.init(document.getElementById("Cont3"));
var Cption3 = {
    // tooltip: {
    //     trigger: "item",
    //     formatter: "{a} <br/>{b}: {c} ({d}%)",
    // },
    grid: {
        top: "3%",
        left: 5,
        right: 5,
        bottom: "20%",
        containLabel: true,
    },
    legend: {
        // orient: 'or',
        top: "bottom",
        itemWidth: 15,
        itemHeight: 15,
        textStyle:{
            color:'#555'
        }
    },
    color: ["#217FCD", "#44CCA0", "#F8C721", "#6E7E9B", "#F98A65"],
    series: [
        {
            name: "类型统计",
            type: "pie",
            radius: ["50%", "70%"],
            avoidLabelOverlap: false,
            label: {
                show: true,
                position: "outside",
                formatter: "{d}% {b} ",
                color:'#333'
            },

            labelLine: {
                show: true,
                color:'#888'
            },
            data: [
                {
                    value: 35,
                    name: "出店经营"
                },
                {
                    value: 12,
                    name: "非机动车违停"
                },
                {
                    value: 13,
                    name: "沿街晾晒"
                },
                {
                    value: 16,
                    name: "游商摊贩"
                },
                {
                    value: 24,
                    name: "垃圾堆放"
                },
            ],
        },
    ],
};
Cont3.setOption(Cption3);

// echarts自适应
setTimeout(() => {
    window.onresize = function () {
        regio1.resize();
        regio2.resize();
        regio3.resize();
        obj1.resize();
        obj2.resize();
        obj3.resize();
    };
}, 500);