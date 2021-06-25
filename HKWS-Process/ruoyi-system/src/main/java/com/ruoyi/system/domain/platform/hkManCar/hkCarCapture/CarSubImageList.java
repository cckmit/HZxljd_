package com.ruoyi.system.domain.platform.hkManCar.hkCarCapture;

import com.ruoyi.system.domain.platform.hkManCar.hkFaceCapture.SubImageInfoObject;

import java.io.Serializable;
import java.util.List;


/**
 * Copyright 2021 json.cn
 */
        import java.util.List;

/**
 * Auto-generated: 2021-05-27 20:10:27
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class CarSubImageList implements Serializable {

    private List<CarSubImageInfoObject> SubImageInfoObject;

    public List<CarSubImageInfoObject> getSubImageInfoObject() {
        return SubImageInfoObject;
    }

    public void setSubImageInfoObject(List<CarSubImageInfoObject> subImageInfoObject) {
        SubImageInfoObject = subImageInfoObject;
    }
}