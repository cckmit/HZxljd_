package com.ruoyi.system.mapper;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.mapper
 * @ClassName: HkMapCoverMapper
 * @Author: guohailong
 * @Description: 地图覆盖物
 * @Date: 2021/3/16 1:44
 * @Version: 1.0
 */

import com.ruoyi.system.domain.HkMapCover;
import com.ruoyi.system.domain.dto.RegionDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 地图覆盖物-地区关联Mapper接口
 *
 * @author ruoyi
 * @date 2021-03-16
 */
public interface HkMapCoverMapper {


    /**
     * 新增地图覆盖物-地区关联
     *
     * @param hkMapCover 地图覆盖物-地区关联
     * @return 结果
     */
    public int insertHkMapCover(HkMapCover hkMapCover);



    HkMapCover getHkMapCover(@Param("parentId") Long parentId);

    /**
     * 根据地区id删除当前地区覆盖物
     * @param parentId
     * @return
     */
    int updateDelFlagByParentId(@Param("parentId") Long parentId);

    /**
     *
     * @param parentId
     * @return
     */
    List<HkMapCover> getChildHkMapCoverList(@Param("parentId") Long parentId);

    /**
     * 根据地区id.获取当前地区兄弟节点地区的地图覆盖物
     * @param parentId
     * @return
     */
    List<HkMapCover> getBrotherHkMapCoverList(@Param("parentId") Long parentId);

    List<RegionDto> getAllRegions();

    /**
     * 获取当前地区父节点的覆盖物(获取上级地区覆盖物)
     * @return
     */
    HkMapCover getParentHkMapCover(@Param("regionId") Long regionId);

    /**
     * 获取所有覆盖物
     * @return
     */
    List<HkMapCover> getALLMapCoverList();

    /**
     * 获取当前地区堂兄弟节点
     * @param regionId
     * @return
     */
    List<HkMapCover> getCousinHkMapCoverList(@Param("regionId")Long regionId);
}
