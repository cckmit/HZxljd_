package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.HkRentHouseDoor;
import org.apache.ibatis.annotations.Param;

/**
 * (HkRentHouseDoor)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-09 11:37:40
 */
public interface HkRentHouseDoorMapper {


    int insertDoor(@Param("hkRentHouseDoor") HkRentHouseDoor hkRentHouseDoor);
}
