package com.ruoyi.system.service.impl;



import com.ruoyi.system.domain.HkRentHouseDoor;
import com.ruoyi.system.mapper.HkRentHouseDoorMapper;
import com.ruoyi.system.service.HkRentHouseDoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (HkRentHouseDoor)表服务实现类
 *
 * @author makejava
 * @since 2021-04-09 11:37:40
 */
@Service
public class HkRentHouseDoorServiceImpl implements HkRentHouseDoorService {
    @Autowired
    private HkRentHouseDoorMapper  hkRentHouseDoorMapper;

    @Override
    public int insertDoor(HkRentHouseDoor hkRentHouseDoor) {

        int i=hkRentHouseDoorMapper.insertDoor(hkRentHouseDoor);
        return i;
    }
}
