var echarts_circle1 = echarts.init(document.getElementById("echarts_circle1"));
var circle1 = {
    title: {
        text: "128",
        textStyle: {
            color: "#333",
            fontSize: 24,
        },
        top: "40%",
        left: "center",
        itemGap: 2,
        subtext: "总数",
        subtextStyle: {
            color: "#999",
            fontSize: 16,
        },
    },
    series: [
        {
            name: "接口单日调用数",
            type: "pie",
            radius: ["65%", "80%"],
            avoidLabelOverlap: false,
            label: {
                show: false,
                position: "center",
            },
            emphasis: {
                label: {
                    show: false,
                    fontSize: "30",
                    fontWeight: "bold",
                },
            },
            labelLine: {
                show: false,
            },
            color: ["#FEC400", "#2ACA96", "#0070cc"],
            data: [
                { value: 0, name: "事件接入" },
                { value: 0, name: "事件反馈接口" },
                { value: 128, name: "事件处理接口" },
            ],
        },
    ],
};
echarts_circle1.setOption(circle1);

var echarts_circle2 = echarts.init(document.getElementById("echarts_circle2"));
var circle2 = {
    title: {
        text: "128",
        textStyle: {
            color: "#333",
            fontSize: 24,
        },
        top: "40%",
        left: "center",
        itemGap: 2,
        subtext: "总数",
        subtextStyle: {
            color: "#999",
            fontSize: 16,
        },
    },
    series: [
        {
            name: "接口单日调用数",
            type: "pie",
            radius: ["65%", "80%"],
            avoidLabelOverlap: false,
            label: {
                show: false,
                position: "center",
            },
            emphasis: {
                label: {
                    show: false,
                    fontSize: "30",
                    fontWeight: "bold",
                },
            },
            labelLine: {
                show: false,
            },
            color: ["#FEC400", "#2ACA96", "#0070cc"],
            data: [
                { value: 110, name: "事件接入" },
                { value: 18, name: "事件反馈接口" },
                { value: 0, name: "事件处理接口" },
            ],
        },
    ],
};
echarts_circle2.setOption(circle2);

var echarts_circle3 = echarts.init(document.getElementById("echarts_circle3"));
var circle3 = {
    title: {
        text: "128",
        textStyle: {
            color: "#333",
            fontSize: 24,
        },
        top: "40%",
        left: "center",
        itemGap: 2,
        subtext: "总数",
        subtextStyle: {
            color: "#999",
            fontSize: 16,
        },
    },
    series: [
        {
            name: "接口单日调用数",
            type: "pie",
            radius: ["65%", "80%"],
            avoidLabelOverlap: false,
            label: {
                show: false,
                position: "center",
            },
            emphasis: {
                label: {
                    show: false,
                    fontSize: "30",
                    fontWeight: "bold",
                },
            },
            labelLine: {
                show: false,
            },
            color: ["#FEC400", "#2ACA96", "#0070cc"],
            data: [
                { value: 0, name: "事件接入" },
                { value: 0, name: "事件反馈接口" },
                { value: 128, name: "事件处理接口" },
            ],
        },
    ],
};
echarts_circle3.setOption(circle3);

var echarts_circle4 = echarts.init(document.getElementById("echarts_circle4"));
var circle4 = {
    title: {
        text: "128",
        textStyle: {
            color: "#333",
            fontSize: 24,
        },
        top: "40%",
        left: "center",
        itemGap: 2,
        subtext: "总数",
        subtextStyle: {
            color: "#999",
            fontSize: 16,
        },
    },
    series: [
        {
            name: "接口单日调用数",
            type: "pie",
            radius: ["65%", "80%"],
            avoidLabelOverlap: false,
            label: {
                show: false,
                position: "center",
            },
            emphasis: {
                label: {
                    show: false,
                    fontSize: "30",
                    fontWeight: "bold",
                },
            },
            labelLine: {
                show: false,
            },
            color: ["#2ACA96", "#d93026"],
            data: [
                { value: 100, name: "正常" },
                { value: 28, name: "异常" },
            ],
        },
    ],
};
echarts_circle4.setOption(circle4);

