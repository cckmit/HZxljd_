package com.ruoyi.system.domain.platform.unifiedAdress;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
* @author xyq
* @date 2020年12月23日
* 类说明:
*/


/**
 * @author yhx
 */
@ApiModel("统一地址查询实体")
public class GatewayAddressSearchReq implements Serializable {

    @ApiModelProperty(value = "token",hidden = true)
    private String token;

    @ApiModelProperty("搜索地址")
    @NotBlank
    private String addr;

    @ApiModelProperty("结果分页参数，分页页码，默认 1")
    private Integer page;

    @ApiModelProperty("结果分页参数，每页结果数，默认 10")
    private Integer limit;

    @ApiModelProperty("是否模糊匹配，false 精确匹配，要求待匹\n" +
            "配地址每个字都出现在结果中，true 模糊\n" +
            "匹配，要求待匹配地址每个字都出现在结\n" +
            "果中，和 equal 参数不可同时使用。\n")
    private Boolean fuzzy;

    @ApiModelProperty("是否完全匹配，false 不要求完全匹配，tr\n" +
            "ue 要求完全匹配，如果为 true，只会返回\n" +
            "地址完全一致的结果，和 fuzzy 参数不可\n" +
            "同时使用。")
    private Boolean equal;

    @ApiModelProperty(value = "业务流水号，用于区分是否为同一笔业务\n" +
            "调用接口\n",hidden = true)
    private String sno;

    public Map<String, Object> getUrlBody() {
    	 Map<String, Object> map = new HashMap<String, Object>();
    	 
    	 map.put("token", token);
    	 map.put("addr", addr);
       
        if (page != null) {
        	map.put("page", page);
        }
        if (limit != null) {
        	map.put("limit", limit);
        }
        if (fuzzy != null) {
        	map.put("fuzzy", fuzzy);
        }
        if (equal != null) {
        	map.put("equal", equal);
        }
        map.put("sno", UUID.randomUUID());
        

        return map;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Boolean getFuzzy() {
        return fuzzy;
    }

    public void setFuzzy(Boolean fuzzy) {
        this.fuzzy = fuzzy;
    }

    public Boolean getEqual() {
        return equal;
    }

    public void setEqual(Boolean equal) {
        this.equal = equal;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
