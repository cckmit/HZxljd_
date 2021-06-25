package com.ruoyi.common.utils.map;

import java.util.Map;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.common.utils.map
 * @ClassName: MapUtils
 * @Author: guohailong
 * @Description: 地图经纬度计算工具类
 * @Date: 2021/3/14 23:34
 * @Version: 1.0
 */
public class MapUtils {

    public static void main(String[] args) {
        //114.331951,30.64091#114.341049,30.610185#114.331436,30.588058#114.312038,30.56393#114.293498,30.558609#114.267922,30.563784#114.231185,30.57945#114.212303,30.601616#114.235649,30.626878#114.280624,30.646818#
        Map[] map = new Map[]{};

        MapPoint[] ps = new MapPoint[]{
                new MapPoint(119.819288, 30.242295),//114.309914,30.599556
                new MapPoint(119.821605, 30.238699),//114.295688,30.592879
                new MapPoint(119.824223, 30.242369),//114.292812,30.587726
                new MapPoint(119.825983, 30.245151),//114.292812,30.587726
                new MapPoint(119.827742, 30.241294),//114.300581,30.580318
                new MapPoint(119.830961, 30.237512),//114.303606,30.586959
                new MapPoint(119.833836, 30.238513),//114.304534,30.594751
                new MapPoint(119.833965, 30.244297),//114.308381,30.590131
                new MapPoint(119.832162, 30.252082),//114.308651,30.584182
                new MapPoint(119.828128, 30.253973),//114.304495,30.584015
                new MapPoint(119.824523, 30.251749),//114.301301,30.578759
                new MapPoint(119.822678, 30.249154),//114.309437,30.578528
                new MapPoint(119.819545, 30.248523) //114.323282,30.592786
        };

        MapPoint n1 = new MapPoint(119.826055, 30.2451);

        System.out.println("" + n1.getLongitude() + n1.getLatitude() + "  " + (isPointInPolys(n1.getLongitude(), n1.getLatitude(), ps) ? "在内" : "在外"));

    }


    /**
     * 判断点是否在多边形中
     *
     * @param ALon 经度
     * @param ALat 维度
     * @param ps   构造多边形的点数组,长度必须大于3
     * @return
     */
    public static boolean isPointInPolys(double ALon, double ALat, MapPoint[] ps) {
        int iSum, iCount, iIndex;
        double dLon1 = 0, dLon2 = 0, dLat1 = 0, dLat2 = 0, dLon;
        // 三个点才能确定面
        if (ps.length < 3) {
            return false;
        }
        iSum = 0;
        iCount = ps.length;
        for (iIndex = 0; iIndex < iCount; iIndex++) {
            if (iIndex == iCount - 1) {
                dLon1 = ps[iIndex].getLongitude();
                dLat1 = ps[iIndex].getLatitude();
                dLon2 = ps[0].getLongitude();
                dLat2 = ps[0].getLatitude();
            } else {
                dLon1 = ps[iIndex].getLongitude();
                dLat1 = ps[iIndex].getLatitude();
                dLon2 = ps[iIndex + 1].getLongitude();
                dLat2 = ps[iIndex + 1].getLatitude();
            }
            // 以下语句判断A点是否在边的两端点的水平平行线之间，在则可能有交点，开始判断交点是否在左射线上
            if (((ALat >= dLat1) && (ALat < dLat2)) || ((ALat >= dLat2) && (ALat < dLat1))) {
                if (Math.abs(dLat1 - dLat2) > 0) {
                    //得到 A点向左射线与边的交点的x坐标：
                    dLon = dLon1 - ((dLon1 - dLon2) * (dLat1 - ALat)) / (dLat1 - dLat2);
                    // 如果交点在A点左侧（说明是做射线与 边的交点），则射线与边的全部交点数加一：
                    if (dLon < ALon) {
                        iSum++;
                    }
                }
            }
        }
        if ((iSum % 2) != 0) {
            return true;
        }
        return false;
    }
}