var echarts_circle5 = echarts.init(document.getElementById("echarts_circle5"));
var circle5 = {
    series: [
        {
            type: "liquidFill",
            radius: "70%",
            center: ["50%", "50%"],
            // shape:
            //     "path://M367.855,428.202c-3.674-1.385-7.452-1.966-11.146-1.794c0.659-2.922,0.844-5.85,0.58-8.719 c-0.937-10.407-7.663-19.864-18.063-23.834c-10.697-4.043-22.298-1.168-29.902,6.403c3.015,0.026,6.074,0.594,9.035,1.728 c13.626,5.151,20.465,20.379,15.32,34.004c-1.905,5.02-5.177,9.115-9.22,12.05c-6.951,4.992-16.19,6.536-24.777,3.271 c-13.625-5.137-20.471-20.371-15.32-34.004c0.673-1.768,1.523-3.423,2.526-4.992h-0.014c0,0,0,0,0,0.014 c4.386-6.853,8.145-14.279,11.146-22.187c23.294-61.505-7.689-130.278-69.215-153.579c-61.532-23.293-130.279,7.69-153.579,69.202 c-6.371,16.785-8.679,34.097-7.426,50.901c0.026,0.554,0.079,1.121,0.132,1.688c4.973,57.107,41.767,109.148,98.945,130.793 c58.162,22.008,121.303,6.529,162.839-34.465c7.103-6.893,17.826-9.444,27.679-5.719c11.858,4.491,18.565,16.6,16.719,28.643 c4.438-3.126,8.033-7.564,10.117-13.045C389.751,449.992,382.411,433.709,367.855,428.202z",
            backgroundStyle: {
                color: "rgba(232,232,232,0.1)",
            },
            data: [
                {
                    value: 0.51,
                    direction: "left",
                    itemStyle: {
                        color: {
                            type: "linear",
                            x: 0,
                            y: 0,
                            x2: 0,
                            y2: 1,
                            colorStops: [
                                {
                                    offset: 1,
                                    color: "rgba(0,112,204, 0.1)",
                                },
                                {
                                    offset: 0.5,
                                    color: "rgba(0,112,204, .5)",
                                },
                                {
                                    offset: 0,
                                    color: "rgba(0,112,204, 1)",
                                },
                            ],
                            globalCoord: false,
                        },
                    },
                },
                {
                    value: 0.51,
                    direction: "left",
                    itemStyle: {
                        // color: "rgba(107,145,221, 1)",
                        color: {
                            type: "linear",
                            x: 0,
                            y: 0,
                            x2: 0,
                            y2: 1,
                            colorStops: [
                                {
                                    offset: 1,
                                    color: "rgba(0,112,204, 0.1)",
                                },
                                {
                                    offset: 0.5,
                                    color: "rgba(0,112,204, .5)",
                                },
                                {
                                    offset: 0,
                                    color: "rgba(0,112,204, 1)",
                                },
                            ],
                            globalCoord: false,
                        },
                    },
                },
            ],
            outline: {
                borderDistance: 8,
                itemStyle: {
                    borderWidth: 5,
                    borderColor: "#e0e0e0",
                    borderType: "dashed",
                },
            },
            // outline: {
            //     show: false,
            // },

            label: {
                normal: {
                    formatter: "{c}" * 100,
                    textStyle: {
                        color: "#333",
                        fontSize: 16,
                    },
                },
            },
        },
    ],
};
echarts_circle5.setOption(circle5);

var echarts_circle6 = echarts.init(document.getElementById("echarts_circle6"));
var circle6 = {
    tooltip: {
        trigger: "axis",
        axisPointer: {
            type: "cross",
        },
    },
    grid: {
        left: "5%",
        top: "5%",
        right: "5%",
        bottom: "3%",
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
            "00:00:00",
            "02:00:00",
            "04:00:00",
            "06:00:00",
            "10:00:00",
            "12:00:00",
            "14:00:00",
            "16:00:00",
            "18:00:00",
            "20:00:00",
            "20:00:00",
            "22:00:00",
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
            show: false,
            // lineStyle: {
            //     type: "dashed",
            // },
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
            name: "接口调用",
            type: "line",
            data: [40, 38, 80, 94, 141, 87, 104, 120, 48, 60, 100, 140],
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
                            color: "rgba(0,112,204,0.5)", // 0% 处的颜色
                        },
                        {
                            offset: 1,
                            color: "rgba(0,112,204,0.1)", // 100% 处的颜色
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
                            color: "rgba(0,112,204)", // 0% 处的颜色
                        },
                        {
                            offset: 0.5,
                            color: "rgba(0,112,204)", // 0% 处的颜色
                        },
                        {
                            offset: 1,
                            color: "rgba(0,112,204)", // 100% 处的颜色
                        },
                    ],
                    global: true, // 缺省为 false
                },
            },
            areaStyle: [],
        },
    ],
};
echarts_circle6.setOption(circle6);

var echarts_circle7 = echarts.init(document.getElementById("echarts_circle7"));
var circle7 = {
    tooltip: {
        trigger: "axis",
        axisPointer: {
            type: "cross",
        },
    },
    grid: {
        left: "5%",
        top: "5%",
        right: "5%",
        bottom: "5%",
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
            "00:00:00",
            "02:00:00",
            "04:00:00",
            "06:00:00",
            "10:00:00",
            "12:00:00",
            "14:00:00",
            "16:00:00",
            "18:00:00",
            "20:00:00",
            "20:00:00",
            "22:00:00",
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
            formatter: "{value} %",
        },
    },
    color: ["#0070cc"],
    series: [
        {
            name: "接口在线率",
            type: "bar",
            data: [40, 38, 80, 94, 41, 87, 74, 20, 48, 60, 50, 40],
            barWidth: 15,
        },
    ],
};
echarts_circle7.setOption(circle7);
setTimeout(() => {
    window.onresize = function () {
        echarts_circle1.resize();
        echarts_circle3.resize();
        echarts_circle2.resize();
        echarts_circle4.resize();
        echarts_circle5.resize();
        echarts_circle6.resize();
        echarts_circle7.resize();
    };
}, 500);