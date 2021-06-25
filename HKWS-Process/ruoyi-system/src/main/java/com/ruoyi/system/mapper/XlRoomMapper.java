package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.XlEnterpriseInfo;
import com.ruoyi.system.domain.XlRoom;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 房屋信息Mapper接口
 *
 * @author ruoyi
 * @date 2021-05-17
 */
public interface XlRoomMapper
{
    /**
     * 查询房屋信息
     *
     * @param id 房屋信息ID
     * @return 房屋信息
     */
    public XlRoom selectXlRoomById(Long id);

    /**
     * 查询房屋信息列表
     *
     * @param xlRoom 房屋信息
     * @return 房屋信息集合
     */
    public List<XlRoom> selectXlRoomList(XlRoom xlRoom);

    /**
     * 新增房屋信息
     *
     * @param xlRoom 房屋信息
     * @return 结果
     */
    public int insertXlRoom(XlRoom xlRoom);

    /**
     * 修改房屋信息
     *
     * @param xlRoom 房屋信息
     * @return 结果
     */
    public int updateXlRoom(XlRoom xlRoom);

    /**
     * 删除房屋信息
     *
     * @param id 房屋信息ID
     * @return 结果
     */
    public int deleteXlRoomById(Long id);

    /**
     * 批量删除房屋信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteXlRoomByIds(String[] ids);
    //查询房屋总数
    int queryRoomAll(XlRoom xlRoom);
    //查询商品房总数
    int queryCommercialCount(XlRoom xlRoom);
    //查询自建房总数
    int querySelfBuiltCount(XlRoom xlRoom);
    //查询房屋详情
    List<XlEnterpriseInfo> queryRoomDetail(int id);
    //查询小区房屋数量
    int queryRoomCount(Map<String, Object> thingResult);
    //查询房屋id
    List<XlRoom> queryRoomId(String address);

    List<XlRoom>  selectXlPersonnelListAll();

    void updatePersonVillageId(Map<String, Object> thingResult);
    //查询房屋详细信息
    String queryRoomAdress(Integer roomId);
    //查询各网格房屋数量
    Integer queryRoomListCount(Map<String, Object> paramsAll);

    public XlRoom selectXlRoomByAddress(String address);

    public List<XlRoom> selectXlRoomInIds(String[] arr);

    /**
     * 根据小区id查询楼幢id和名称
     * @param
     * @return
     */
    List<Map<String,Object>> findbuilding(@Param("deptId") Integer deptId,@Param("villageId") Integer villageId);
    /**
     * 根据楼幢id查询单元
     * @param buildingCode
     * @return
     */
    List<Map<String,Object>> findUnit(@Param("deptId") Integer deptId,@Param("villageId") Integer villageId,@Param("buildingCode") Integer buildingCode);
}
