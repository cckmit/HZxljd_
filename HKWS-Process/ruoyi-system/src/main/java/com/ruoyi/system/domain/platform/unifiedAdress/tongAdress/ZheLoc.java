package com.ruoyi.system.domain.platform.unifiedAdress.tongAdress;

import java.io.Serializable;
import java.util.List;


/**
 * Auto-generated: 2021-06-18 20:23:41
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class ZheLoc implements Serializable {

    private List<Double> coordinates;
    private String type;
    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }
    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

}
